package machine;

import java.util.ArrayList;
import java.util.List;

import machine.hardware.BillAcceptor;
import machine.hardware.CardReader;
import machine.hardware.Display;
import machine.hardware.Keyboard;
import machine.hardware.Printer;
import machine.model.Event;
import machine.model.Ticket;
import payments.PaymentMode;
import ruralvia.BankGateway;

public class Machine {

	private List<Event> events = new ArrayList<>();
	private List<PaymentMode> mediosPago = new ArrayList<>();

	// los distintos componentes físicos con los que interactúa la máquina
	// expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();
	private CardReader cardReader = new CardReader();
	private BillAcceptor billAcceptor = new BillAcceptor();

	// pasarela de pagos (para los pagos con tarjeta)
	private BankGateway bankGateway = new BankGateway();

//	PaymentMode mode;

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

			// se realiza el pago
			boolean isValidPayment = 
			mediosPago.forEach(c -> c.pay(amountToPay, this));

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

	// Metodos auxiliares
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public CardReader getCardReader() {
		return cardReader;
	}

	public void setCardReader(CardReader cardReader) {
		this.cardReader = cardReader;
	}

	public BillAcceptor getBillAcceptor() {
		return billAcceptor;
	}

	public void setBillAcceptor(BillAcceptor billAcceptor) {
		this.billAcceptor = billAcceptor;
	}

	public BankGateway getBankGateway() {
		return bankGateway;
	}

	public void setBankGateway(BankGateway bankGateway) {
		this.bankGateway = bankGateway;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

}
