package cajero;

import javax.swing.*;
public class Register {

	int accountN;
	int pin;
	String name;

	public Boolean checkAccount(String name, int accountN, int pass) {

		if (Data.getAccounts().containsKey(accountN)) {
			JOptionPane.showMessageDialog(null, "El número de cuenta ya existe");
			return (false);

		} else {

			Register client = new Register();
			client.addAccount(accountN, name);
			client.addBalance(accountN);
			client.addPass(accountN, pass);

			JOptionPane.showMessageDialog(null, "Cuenta creada");
			return (true);
		}
	}

	public void addAccount(int accountN, String name) {
		Data.getAccounts().put(accountN, name);
	}

	public void addBalance(int accountN) {
		Data.getBalances().put(accountN, 0.0);
	}

	public void addPass(int accountN, int pass) {
		Data.getPass().put(accountN, pass);
	}

}
