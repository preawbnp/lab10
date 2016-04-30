package coinmachine;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * The observer class for update status and balance of the coin machine
 * @author Budnampetch Onmee
 * 
 */
public class InsertCoinUI extends JFrame implements Observer {
	private CoinMachine coin;
	private JPanel contents;
	private JPanel panelA, panelB;
	private JLabel textBalance, textStatus;
	private JTextField balance;
	private JButton oneButton, fiveButton, tenButton;
	private JProgressBar currStatus;
	
	public InsertCoinUI(CoinMachine coin){
		this.coin = coin;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	public void initComponents() {
		contents = new JPanel();
		contents.setLayout(new GridLayout(2,1));
		
		panelA = new JPanel();
		panelA.setLayout(new FlowLayout());
		panelB = new JPanel();
		panelB.setLayout(new FlowLayout());
		
		textBalance = new JLabel("Balance: ");
		balance = new JTextField(4);
		balance.setEditable(false);
		
		textStatus = new JLabel("     Status: ");
		currStatus = new JProgressBar(0,10);
		
		oneButton = new JButton();
		oneButton.setIcon(new ImageIcon(InsertCoinUI.class.getResource("/images/1baht.png")));
		oneButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				coin.insert(new Coin(1));
			}
		});
		
		fiveButton = new JButton();
		fiveButton.setIcon(new ImageIcon(InsertCoinUI.class.getResource("/images/5baht.png")));
		fiveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				coin.insert(new Coin(5));
			}
		});

		tenButton = new JButton();
		tenButton.setIcon(new ImageIcon(InsertCoinUI.class.getResource("/images/10baht.png")));
		tenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				coin.insert(new Coin(10));
			}
		});
		
		this.add(contents);
		contents.add(panelA);
		contents.add(panelB);

		panelA.add(textBalance);
		panelA.add(balance);
		panelA.add(textStatus);
		panelA.add(currStatus);
				
		panelB.setBorder( BorderFactory.createTitledBorder("Insert Money"));
		panelB.add(oneButton);
		panelB.add(fiveButton);
		panelB.add(tenButton);

		getContentPane().add(contents);
		this.pack();
	}

	@Override
	public void update(Observable o, Object arg) {
		currStatus.setValue(((CoinMachine)o).getCount());
		balance.setText("" + ((CoinMachine)o).getBalance());
	}
}
