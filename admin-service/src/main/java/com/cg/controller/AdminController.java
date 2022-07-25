package com.cg.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.models.Admin;
import com.cg.models.OrderDetails;
import com.cg.models.PaymentDetails;
import com.cg.models.Signup;
import com.cg.models.UserRating;
import com.cg.models.Washers;
import com.cg.models.Washpack;
import com.cg.services.AdminService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
    
    
 /* Name:Abhijeet kant
  * EmpId: 46195747
  * Creation Date:24/07/22
  * Modification Date:25/07/22
  * 
  */
	@Autowired
	private AdminService service;
	
    @Autowired
	private RestTemplate restTemplate;
    //Admin operations
    @PostMapping("/addadmin")
    @ApiOperation(value="To Add admin Details")
    public String saveAdmin(@RequestBody Admin admin)
    {
    	service.saveAdmin(admin);
		return "Registration Succefully!!!";
    }
    @PutMapping("account/update")
    @ApiOperation(value="To update admin details")
    public String updateAdmin(@RequestBody Admin admin,@RequestParam int id) {
    	  
    	service.updateAdmin(admin);
        return "Updated succesfully";
}
    
    @GetMapping("/alladmins")
	@ApiOperation(value = "To Get all User Details")
	public List<Admin> findAll() {
	return service.findAll();
		
	}
    @DeleteMapping("/account/delete")
	@ApiOperation(value = "To delete admin Details")
	public String deleteAdmin(@RequestBody Admin admin,@RequestParam int id ) {
	 service.deleteAdmin(id);
	 return "Deleted Succesfull!!!";

	}
    
    //Washpack operations
    @PostMapping("/addwashpack")
	@ApiOperation(value = "To Add washpack Details")
	public String saveWashpack(@RequestBody Washpack washpacks) {
		 service.saveWashpack(washpacks);
		 return "WashPack Added Succesfully!!!";
	}
    @PutMapping("/washpack/update")
	@ApiOperation(value = "To update washpack Details")
	public String updateWashpack(@RequestBody Washpack updatepack,@RequestParam int id ) {
		service.updateWashpack(updatepack);
		return "Washpack updated Succesfull!!!";

	}
    @GetMapping("/washpack")
	@ApiOperation(value = "To get washpack Details")
	public List<Washpack> findAll1(){
		return service.getWashpack();

}
	@DeleteMapping("/washpack/delete")
	@ApiOperation(value = "To delete washpack Details")
	public String deletewashpack(@RequestBody Washpack admin,@RequestParam int id ) {
	 service.deleteWashpack(id);
	 return "Washpack Deleted Succesfully!!!";

	}
	
	
       //Rating 
	@PostMapping("/addrating")
	public String save(@RequestBody UserRating ratings)
	{
		service.save(ratings);
		return " Thanks for Your Valuable feedback";
	}
	@GetMapping("/allratings")
	public List<UserRating> getuser()
	{
		return service.getUser();
		
	}
    //Rest template
	@GetMapping("/allorder")
	public List<OrderDetails> getwashpacks(){
		 String baseurl="http://localhost:/order/allorder";
		 OrderDetails[] orders=restTemplate.getForObject(baseurl, OrderDetails[].class);
		return Arrays.asList(orders);
		
	}
	
		
		@GetMapping("/allpayment")
		public List<PaymentDetails> getallpayment(){
			 String baseurl="http://localhost:/payment/allpayment";
			 PaymentDetails[] pay=restTemplate.getForObject(baseurl, PaymentDetails[].class);
			return Arrays.asList(pay);
		}
		
			
			@GetMapping("/allusers")
			public List<Signup> getallusers(){
				 String baseurl="http://localhost:/user/allusers";
				 Signup[] user =restTemplate.getForObject(baseurl, Signup[].class);
				return Arrays.asList(user);
			
		
}
			@GetMapping("/allwasher")
			public List<Washers> getwasher(){
				 String baseurl="http://localhost:/washer/allwasher";
				 Washers[] washer =restTemplate.getForObject(baseurl, Washers[].class);
				return Arrays.asList(washer);
			
			
			}
	
	
	
	
	
}
