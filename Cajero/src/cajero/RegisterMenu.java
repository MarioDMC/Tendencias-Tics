package cajero;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterMenu implements ActionListener {

	JFrame frame;
	JPanel buttonsPanel, fieldsPanel;
	JLabel name;
	JLabel number;
	JLabel pin;
	static JTextField numberField, nameField, pinField;
	JButton ok, cancel;

	RegisterMenu() {

		frame = new JFrame("Register");
		buttonsPanel = new JPanel();
		fieldsPanel = new JPanel();
		name = new JLabel("Nombre");
		number = new JLabel("Número de cuenta");
		pin = new JLabel("PIN");
		numberField = new JTextField("", 10);
		nameField = new JTextField("", 50);
		pinField = new JTextField("", 4);
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
	}

	public JFrame getRegisterMenu(boolean display) {

		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
		fieldsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonsPanel.setLayout(new FlowLayout());

		fieldsPanel.add(name);
		fieldsPanel.add(nameField);
		fieldsPanel.add(number);
		fieldsPanel.add(numberField);
		fieldsPanel.add(pin);
		fieldsPanel.add(pinField);
		buttonsPanel.add(ok);
		buttonsPanel.add(cancel);

		frame.add(fieldsPanel, BorderLayout.PAGE_START);
		frame.add(buttonsPanel, BorderLayout.PAGE_END);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(200, 200));
		frame.setVisible(display);

		ok.addActionListener(this);
		cancel.addActionListener(this);

		return frame;
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == ok) {
			String client = RegisterMenu.nameField.getText();
			int pass = Integer.parseInt((RegisterMenu.pinField.getText()));
			int Anumber = Integer.parseInt((RegisterMenu.numberField.getText()));

			Register Add = new Register();
			boolean done = Add.checkAccount(client, Anumber, pass);

			if (done) {
				LoginMenu menu = new LoginMenu();
				menu.getLoginMenu(true);
				frame.dispose();
			}
		}

		else {
			frame.dispose();
		}
	}
}
