package com.cg.service;

import java.util.List;



import com.cg.models.UserDetail;
public interface UserService {

	
	
	  public List<UserDetail> getuser();
  	  public void deleteUser(int id);
	  public int getSequenceNumber(String sequenceName);
	 
	UserDetail addUser(UserDetail signup);
	UserDetail Updateuser(UserDetail update);
	
	void deleteUser(UserDetail user);
	
	  
	  
	  
	  
	
}
