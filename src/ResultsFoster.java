

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResultsFoster extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultsFoster frame = new ResultsFoster();
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
			String query = "select fid, username,firstname, location from Fostr";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();

		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	
	}
	/**
	 * Create the frame.
	 */
	public ResultsFoster() {
		conn = sqliteConnector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("load results");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select fid, username,firstname, location from Fostr";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
	
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton.setBounds(582, 429, 163, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 31, 683, 378);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String EID_=(table.getModel().getValueAt(row, 0)).toString();
				SingleFoster sf = new SingleFoster();
				sf.setRow(row);
				sf.setEID_(EID_);
				sf.setVisible(true);
				dispose();
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OwnerGUI ownerGui = new OwnerGUI();
			}
		});
		btnExit.setBounds(48, 429, 117, 25);
		contentPane.add(btnExit);
		
		JLabel lblSearchResults = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/fostr_red.png")).getImage();
		lblSearchResults.setIcon(new ImageIcon(img));
		lblSearchResults.setBounds(238, 375, 214, 95);
		contentPane.add(lblSearchResults);
		
		JLabel lblFostr = new JLabel("fostr");
		lblFostr.setBounds(487, 434, 70, 15);
		contentPane.add(lblFostr);
		
		refreshTable();
	}
}
