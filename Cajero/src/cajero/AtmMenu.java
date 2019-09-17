package cajero;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.*;

public class AtmMenu implements ActionListener {

	JFrame frame;
	JLabel name;
	static JLabel accountN;
	JPanel LabelsPanel, ButtonPanel, OptionsPanel;
	JButton check, deposit, retire, changePin, cancel, logout;
	static int account;

	AtmMenu() {

		frame = new JFrame("ATM");
		name = new JLabel("");
		accountN = new JLabel();
		check = new JButton("Consultar saldo");
		deposit = new JButton("Realizar deposito");
		retire = new JButton("Retirar");
		changePin = new JButton("Cambiar PIN");
		LabelsPanel = new JPanel();
		ButtonPanel = new JPanel();
		OptionsPanel = new JPanel();
		cancel = new JButton("Cancel");
		logout = new JButton("Logout");
	}

	public JFrame getAtmMenu(boolean display, int client) {

		account = client;
		accountN.setText(Integer.toString(account));
		Map<Integer, String> info = Data.getAccounts();
		name.setText("Nombre de titular: " + (info.get(client)));

		LabelsPanel.setLayout(new BoxLayout(LabelsPanel, BoxLayout.PAGE_AXIS));
		LabelsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		OptionsPanel.setLayout(new GridLayout(2, 2));
		OptionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		ButtonPanel.setLayout(new FlowLayout());

		LabelsPanel.add(name);
		LabelsPanel.add(accountN);
		OptionsPanel.add(check);
		OptionsPanel.add(deposit);
		OptionsPanel.add(retire);
		OptionsPanel.add(changePin);
		ButtonPanel.add(cancel);
		ButtonPanel.add(logout);

		frame.add(LabelsPanel, BorderLayout.PAGE_START);
		frame.add(OptionsPanel, BorderLayout.CENTER);
		frame.add(ButtonPanel, BorderLayout.PAGE_END);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(500, 200));
		frame.setVisible(display);

		check.addActionListener(this);
		deposit.addActionListener(this);
		retire.addActionListener(this);
		changePin.addActionListener(this);
		cancel.addActionListener(this);
		logout.addActionListener(this);

		return frame;
	}

	public void actionPerformed(ActionEvent event) {

		int accountN = account;

		Atm atm = new Atm();

		if (event.getSource() == check) {
			atm.check(accountN);

		}

		else if (event.getSource() == deposit) {
			atm.deposit(accountN);

		}

		else if (event.getSource() == retire) {
			atm.retire(accountN);

		}

		else if (event.getSource() == changePin) {
			atm.changePin(accountN);

		}

		else if (event.getSource() == logout) {
			LoginMenu menu = new LoginMenu();
			menu.getLoginMenu(true);
			frame.dispose();
		}

		else {
			frame.dispose();
		}
	}

}
