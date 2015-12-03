

import java.util.Scanner;
import javax.swing.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PasswordFosterTest {
	

	AddOwner foster = null;
	public boolean test(String user, String pass)
	{

		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		conn = sqliteConnector.dbConnector();
		boolean passed=false;
		
		
		try {
			String query = "select * from fostr where username =? and password=?";
			PreparedStatement pst= conn.prepareStatement(query);
			pst.setString(1, user);
			pst.setString(2, pass);
			
			ResultSet rs = pst.executeQuery();
			int count=0;
			while(rs.next())
			{
				count++;
				if (count==1)
				{
					System.out.println("User name and password is correct");
					passed=true;
					
				}
				else if(count>1)
				{
					System.out.println("duplicate username and password");
					passed = false;
				}
				else
				{
					System.out.println("User name and password is incorrect");
					passed = false;
				}
			}
			rs.close();
			pst.close();
		} catch (Exception e) {
			System.out.println("password faild auth");
		}
		return passed;
	}
}
	

