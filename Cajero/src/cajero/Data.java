package cajero;

import java.util.HashMap;
import java.util.Map;

public class Data {
	
	static Map<Integer, String> accounts = new HashMap<Integer, String>();
	static Map<Integer, Double> balances = new HashMap<Integer, Double>();
	static Map<Integer, Integer> passw = new HashMap<Integer, Integer>();
	
	public static Map<Integer, String> getAccounts() {
		return accounts;
	}
	
	public static Map<Integer, Double> getBalances() {
		return balances;
	}
	
	public static Map<Integer, Integer> getPass() {
		return passw;
	}

}
