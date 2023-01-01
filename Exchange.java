import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;

public class Exchange extends JFrame implements ActionListener {
	Account account;
	JButton homeBtn, sendBtn, exchangeBtn, logoutBtn, exchangeSubmitBtn, usersBtn;
	JComboBox fromDropdown, toDropdown; 
	JTextField amountField;
	
	String[] fromCurrency = new String[] {"BTC", "LTC", "ETH"};
	String[] toCurrency = new String[] {"ETH", "BTC", "LTC"};

	Utils util = new Utils();
	
	Exchange(Account account) {
		super("Cryptonance | Exchange");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		

		ImageIcon icon = new ImageIcon("images/icon.png");
		this.setIconImage(icon.getImage());
		
		this.account = account;
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(19,19,19));
		panel1.setBounds(0, 0, 1200, 800);
		
		ImageIcon logo = new ImageIcon("images/logo.png");
		JLabel logoLabel = new JLabel("", logo, JLabel.CENTER);
		logoLabel.setBounds(91, 36, 211, 56);
		panel1.add(logoLabel);
		
		usersBtn = new JButton("Users");
		usersBtn.setBounds(609, 49, 60, 30);
		usersBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		usersBtn.setForeground(Color.white);
		usersBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		usersBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		usersBtn.setFocusable(false);
		usersBtn.setFocusPainted(false); 
		usersBtn.setContentAreaFilled(false);
		panel1.add(usersBtn);
		
		homeBtn = new JButton("Home");
		homeBtn.setBounds(704, 49, 60, 30);
		homeBtn.setFont(new Font("Poppins", Font.PLAIN, 20));
		homeBtn.setForeground(Color.white);
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
		exchangeBtn.setForeground(new Color(85,151,251));
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
		
		JLabel l1 = new JLabel("Exchange Rate");
		l1.setBounds(213, 275, 150, 30);
		l1.setFont(new Font("Poppins", Font.BOLD, 20));
		l1.setForeground(new Color(85, 151, 251));
		panel1.add(l1);
		
		JLabel l2 = new JLabel("1 BTC  = 13.51 ETH");
		l2.setBounds(213, 322, 160, 24);
		l2.setFont(new Font("Poppins", Font.BOLD, 16));
		l2.setForeground(Color.white);
		panel1.add(l2);
		
		JLabel l3 = new JLabel("1 BTC  = 210.68 LTC");
		l3.setBounds(213, 363, 160, 24);
		l3.setFont(new Font("Poppins", Font.BOLD, 16));
		l3.setForeground(Color.white);
		panel1.add(l3);
		
		JLabel l4 = new JLabel("1 ETH = 0.074 BTC");
		l4.setBounds(213, 404, 160, 24);
		l4.setFont(new Font("Poppins", Font.BOLD, 16));
		l4.setForeground(Color.white);
		panel1.add(l4);
		
		JLabel l5 = new JLabel("1 ETH = 15.56 LTC");
		l5.setBounds(213, 445, 160, 24);
		l5.setFont(new Font("Poppins", Font.BOLD, 16));
		l5.setForeground(Color.white);
		panel1.add(l5);
		
		JLabel l6 = new JLabel("1 LTC = 0.064 ETH");
		l6.setBounds(213, 486, 160, 24);
		l6.setFont(new Font("Poppins", Font.BOLD, 16));
		l6.setForeground(Color.white);
		panel1.add(l6);
		
		JLabel l7 = new JLabel("1 LTC = 0.0047 BTC");
		l7.setBounds(213, 527, 160, 24);
		l7.setFont(new Font("Poppins", Font.BOLD, 16));
		l7.setForeground(Color.white);
		panel1.add(l7);
		
		ImageIcon arrowImg = new ImageIcon("images/exchange-cursor.png");
		JLabel arrowImgLabel = new JLabel("", arrowImg, JLabel.CENTER);
		arrowImgLabel.setBounds(450, 365, 130, 97);
		panel1.add(arrowImgLabel);
		
		JLabel l8 = new JLabel("From");
		l8.setBounds(661, 252, 42, 24);
		l8.setFont(new Font("Poppins", Font.BOLD, 16));
		l8.setForeground(Color.white);
		panel1.add(l8);
		
		fromDropdown = new JComboBox(fromCurrency);
		fromDropdown.setBounds(661, 280, 320, 37);
		fromDropdown.setForeground(Color.black);
		fromDropdown.setBackground(new Color(197,197,197));
		fromDropdown.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		fromDropdown.setFont(new Font("Poppins", Font.PLAIN, 18));
		fromDropdown.setFocusable(false);
		panel1.add(fromDropdown);
		
