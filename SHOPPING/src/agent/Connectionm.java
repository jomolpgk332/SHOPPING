package agent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

	public class Connectionm {

	public Connection getconnection() throws ClassNotFoundException, SQLException
	{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=null;

			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","");
			if(con!=null)//connection checking 
			{
				return con;
			}
			else {
				System.out.println("check connection");
				return null;
			}
			
		}



	

	}