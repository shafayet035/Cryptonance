import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Register extends JFrame implements ActionListener {
	JButton loginText, registerBtn;
	JTextField userNameField, emailField, passwordField;
	Register() {
		super("Cryptonance | Register");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		ImageIcon leftimg = new ImageIcon("images/login-img.jpg");
		JLabel LeftImage = new JLabel("", leftimg, JLabel.CENTER);
		LeftImage.setBounds(0, 0, 600, 800);
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(19,19,19));
		panel1.setBounds(0, 0, 600, 800);
		
		panel1.add(LeftImage);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(19,19,19));
		panel2.setBounds(600, 0, 600, 800);
		
		JLabel registerLabel = new JLabel("Register to Cryptonance");
		registerLabel.setBounds(754, 128, 292, 36);
		registerLabel.setFont(new Font("Poppins", Font.BOLD, 24));
		registerLabel.setForeground(Color.white);
		panel2.add(registerLabel);
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(669, 223, 83, 24);
		userNameLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
		userNameLabel.setForeground(Color.white);
		panel2.add(userNameLabel);
		
		userNameField = new JTextField();
		userNameField.setBounds(669, 252, 463, 48);
		userNameField.setFont(new Font("Poppins", Font.PLAIN, 16));
		userNameField.setForeground(Color.black);
		userNameField.setBackground(new Color(197,197,197));
		userNameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel2.add(userNameField);
		
		JLabel emailText = new JLabel("Email");
		emailText.setBounds(669, 325, 44, 24);
		emailText.setFont(new Font("Poppins", Font.PLAIN, 16));
		emailText.setForeground(Color.white);
		panel2.add(emailText);
		
		emailField = new JTextField();
		emailField.setBounds(669, 354, 463, 48);
		emailField.setFont(new Font("Poppins", Font.PLAIN, 16));
		emailField.setForeground(Color.black);
		emailField.setBackground(new Color(197,197,197));
		emailField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel2.add(emailField);
		
		JLabel passwordText = new JLabel("Password");
		passwordText.setBounds(669, 428, 77, 24);
		passwordText.setFont(new Font("Poppins", Font.PLAIN, 16));
		passwordText.setForeground(Color.white);
		panel2.add(passwordText);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(669, 456, 463, 48);
		passwordField.setFont(new Font("Poppins", Font.PLAIN, 16));
		passwordField.setForeground(Color.black);
		passwordField.setBackground(new Color(197,197,197));
		passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel2.add(passwordField);
		
		registerBtn = new JButton("Register");
		registerBtn.setBounds(669, 540, 122, 38);
		registerBtn.setBackground(new Color(85,151,251));
		registerBtn.setForeground(Color.white);
		registerBtn.setFont(new Font("Poppins", Font.BOLD, 18));
		registerBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		registerBtn.setFocusable(false);
		registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel2.add(registerBtn);
		
		JLabel helpText = new JLabel("Already have an account?");
		helpText.setBounds(669, 639, 211, 24);
		helpText.setFont(new Font("Poppins", Font.PLAIN, 16));
		helpText.setForeground(Color.white);
		panel2.add(helpText);
		
		loginText = new JButton("Login here");
		loginText.setBounds(860, 639, 83, 24);
		loginText.setFont(new Font("Poppins", Font.PLAIN, 16));
		loginText.setForeground(new Color(85, 151, 251));
		loginText.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginText.setFocusable(false);
		loginText.setFocusPainted(false); 
		loginText.setContentAreaFilled(false);
		loginText.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		panel2.add(loginText);
		
		loginText.addActionListener(this);
		registerBtn.addActionListener(this);
		
		this.add(panel1);
		this.add(panel2);
	}
	
	public void actionPerformed(ActionEvent event ) {
		
		if(event.getSource() == loginText) {
			Login login = new Login();
			this.setVisible(false);
			login.setVisible(true);
		}
		
		if(event.getSource() == registerBtn) {
			Utils util = new Utils();
			Account account;
			
			String userName = userNameField.getText();
			String email = emailField.getText();
			String password = passwordField.getText();
			String userKey = util.randromString(25);
			
			if(userName.isEmpty() || email.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(null, 
						"Please enter all the required fields", "Warning!", 
						JOptionPane.WARNING_MESSAGE);
			} else if(!util.isValid(email)) {
				JOptionPane.showMessageDialog(null, "Please enter a valid email address!", "Warning!", JOptionPane.WARNING_MESSAGE);
			} else if(password.length() < 6) {
				JOptionPane.showMessageDialog(null, "Enter at least 6 character long password!", "Warning!", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					File db = new File("./database/users.txt");
					if(!db.exists()) db.createNewFile();
					FileWriter fw = new FileWriter(db, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    pw.println("===============================================");
                    pw.println("User Name : " + userName);
                    pw.println("Email : " + email);
                    pw.println("Password : " + password);
                    pw.println("KEY : " + userKey);
                    pw.println("BTC:0.0006897");
                    pw.println("LTC:"+0.15);
                    pw.println("ETH:"+0.0084);
                    pw.println("===============================================");
                    pw.close();
                    account = new Account(userName, email, userKey, 0.0006897, 0.15, 0.0084);
                    Home home = new Home(account);
        			this.setVisible(false);
        			home.setVisible(true);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Techincal Error, Please contact support team!", "Error!",
                            JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
