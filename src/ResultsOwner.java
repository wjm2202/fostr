

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResultsOwner extends JFrame {

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
					ResultsOwner frame = new ResultsOwner();
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
			String query = "select cid, username,firstname, dogname, location, age from owner";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	/**
	 * Create the frame.
	 */
	public ResultsOwner() {
		conn=sqliteConnector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load Results");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select cid, username,firstname, dogname, location, age from owner";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(564, 421, 194, 25);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				OwnerGUI ownerGui = new OwnerGUI();
			}
		});
		btnExit.setBounds(47, 421, 117, 25);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 47, 711, 362);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String EID_=(table.getModel().getValueAt(row, 0)).toString();
				SingleOwner so = new SingleOwner();
				so.setRow(row);
				so.setEID_(EID_);
				so.setVisible(true);
				dispose();
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/fostr_red.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(232, 363, 214, 84);
		contentPane.add(lblNewLabel);
		
		JLabel lblOwner = new JLabel("owner");
		lblOwner.setBounds(203, 426, 70, 15);
		contentPane.add(lblOwner);
		refreshTable();
	}

}
