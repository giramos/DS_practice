package machine;

import java.util.*;

import machine.hardware.*;
import machine.model.*;
import paypal.PayPalAPI;
import ruralvia.BankGateway;

public class Machine {
	private enum PaymentMode {
		CREDIT_CARD, CASH, PAYPAL
	}

	private List<Event> events = new ArrayList<>();

	// los distintos componentes físicos con los que interactúa la máquina
	// expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();
	private CardReader cardReader = new CardReader();
	private BillAcceptor billAcceptor = new BillAcceptor();

	// pasarela de pagos (para los pagos con tarjeta)
	private BankGateway bankGateway = new BankGateway();

	PayPalAPI paypal = new PayPalAPI();

	// -- Métodos públicos
	// -------------------------------------------------------------------------

	public void addEvent(Event event) {
		events.add(event);
	}

	public void run() {
		while (true) {
			Event selectedEvent = selectEvent();

			display.show("\n¿Cuántas entradas desea comprar? ");
			int numberOfTickets = howManyTickets(selectedEvent.getAvailableTickets());

			// se calcula el importe a pagar
			double amountToPay = numberOfTickets * selectedEvent.getPrice();
			display.show(String.format("Importe a pagar: %.2f €%n", amountToPay));

			PaymentMode paymentMode = selectPaymentMode();

			// se realiza el pago
			boolean isValidPayment;
			if (paymentMode == PaymentMode.CREDIT_CARD) {
				isValidPayment = payByCard(amountToPay);
			} else if (paymentMode == PaymentMode.CASH) {
				isValidPayment = payByCash(amountToPay);
			} else if (paymentMode == PaymentMode.PAYPAL) {
				isValidPayment = payByPaypal(amountToPay);
			} else {
				throw new AssertionError("Método de pago desconocido: " + paymentMode);
			}

			if (!isValidPayment) {
				display.show("No se ha podido completar el pago\n\n");
				continue;
			}

			// se generan las entradas
			List<Ticket> tickets = selectedEvent.generateTickets(numberOfTickets);

			// por último, la máquina imprime las entradas generadas
			display.show("\nSus entradas se están imprimiendo...\n");
			for (Ticket ticket : tickets) {
				printer.printTicket(ticket);
			}

			display.show("Gracias por su compra, que disfrute del evento.\n\n");
		}

	}

	// -- Pago
	// -------------------------------------------------------------------------

	private PaymentMode selectPaymentMode() {
		display.show("\nEscoja un método de pago:\n");
		display.show("  1. Pago con tarjeta\n");
		display.show("  2. Pago en efectivo\n");
		display.show("  3. Pago a través de PayPal\n");
		int option = keyboard.readOption(3);
		switch (option) {
		case 1:
			return PaymentMode.CREDIT_CARD;
		case 2:
			return PaymentMode.CASH;
		case 3:
			return PaymentMode.PAYPAL;
		default:
			throw new AssertionError("Método de pago inválido");
		}
	}

	private boolean payByCard(double amount) {
		String cardNumber = cardReader.readCardNumber();
		boolean isValid = bankGateway.pay(cardNumber, amount);
		if (!isValid) {
			display.show("Tarjeta rechazada\n");
			return false;
		}
		// pago correcto
		display.show("Tarjeta aceptada: pago realizado con éxito\n");
		return true;
	}

	private boolean payByPaypal(double amountToPay) {
		// mostrar en pantalla "Iniciando sesión en PayPal..."
		display.show("Iniciando sesión en PayPal...\n");
		// pedir nombre de usuario y contraseña por pantalla
		display.show("Nombre: ");
		String username = keyboard.readString();
		display.show("\nContraseña: ");
		String password = keyboard.readString();
		String token = paypal.logIn(username, password);
		if (!paypal.isLogged(token)) {
			// mostrar "Nombre de usuario o contraseña incorrectas" y finalizar
			display.show("Nombre de usuario o contraseña incorrectas\n");
		}

		// si el nombre de usuario y contraseña son correctos, PayPal nos
		// habrá devuelto un token válido, que usaremos para realizar el pago
		boolean isValid = paypal.checkout(token, amountToPay);
		return isValid;
	}

	private boolean payByCash(double amount) {
		int insertedAmount = 0;
		boolean cancel = false;
		billAcceptor.reset();
		do {
			display.show(String.format("Quedan por pagar %.2f €%n", amount - insertedAmount));
			double inserted = billAcceptor.insertBill();
			insertedAmount = billAcceptor.getTotalAmount();
			if (inserted == 0)
				cancel = true;
		} while (insertedAmount < amount && !cancel);

		if (cancel) {
			display.show("Operación cancelada por el usuario\n");
			// si antes de cancelar había introducido dinero, se le devuelve
			if (insertedAmount > 0)
				billAcceptor.returnChange(insertedAmount);
			return false;
		}
		display.show("Pago completado\n");
		// se devuelve el cambio
		if (insertedAmount > amount) {
			billAcceptor.returnChange(insertedAmount - amount);
		}
		return true;
	}

	// -- Seleccionar evento
	// -------------------------------------------------------------------------

	private Event selectEvent() {
		showEvents();
		int option = keyboard.readOption(events.size());
		Event event = events.get(option - 1);
		showEvent(event);
		return event;
	}

	private void showEvents() {
		display.show("Seleccione un evento:\n");
		int i = 1;
		for (Event each : events) {
			System.out.printf("%d. %s%n", i, each.getName());
			i++;
		}
	}

	private void showEvent(Event event) {
		display.show("Evento seleccionado:\n");
		display.show("  " + event.getName() + "\n");
		display.show(String.format("  Quedan %d entradas disponibles a %.2f euros%n", event.getAvailableTickets(),
				event.getPrice()));
	}

	// -- Pedir el número de entradas
	// -------------------------------------------------------------------------

	private int howManyTickets(int availableTickets) {
		do {
			int numberOfTickets = keyboard.readInt();
			if (numberOfTickets <= availableTickets)
				return numberOfTickets;
			display.show(String.format("Sólo quedan %d entradas disponibles, seleccione un número menor: ",
					availableTickets));
		} while (true);
	}
}
