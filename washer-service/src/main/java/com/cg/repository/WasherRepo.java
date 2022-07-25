package com.cg.repository;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.models.Washers;
@Repository
public interface WasherRepo extends MongoRepository<Washers, String> {

	Optional<Washers> findById(Long id);

	void deleteById(int id);	

}
