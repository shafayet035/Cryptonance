import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register extends JFrame implements ActionListener {
	JButton loginText, registerBtn;
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
		
		JTextField userNameField = new JTextField();
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
		
		JTextField emailField = new JTextField();
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
		
		JPasswordField  passwordField = new JPasswordField();
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
			this.hide();
			login.show();
		}
		if(event.getSource() == registerBtn) {
			Home home = new Home();
			this.hide();
			home.show();
		}
	}
}
