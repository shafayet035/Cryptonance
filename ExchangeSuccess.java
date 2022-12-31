import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExchangeSuccess extends JFrame implements ActionListener  {
	JButton homeBtn, sendBtn, exchangeBtn, logoutBtn, okBtn;
	ExchangeSuccess() {
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
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(37, 37, 37));
		panel2.setBounds(341, 272, 518, 257);
		
		
		ImageIcon checkIcon = new ImageIcon("images/check.png");
		JLabel checkLabel = new JLabel("", checkIcon, JLabel.CENTER);
		checkLabel.setBounds(568, 324, 63, 63);
		panel1.add(checkLabel);
		
		
		JLabel l1 = new JLabel("Currency Exchanged Sent Successfully");
		l1.setBounds(420, 400, 400, 24);
		l1.setFont(new Font("Poppins", Font.PLAIN, 20));
		l1.setForeground(Color.white);
		panel1.add(l1);
		
		
		okBtn = new JButton("Ok");
		okBtn.setBounds(535, 442, 122, 38);
		okBtn.setBackground(new Color(85,151,251));
		okBtn.setForeground(Color.white);
		okBtn.setFont(new Font("Poppins", Font.BOLD, 18));
		okBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		okBtn.setFocusable(false);
		okBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel1.add(okBtn);
		
		logoutBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		okBtn.addActionListener(this);
		exchangeBtn.addActionListener(this);
		
		panel1.add(panel2);
		this.add(panel1);
	}
	
	
	public void actionPerformed(ActionEvent event ) {
		if(event.getSource() == logoutBtn) {
			Login screen = new Login();
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == okBtn || event.getSource() == homeBtn) {
			Account account = new Account("test", "testemail", "testKey", 50, 50, 50);
			Home screen = new Home(account);
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == sendBtn) {
			Send screen = new Send();
			this.setVisible(false);
			screen.setVisible(true);
		}
		if(event.getSource() == exchangeBtn) {
			Exchange screen  = new Exchange();
			this.setVisible(false);
			screen.setVisible(true);
		}
	}
}
