package payments;

import machine.Machine;

public interface PaymentMode {

	boolean pay(double amountToPay, Machine machine);
}
