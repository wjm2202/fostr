

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class RegisterOwnerGUI extends JFrame {

	private JPanel contentPane;
	private String user;
	private String pass;
	private JTextField userFeild;
	private JTextField passFeild;
	private JTextField emailFeild;
	private JTextField firstFeild;
	private JTextField lastFeild;
	private JTextField dogNameFeild;
	private JTextField breedFeild;
	private JTextField locationFeild;
	private JTextField textField_5;
	private JTextField ageFeild;
	private JTextField contactFeild;
	private JTextField MemberFeild;
	PasswordOwnerTest passtest = new PasswordOwnerTest();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterOwnerGUI frame = new RegisterOwnerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	/**
	 * Create the frame.
	 */
	public RegisterOwnerGUI() {
		conn = sqliteConnector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegister = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/fostr_red.png")).getImage();
		lblRegister.setIcon(new ImageIcon(img));
		lblRegister.setBounds(-53, -33, 201, 73);
		contentPane.add(lblRegister);

		userFeild = new JTextField();
		userFeild.setBounds(463, 35, 214, 19);
		contentPane.add(userFeild);
		userFeild.setColumns(10);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(320, 37, 105, 15);
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(330, 64, 70, 15);
		contentPane.add(lblPassword);

		passFeild = new JTextField();
		passFeild.setBounds(463, 66, 217, 19);
		contentPane.add(passFeild);
		passFeild.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(25, 127, 70, 15);
		contentPane.add(lblEmail);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(25, 186, 105, 15);
		contentPane.add(lblFirstName);

		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setBounds(25, 236, 162, 15);
		contentPane.add(lblNewLabel);

		JLabel lblDogName = new JLabel("Dog Name");
		lblDogName.setBounds(25, 290, 122, 15);
		contentPane.add(lblDogName);

		JLabel lblBreed = new JLabel("Breed");
		lblBreed.setBounds(25, 343, 122, 15);
		contentPane.add(lblBreed);

		emailFeild = new JTextField();
		emailFeild.setBounds(129, 125, 189, 19);
		contentPane.add(emailFeild);
		emailFeild.setColumns(10);

		firstFeild = new JTextField();
		firstFeild.setBounds(139, 184, 179, 19);
		contentPane.add(firstFeild);
		firstFeild.setColumns(10);

		lastFeild = new JTextField();
		lastFeild.setBounds(139, 234, 179, 19);
		contentPane.add(lastFeild);
		lastFeild.setColumns(10);

		dogNameFeild = new JTextField();
		dogNameFeild.setBounds(138, 288, 180, 19);
		contentPane.add(dogNameFeild);
		dogNameFeild.setColumns(10);

		breedFeild = new JTextField();
		breedFeild.setBounds(139, 341, 179, 19);
		contentPane.add(breedFeild);
		breedFeild.setColumns(10);

		JLabel lblLocation = new JLabel("location");
		lblLocation.setBounds(353, 127, 70, 15);
		contentPane.add(lblLocation);

		JLabel lblMedical = new JLabel("medical");
		lblMedical.setBounds(353, 186, 70, 15);
		contentPane.add(lblMedical);

		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(353, 236, 70, 15);
		contentPane.add(lblAge);

		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(353, 290, 130, 15);
		contentPane.add(lblContactNumber);

		JLabel lblPaidMember = new JLabel("Paid Member");
		lblPaidMember.setBounds(353, 343, 130, 15);
		contentPane.add(lblPaidMember);

		locationFeild = new JTextField();
		locationFeild.setBounds(469, 125, 208, 19);
		contentPane.add(locationFeild);
		locationFeild.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(469, 184, 208, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		ageFeild = new JTextField();
		ageFeild.setBounds(469, 234, 208, 19);
		contentPane.add(ageFeild);
		ageFeild.setColumns(10);

		contactFeild = new JTextField();
		contactFeild.setBounds(491, 288, 186, 19);
		contentPane.add(contactFeild);
		contactFeild.setColumns(10);

		MemberFeild = new JTextField();
		MemberFeild.setBounds(491, 341, 114, 19);
		contentPane.add(MemberFeild);
		MemberFeild.setColumns(10);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				try {
					String query = "insert into owner (username, email, firstname, lastname, dogname, breed, location, password) values (?,?,?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, userFeild.getText());
					pst.setString(2, emailFeild.getText());
					pst.setString(3, firstFeild.getText());
					pst.setString(4, lastFeild.getText());
					pst.setString(5, dogNameFeild.getText());
					pst.setString(6, breedFeild.getText());
					pst.setString(7, locationFeild.getText());
					pst.setString(8, passFeild.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Owner Details saved");
					dispose();
					OwnerGUI ownerGui = new OwnerGUI();    //results foster gui
					ownerGui.setUser(userFeild.getText());
					ownerGui.setPass(userFeild.getText());
					ownerGui.setVisible(true);
					
					pst.close();

				} catch (Exception e2) {
					System.out.println("database or customer object error in RegisterOwner");
				}

			}
		});
		btnRegister.setBounds(304, 412, 117, 25);
		contentPane.add(btnRegister);
		
		JLabel lblOwnerRegister = new JLabel("owner register");
		lblOwnerRegister.setBounds(61, 417, 138, 15);
		contentPane.add(lblOwnerRegister);
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

}
