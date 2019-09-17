package cajero;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginMenu implements ActionListener {

	JFrame frame;
	JPanel buttonsPanel, fieldsPanel;
	JLabel number, pin;
	static JTextField numberField, pinField;
	JButton ok, register, cancel;

	LoginMenu() {
		frame = new JFrame("Register");
		buttonsPanel = new JPanel();
		fieldsPanel = new JPanel();
		number = new JLabel("Número de cuenta");
		pin = new JLabel("PIN");
		numberField = new JTextField("", 10);
		pinField = new JTextField("", 4);
		ok = new JButton("OK");
		register = new JButton("Register");
		cancel = new JButton("Cancel");
	}

	public JFrame getLoginMenu(boolean display) {

		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
		fieldsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonsPanel.setLayout(new FlowLayout());

		fieldsPanel.add(number);
		fieldsPanel.add(numberField);
		fieldsPanel.add(pin);
		fieldsPanel.add(pinField);
		buttonsPanel.add(ok);
		buttonsPanel.add(register);
		buttonsPanel.add(cancel);

		frame.add(fieldsPanel, BorderLayout.PAGE_START);
		frame.add(buttonsPanel, BorderLayout.PAGE_END);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(250, 200));
		frame.setVisible(display);

		ok.addActionListener(this);
		register.addActionListener(this);
		cancel.addActionListener(this);

		return frame;
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == ok) {
			int pass = Integer.parseInt((LoginMenu.pinField.getText()));
			int Anumber = Integer.parseInt((LoginMenu.numberField.getText()));

			Login client = new Login();
			boolean exist = client.ValidateLogin(Anumber, pass);

			if (exist) {
				AtmMenu menu = new AtmMenu();
				menu.getAtmMenu(true, Anumber);
				frame.dispose();
			}
		}

		else if (event.getSource() == register) {

			RegisterMenu menu = new RegisterMenu();
			menu.getRegisterMenu(true);
			frame.dispose();
		}

		else {
			frame.dispose();
		}
	}
}
