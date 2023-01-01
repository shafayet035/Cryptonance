import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Send extends JFrame  implements ActionListener{
	Account account;
	JButton homeBtn, sendBtn, exchangeBtn, logoutBtn, sendSubmitBtn, usersBtn;
	
	String[] currency = new String[] {"BTC", "LTC", "ETH"};
	
	JComboBox curSelect; 
	JTextField amountField, recieverField, noteField;
	Utils util = new Utils();
	
	Send(Account account) {
		super("Cryptonance | Send");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.account = account;
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(19,19,19));
		panel1.setBounds(0, 0, 1200, 800);
		
		ImageIcon icon = new ImageIcon("images/icon.png");
		this.setIconImage(icon.getImage());
		
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
		curSelect.setFocusable(false);
		curSelect.setFont(new Font("Poppins", Font.PLAIN, 18));
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
		
		JLabel l5 = new JLabel("Current Balance");
		l5.setBounds(91, 151, 144, 24);
		l5.setFont(new Font("Poppins", Font.BOLD, 18));
		l5.setForeground(Color.white);
		panel1.add(l5);
		
		JLabel l6 = new JLabel("BTC - " + util.doubleToString(this.account.BTC));
		l6.setBounds(91, 190, 160, 24);
		l6.setFont(new Font("Poppins", Font.BOLD, 16));
		l6.setForeground(Color.white);
		panel1.add(l6);
		
		JLabel l7 = new JLabel("LTC  - " + util.doubleToString(this.account.LTC));
		l7.setBounds(91, 222, 160, 24);
		l7.setFont(new Font("Poppins", Font.BOLD, 16));
		l7.setForeground(Color.white);
		panel1.add(l7);
		
		JLabel l8 = new JLabel("ETH  - " + util.doubleToString(this.account.ETH));
		l8.setBounds(91, 254, 160, 24);
		l8.setFont(new Font("Poppins", Font.BOLD, 16));
		l8.setForeground(Color.white);
		panel1.add(l8);
		
		logoutBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		sendSubmitBtn.addActionListener(this);
		exchangeBtn.addActionListener(this);
		usersBtn.addActionListener(this);
		
		panel1.add(panel2);
		this.add(panel1);
	}
	
	private Boolean TransferHandler() {
		
		String currency = curSelect.getSelectedItem().toString();
		String amountString = amountField.getText();
		String reciever = "KEY : " + recieverField.getText();
		String sender = this.account.key;
		String note = noteField.getText();
		String filePath = "./database/users.txt";
		String snAmountString = "", snNewbalanceString = "", rcAmountString = "", newbalanceString = "";
		Boolean isReceiver = false;
		
		if(amountString.isEmpty() || reciever.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter all the required fields");
			return false;
		} 
		
		if(!util.checkOnlyNumbers(amountString)) {
			JOptionPane.showMessageDialog(null, "Please enter only decimal number to amount field");
			return false;
		} 
		
		double amount = Double.parseDouble(amountField.getText());
		
		if(currency == "BTC" && amount > this.account.BTC) {
			JOptionPane.showMessageDialog(null, "Not Enough Balance");
			return false;
		}
		
		if(currency == "LTC" && amount > this.account.LTC) {
			JOptionPane.showMessageDialog(null, "Not Enough Balance");
			return false;
		}
		
		if(currency == "ETH" && amount > this.account.ETH) {
			JOptionPane.showMessageDialog(null, "Not Enough Balance");
			return false;
		}
		
		if(reciever.equals(sender)) {
			JOptionPane.showMessageDialog(null, "You can't transfer to yourself, LOL!");
			return false;
		}
		
		try {
			File mainFile = new File(filePath);
			BufferedReader db = new BufferedReader(new FileReader(filePath));
			
			File tempFile = new File("./database/users-temp.txt");
	        PrintWriter tempDb = new PrintWriter(new FileWriter(tempFile));
	        
			
			int totalLines = 0;
            while (db.readLine() != null)
                totalLines++;
            
            
            for (int i = 0; i < totalLines; i++) {
            	String line = Files.readAllLines(Paths.get(filePath)).get(i);
            	
            	if(line.equals(sender)) {
            		if(currency == "BTC") {
            			snAmountString = Files.readAllLines(Paths.get(filePath)).get(i + 1);
            		}
            		if(currency == "LTC") {
            			snAmountString = Files.readAllLines(Paths.get(filePath)).get(i + 2);
            		}
            		if(currency == "ETH") {
            			snAmountString = Files.readAllLines(Paths.get(filePath)).get(i + 3);
            		}
            		
            		double snBalance = Double.parseDouble(snAmountString.substring(snAmountString.lastIndexOf(":") + 1));
            		double newBalance = snBalance - amount;
            		snNewbalanceString = currency+":"+newBalance;
            	}
            	
            	if(line.equals(reciever)) {
            		isReceiver = true;
            		if(currency == "BTC") {
            			rcAmountString = Files.readAllLines(Paths.get(filePath)).get(i + 1);
            			this.account.setBtc(this.account.BTC - amount);
            		}
            		if(currency == "LTC") {
            			rcAmountString = Files.readAllLines(Paths.get(filePath)).get(i + 2);
            			this.account.setLtc(this.account.LTC - amount);
            		}
            		if(currency == "ETH") {
            			rcAmountString = Files.readAllLines(Paths.get(filePath)).get(i + 3);
            			this.account.setEth(this.account.ETH - amount);
            		}
            		
            		double rcBalance = Double.parseDouble(rcAmountString.substring(rcAmountString.lastIndexOf(":") + 1));
            		double newBalance = rcBalance + amount;
            		newbalanceString = currency+":"+newBalance;
            	}
             	
            	if(line.equals(rcAmountString)) {
            		line = newbalanceString;
                	rcAmountString = "";
            	}
            	
            	
            	if(line.equals(snAmountString)) {
            		line = snNewbalanceString;
            		snAmountString = "";
            	}
            	
            	tempDb.println(line);
            	tempDb.flush();
            	
            }
            
            tempDb.close();
            db.close();

        	if(!isReceiver) {
        		JOptionPane.showMessageDialog(null, "Receiver not found!");
        		tempFile.delete();
        		return false;
        	} 
        	
			if (!mainFile.delete())
	            System.out.println("Could not delete file");
			 
			if (!tempFile.renameTo(mainFile))
	           System.out.println("Could not rename file");
	        	
            
		 } catch(Exception e) {
			JOptionPane.showMessageDialog(null, "User not found!");
		}
		TransactionSave(sender.substring(sender.lastIndexOf(":") + 2), 
				reciever.substring(reciever.lastIndexOf(":") + 2), currency, amount, note);
		return true;
	}
	
	private void TransactionSave(String sender, String receiver, String currency, double amount, String note) {
		try {
			File db = new File("./database/transactions.txt");
			if(!db.exists()) db.createNewFile();
			FileWriter fw = new FileWriter(db, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("===============================================");
            pw.println("sender : " + sender);
            pw.println("receiver : " + receiver);
            pw.println("currency : " + currency);
            pw.println("amount : " + util.doubleToString(amount));
            pw.println("Note : " + note);
            pw.println("===============================================");
            pw.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Techincal Error, Please contact support team!");
		}
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
		
		
		if(event.getSource() == exchangeBtn) {
			Exchange screen  = new Exchange(this.account);
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == sendSubmitBtn) {
			Boolean verified = TransferHandler();
			if(verified) {
				SendSuccess screen = new SendSuccess(this.account);
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
