

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OwnerGUI extends JFrame {

	private JPanel contentPane;
	static AddOwner curr;
	private JLabel lblOwnergui;
	private String user;
	private String pass;
	private JTextField userField;
	private JTextField locationField;
	private JButton btnNewButton_1;
	private JTextField dogFeild;
	private JTextField breedFeild;
	private JTextField emailFeild;
	private JLabel lblEmail;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerGUI frame = new OwnerGUI();
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
	public OwnerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("");
		//make picture button
		Image img = new ImageIcon(this.getClass().getResource("/fostr_red.png")).getImage();
		lblUser.setIcon(new ImageIcon(img));
		//end of picture button
		lblUser.setBounds(-63, -58, 237, 102);
		contentPane.add(lblUser);
		
		JButton btnNewButton = new JButton("Search Fosters");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResultsFoster fosterResults = new ResultsFoster();
				fosterResults.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(276, 217, 141, 25);
		contentPane.add(btnNewButton);
		
		lblOwnergui = new JLabel("ownerGUI");
		lblOwnergui.setBounds(44, 245, 70, 15);
		contentPane.add(lblOwnergui);
		
		userField = new JTextField();
		userField.setBounds(222, 25, 195, 19);
		contentPane.add(userField);
		userField.setColumns(10);
		
		locationField = new JTextField();
		locationField.setBounds(222, 56, 195, 19);
		contentPane.add(locationField);
		locationField.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(136, 25, 100, 15);
		contentPane.add(lblUserName);
		
		JLabel lblDogName = new JLabel("Location");
		lblDogName.setBounds(146, 56, 107, 15);
		contentPane.add(lblDogName);
		
		btnNewButton_1 = new JButton("Message");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Message msgObject = new Message();
				msgObject.setVisible(true);
				msgObject.setMsgObject(msgObject);
			}
		});
		btnNewButton_1.setBounds(135, 217, 117, 25);
		contentPane.add(btnNewButton_1);
		
		dogFeild = new JTextField();
		dogFeild.setBounds(222, 87, 195, 19);
		contentPane.add(dogFeild);
		dogFeild.setColumns(10);
		
		JLabel lblDog = new JLabel("Dog");
		lblDog.setBounds(156, 89, 70, 15);
		contentPane.add(lblDog);
		
		breedFeild = new JTextField();
		breedFeild.setBounds(222, 118, 195, 19);
		contentPane.add(breedFeild);
		breedFeild.setColumns(10);
		
		JLabel lblBreed = new JLabel("Breed");
		lblBreed.setBounds(156, 118, 70, 15);
		contentPane.add(lblBreed);
		
		emailFeild = new JTextField();
		emailFeild.setBounds(222, 149, 195, 19);
		contentPane.add(emailFeild);
		emailFeild.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(156, 151, 70, 15);
		contentPane.add(lblEmail);
		
	}

	public AddOwner getCurr() {
		return curr;
	}

	public void setCurr(AddOwner owner) {
		this.curr=owner;
		
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
	public void testOwner()
	{
		System.out.println(curr);
	}
	public void setFeilds()
	{
		userField.setText(curr.getUsername());
		locationField.setText(curr.getLocation());
		dogFeild.setText(curr.getDogName());
		breedFeild.setText(curr.getBreed());
		emailFeild.setText(curr.getEmail());
	}
}
