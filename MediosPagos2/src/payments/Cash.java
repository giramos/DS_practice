package payments;

import machine.Machine;

public class Cash implements PaymentMode {

	@Override
	public boolean pay(double amountToPay, Machine machine) {
		int insertedAmount = 0;
		boolean cancel = false;
		machine.getBillAcceptor().reset();
		do {
			machine.getDisplay().show(String.format("Quedan por pagar %.2f €%n", amountToPay - insertedAmount));
			double inserted = machine.getBillAcceptor().insertBill();
			insertedAmount = machine.getBillAcceptor().getTotalAmount();
			if (inserted == 0)
				cancel = true;
		} while (insertedAmount < amountToPay && !cancel);

		if (cancel) {
			machine.getDisplay().show("Operación cancelada por el usuario\n");
			// si antes de cancelar había introducido dinero, se le devuelve
			if (insertedAmount > 0)
				machine.getBillAcceptor().returnChange(insertedAmount);
			return false;
		}
		machine.getDisplay().show("Pago completado\n");
		// se devuelve el cambio
		if (insertedAmount > amountToPay) {
			machine.getBillAcceptor().returnChange(insertedAmount - amountToPay);
		}
		return true;
	}

}
