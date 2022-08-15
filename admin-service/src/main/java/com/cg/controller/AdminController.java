package com.cg.controller;

import java.util.Arrays;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.models.Admin;
import com.cg.models.OrderDetails;
import com.cg.models.Payment;
import com.cg.models.UserDetail;
import com.cg.models.UserRating;
import com.cg.models.Washers;
import com.cg.models.Washpack;
import com.cg.services.AdminService;
import com.cg.services.LoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.annotations.ApiOperation;

/* Name:Abhijeet kant
 * EmpId: 46195747
 * 
 * 
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController 
{
    
    
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private AdminService service;
	
	@Autowired
	private LoginService admin;
	
    @Autowired
	private RestTemplate restTemplate;
    
    //Admin operations
    @PostMapping("/addadmin")
    @ApiOperation(value="To Add admin Details")
    public String saveAdmin(@RequestBody Admin admin)
    {
    	logger.info("Adding Admin");
    	service.saveAdmin(admin);
		return "Registration Succefully!!!";
    }
    @PutMapping("account/update")
    @ApiOperation(value="To update admin details")
    public String updateAdmin(@RequestBody Admin admin,@RequestParam int id) {
    	logger.info("Updating the admin details");
    	service.updateAdmin(admin);
        return "Updated succesfully";
}
    
    @GetMapping("/alladmins")
	@ApiOperation(value = "To Get all Admins Details")
	public List<Admin> findAll() {
    	logger.info("Getting all admins");
    	return service.findAll();
		
	}
    @DeleteMapping("/account/delete")
	@ApiOperation(value = "To delete admin Details")
	public String deleteAdmin(@RequestBody Admin admin,@RequestParam int id ) {
    	logger.info("Deleting the  admin account");
    	service.deleteAdmin(id);
	 return "Deleted Succesfull!!!";

	}
    
    //Washpack operations
    
    @PostMapping("/addwashpack")
	@ApiOperation(value = "To Add washpack Details")
	public String saveWashpack(@RequestBody Washpack washpacks) {
    	logger.info("Adding washpacks");
    	washpacks.setId(service.getSequenceNumber(Washpack.SEQUENCE_NAME));
    	service.saveWashpack(washpacks);
		 return "WashPack Added Succesfully!!!";
	}
    @PutMapping("/washpack/update")
	@ApiOperation(value = "To update washpack Details")
	public String updateWashpack(@RequestBody Washpack updatepack ) {
    	logger.info("Updating washpack details");
    	service.updateWashpack(updatepack);
		return "Washpack updated Succesfull!!!";

	}
    @GetMapping("/washpack")
	@ApiOperation(value = "To get washpack Details")
	public List<Washpack> findAll1(){
    	logger.info("Getting List Of washpacks");
    	return service.getWashpack();

}
	@DeleteMapping("/washpack/delete")
	@ApiOperation(value = "To delete washpack Details")
	public String deletewashpack(@RequestBody Washpack admin,@RequestParam int id ) {
		 logger.info("Deleting washpacks");
		service.deleteWashpack(id);
	 return "Washpack Deleted Succesfully!!!";

	}
	
	
       //Rating 

	@GetMapping("/allratings")
	public List<UserRating> getUser()
	{
		logger.info("Getting all ratings");
		return service.getUser();
		
	}
	@PostMapping("/login")

	public String adminLogin(@RequestBody Admin login) {
		logger.info("Admin login");
		return admin.adminLogin(login);
	}
    //Rest template
	
	@GetMapping("/allorders")
	public List<OrderDetails> getwashpacks(){
		 String baseurl="http://localhost:8081/order/allorders";
		 OrderDetails[] orders=restTemplate.getForObject(baseurl, OrderDetails[].class);
		return Arrays.asList(orders);
		
	}
	
	
		
//		@GetMapping("/allpayment")
//		public List<Payment> getallpayment(){
//			 String baseurl="http://localhost:8083/payment/all";
//			 Payment[] pay=restTemplate.getForObject(baseurl, Payment[].class);
//			return Arrays.asList(pay);
//		}
		
			
			@GetMapping("/allusers")
			public List<UserDetail> getallusers(){
				 String baseurl="http://localhost:8083/user/allusers";
				 UserDetail[] user =restTemplate.getForObject(baseurl, UserDetail[].class);
				return Arrays.asList(user);
			
		
}
			@GetMapping("/allwasher")
			public List<Washers> getwasher(){
				 String baseurl="http://localhost:8082/washer/allwasher";
				 Washers[] washer =restTemplate.getForObject(baseurl, Washers[].class);
				return Arrays.asList(washer);
			
			
			}
	
	
	
	
	
}
