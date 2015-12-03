

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
		userField.setBounds(222, 79, 195, 19);
		contentPane.add(userField);
		userField.setColumns(10);
		
		locationField = new JTextField();
		locationField.setBounds(222, 133, 195, 19);
		contentPane.add(locationField);
		locationField.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(104, 81, 100, 15);
		contentPane.add(lblUserName);
		
		JLabel lblDogName = new JLabel("Location");
		lblDogName.setBounds(111, 135, 107, 15);
		contentPane.add(lblDogName);
		
		btnNewButton_1 = new JButton("Message");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Message msg = new Message();
				msg.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(135, 217, 117, 25);
		contentPane.add(btnNewButton_1);
		
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
}
