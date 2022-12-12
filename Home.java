import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener   {
	JButton homeBtn, sendBtn, exchangeBtn, logoutBtn, copyBtn;
	JTextField addressField;
	Home() {
		super("Cryptonance | Home");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(19,19,19));
		panel1.setBounds(0, 0, 1200, 800);
		
		ImageIcon logo = new ImageIcon("images/logo.png");
		JLabel logoLabel = new JLabel("", logo, JLabel.CENTER);
		logoLabel.setBounds(91, 36, 211, 56);
		panel1.add(logoLabel);
		
		homeBtn = new JButton("Home");
		homeBtn.setBounds(704, 49, 60, 30);
		homeBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		homeBtn.setForeground(new Color(85,151,251));
		homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		homeBtn.setFocusable(false);
		homeBtn.setFocusPainted(false); 
		homeBtn.setContentAreaFilled(false);
		panel1.add(homeBtn);
		
		sendBtn = new JButton("Send");
		sendBtn.setBounds(804, 49, 51, 30);
		sendBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		sendBtn.setForeground(Color.white);
		sendBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sendBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		sendBtn.setFocusable(false);
		sendBtn.setFocusPainted(false); 
		sendBtn.setContentAreaFilled(false);
		panel1.add(sendBtn);
		
		exchangeBtn = new JButton("Exchange");
		exchangeBtn.setBounds(904, 49, 97, 30);
		exchangeBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		exchangeBtn.setForeground(Color.white);
		exchangeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exchangeBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		exchangeBtn.setFocusable(false);
		exchangeBtn.setFocusPainted(false); 
		exchangeBtn.setContentAreaFilled(false);
		panel1.add(exchangeBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(1045, 49, 68, 30);
		logoutBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		logoutBtn.setForeground(Color.white);
		logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logoutBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		logoutBtn.setFocusable(false);
		logoutBtn.setFocusPainted(false); 
		logoutBtn.setContentAreaFilled(false);
		panel1.add(logoutBtn);
		
		JLabel lb1 = new JLabel("Your wallet address:");
		lb1.setBounds(91, 171, 165, 24);
		lb1.setFont(new Font("Poppins", Font.PLAIN, 18));
		lb1.setForeground(Color.white);
		panel1.add(lb1);
		
		addressField = new JTextField("Kz5DCYErXz7VFTt4bpJ3jYe5J3Ead");
		addressField.setBounds(274, 163, 400, 40);
		addressField.setFont(new Font("Poppins", Font.PLAIN, 16));
		addressField.setForeground(Color.white);
		addressField.setBackground(new Color(84,84,84));
		addressField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		addressField.setEditable(false);
		addressField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		panel1.add(addressField);
		
		JLabel lb2 = new JLabel("use this to receive crypto");
		lb2.setBounds(274, 206, 177, 21);
		lb2.setFont(new Font("Poppins", Font.ITALIC, 12));
		lb2.setForeground(new Color(148, 148, 148));
		panel1.add(lb2);
		

		copyBtn = new JButton(new ImageIcon("images/copy.png"));
		copyBtn.setBorder(BorderFactory.createEmptyBorder());
		copyBtn.setContentAreaFilled(false);
		copyBtn.setBounds(680, 163, 48, 38);
		copyBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel1.add(copyBtn);
		
		JLabel copyLabel = new JLabel("click to copy");
		copyLabel.setBounds(680, 206, 76, 21);
		copyLabel.setFont(new Font("Poppins", Font.ITALIC, 12));
		copyLabel.setForeground(new Color(148, 148, 148));
		panel1.add(copyLabel);
		
		JLabel lb3 = new JLabel("Your wallets balance");
		lb3.setBounds(91, 274, 170, 24);
		lb3.setFont(new Font("Poppins", Font.PLAIN, 18));
		lb3.setForeground(new Color(255, 255, 255));
		panel1.add(lb3);
		
		
		// Bitcoin Card Start
		ImageIcon btcIcon = new ImageIcon("images/bitcoin-coin.png");
		JLabel btcIconLabel = new JLabel("", btcIcon, JLabel.CENTER);
		btcIconLabel.setBounds(115, 341, 69, 69);
		panel1.add(btcIconLabel);
		
		JLabel lb4 = new JLabel("Bitcoin");
		lb4.setBounds(201, 351, 61, 27);
		lb4.setFont(new Font("Poppins", Font.PLAIN, 18));
		lb4.setForeground(new Color(255, 255, 255));
		panel1.add(lb4);
		
		JLabel lb5 = new JLabel("BTC");
		lb5.setBounds(201, 378, 40, 21);
		lb5.setFont(new Font("Poppins", Font.PLAIN, 14));
		lb5.setForeground(new Color(139, 139, 139));
		panel1.add(lb5);
		
		JLabel lb6 = new JLabel("$50.65");
		lb6.setBounds(115, 431, 54, 24);
		lb6.setFont(new Font("Poppins", Font.PLAIN, 16));
		lb6.setForeground(new Color(255, 255, 255));
		panel1.add(lb6);
		
		JLabel lb7 = new JLabel("BTC: 0.0009346");
		lb7.setBounds(115, 462, 120, 24);
		lb7.setFont(new Font("Poppins", Font.PLAIN, 16));
		lb7.setForeground(new Color(255, 255, 255));
		panel1.add(lb7);
		
		JPanel btcPanel = new JPanel();
		btcPanel.setLayout(null);
		btcPanel.setBounds(91, 321, 240, 191);
		btcPanel.setBackground(new Color(34,34,34));
		panel1.add(btcPanel);
		// Bitcoin Card End
		
		// Litecoin Card Start
		ImageIcon ltcIcon = new ImageIcon("images/litecoin-coin.png");
		JLabel ltcIconLabel = new JLabel("", ltcIcon, JLabel.CENTER);
		ltcIconLabel.setBounds(391, 341, 69, 69);
		panel1.add(ltcIconLabel);
		
		JLabel lb8 = new JLabel("Litecoin");
		lb8.setBounds(477, 351, 69, 27);
		lb8.setFont(new Font("Poppins", Font.PLAIN, 18));
		lb8.setForeground(new Color(255, 255, 255));
		panel1.add(lb8);
		
		JLabel lb10 = new JLabel("LTC");
		lb10.setBounds(477, 378, 40, 21);
		lb10.setFont(new Font("Poppins", Font.PLAIN, 14));
		lb10.setForeground(new Color(139, 139, 139));
		panel1.add(lb10);
		
		JLabel lb11 = new JLabel("$5.65");
		lb11.setBounds(391, 431, 54, 24);
		lb11.setFont(new Font("Poppins", Font.PLAIN, 16));
		lb11.setForeground(new Color(255, 255, 255));
		panel1.add(lb11);
		
		JLabel lb12 = new JLabel("BTC: 0.0009346");
		lb12.setBounds(391, 462, 120, 24);
		lb12.setFont(new Font("Poppins", Font.PLAIN, 16));
		lb12.setForeground(new Color(255, 255, 255));
		panel1.add(lb12);
		
		JPanel ltcPanel = new JPanel();
		ltcPanel.setLayout(null);
		ltcPanel.setBounds(367, 321, 240, 191);
		ltcPanel.setBackground(new Color(34,34,34));
		panel1.add(ltcPanel);
		// Litecoin Card End
		
		// Etherium Card Start
		ImageIcon ethIcon = new ImageIcon("images/etherium-coin.png");
		JLabel ethIconLabel = new JLabel("", ethIcon, JLabel.CENTER);
		ethIconLabel.setBounds(667, 341, 69, 69);
		panel1.add(ethIconLabel);
		
		JLabel lb13 = new JLabel("Ethereum");
		lb13.setBounds(753, 351, 87, 27);
		lb13.setFont(new Font("Poppins", Font.PLAIN, 18));
		lb13.setForeground(new Color(255, 255, 255));
		panel1.add(lb13);
		
		JLabel lb14 = new JLabel("ETH");
		lb14.setBounds(753, 378, 40, 21);
		lb14.setFont(new Font("Poppins", Font.PLAIN, 14));
		lb14.setForeground(new Color(139, 139, 139));
		panel1.add(lb14);
		
		JLabel lb15 = new JLabel("$49.65");
		lb15.setBounds(667, 431, 60, 24);
		lb15.setFont(new Font("Poppins", Font.PLAIN, 16));
		lb15.setForeground(new Color(255, 255, 255));
		panel1.add(lb15);
		
		JLabel lb16 = new JLabel("ETH: 5.1354");
		lb16.setBounds(667, 462, 120, 24);
		lb16.setFont(new Font("Poppins", Font.PLAIN, 16));
		lb16.setForeground(new Color(255, 255, 255));
		panel1.add(lb16);
		
		JPanel ethPanel = new JPanel();
		ethPanel.setLayout(null);
		ethPanel.setBounds(643, 321, 240, 191);
		ethPanel.setBackground(new Color(34,34,34));
		panel1.add(ethPanel);
		// Etherium Card End
		
		logoutBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		copyBtn.addActionListener(this);
		exchangeBtn.addActionListener(this);
		
		this.add(panel1);
	}
	
	public void actionPerformed(ActionEvent event ) {
		if(event.getSource() == logoutBtn) {
			Login screen = new Login();
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == sendBtn) {
			Send screen  = new Send();
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == copyBtn) {
			addressField.selectAll();
			addressField.copy();
		}
		if(event.getSource() == exchangeBtn) {
			Exchange screen  = new Exchange();
			this.setVisible(false);
			screen.setVisible(true);
		}
	}
}
