

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

public class SingleOwner extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JTextField emailField;
	private JTextField firstFeild;
	private JTextField lastField;
	private JTextField dogFeild;
	private JTextField locationFeild;
	private JTextField medicalFeild;
	private JTextField breedFeild;
	private int row;
	private String EID_;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleOwner frame = new SingleOwner();
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
	public SingleOwner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(35, 12, 109, 15);
		contentPane.add(lblUserName);
		
		JLabel lblE = new JLabel("Email");
		lblE.setBounds(35, 40, 70, 15);
		contentPane.add(lblE);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(35, 66, 109, 15);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(35, 93, 96, 15);
		contentPane.add(lblLastName);
		
		JLabel lblDogName = new JLabel("Dog Name");
		lblDogName.setBounds(35, 116, 99, 15);
		contentPane.add(lblDogName);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(35, 143, 70, 15);
		contentPane.add(lblLocation);
		
		JLabel lblMedical = new JLabel("Medical");
		lblMedical.setBounds(35, 170, 70, 15);
		contentPane.add(lblMedical);
		
		JLabel lblAge = new JLabel("Breed");
		lblAge.setBounds(35, 197, 70, 15);
		contentPane.add(lblAge);
		
		userField = new JTextField();
		userField.setBounds(162, 10, 254, 19);
		contentPane.add(userField);
		userField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(162, 38, 254, 19);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		firstFeild = new JTextField();
		firstFeild.setBounds(162, 64, 254, 19);
		contentPane.add(firstFeild);
		firstFeild.setColumns(10);
		
		lastField = new JTextField();
		lastField.setBounds(162, 91, 253, 19);
		contentPane.add(lastField);
		lastField.setColumns(10);
		
		dogFeild = new JTextField();
		dogFeild.setBounds(172, 114, 244, 19);
		contentPane.add(dogFeild);
		dogFeild.setColumns(10);
		
		locationFeild = new JTextField();
		locationFeild.setBounds(162, 141, 254, 19);
		contentPane.add(locationFeild);
		locationFeild.setColumns(10);
		
		medicalFeild = new JTextField();
		medicalFeild.setBounds(169, 168, 247, 19);
		contentPane.add(medicalFeild);
		medicalFeild.setColumns(10);
		
		breedFeild = new JTextField();
		breedFeild.setBounds(172, 195, 244, 19);
		contentPane.add(breedFeild);
		breedFeild.setColumns(10);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection conn = sqliteConnector.dbConnector();
					String query="select * from Owner where cid='"+EID_+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						userField.setText(rs.getString("username"));
						emailField.setText(rs.getString("email"));
						firstFeild.setText(rs.getString("firstname"));
						lastField.setText(rs.getString("lastname"));
						dogFeild.setText(rs.getString("dogname"));
						breedFeild.setText(rs.getString("breed"));
						locationFeild.setText(rs.getString("location"));

					}
					pst.close();
				}catch (Exception e2)
				{
					System.out.println("single owner textfeild error");
				}
				
				
			}
		});
		btnDisplay.setBounds(299, 226, 117, 25);
		contentPane.add(btnDisplay);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FosterGUI fost = new FosterGUI();
				fost.setVisible(true);
			}
		});
		btnExit.setBounds(35, 226, 117, 25);
		contentPane.add(btnExit);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setEID_(String eID_2) {
		this.EID_=eID_2;
		
	}

}
