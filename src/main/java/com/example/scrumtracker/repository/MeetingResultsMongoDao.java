package com.example.scrumtracker.repository;

import com.example.scrumtracker.model.MeetingResults;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author mkurfeyiz
 */

public interface MeetingResultsMongoDao extends MongoRepository<MeetingResults, String> {
}
