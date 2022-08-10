package com.cg.service;

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

import com.cg.exception.UserNotFoundException;

import com.cg.models.DatabaseSequence;
//import com.cg.models.Payment;
import com.cg.models.UserDetail;
import com.cg.repository.UserRepo;
@Service
public class UserServiceImplementation implements UserService{

	
	@Autowired
	private UserRepo repo;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);
	
	@Override
	public UserDetail addUser(UserDetail signup)
	{
		 logger.info("Adding User");
		UserDetail addUser=repo.save(signup);
		logger.info("Successfully added user");
		return addUser;
	
	}

	@Override
	public List<UserDetail> getuser() {
		 logger.info("Getting User List");
		List<UserDetail> users=repo.findAll();
		 logger.info("Successfully Getting list of user");
		return users;
	}

	@Override
	public UserDetail Updateuser(UserDetail update) {
		logger.info("Updating User");
		    Optional<UserDetail> optionalUser = repo.findById(update.getId());

	        if (optionalUser == null) {
	            throw new UserNotFoundException("User not exising with id: " + update.getId());
	        }

	        UserDetail updateUser = repo.save(update);
	        logger.info("Updated user successfully");
	        return updateUser;
	    }

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		logger.info("Deleting user by id");
		Optional<UserDetail> optionalUser = repo.findById(id);

		if (optionalUser == null) {
			throw new UserNotFoundException("User not exising with id: " + id);
		}

		UserDetail deleteUser = optionalUser.get();

		repo.delete(deleteUser);
		logger.info("User deleted successfully by id");

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

	@Override
	public void deleteUser(UserDetail user) {
		// TODO Auto-generated method stub
		repo.delete(user);
		
	
}
}