import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Users extends JFrame implements ActionListener  {
	
	Account account;
	JButton homeBtn, sendBtn, exchangeBtn, logoutBtn, okBtn;
	
	String[] column = { "User Name", "Email", "Key", "BTC", "LTC", "ETH" };
	
	Users(Account account) {
		super("Cryptonance | All Users");
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
	
		
		DefaultTableModel model = new DefaultTableModel();
		String[] rows = new String[6];
	 
		JTable table = new JTable();
		table.setFont(new Font("Poppins", Font.PLAIN, 16));
		model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setRowHeight(30);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(91, 134, 981, 548);
		this.add(sp);
		
		logoutBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		exchangeBtn.addActionListener(this);
		
		this.add(panel1);
		
		
		
		  try {
			String filePath = "./database/users.txt";
			BufferedReader db = new BufferedReader(new FileReader(filePath));
			
			int totalLines = 0;
            while (db.readLine() != null)
                totalLines++;
            db.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(filePath)).get(i);
                String match = line.substring(0, 4);
                if (match.equals("User")) {
                    rows[0] = Files.readAllLines(Paths.get(filePath)).get(i).substring(12);
                    rows[1] = Files.readAllLines(Paths.get(filePath)).get(i + 1).substring(8);
                    rows[2] = Files.readAllLines(Paths.get(filePath)).get(i + 3).substring(6);
                    rows[3] = Files.readAllLines(Paths.get(filePath)).get(i + 4).substring(4);
                    rows[4] = Files.readAllLines(Paths.get(filePath)).get(i + 5).substring(4);
                    rows[5] = Files.readAllLines(Paths.get(filePath)).get(i + 6).substring(4);
                    model.addRow(rows);
                }
            }

	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	}
	
	
	public void actionPerformed(ActionEvent event ) {
		if(event.getSource() == logoutBtn) {
			Login screen = new Login();
			this.setVisible(false);
			screen.setVisible(true);
		}
		
		if(event.getSource() == sendBtn) {
			Send screen = new Send(this.account);
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
	}
}
