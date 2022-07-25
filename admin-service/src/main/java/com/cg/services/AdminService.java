package com.cg.services;



import java.util.List;

import com.cg.models.Admin;
import com.cg.models.UserRating;
import com.cg.models.Washpack;

public interface AdminService {
	
	//Admin
	public List<Admin> findAll();
	public void saveAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void deleteAdmin(int id);
	
	//Ratings
	public List<UserRating> getUser();
	public void save(UserRating ratings);
	
	//washpacks
	public List<Washpack> getWashpack();
	public void savePack(Washpack Washpacks);
	public void updatePack(Washpack updatepack);
	public void deletePack(int id);
	
	
	
	
	
	
	    
	

}
