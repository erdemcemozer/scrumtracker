package com.example.scrumtracker.repository;

import com.example.scrumtracker.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erdemcemozer
 *
 * We need to check for
 */

@Repository
public interface UserMongoDao extends MongoRepository<Users, Integer> {
}
