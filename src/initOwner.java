

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class initOwner {

	
	Connection conn = sqliteConnector.dbConnector();
	private String user;
	private String pass;
	AddOwner owner = new AddOwner();
	
	public AddOwner startOwner(String user, String pass)
	{
		try {
			String query = "select * from Owner where username =? and password=?";
			PreparedStatement pst= conn.prepareStatement(query);
			pst.setString(1, user);
			pst.setString(2, pass);
			
			ResultSet rs = pst.executeQuery();
			
			owner.setUsername(user);
			owner.setEmail(rs.getString(3));
			owner.setFirst(rs.getString(4));
			owner.setLast(rs.getString(5));
			owner.setDogName(rs.getString(6));
			owner.setBreed(rs.getString(7));
			owner.setLocation(rs.getString(8));
			owner.setPassword(rs.getString(9));
			System.out.println("init owner create owner success");
			rs.close();
			pst.close();
		} catch (Exception e) {
			System.out.println("create owner in initOwner failed");
		}
		return owner;
	}
}
