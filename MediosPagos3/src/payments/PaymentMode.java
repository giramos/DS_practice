package payments;

import machine.Machine;

public interface PaymentMode {

	boolean pay(double amount, Machine machine);
	String getTipo();
}
