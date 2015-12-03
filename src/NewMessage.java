

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewMessage extends JFrame {

	private JPanel contentPane;
	private JTextField touserFeild;
	Connection conn = null;
	private JTextField msgFeild;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMessage frame = new NewMessage();
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
	public NewMessage() {
		conn = sqliteConnector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		touserFeild = new JTextField();
		touserFeild.setBounds(211, 12, 212, 19);
		contentPane.add(touserFeild);
		touserFeild.setColumns(10);
		
		JLabel lblToUser = new JLabel("To User");
		lblToUser.setBounds(150, 14, 70, 15);
		contentPane.add(lblToUser);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				//submit message to table
				try{
					String query ="insert into message (username, msg) values (?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, touserFeild.getText());
					pst.setString(2,  msgFeild.getText());
					//pst.setDate(3,  (java.sql.Date)ft.format(dNow));
					
					pst.execute();
					
					System.out.println("post message success");
					
					pst.close();
					dispose();
				}
				catch (Exception e7)
				{
					System.out.println("post message fail");
					JOptionPane.showMessageDialog(null, "Message Failed to post");
				}
			}
		});
		btnSubmit.setBounds(307, 224, 117, 25);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(33, 224, 117, 25);
		contentPane.add(btnCancel);
		
		msgFeild = new JTextField();
		msgFeild.setBounds(52, 41, 371, 171);
		contentPane.add(msgFeild);
		msgFeild.setColumns(10);
	}

}
