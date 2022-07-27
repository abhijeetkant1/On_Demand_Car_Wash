package com.cg.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.models.OrderDetails;
@Repository
public interface OrderRepo extends MongoRepository<OrderDetails, Long>
{
boolean save(Long id);

//Optional<OrderDetails> findById(Long orderId);
}
