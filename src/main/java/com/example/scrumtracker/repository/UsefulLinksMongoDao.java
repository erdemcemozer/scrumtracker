package com.example.scrumtracker.repository;

import com.example.scrumtracker.model.UsefulLinks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erdemcemozer
 */

@Repository
public interface UsefulLinksMongoDao extends MongoRepository<UsefulLinks, String> {
}
