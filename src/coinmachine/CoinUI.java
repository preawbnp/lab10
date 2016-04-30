package coinmachine;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * The program are show balance and count,
 * when you insert coin in coin machine.
 * @author Budnampetch Onmee
 *
 */
public class CoinUI extends JFrame implements Observer {
	private Container contents, containerA, containerB;
	private JLabel coinText, acceptingCoin;
	private JTextField numCoin;
	private CoinMachine coin;
	/**
	 * Constructor of CoinUI class
	 * @param coin recieve form coin machine
	 */
	public CoinUI (CoinMachine coin){
		this.coin = coin;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	/**
	 * Create initial component and add to display
	 */
	private void initComponents() {
		//create layout of display
		contents = new Container();
		contents.setLayout(new GridLayout(2,1));

		containerA = new Container();
		containerA.setLayout(new FlowLayout());

		containerB = new Container();
		containerB.setLayout(new FlowLayout());

		coinText = new JLabel("#Coins: ");
		numCoin = new JTextField(6);

		acceptingCoin = new JLabel("0");
		acceptingCoin.setForeground(new Color(60, 179, 33));
		acceptingCoin.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		acceptingCoin.setText("Accepting Coins");

		//add component to JFrame
		this.add(contents);
		contents.add(containerA);
		contents.add(containerB);

		containerA.add(coinText);
		containerA.add(numCoin);
		containerB.add(acceptingCoin);		

		getContentPane().add(contents);
		this.pack();
		setBounds(0, 330, 400, 100);;
	}

	@Override
	public void update(Observable o, Object arg) {
		numCoin.setText(((CoinMachine)o).getCount() + "");
		if (((CoinMachine)o).getCount() == 10){
			acceptingCoin.setForeground(Color.RED);
			acceptingCoin.setText("FULL!");;
		}
	}
}
