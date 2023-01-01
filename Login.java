import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Login extends JFrame  implements ActionListener  {
	JButton loginBtn, registerText;
	JTextField emailField, passwordField;
	
	Login() {
		super("Cryptonance | Login");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		ImageIcon icon = new ImageIcon("images/icon.png");
		this.setIconImage(icon.getImage());
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(19,19,19));
		panel1.setBounds(0, 0, 600, 800);
		
		ImageIcon leftimg = new ImageIcon("images/login-img.jpg");
		JLabel LeftImage = new JLabel("", leftimg, JLabel.CENTER);
		LeftImage.setBounds(0, 0, 600, 800);
		panel1.add(LeftImage);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(19,19,19));
		panel2.setBounds(600, 0, 600, 800);
		
		JLabel loginText = new JLabel("Login to your Wallet");
		loginText.setBounds(793, 168, 235, 41);
		loginText.setFont(new Font("Poppins", Font.BOLD, 24));
		loginText.setForeground(Color.white);
		panel2.add(loginText);
		
		JLabel emailText = new JLabel("Email");
		emailText.setBounds(669, 285, 45, 26);
		emailText.setFont(new Font("Poppins", Font.PLAIN, 16));
		emailText.setForeground(Color.white);
		panel2.add(emailText);
		
		emailField = new JTextField();
		emailField.setBounds(669, 314, 463, 48);
		emailField.setFont(new Font("Poppins", Font.PLAIN, 16));
		emailField.setForeground(Color.black);
		emailField.setBackground(new Color(197,197,197));
		emailField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel2.add(emailField);
		
		JLabel passwordText = new JLabel("Password");
		passwordText.setBounds(669, 384, 77, 27);
		passwordText.setFont(new Font("Poppins", Font.PLAIN, 16));
		passwordText.setForeground(Color.white);
		panel2.add(passwordText);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(669, 417, 463, 48);
		passwordField.setFont(new Font("Poppins", Font.PLAIN, 16));
		passwordField.setForeground(Color.black);
		passwordField.setBackground(new Color(197,197,197));
		passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel2.add(passwordField);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(669, 490, 122, 38);
		loginBtn.setBackground(new Color(85,151,251));
		loginBtn.setForeground(Color.white);
		loginBtn.setFont(new Font("Poppins", Font.BOLD, 18));
		loginBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		loginBtn.setFocusable(false);
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel2.add(loginBtn);
		
		JLabel helpText = new JLabel("Don’t have an account?");
		helpText.setBounds(669, 601, 191, 24);
		helpText.setFont(new Font("Poppins", Font.PLAIN, 16));
		helpText.setForeground(Color.white);
		panel2.add(helpText);
		
		registerText = new JButton("Register here");
		registerText.setBounds(840, 601, 110, 24);
		registerText.setFont(new Font("Poppins", Font.PLAIN, 16));
		registerText.setForeground(new Color(85,151,251));
		registerText.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registerText.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		registerText.setFocusable(false);
		registerText.setFocusPainted(false); 
		registerText.setContentAreaFilled(false);
		panel2.add(registerText);
		
		registerText.addActionListener(this);
		loginBtn.addActionListener(this);
		
		this.add(panel1);
		this.add(panel2);
	}
	
	public void actionPerformed(ActionEvent event ) {
		if(event.getSource() == registerText) {
			Register register = new Register();
			this.setVisible(false);
			register.setVisible(true);
		}
		if(event.getSource() == loginBtn) {
			String email = emailField.getText();
			String password = passwordField.getText();
			
			if(email.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(null, 
						"Please enter all the required fields", "Warning!", 
						JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					String filePath = "./database/users.txt";
					String emailMatch = "Email : " + email;
					String passwordMatch = "Password : " + password;
					BufferedReader db = new BufferedReader(new FileReader(filePath));
					
					int totalLines = 0;
                    while (db.readLine() != null)
                        totalLines++;
                    db.close();
                    
                    for (int i = 0; i <= totalLines; i++) {
                    	String findEmail = Files.readAllLines(Paths.get(filePath)).get(i);
                    	if(findEmail.equals(emailMatch)) {
                    		String findPassword = Files.readAllLines(Paths.get(filePath)).get(i + 1);
                    		if(findPassword.equals(passwordMatch)) {
                    			String username = Files.readAllLines(Paths.get(filePath)).get(i - 1);
                    			String key = Files.readAllLines(Paths.get(filePath)).get(i + 2);
                    			String btc = Files.readAllLines(Paths.get(filePath)).get(i + 3);
                    			String ltc = Files.readAllLines(Paths.get(filePath)).get(i + 4);
                    			String eth = Files.readAllLines(Paths.get(filePath)).get(i + 5);
                    			double BTC = Double.parseDouble(btc.substring(btc.lastIndexOf(":") + 1));
                    			double LTC = Double.parseDouble(ltc.substring(ltc.lastIndexOf(":") + 1));
                    			double ETH = Double.parseDouble(eth.substring(eth.lastIndexOf(":") + 1));
                    			Account account = new Account(username, email, key, BTC, LTC, ETH);
                    			Home home = new Home(account);
                    			home.setVisible(true);
                    			this.setVisible(false);
                    			break;
                    		}
                    	} 
                    }
                    
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, 
							"Invalid Email or Password!", "Warning", 
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}
