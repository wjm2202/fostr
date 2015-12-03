

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class initfoster {

	
	Connection conn = sqliteConnector.dbConnector();
	private String user;
	private String pass;
	AddOwner owner = new AddOwner();
	
	public initfoster(String user, String pass)
	{
		this.user=user;
		this.pass=pass;
	}
	
	
	
	public AddOwner startOwner(String user, String pass)
	{
		try {
			String query = "select * from Fostr where username =? and password=?";
			PreparedStatement pst= conn.prepareStatement(query);
			pst.setString(1, user);
			pst.setString(2, pass);
			
			ResultSet rs = pst.executeQuery();
			
			owner.setUsername(user);
			owner.setEmail(rs.getString(2));
			owner.setFirst(rs.getString(3));
			owner.setLast(rs.getString(4));
			owner.setUsername(rs.getString(5));
			owner.setLocation(rs.getString(6));
			owner.setPassword(pass);
			System.out.println("initfoster fosterer created success");
			
			rs.close();
			pst.close();
		} catch (Exception e) {
			System.out.println("create foster in init foster failed");
		}
		return owner;
	}
}
