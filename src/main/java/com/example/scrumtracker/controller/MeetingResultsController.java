package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.MeetingResults;
import com.example.scrumtracker.service.MeetingResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author mkurfeyiz
 */

@RestController
@RequestMapping(path = "/meetingResults")
public class MeetingResultsController {

	@Autowired
	private MeetingResultsService resultsService;

	@RequestMapping(value = "/createMeeting", method = RequestMethod.POST)
	public ResponseEntity<MeetingResults> createResult(@RequestBody MeetingResults results) {

		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		results.setMeetingId(id);

		System.out.println("Logger : Meeting Results controller create.");
		if (!ObjectUtils.isEmpty(results)) {
			resultsService.createMeetingResult(results);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/updateMeeting", method = RequestMethod.POST)
	public ResponseEntity<MeetingResults> updateResult(@RequestBody MeetingResults results) {

		System.out.println("Logger : Meeting Results controller update.");
		if (!ObjectUtils.isEmpty(results)) {
			resultsService.updateMeetingResult(results);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/deleteMeeting", method = RequestMethod.POST)
	public ResponseEntity<MeetingResults> deleteResult(@RequestBody MeetingResults results) {

		System.out.println("Logger : Meeting Results controller delete.");
		if (!ObjectUtils.isEmpty(results)) {
			resultsService.deleteMeetingResult(results);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/getMeetingResults", method = RequestMethod.GET)
	public List<MeetingResults> getAllMeetingResults() {

		System.out.println("Logger : Listing all meeting results");

		List<MeetingResults> resultsList = resultsService.getAllMeetingResults();
		return resultsList;
	}
}
