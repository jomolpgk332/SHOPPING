package agent;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import user_management.Connection;


public class Login {
	My_First_App con=new My_First_App();
	public void log() throws SQLException, ClassNotFoundException {

			java.sql.Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","");
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the username");
			String name=s.next();
			System.out.println("Enter the password");
			String pass=s.next();
			int flag=0;
			Statement st=(Statement)con.createStatement();
			ResultSet set=st.executeQuery("select * from admin_login"); 
			
			while(set.next()) {
				//to display the values
				String name1=set.getString(1);
				String pw1=set.getString(2);
			
			if(name1.contentEquals(name)&& pass.contentEquals(pw1)) 
				flag=1;
			}
			if(flag==1) {
				
				System.out.println("welcome admin ");
			}
			
Admin_add ad=new Admin_add();
ad.insert();
	}
		
		}
