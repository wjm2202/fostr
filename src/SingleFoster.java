

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SingleFoster extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JTextField locationFeild;
	private JTextField firstField;
	private JTextField lastFeild;
	private int row;
	private String EID_;
	private JButton btnDisplay;
	private JLabel lblEmail;
	private JTextField emailFeild;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleFoster frame = new SingleFoster();
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
	public SingleFoster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(26, 12, 126, 15);
		contentPane.add(lblUserName);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(36, 39, 70, 15);
		contentPane.add(lblLocation);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(26, 72, 126, 17);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(26, 101, 126, 15);
		contentPane.add(lblLastName);
		
		userField = new JTextField();
		userField.setBounds(128, 10, 293, 19);
		contentPane.add(userField);
		userField.setColumns(10);
		
		locationFeild = new JTextField();
		locationFeild.setBounds(138, 39, 294, 19);
		contentPane.add(locationFeild);
		locationFeild.setColumns(10);
		
		firstField = new JTextField();
		firstField.setBounds(148, 71, 294, 19);
		contentPane.add(firstField);
		firstField.setColumns(10);
		
		lastFeild = new JTextField();
		lastFeild.setBounds(146, 99, 286, 19);
		contentPane.add(lastFeild);
		lastFeild.setColumns(10);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerGUI owner = new OwnerGUI();
				owner.setVisible(true);
				dispose();
			}
		});
		btnExit.setBounds(36, 212, 117, 25);
		contentPane.add(btnExit);
		
		btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection conn = sqliteConnector.dbConnector();
					String query="select * from Fostr where fid='"+EID_+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						emailFeild.setText(rs.getString("email"));
						firstField.setText(rs.getString("firstname"));
						lastFeild.setText(rs.getString("lastname"));
						userField.setText(rs.getString("username"));
						locationFeild.setText(rs.getString("location"));
						
					}
					pst.close();
				}catch (Exception e2)
				{
					System.out.println("single foster textfeild error");
				}
				
			}
		});
		btnDisplay.setBounds(304, 212, 117, 25);
		contentPane.add(btnDisplay);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(26, 155, 70, 15);
		contentPane.add(lblEmail);
		
		emailFeild = new JTextField();
		emailFeild.setBounds(145, 157, 276, 19);
		contentPane.add(emailFeild);
		emailFeild.setColumns(10);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getEID_() {
		return EID_;
	}

	public void setEID_(String eID_) {
		EID_ = eID_;
	}

}