		JLabel l9 = new JLabel("Amount");
		l9.setBounds(661, 335, 64, 24);
		l9.setFont(new Font("Poppins", Font.BOLD, 16));
		l9.setForeground(Color.white);
		panel1.add(l9);
		
		amountField = new JTextField();
		amountField.setBounds(661, 364, 320, 37);
		amountField.setFont(new Font("Poppins", Font.PLAIN, 16));
		amountField.setForeground(Color.black);
		amountField.setBackground(new Color(197,197,197));
		amountField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel1.add(amountField);
		
		JLabel l10 = new JLabel("To");
		l10.setBounds(661, 419, 42, 24);
		l10.setFont(new Font("Poppins", Font.BOLD, 16));
		l10.setForeground(Color.white);
		panel1.add(l10);
		
		toDropdown = new JComboBox(toCurrency);
		toDropdown.setBounds(661, 446, 320, 37);
		toDropdown.setForeground(Color.black);
		toDropdown.setBackground(new Color(197,197,197));
		toDropdown.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		toDropdown.setFont(new Font("Poppins", Font.PLAIN, 18));
		toDropdown.setFocusable(false);
		panel1.add(toDropdown);
		
		
		exchangeSubmitBtn = new JButton("Exchange");
		exchangeSubmitBtn.setBounds(661, 558, 122, 38);
		exchangeSubmitBtn.setBackground(new Color(85,151,251));
		exchangeSubmitBtn.setForeground(Color.white);
		exchangeSubmitBtn.setFont(new Font("Poppins", Font.BOLD, 18));
		exchangeSubmitBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		exchangeSubmitBtn.setFocusable(false);
		exchangeSubmitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel1.add(exchangeSubmitBtn);
		
		logoutBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		exchangeSubmitBtn.addActionListener(this);
		usersBtn.addActionListener(this);
		
		JLabel l11 = new JLabel("Current Balance");
		l11.setBounds(215, 185, 120, 24);
		l11.setFont(new Font("Poppins", Font.BOLD, 14));
		l11.setForeground(new Color(85,151,251));
		panel1.add(l11);
		
		JLabel l12 = new JLabel("BTC - " + util.doubleToString(this.account.BTC));
		l12.setBounds(215, 210, 125, 24);
		l12.setFont(new Font("Poppins", Font.BOLD, 14));
		l12.setForeground(Color.white);
		panel1.add(l12);
		
		JLabel l13 = new JLabel("LTC  - " + util.doubleToString(this.account.LTC));
		l13.setBounds(367, 210, 125, 24);
		l13.setFont(new Font("Poppins", Font.BOLD, 14));
		l13.setForeground(Color.white);
		panel1.add(l13);
		
