

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class startGUI {

	public static AddOwner curr;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	Connection conn = null;
	PasswordOwnerTest passOTest = new PasswordOwnerTest();
	PasswordFosterTest passFTest = new PasswordFosterTest();
	String[] userOption = new String[] {"Dog Owner", "Dog Fostr", "Register Owner", "Register Foster"};
	private String selectedOption;
	private String user,pass;
	boolean status;
	private AddOwner  dogOwner= null;
	private AddOwner fosterer=null;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startGUI window = new startGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public startGUI() {
		initialize();
		conn = sqliteConnector.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (selectedOption.equals("Dog Owner"))
				{
					
					user=textField.getText();
					pass=passwordField.getText();
					status = passOTest.test(user, pass);
					//System.out.println("start gui dog owner \n"+status.toString());
					if(status==true)
					{
						frame.dispose();
						OwnerGUI ownerGui = new OwnerGUI();
						initOwner owner = new initOwner();
						dogOwner = owner.startOwner(user, pass);
						ownerGui.setCurr(dogOwner);
						ownerGui.setVisible(true);
						curr = dogOwner;
						//ownerGui.testOwner();                            //testing
					}
					else
					{
						JOptionPane.showMessageDialog(null, "User and Password not vailid");
					}
					
				}
				else if (selectedOption.equals("Dog Fostr"))
				{
					
					user=textField.getText();
					pass=passwordField.getText();
					status = passFTest.test(user, pass);
					//System.out.println("start gui selection fostr "+status.toString());
					if(status==true)
					{
						frame.dispose();
						FosterGUI fosterGui = new FosterGUI();
						initfoster foster = new initfoster(user, pass);
						fosterer = foster.startOwner();
						fosterGui.setCurr(fosterer);
						fosterGui.setVisible(true);
						fosterGui.setUser(user);
						curr = fosterer;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "User and Password not vailid");
					}
					
				}
				else if (selectedOption.equals("Register Owner"))
				{

					frame.dispose();
					RegisterOwnerGUI registerGui = new RegisterOwnerGUI();
					user=textField.getText();
					pass=passwordField.getText();
					registerGui.setUser(user);
					registerGui.setPass(pass);
					registerGui.setVisible(true);


				}
				else if (selectedOption.equals("Register Foster"))
				{

					frame.dispose();
					RegisterFoster fosterGui = new RegisterFoster();
					user=textField.getText();
					pass=passwordField.getText();
					fosterGui.setUser(user);
					fosterGui.setPass(pass);
					fosterGui.setVisible(true);


				}	
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(255, 221, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JComboBox<String> comboBox = new JComboBox(userOption);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				selectedOption = (String)cb.getSelectedItem();
			}
		});
		comboBox.setBounds(189, 47, 172, 24);
		frame.getContentPane().add(comboBox);
		
		
		textField = new JTextField();
		textField.setBounds(189, 109, 179, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(192, 148, 180, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Owner or Fostr");
		lblNewLabel.setBounds(37, 52, 179, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(65, 111, 106, 15);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(65, 150, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/fostr_red.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(-60, -45, 267, 89);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblManditorySelection = new JLabel("Manditory Selection");
		lblManditorySelection.setBounds(199, 70, 173, 15);
		frame.getContentPane().add(lblManditorySelection);
		
		JLabel lblStart = new JLabel("start");
		lblStart.setBounds(65, 226, 70, 15);
		frame.getContentPane().add(lblStart);
	}
}
