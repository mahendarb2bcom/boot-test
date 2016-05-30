package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class deleteService {
	String sql= "delete from department where deptid=?";
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/emp1";

	 static final String USER = "root";
	 static final String PASS = "";
	 public ArrayList<Integer> service(Integer id) 
	{
		Connection conn = null;
		
		   try{
		      
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("in");
		      
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      PreparedStatement ps = conn.prepareStatement(sql);
		      
		      ps.setInt(1,id);
				ps.executeUpdate();
				
		        
		     
		   }catch(SQLException se){
		      
		      se.printStackTrace();
		   }catch(Exception e){
		    
		      e.printStackTrace();
		   }
		   ArrayList<Integer> a = new ArrayList<Integer>();
			 a.add(id);
			 return a;
		   }


}
