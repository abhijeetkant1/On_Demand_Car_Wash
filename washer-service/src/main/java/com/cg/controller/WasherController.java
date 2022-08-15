package com.cg.controller;

import java.util.Arrays;

//import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;

import com.cg.models.OrderDetails;
import com.cg.models.UserRating;
import com.cg.models.WasherLogin;
//import com.cg.models.OrderDetails;
//import com.cg.models.UserRating;
import com.cg.models.Washers;
import com.cg.services.LoginService;
import com.cg.services.WasherService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/washer")
public class WasherController
{
   
    
    /* Name:Abhijeet kant
     * EmpId: 46195747
     * 
     * 
     */
	Logger logger = LoggerFactory.getLogger(WasherController.class);
	@Autowired
	private LoginService wahser;
	
	@Autowired
		private WasherService service;
	 
	 @Autowired
		private RestTemplate restTemplate;
    
    @PostMapping("/addwasher")
    @ApiOperation(value = "To Add washer Details")
    public String saveUser(@RequestBody Washers washer) {
    	logger.info("Adding washer"); 
    	service.save(washer);
    	 return "you Are working With A1A Carwash";
    }

    @PutMapping("/account/update")
    @ApiOperation(value = "To Update washer Details")
    public String updateRegistrationDetails(@RequestBody Washers user, @RequestParam int id) {
    	logger.info("Updating registration details"); 
    	service.save(user);
    	 return "update of details Successfull";

    }

    @GetMapping("/allwasher")
    @ApiOperation(value = "To Get all washer Details")
    public List<Washers> findAll(){
    	logger.info("Getting all washers");
    	return service.getWashers();
    }

    @DeleteMapping("/account/delete")
    @ApiOperation(value = "To delete washer ")
    public String deletewasher( @RequestParam int id ) {
    	 logger.info("Deleting washer"); 
    	this.service.deleteWasher(id);
    	 return "Account Delete Happy to work With you";
    }
    @PostMapping("/login")
	@ApiOperation(value = "To Add Login Details")
	public String userWasher(@RequestBody WasherLogin login) {
    	logger.info("Adding login details for user");
    	return wahser.userWasher(login);
	}
    
    @GetMapping("/viewWasher/{Id}")
	public ResponseEntity<Washers> viewWasher(@PathVariable int Id) 
	{
    	 logger.info("view all washer by id");
			Washers washer =service.viewWasher(Id);
			return new ResponseEntity<Washers>(washer,HttpStatus.OK);
	}
    
 
    /*------------------ Resttemplates---------------------------- */
    
	@GetMapping("/allratings")
	@ApiOperation(value = "Gets all ")
	public List<UserRating> getwashpacks() {
		String baseurl = "http://localhost:8084/admin/allratings";
		UserRating[] washpack = restTemplate.getForObject(baseurl,UserRating[].class);
		return Arrays.asList(washpack);
	}
	
        
		@GetMapping("/allbooking")
		@ApiOperation(value = "Gets all orders")
		public List<OrderDetails> getallbookings(){
			String baseurl="http://localhost:8081/order/allorders";
			OrderDetails[] allorders=restTemplate.getForObject(baseurl, OrderDetails[].class);
			
			return Arrays.asList(allorders);
   
}
}
