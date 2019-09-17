package cajero;

import java.awt.*;
import java.util.Map;

import javax.swing.*;

public class AtmMenu {

	JFrame frame;
	JLabel name, accountN;
	JPanel LabelsPanel, ButtonPanel, OptionsPanel;
	JButton check, deposit, retire, changePin, cancel;

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
	}
		
		public JFrame getAtmMenu(boolean display, int client) {
			
		String account = Integer.toString(client);
		accountN.setText("Número de cuenta: "+account);
		Map<Integer,String> info = Data.getAccounts();
		name.setText("Nombre de titular: "+(info.get(client)));
				
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
		

		frame.add(LabelsPanel, BorderLayout.PAGE_START);
		frame.add(OptionsPanel, BorderLayout.CENTER);
		frame.add(ButtonPanel, BorderLayout.PAGE_END);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(500, 200));
		frame.setVisible(display);
		
		return frame;
	}

}
