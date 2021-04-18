package com.example.scrumtracker.repository;

import com.example.scrumtracker.model.Sprints;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erdemcemozer
 */

@Repository
public interface SprintsMongoDao extends MongoRepository<Sprints,String> {
}
