package agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Agent_login {
	
	
	Scanner s=new Scanner(System.in);
	
     Connectionm con = new Connectionm();
	public void login() throws SQLException, ClassNotFoundException {
		
		System.out.println("Enter the username");
		String name=s.next();
		System.out.println("Enter the password");
		String pass=s.next();
		int flag=0;
		Statement st=((Connection) con.getconnection()).createStatement();
	
		
		ResultSet set1=st.executeQuery("select * from agentlogin"); 
		
		while(set1.next()) {
			//to display the values
			String name1=set1.getString(1);
			String pw1=set1.getString(2);
		
		if(name1.contentEquals(name)&& pw1.contentEquals(pass)) {
			flag=1;
		}
	}
	if(flag==1) {
		System.out.println("welcome agent");
	}
	else {
		System.out.println("invalid");
	}
	Agent_login ag=new Agent_login();
	ag.option();
	}

	public void option() throws ClassNotFoundException, SQLException {
	
				System.out.println("\nEnter your choice\n1)BuySell\n2)View Product\n3)Logout");
				int num=s.nextInt();
				if(num==1)
				{
					Statement st1= con.getconnection().createStatement();

					ResultSet r=st1.executeQuery("select * from add_product");

					while(r.next())//iterating the values of result
					{
						System.out.println("Product id\t-->\t"+r.getInt(1)+"\n"+"Product name\t-->\t"+r.getString(2)+"\n"+"Quantity\t-->\t"+r.getInt(3)+"\n"+"Price\t\t-->\t"+r.getInt(4)+" \n");
					}
					System.out.println("*******************************");

					
					System.out.println("Enter the Product id you want to buy");
					int buy =s.nextInt();
					System.out.println("Quantity");
					int quan=s.nextInt();
					int pri,tot,qa;
					ResultSet resu=st1.executeQuery("select * from add_product");
					while(resu.next()) {
						int id=resu.getInt(1);
						if(id==buy) {
							pri=resu.getInt(4);
							qa=resu.getInt(3);
							tot=pri*quan;
							System.out.println("Cost-->"+tot);
							System.out.println("Enter 1 if you want to continue");
							int enter=s.nextInt();
							if(enter==1) {
								System.out.println("Booking confirmed");
								int ta=qa-quan;
								PreparedStatement sta=con.getconnection().prepareStatement("update add_product set min_sell_quantity=? where pro_id=?");
								sta.setInt(1, ta);
								sta.setInt(2,buy);
								sta.executeUpdate();
								
							}
							
						}
					}
					
					con.getconnection().close();
			
				}
				if(num==2) {
					My_First_App first1=new My_First_App();
					int i=1;
					System.out.println("List of products--->>");
					System.out.println("*******************************");
					Statement st1= ((Connection) con.getconnection()).createStatement();

					ResultSet r=st1.executeQuery("select * from add_product");//query to select the details of all students
					//objects returned from the query by repeatedly calling Statement
					System.out.println("Details-->");
					while(r.next())//iterating the values of result
					{
						System.out.println("Product details"+i);
						System.out.println("Product id\t-->\t"+r.getInt(1)+"\n"+"Product name\t-->\t"+r.getString(2)+"\n"+"Quantity\t-->\t"+r.getInt(3)+"\n"+"Price\t\t-->\t"+r.getInt(4)+" \n");
						i++;
					}
					System.out.println("*******************************");

					
					}
					if(num==3) {
						return;
						
					}
	
					Agent_login ag=new Agent_login();
					ag.option();
	}
		
	}


