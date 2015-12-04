

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FosterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField userFeild;
	static AddOwner curr;
	private String user="test";
	private String pass="test";
	private String location;
	private JTextField locationField;
	private JTextField emailFeild;
	private JTextField firstFeild;
	private JTextField lastFeild;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FosterGUI frame = new FosterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public FosterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFostr = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/fostr_red.png")).getImage();
		lblFostr.setIcon(new ImageIcon(img));
		lblFostr.setBounds(-72, -51, 264, 80);
		contentPane.add(lblFostr);
		
		JButton btnSearchOwners = new JButton("Search owners");
		btnSearchOwners.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ResultsOwner ownerResults = new ResultsOwner();
				ownerResults.setVisible(true);
				
			}
		});
		btnSearchOwners.setBounds(267, 211, 140, 25);
		contentPane.add(btnSearchOwners);
		
		userFeild = new JTextField();
		userFeild.setBounds(249, 27, 170, 19);
		contentPane.add(userFeild);
		userFeild.setColumns(10);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(185, 27, 70, 15);
		contentPane.add(lblUser);
		
		JLabel lblFostrgui = new JLabel("fostrGUI");
		lblFostrgui.setBounds(46, 216, 70, 15);
		contentPane.add(lblFostrgui);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(168, 60, 70, 15);
		contentPane.add(lblLocation);
		
		locationField = new JTextField();
		locationField.setBounds(249, 58, 172, 19);
		contentPane.add(locationField);
		locationField.setColumns(10);
		
		JButton btnMessages = new JButton("Messages");
		btnMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Message msgObject = new Message();
				msgObject.setVisible(true);
				msgObject.setMsgObject(msgObject);
			}
		});
		btnMessages.setBounds(134, 211, 117, 25);
		contentPane.add(btnMessages);
		
		emailFeild = new JTextField();
		emailFeild.setBounds(251, 89, 168, 19);
		contentPane.add(emailFeild);
		emailFeild.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(185, 91, 70, 15);
		contentPane.add(lblEmail);
		
		firstFeild = new JTextField();
		firstFeild.setBounds(249, 123, 170, 19);
		contentPane.add(firstFeild);
		firstFeild.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(142, 125, 96, 15);
		contentPane.add(lblFirstName);
		
		lastFeild = new JTextField();
		lastFeild.setBounds(249, 155, 170, 19);
		contentPane.add(lastFeild);
		lastFeild.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(144, 152, 96, 15);
		contentPane.add(lblLastName);
	
	}
	public AddOwner getCurr() {
		return curr;
	}

	public void setCurr(AddOwner curr) {
		this.curr = curr;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	public void testFoster()
	{
		System.out.println(curr);
	}
	public void setFeilds()
	{
		locationField.setText(curr.getLocation());
		userFeild.setText(curr.getUsername());
		emailFeild.setText(curr.getEmail());
		firstFeild.setText(curr.getFirst());
		lastFeild.setText(curr.getLast());
	}
	
}
