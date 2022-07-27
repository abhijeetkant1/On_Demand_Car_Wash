package com.cg.controller;

import java.util.Arrays;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.models.OrderDetails;
import com.cg.models.PaymentDetails;
import com.cg.models.Signup;
import com.cg.models.UserLogin;
import com.cg.models.UserRating;
import com.cg.models.Washpack;
import com.cg.service.LoginService;
import com.cg.service.UserServiceImplementation;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private LoginService user;
	@Autowired
	private UserServiceImplementation service;
	
	 /* Name:Abhijeet kant
	  * EmpId: 46195747
	  * Creation Date:24/07/22
	  * Modification Date:25/07/22
	  * 
	  */

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/adduser")
	@ApiOperation(value = "Adds new Customer's details")
	public Signup saveUser(@RequestBody Signup signup) {
		signup.setId(service.getSequenceNumber(Signup.SEQUENCE_NAME));
		return service.addUser(signup);
	}

	@GetMapping("/allusers")
	@ApiOperation(value = "Shows all Customer's details")
	public List<Signup> findAllUsers() {
		return service.getuser();
	}

	@PutMapping("/updateUser")
	@ApiOperation(value = "Updates Customer's details")
	public Signup updateUser(@RequestBody Signup signup) {
		Signup result = service.Updateuser(signup);
		return result;
	}

	@DeleteMapping("/deleteUser/{id}")
	@ApiOperation(value = "Deletes customer")
	public void deleteuser(@RequestParam int id) {
		 service.deleteUser(id);
	}
	/*-------------------UserLogin----------------------------- */
	
	@PostMapping("/login")
	@ApiOperation(value = "To Add Login Details")
	public String userLogin(@RequestBody UserLogin login) {
		return user.userLogin(login);
	}
	/*-------------------Payment----------------------------- */
	
	@PostMapping("/addpayment")
    @ApiOperation(value = "To Add payment details")
    public String addpayment(@RequestBody PaymentDetails payment) {
    	 service.addpayment(payment);
    	 return "Thank You For Choosing us";
    	 
    }

    @GetMapping("/allpayment")
    @ApiOperation(value = "To Get all Payment Details")
    public List<PaymentDetails> findAllpayment(){
    	return service.findAllpayment();
    }

	/*-------------------Resttemplates----------------------------- */

	@GetMapping("/allpacks")
	@ApiOperation(value = "Gets all packs")
	public List<Washpack> getwashpacks() {
		String baseurl = "http://localhost:8084/admin/allpacks";
		Washpack[] wp = restTemplate.getForObject(baseurl, Washpack[].class);
		return Arrays.asList(wp);
	}

	@PostMapping("/addorder")
	@ApiOperation(value = "User can add new order")
	public String addorder(@RequestBody OrderDetails order) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<OrderDetails> entity = new HttpEntity<OrderDetails>(order, headers);

		return restTemplate.exchange("http://localhost:8081/order/addorder", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	@DeleteMapping("/cancelorder")
	@ApiOperation(value = "User can cancel order")
	public String deleteorder(@RequestParam int id) {
		String baseurl = "http://localhost:8081/order/cancelorder";
		OrderDetails order = restTemplate.getForObject(baseurl, OrderDetails.class);
		return "Your Order is successfully Canceled " + order;
	}

	@PostMapping("/addratings")
	@ApiOperation(value = "User can give ratings to washers")
	public String addrating(@RequestBody UserRating rating) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserRating> entity = new HttpEntity<UserRating>(rating, headers);

		return restTemplate.exchange("http://localhost:8084/admin/addratings", HttpMethod.POST, entity, String.class)
				.getBody();
	}


}
