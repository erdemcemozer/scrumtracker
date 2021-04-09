package com.example.scrumtracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.scrumtracker.model.Issues;

/**
 * @author erdemcemozer
 */

@Repository
public interface IssuesMongoDao extends MongoRepository<Issues, String> {
}
