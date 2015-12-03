

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Message extends JFrame {

	Connection conn = null;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Message frame = new Message();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void refreshTable()
	{
		try {
			
			
			String query ="select * from message";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} 
		catch (Exception e5) 
		{
			System.out.println("message table error on query");
			e5.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Message() {
		conn = sqliteConnector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				//exit
			}
		});
		btnExit.setBounds(35, 430, 117, 25);
		contentPane.add(btnExit);
		
		JButton displayMSG = new JButton("Display MSG");
		displayMSG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					String query ="select * from message";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} 
				catch (Exception e5) 
				{
					System.out.println("message table error on query");
					e5.printStackTrace();
				}
			}});
		displayMSG.setBounds(605, 430, 179, 25);
		contentPane.add(displayMSG);
		
		JButton btnNewMessage = new JButton("New Message");
		btnNewMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewMessage nmsg = new NewMessage();
				nmsg.setVisible(true);
			}
		});
		btnNewMessage.setBounds(294, 430, 160, 25);
		contentPane.add(btnNewMessage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 78, 747, 335);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//message to picked user
				
			}
		});
		scrollPane.setViewportView(table);
		refreshTable();
	}
}
