package Main;


import java.util.ArrayList;

import model.deptDetails;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rabbitmq.clients.Send;
import services.RetrieveService;
import services.deleteService;
import services.insertService;
import services.updateService;

	@RestController
	public class RetrieveController {
		//@CrossOrigin
	    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
	    public  String getProductMethod1() throws Exception {
	    	RetrieveService service=new RetrieveService();
	    	
	    	return Send.send();
	    	
	    	  //return  "Message Sent!!";
	    }
	    
	    //@CrossOrigin
	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public @ResponseBody ArrayList<Integer> deleteDept(@PathVariable("id") int id) 
	    {
	    	System.out.println("delete");
	    	deleteService del=new deleteService();
	    	System.out.println(del.service(id));
	    	return del.service(id);
	    	
	       
	    }
	    
	    
	   /* @RequestMapping(value = "/{id}/{name}", method = RequestMethod.PUT)
	    public @ResponseBody String updateDept(@PathVariable("id") int id,@PathVariable("name") String name) 
	    {
	    	System.out.println("update");
	    	updateService update=new updateService();
	    	return update.service(id,name);
	    	
	       
	    }*/
	    //@CrossOrigin
	    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	    public @ResponseBody ArrayList<Object> updateDept(@PathVariable("id") int id,@RequestBody deptDetails user) 
	    {
	    	System.out.println("update");
	    	updateService update=new updateService();
	    	return update.service(id,user.getDeptName(),user.getDeptLocation());
	    	
	       
	    }
	    
	    
	   /* @RequestMapping(value = "/insert/{id}/{name}", method = RequestMethod.POST)
	    public @ResponseBody String insertDept(@PathVariable("id") int id,@PathVariable("name") String name) 
	    {
	    	System.out.println("insert");
	    	insertService insert=new insertService();
	    	return insert.service(id,name);
	    	
	       
	    }*/
	    
	    //@CrossOrigin
	    @RequestMapping(value = "/", method = RequestMethod.POST)
	    public @ResponseBody ArrayList<String> insert1Dept(@RequestBody deptDetails user) 
	    {
	    	System.out.println("insert");
	    	insertService insert=new insertService();
	    	//return insert.service(id,name);
	    	//user.setId(null);
	    	//System.out.println(user.getId());
	    	return insert.service(user.getDeptName(),user.getDeptLocation());
	    	
	       
	    }

	   
	

}
