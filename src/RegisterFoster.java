

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

public class RegisterFoster extends JFrame {

	private JPanel contentPane;
	private String user;
	private String pass;
	private JTextField userFeild;
	private JTextField passFeild;
	private JTextField emailFeild;
	private JTextField firstFeild;
	private JTextField lastFeild;
	private JTextField locationFeild;
	private JTextField ageFeild;
	private JTextField contactFeild;
	private JTextField MemberFeild;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFoster frame = new RegisterFoster();
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
	public RegisterFoster() {
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
		lblRegister.setBounds(-41, -46, 214, 92);
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
		
		JLabel lblLocation = new JLabel("location");
		lblLocation.setBounds(353, 127, 70, 15);
		contentPane.add(lblLocation);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(364, 186, 70, 15);
		contentPane.add(lblAge);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(353, 236, 130, 15);
		contentPane.add(lblContactNumber);
		
		JLabel lblPaidMember = new JLabel("Paid Member");
		lblPaidMember.setBounds(353, 285, 130, 15);
		contentPane.add(lblPaidMember);
		
		locationFeild = new JTextField();
		locationFeild.setBounds(469, 125, 208, 19);
		contentPane.add(locationFeild);
		locationFeild.setColumns(10);
		
		ageFeild = new JTextField();
		ageFeild.setBounds(469, 184, 208, 19);
		contentPane.add(ageFeild);
		ageFeild.setColumns(10);
		
		contactFeild = new JTextField();
		contactFeild.setBounds(491, 234, 186, 19);
		contentPane.add(contactFeild);
		contactFeild.setColumns(10);
		
		MemberFeild = new JTextField();
		MemberFeild.setBounds(563, 283, 114, 19);
		contentPane.add(MemberFeild);
		MemberFeild.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into Fostr (username, email, firstname, lastname, location, password) values (?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, userFeild.getText());
					pst.setString(2, emailFeild.getText());
					pst.setString(3, firstFeild.getText());
					pst.setString(4, lastFeild.getText());
					pst.setString(5, locationFeild.getText());
					pst.setString(6, passFeild.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Owner Details saved");
					dispose();
					FosterGUI fosterGui = new FosterGUI();    //results foster gui
					
					fosterGui.setUser(userFeild.getText());
					fosterGui.setPass(passFeild.getText());
					fosterGui.setVisible(true);

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnRegister.setBounds(304, 412, 117, 25);
		contentPane.add(btnRegister);
		
		JLabel lblFostrRegister = new JLabel("fostr register");
		lblFostrRegister.setBounds(35, 283, 152, 15);
		contentPane.add(lblFostrRegister);
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
