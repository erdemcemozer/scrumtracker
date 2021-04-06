package com.example.scrumtracker.service;

import com.example.scrumtracker.model.MeetingResults;
import com.example.scrumtracker.repository.MeetingResultsMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mkurfeyiz
 */

@Service
public class MeetingResultsServiceImpl implements MeetingResultsService{

    @Autowired
    private MeetingResultsMongoDao resultsMongoDao;

    @Override
    public void createMeetingResult(MeetingResults results) {
        //Inserting meeting
        resultsMongoDao.insert(results);
    }

    @Override
    public void updateMeetingResult(MeetingResults results) {
        if(resultsMongoDao.existsById(results.getMeetingId())){
            //Update
            results.setMeetingType(results.getMeetingType());
            results.setTitle(results.getTitle());
            results.setDescription(results.getDescription());
            results.setMeetingDate(results.getMeetingDate());

            resultsMongoDao.save(results);
        } else {
            System.out.println("Logger : Requested meeting not found.");
        }
    }

    @Override
    public void deleteMeetingResult(MeetingResults results) {
        if(resultsMongoDao.existsById(results.getMeetingId())){
            //Delete
            resultsMongoDao.deleteById(results.getMeetingId());
        } else {
            System.out.println("Logger : Requested meeting does not exists.");
        }
    }

    @Override
    public List<MeetingResults> getAllMeetingResults() {
        return resultsMongoDao.findAll();
    }
}
