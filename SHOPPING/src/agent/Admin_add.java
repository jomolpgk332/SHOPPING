package agent;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.Statement;

public class Admin_add {
	

	public void insert() throws SQLException, ClassNotFoundException {
		
		java.sql.Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","");
			Scanner s=new Scanner(System.in);
			System.out.println("Enter your choice\n1)Add product\n2)Display\n3)Remove\n4)Update\n5)Exit");
			int det=s.nextInt();
			switch(det)
			{
			case 1:
			System.out.println("enter the product id");
			int p_id=s.nextInt();
			System.out.println("enter the product name");
			String p_name=s.next();
			System.out.println("enter the minsellquantity");
			int p_misell=s.nextInt();
			System.out.println("enter the price");
			int p_price=s.nextInt();
			System.out.println("the product is added successfully");
			
				PreparedStatement st=con.prepareStatement("insert into add_product(pro_id,pro_name,min_sell_quantity,Price) values(?,?,?,?)");
				st.setInt(1, p_id);
				st.setString(2,p_name);
				st.setInt(3, p_misell);
				st.setInt(4, p_price);
				
				st.executeUpdate();
				
				break;
			case 2:
				Statement s1=(Statement) con.createStatement();
				ResultSet set=s1.executeQuery("select * from add_product"); 
				System.out.println("************DETAILS************");	
				while(set.next()) {
					//to display the values
					System.out.println("Product id\t-->\t"+set.getInt(1)+" \"Product name\t-->\t"+set.getString(2)+"\"Quantity\t-->\t" +set.getString(3));
					System.out.println("*******************************");
				}
				break;
			case 3:
				System.out.println("id to be deleted");
				int id=s.nextInt();
				PreparedStatement st1=con.prepareStatement("delete from add_product where pro_id=?");
				st1.setInt(1,id);
				st1.executeUpdate();
				System.out.println("product is deleted");
				break;
			case 4:
				Admin_update upd =new Admin_update();
				upd.updatedata();
				break;
			case 5:
				System.out.println("Process will be completed");
				return;}
			Admin_add ad=new Admin_add();

				ad.insert();

	}
}
