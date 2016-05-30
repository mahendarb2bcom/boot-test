package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class updateService {
String sql= "update department set deptname=?,deptlocation =? where deptid=?";
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/emp1";

	 static final String USER = "root";
	 static final String PASS = "";
	public ArrayList<Object> service(int id, String name,String location)
	{
		Connection conn = null;
		
		   try{
		      
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("in");
		      
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      PreparedStatement ps = conn.prepareStatement(sql);
		      
		      ps.setString(1,name);
		      ps.setString(2,location);
		      ps.setInt(3,id);
				ps.executeUpdate();
				
		        
		     
		   }catch(SQLException se){
		      
		      se.printStackTrace();
		   }catch(Exception e){
		    
		      e.printStackTrace();
		   }
		   ArrayList<Object> a = new ArrayList<Object>();
			 a.add(name);
			 a.add(location);
			 a.add(id);
			 return a;
		   }


}
