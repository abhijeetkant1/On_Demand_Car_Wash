package com.cg.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cg.exception.OrderNotFoundException;
import com.cg.models.DatabaseSequence;
import com.cg.models.OrderDetails;
import com.cg.repository.OrderRepo;

@Service
public class OrderServiceImplementation implements OrderService{

	Logger logger = LoggerFactory.getLogger(OrderServiceImplementation.class);
	@Autowired
	private OrderRepo repo;

	@Override
	public OrderDetails addOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		logger.info("Adding Order by orderdetails");
		OrderDetails addOrder=repo.save(order);
		logger.info("Successfully Adding Order by orderdetails");
		return addOrder;
	}
	@Override
	public List<OrderDetails> orderDetails() {
		// TODO Auto-generated method stub
		 logger.info("Getting Order list");
		List<OrderDetails> order=repo.findAll();
		 logger.info("Successfully got list of orders");
		return order;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails update) {
		// TODO Auto-generated method stub
		Optional<OrderDetails> optionalOrder = repo.findById(update.getOrderId());
		logger.info("Updating order details");
		if (optionalOrder == null) {
			throw new OrderNotFoundException("order not exising with id: " + update.getOrderId());
		}

		OrderDetails updateOrder = repo.save(update);
		logger.info("Successfully Updated Order");
		return updateOrder;
	}
	public boolean existsById(int id)
	{
		 logger.info("Order exists by id");
		return repo.existsById(id);
		
	}
	@Override
	public void deleteById(int id) {
		Optional<OrderDetails> optionalOrder = repo.findById(id);
		logger.info("deleted order by id");
		if (optionalOrder == null) {
			throw new OrderNotFoundException("User not exising with id: " + id);
		}

		OrderDetails order = optionalOrder.get();
		repo.delete(order);
		logger.info("Succesfully deleted order by id");

	}
	
	@Override
    public     OrderDetails viewOrder(int id) {
        // TODO Auto-generated method stub
        Optional<OrderDetails> optionalOrder = repo.findById(id);
        logger.info("view order by id");
        if(optionalOrder.isEmpty()) {
            throw new OrderNotFoundException("Order  not existing with id: "+id);
        }
        return optionalOrder.get();


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
