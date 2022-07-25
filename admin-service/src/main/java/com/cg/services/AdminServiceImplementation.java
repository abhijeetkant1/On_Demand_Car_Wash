package com.cg.services;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.models.Admin;
import com.cg.models.UserRating;
import com.cg.models.Washpack;
import com.cg.repository.AdminRepo;
import com.cg.repository.RatingRepo;
import com.cg.repository.WashRepo;


@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepo admin_repo;
	@Autowired
	private RatingRepo rating_repo;
	@Autowired
	private WashRepo wash_repo;

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return admin_repo.findAll();
	}

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		admin_repo.save(admin);

	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		admin_repo.save(admin);

	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		admin_repo.deleteById(id);

	}


	@Override
	public List<Washpack> getWashpack() {
		// TODO Auto-generated method stub
		return wash_repo.findAll();
	}

	@Override
	public void saveWashpack(Washpack washpacks) {
		// TODO Auto-generated method stub
		wash_repo.save(washpacks);

	}

	@Override
	public void updateWashpack(Washpack updatepack) {
		// TODO Auto-generated method stub
		wash_repo.save(updatepack);

	}

	@Override
	public void deleteWashpack(int id) {
		// TODO Auto-generated method stub
		wash_repo.deleteById(id);

	}

	@Override
	public List<UserRating> getUser() {
		// TODO Auto-generated method stub
		return rating_repo.findAll();
	}

	@Override
	public void save(UserRating ratings) {
		// TODO Auto-generated method stub
		rating_repo.save(ratings);
		
	}

}
