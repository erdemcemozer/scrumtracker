package com.example.scrumtracker.repository;

import com.example.scrumtracker.model.Announcements;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mkurfeyiz
 */

@Repository
public interface AnnouncementsMongoDao extends MongoRepository<Announcements, String> {
}
