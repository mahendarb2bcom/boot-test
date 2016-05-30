package services;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

import model.deptDetails;
	





	public class RetrieveService {
		
		
		String sql= "SELECT deptid, deptname,deptlocation FROM department";
			ArrayList<deptDetails> details= new ArrayList<deptDetails>();
			
			static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			static final String DB_URL = "jdbc:mysql://localhost/emp1";

			 static final String USER = "root";
			 static final String PASS = "";
			public RetrieveService()
			{
				Connection conn = null;
				ResultSet rs = null;
				   
				   try{
				      
				      Class.forName("com.mysql.jdbc.Driver");

				      System.out.println("in");
				      
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      PreparedStatement ps = conn.prepareStatement(sql);
				      
				      rs = ps.executeQuery();

				      
				      while(rs.next()){
				         
				         deptDetails detail=new deptDetails();
				         detail.setId(rs.getInt("deptid"));
				         detail.setDeptName(rs.getString("deptname"));
				         detail.setDeptLocation(rs.getString("deptlocation"));
				        
						//System.out.print(rs.getInt("id"));
				       
						//System.out.print(rs.getString("name"));
				    details.add(detail);
				      }
				     
				     
				   }catch(SQLException se){
				      
				      se.printStackTrace();
				   }catch(Exception e){
				    
				      e.printStackTrace();
				   }
				   }

				
				
				
				
		
			
			public ArrayList<deptDetails> getDetails()
			{
				
				return details;
				
			}
		
}
