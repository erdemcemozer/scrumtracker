package com.example.scrumtracker.service;

import com.example.scrumtracker.model.MeetingResults;

import java.util.List;

/**
 * @author mkurfeyiz
 */

public interface MeetingResultsService {

	void createMeetingResult(MeetingResults results);

	void updateMeetingResult(MeetingResults results);

	void deleteMeetingResult(MeetingResults results);

	List<MeetingResults> getAllMeetingResults();
}
