package agent;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import crud.Connectionn;

public class My_First_App {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		My_First_App first=new My_First_App();
		first.choice();
		java.sql.Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","");

	}

	public void choice() throws ClassNotFoundException, SQLException {
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("1)Admin Login\n2)Agent Login\n3)Exit");
		System.out.println("Enter the choice");
		int n=s.nextInt();
		switch(n) {
		case 1:
			Login login =new Login();
			login.log();
			
			break;
			
			
			case 2:
				Agent_login ag =new Agent_login();
				ag.login();
				ag.option();
				break;
			case 3:
				System.out.println("procees completed");
				return;
			
			
}
		}
	}


