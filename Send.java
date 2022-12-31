import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Send extends JFrame  implements ActionListener{
	JButton homeBtn, sendBtn, exchangeBtn, logoutBtn;
	
	String[] currency = new String[] {"BTC", "LTC", "ETH"};
	
	JComboBox curSelect; 
	JTextField amountField, recieverField, noteField;
	JButton sendSubmitBtn;
	
	Send() {
		super("Cryptonance | Send");
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
		homeBtn.setForeground(new Color(255,255,255));
		homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		homeBtn.setFocusable(false);
		homeBtn.setFocusPainted(false); 
		homeBtn.setContentAreaFilled(false);
		panel1.add(homeBtn);
		
		sendBtn = new JButton("Send");
		sendBtn.setBounds(804, 49, 51, 30);
		sendBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		sendBtn.setForeground(new Color(85,151,251));
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
		panel2.setBounds(395, 151, 396, 500);
		
		JLabel l1 = new JLabel("Send with");
		l1.setBounds(432, 196, 78, 24);
		l1.setFont(new Font("Poppins", Font.PLAIN, 16));
		l1.setForeground(Color.white);
		panel1.add(l1);
		
		curSelect = new JComboBox(currency);
		curSelect.setBounds(432, 228, 320, 37);
		curSelect.setForeground(Color.black);
		curSelect.setBackground(new Color(197,197,197));
		curSelect.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		curSelect.setFocusable(false);
		panel1.add(curSelect);
		
		
		JLabel l2 = new JLabel("Amount");
		l2.setBounds(432, 283, 78, 24);
		l2.setFont(new Font("Poppins", Font.PLAIN, 16));
		l2.setForeground(Color.white);
		panel1.add(l2);
		
		amountField = new JTextField();
		amountField.setBounds(432, 315, 320, 37);
		amountField.setFont(new Font("Poppins", Font.PLAIN, 16));
		amountField.setForeground(Color.black);
		amountField.setBackground(new Color(197,197,197));
		amountField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel1.add(amountField);
		
		JLabel l3 = new JLabel("Reciever");
		l3.setBounds(432, 371, 78, 24);
		l3.setFont(new Font("Poppins", Font.PLAIN, 16));
		l3.setForeground(Color.white);
		panel1.add(l3);
		
		recieverField = new JTextField();
		recieverField.setBounds(432, 404, 320, 37);
		recieverField.setFont(new Font("Poppins", Font.PLAIN, 16));
		recieverField.setForeground(Color.black);
		recieverField.setBackground(new Color(197,197,197));
		recieverField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel1.add(recieverField);
		
		JLabel l4 = new JLabel("Note");
		l4.setBounds(432, 460, 78, 24);
		l4.setFont(new Font("Poppins", Font.PLAIN, 16));
		l4.setForeground(Color.white);
		panel1.add(l4);
		
		noteField = new JTextField();
		noteField.setBounds(432, 492, 320, 37);
		noteField.setFont(new Font("Poppins", Font.PLAIN, 16));
		noteField.setForeground(Color.black);
		noteField.setBackground(new Color(197,197,197));
		noteField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel1.add(noteField);
		
		
		sendSubmitBtn = new JButton("Send");
		sendSubmitBtn.setBounds(432, 564, 122, 38);
		sendSubmitBtn.setBackground(new Color(85,151,251));
		sendSubmitBtn.setForeground(Color.white);
		sendSubmitBtn.setFont(new Font("Poppins", Font.BOLD, 18));
		sendSubmitBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		sendSubmitBtn.setFocusable(false);
		sendSubmitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel1.add(sendSubmitBtn);
		
		logoutBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		sendSubmitBtn.addActionListener(this);
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
		
		if(event.getSource() == homeBtn) {
			Account account = new Account("test", "testemail", "testKey", 50, 50, 50);
			Home screen = new Home(account);
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == sendSubmitBtn) {
			SendSuccess screen = new SendSuccess();
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
