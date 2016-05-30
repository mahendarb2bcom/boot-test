package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class insertService {
String sql="insert into department values(null,?,?)";
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/emp1";

	 static final String USER = "root";
	 static final String PASS = "";
	public ArrayList<String> service(String name,String location)
	{
		Connection conn = null;
		
		   try{
		      
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("in");
		      
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      PreparedStatement ps = conn.prepareStatement(sql);
		      
		    //  ps.setInt(1,id);
		      ps.setString(1,name);
		      ps.setString(2,location);
				ps.executeUpdate();
				
		        
		     
		   }catch(SQLException se){
		      
		      se.printStackTrace();
		   }catch(Exception e){
		    
		      e.printStackTrace();
		   }
		   ArrayList<String> a = new ArrayList<String>();
			 a.add(name);
			 a.add(location);
			 return a;
		   }

	
	

}
