package cajero;

import java.util.Map;

import javax.swing.JOptionPane;

public class Atm {

	int accountN;
	double cash;

	public void check(int accountN) {

		Map<Integer, Double> info = Data.getBalances();

		double actualBalance = info.get(accountN);

		JOptionPane.showMessageDialog(null, "Saldo Actual: " + actualBalance);
	}

	public void deposit(int accountN) {

		Map<Integer, Double> info = Data.getBalances();

		String value = JOptionPane.showInputDialog(null, "Cantidad a depositar");

		Double cash = Double.parseDouble(value);

		info.put(accountN, cash);

		JOptionPane.showMessageDialog(null, "Deposito realizado");
	}

	public void retire(int accountN) {

		Map<Integer, Double> info = Data.getBalances();

		double actualBalance = info.get(accountN);

		String value = JOptionPane.showInputDialog(null, "Cantidad a depositar");

		Double cash = Double.parseDouble(value);

		if (actualBalance >= cash) {

			double newBalance = actualBalance - cash;

			info.put(accountN, newBalance);

			JOptionPane.showMessageDialog(null, "Retiro de " + cash + " realizado/nSaldo actual: " + newBalance);
		}

		else {
			JOptionPane.showMessageDialog(null, "Fondos Insuficientes");
		}
	}
	
	public void changePin(int accountN) {

		Map<Integer, Integer> info = Data.getPass();
	
		String pin = JOptionPane.showInputDialog(null, "Ingresa el nuevo PIN");
		
		int newPin = Integer.parseInt(pin);
		
		info.put(accountN, newPin);

		JOptionPane.showMessageDialog(null, "PIN actualizado");
	}

}
