

import java.sql.*;
import javax.swing.*;

public class sqliteConnector {
	Connection conn=null;

	public static Connection dbConnector()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/liandri/workspace/ownerinfo.sqlite");
			System.out.println("connection sucessful");
			return conn;
		} catch (Exception e) {
			System.out.println("connection failed"+ e);
			return null;
		}
	}
}