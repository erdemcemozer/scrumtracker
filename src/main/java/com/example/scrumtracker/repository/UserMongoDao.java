package com.example.scrumtracker.repository;

import com.example.scrumtracker.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author erdemcemozer
 */

@Repository
public interface UserMongoDao extends MongoRepository<Users, String> {

	@Query("{ 'email' :?0 }")
	Users findByEmail(String email);

}
