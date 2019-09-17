package cajero;

import java.util.Map;
import javax.swing.JOptionPane;

public class Login {

	int accountN;
	int pin;
	String name;

	public Boolean ValidateLogin(int number, int pass) {

		Map<Integer, Integer> info = Data.getPass();
		boolean done = Validate(info, number);

		if (!done) {
			JOptionPane.showMessageDialog(null, "El número de cuenta no existe");
			return (false);
		}

		else {
			if (info.get(number).equals(pass)) {
				return (true);
			}

			else if (!info.get(number).equals(pass)) {
				JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
				return (false);
			}

			else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
				return (false);
			}

		}
	}

	public Boolean Validate(Map<Integer, Integer> info, int accountN) {

		if (info.containsKey(accountN)) {
			return (true);

		}

		else {
			return (false);
		}
	}
}
