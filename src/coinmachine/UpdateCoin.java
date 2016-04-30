package coinmachine;

import java.util.Observable;
import java.util.Observer;

public class UpdateCoin implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		if (((CoinMachine)o).getCount() == 1)
			System.out.println(((CoinMachine)o).getBalance());
		else if (((CoinMachine)o).getCount() < 10)
			System.out.println("Machine balance : " + ((CoinMachine)o).getBalance());
		else 
			System.out.println("*Machine balance : " + ((CoinMachine)o).getBalance()
					+ "\nMachine contains " + ((CoinMachine)o).getCount() + " coins and value " + ((CoinMachine)o).getBalance() + " Baht" + "\nMachine is FULL.");
	}
}
