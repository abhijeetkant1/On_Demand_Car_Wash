package com.cg.services;

import java.util.List;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cg.models.DatabaseSequence;
import com.cg.models.OrderDetails;
import com.cg.repository.OrderRepo;

@Service
public class OrderServiceImplementation implements OrderService{

	@Autowired
	private OrderRepo repo;

	@Override
	public OrderDetails addOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		return repo.save(order);
	}

	@Override
	public List<OrderDetails> orderdetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public OrderDetails updateOrder(OrderDetails update) {
		// TODO Auto-generated method stub
		return repo.save(update);
	}
	public boolean existsById(int id)
	{
		return repo.existsById(id);
		
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	@Autowired
	  private MongoOperations mongoOperations;



	  public Long getSequenceNumber(String sequenceName) {
	  //get sequence no
	  Query query = new Query(Criteria.where("id").is(sequenceName));
	  //update the sequence no
	  Update update = new Update().inc("seq", 1);
	  //modify in document
	  DatabaseSequence counter = mongoOperations.findAndModify(query,
	  update, options().returnNew(true).upsert(true),
	  DatabaseSequence.class);



	  return !Objects.isNull(counter) ? counter.getSeq() : 1;

	  }
}
