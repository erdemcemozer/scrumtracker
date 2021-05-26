package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Issues;
import com.example.scrumtracker.model.Sprints;
import com.example.scrumtracker.service.IssuesService;
import com.example.scrumtracker.service.SprintsService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author erdemcemozer
 */

@RequestMapping("board")
@RestController
public class ScrumBoardController {

	@Autowired
	private IssuesService issuesService;

	@Autowired
	private SprintsService sprintsService;

	@RequestMapping(value = "/getLastSprint", method = RequestMethod.GET)
	public Sprints getLastSprint() {
		Sprints lastSprint = sprintsService.getLastSprint();

		if (lastSprint == null) {
			System.out.println("ERROR : NO SPRINTS FOUND");
			return null;
		} else {
			return lastSprint;
		}
	}

	@RequestMapping(value = "/getLastSprintIssues", method = RequestMethod.GET)
	public List<Issues> getLastSprintIssues(@RequestBody Sprints sprints) {
		List<Issues> lastIssues = null;
		List<Issues> issuesList = issuesService.getAllIssues();

		for (Issues issue : issuesList) {
			if (issue.getIssueSprintName().equals(sprints.getSprintName())) {
				lastIssues.add(issue);
			}
		}

		return lastIssues;
	}

	@RequestMapping(value = "/getIssue", method = RequestMethod.GET)
	public Optional<Issues> getIssueById(@RequestBody Issues issues) {
		return issuesService.getIssue(issues);
	}

	@RequestMapping(value = "/getSprint", method = RequestMethod.GET)
	public Optional<Sprints> getSprint(@RequestBody Sprints sprint) {
		Optional<Sprints> selectedSprint = sprintsService.getSprint(sprint);

		return selectedSprint;
	}

	@RequestMapping(value = "/createSprint", method = RequestMethod.POST)
	public ResponseEntity<Sprints> createSprint(@RequestBody Sprints sprint) {
		if (!ObjectUtils.isEmpty(sprint)) {
			sprintsService.createSprint(sprint);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteSprint", method = RequestMethod.POST)
	public ResponseEntity<Sprints> deleteSprint(@RequestBody Sprints sprint) {
		if (!ObjectUtils.isEmpty(sprint)) {
			sprintsService.deleteSprint(sprint);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
