package com.cg.services;



import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.WashpackNotFoundException;
import com.cg.models.Admin;
import com.cg.models.DatabaseSequence;
import com.cg.models.UserRating;
import com.cg.models.Washpack;
import com.cg.repository.AdminRepo;
import com.cg.repository.RatingRepo;
import com.cg.repository.WashRepo;


@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepo adminrepo;
	@Autowired
	private RatingRepo ratingrepo;
	@Autowired
	private WashRepo washrepo;

	Logger logger = LoggerFactory.getLogger(AdminServiceImplementation.class);
	
	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		logger.info("Getting Admin list");
		List<Admin> admin=adminrepo.findAll();
		logger.info(" Successfull search of all admins");
		return admin;
	}

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		logger.info("Adding Admins");
		adminrepo.save(admin);
		logger.info("Admin added Successfully");
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		logger.info("Updating Admin");
		Optional<Admin> optionalAdmin = adminrepo.findById(admin.getId());

		if (optionalAdmin == null) {
			throw new AdminNotFoundException("Admin not exising with id: " + admin.getId());
		}
		adminrepo.save(admin);
		logger.info("Admin Updated Successfully");
		
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		logger.info("Deleting admin by id");
		Optional<Admin> optionalAdmin = adminrepo.findById(id);

		if (optionalAdmin == null) {
			throw new AdminNotFoundException("Admin not exising with id: " + id);
		}

		Admin student = optionalAdmin.get();

		adminrepo.delete(student);
		logger.info("Admin Deleted Successfully");
	}


	@Override
	public List<Washpack> getWashpack() {
		// TODO Auto-generated method stub
		logger.info("Getting List of washpacks");
		List<Washpack> washpack=washrepo.findAll();
		logger.info("Successfully got List of washpacks");
		return washpack;
	}

	@Override
	public void saveWashpack(Washpack washpacks) 
	{
		logger.info("Adding Washpack");
		washrepo.save(washpacks);
		logger.info("Successfully added washpacks");

	}

	@Override
	public void updateWashpack(Washpack updatepack) {
		Optional<Washpack> optionalWashpack = washrepo.findById(updatepack.getId());
		logger.info("Updating Washpack");
		if (optionalWashpack == null) {
			throw new WashpackNotFoundException("Washpack not exising with id: " + updatepack.getId());
		}

		 washrepo.save(updatepack);
		 logger.info("Successfully updated Washpack");
	}

	@Override
	public void deleteWashpack(int id) {
		// TODO Auto-generated method stub
		logger.info("Deleting the washpack by id");
		Optional<Washpack> optionalWashpack = washrepo.findById(id);

		if (optionalWashpack == null) {
			throw new WashpackNotFoundException("Washpack not exising with id: " + id);
		}

		Washpack wash = optionalWashpack.get();

		washrepo.delete(wash);
		logger.info("Successfully deleted washpack");


	}

	@Override
	public List<UserRating> getUser() {
		// TODO Auto-generated method stub
		logger.info("Getting list of userratings");
		List<UserRating> rating=ratingrepo.findAll();
		logger.info(" Successfully got list of ratings");
		return rating;
	}
	
	@Autowired
	  private MongoOperations mongoOperations;



	  public int getSequenceNumber(String sequenceName) {
	  //get sequence no
	  Query query = new Query(Criteria.where("id").is(sequenceName));
	  //update the sequence no
	  Update update = new Update().inc("seq", 1);
	  //modify in document
	  DatabaseSequence counter = mongoOperations.findAndModify(query,
	  update, options().returnNew(true).upsert(true),
	  DatabaseSequence.class);



	  return (int) (!Objects.isNull(counter) ? counter.getSeq() : 1);

	  }

	

}
