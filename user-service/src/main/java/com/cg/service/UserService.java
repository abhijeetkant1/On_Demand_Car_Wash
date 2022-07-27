package com.cg.service;

import java.util.List;

import com.cg.models.PaymentDetails;
import com.cg.models.Signup;
public interface UserService {

	
	 public Signup addUser(Signup signup);
	  public List<Signup> getuser();
     public Signup Updateuser(Signup update);
	  public void deleteUser(int id);
	  public Long getSequenceNumber(String sequenceName);
	  public void deleteUser(Signup user);
	  
	  
	  // For payment
	  

		public List<PaymentDetails> findAllpayment();

		public void addpayment(PaymentDetails payment);
	
}