		JLabel l14 = new JLabel("ETH  - " + util.doubleToString(this.account.ETH));
		l14.setBounds(519, 210, 125, 24);
		l14.setFont(new Font("Poppins", Font.BOLD, 14));
		l14.setForeground(Color.white);
		panel1.add(l14);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(37, 37, 37));
		panel2.setBounds(137, 141, 926, 512);
		
		panel1.add(panel2);
		this.add(panel1);
	}
	
	private Boolean ExchangeHandler() {
		String fromCurr = fromDropdown.getSelectedItem().toString();
		String toCurr = toDropdown.getSelectedItem().toString();
		String amountString = amountField.getText();
		
		
		if(amountString.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter all the required fields");
			return false;
		} 
		
		if(fromCurr.equals(toCurr)) {
			JOptionPane.showMessageDialog(null, "You can't Exchange Same currency, Lol!");
			return false;
		}
		
		if(!util.checkOnlyNumbers(amountString)) {
			JOptionPane.showMessageDialog(null, "Please enter only decimal number to amount field");
			return false;
		} 
		
		double amount = Double.parseDouble(amountField.getText());
		
		if(fromCurr == "BTC" && amount > this.account.BTC) {
			JOptionPane.showMessageDialog(null, "Not Enough Balance");
			return false;
		}
		
		if(fromCurr == "LTC" && amount > this.account.LTC) {
			JOptionPane.showMessageDialog(null, "Not Enough Balance");
			return false;
		}
		
		if(fromCurr == "ETH" && amount > this.account.ETH) {
			JOptionPane.showMessageDialog(null, "Not Enough Balance");
			return false;
		}
		
		double exchangeAmount = util.exchange(fromCurr, toCurr, amount);
		if(fromCurr == "BTC") this.account.setBtc(this.account.BTC - amount);
		if(fromCurr == "ETH") this.account.setEth(this.account.ETH - amount);
		if(fromCurr == "LTC") this.account.setLtc(this.account.LTC - amount);
		if(toCurr == "BTC") this.account.setBtc(this.account.BTC + exchangeAmount);
		if(toCurr == "ETH") this.account.setEth(this.account.ETH + exchangeAmount);
		if(toCurr == "LTC") this.account.setLtc(this.account.LTC + exchangeAmount);
		
		
		String filePath = "./database/users.txt";
		File tempFile = new File("./database/users-temp.txt");
		String sender = this.account.key;
		String balanceString = "", updateString = "";
		
		try {
			File mainFile = new File(filePath);
			BufferedReader db = new BufferedReader(new FileReader(filePath));
	        PrintWriter tempDb = new PrintWriter(new FileWriter(tempFile));
	        
	        int totalLines = 0;
            while (db.readLine() != null)
                totalLines++;
            
            for (int i = 0; i < totalLines; i++) {
            	String line = Files.readAllLines(Paths.get(filePath)).get(i);
            	if(line.equals(sender)) {
            		if(fromCurr == "BTC") {
            		    balanceString = Files.readAllLines(Paths.get(filePath)).get(i + 1);
            			updateString = "BTC:"+util.doubleToString(this.account.BTC);
            		}
            		if(fromCurr == "LTC") {
            		    balanceString = Files.readAllLines(Paths.get(filePath)).get(i + 2);
            			updateString = "LTC:"+util.doubleToString(this.account.LTC);
            		}
            		if(fromCurr == "ETH") {
            		    balanceString = Files.readAllLines(Paths.get(filePath)).get(i + 3);
            			updateString = "ETH:"+util.doubleToString(this.account.ETH);
            		}
            	}
            	
            	if(line.equals(balanceString)) {
            		line = updateString;
            		balanceString = "";
            		updateString = "";
            	}
            	
            	tempDb.println(line);
            	tempDb.flush();
            }
            
            tempDb.close();
            db.close();
            
        	mainFile.delete();
        	tempFile.renameTo(mainFile);
	        
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		try {
			File mainFile = new File(filePath);
			BufferedReader db = new BufferedReader(new FileReader(filePath));
	        PrintWriter tempDb = new PrintWriter(new FileWriter(tempFile));
	        
	        int totalLines = 0;
            while (db.readLine() != null)
                totalLines++;

            for (int i = 0; i < totalLines; i++) {
            	String line = Files.readAllLines(Paths.get(filePath)).get(i);
            	if(line.equals(sender)) {
            		if(toCurr == "BTC") {
            		    balanceString = Files.readAllLines(Paths.get(filePath)).get(i + 1);
            			updateString = "BTC:"+util.doubleToString(this.account.BTC);
            		}
            		if(toCurr == "LTC") {
            		    balanceString = Files.readAllLines(Paths.get(filePath)).get(i + 2);
            			updateString = "LTC:"+util.doubleToString(this.account.LTC);
            		}
            		if(toCurr == "ETH") {
            		    balanceString = Files.readAllLines(Paths.get(filePath)).get(i + 3);
            			updateString = "ETH:"+util.doubleToString(this.account.ETH);
            		}
            	}
            	
            	if(line.equals(balanceString)) {
            		line = updateString;
            		balanceString = "";
            		updateString = "";
            	}
            	
            	tempDb.println(line);
            	tempDb.flush();
            }
            
            tempDb.close();
            db.close();
            

        	mainFile.delete();
        	tempFile.renameTo(mainFile);
        	
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return true;
	}
	
	public void actionPerformed(ActionEvent event ) {
		if(event.getSource() == logoutBtn) {
			Login screen = new Login();
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == homeBtn) {
			Home screen = new Home(this.account);
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == sendBtn) {
			Send screen = new Send(this.account);
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == exchangeSubmitBtn) {
			Boolean verified = ExchangeHandler();
			if(verified) {
				ExchangeSuccess screen = new ExchangeSuccess(this.account);
				this.setVisible(false);
				screen.setVisible(true);				
			}
		}
		if(event.getSource() == usersBtn) {
			Users screen  = new Users(this.account);
			this.setVisible(false);
			screen.setVisible(true);
		}
	}
}
