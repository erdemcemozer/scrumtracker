package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Issues;
import com.example.scrumtracker.service.IssuesService;
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
 * @author erdemcemozer
 */

@RequestMapping("issues")
@RestController
public class IssuesController {

	@Autowired
	private IssuesService issuesService;

	@RequestMapping(value = "/createIssue", method = RequestMethod.POST)
	public ResponseEntity<Issues> createIssue(@RequestBody Issues issues) {

		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		issues.setId(id);

		System.out.println("create test issue log");

		if (!ObjectUtils.isEmpty(issues)) {
			issuesService.createIssue(issues);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/updateIssue", method = RequestMethod.POST)
	public ResponseEntity<Issues> updateIssue(@RequestBody Issues issues) {

		System.out.println("Logger : Update issue controller");

		if (!ObjectUtils.isEmpty(issues)) {
			issuesService.updateIssue(issues);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteIssue", method = RequestMethod.POST)
	public ResponseEntity<Issues> deleteIssue(@RequestBody Issues issues) {

		System.out.println("Logger : Delete issue controller");

		if (!ObjectUtils.isEmpty(issues)) {
			issuesService.deleteIssue(issues);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getIssues", method = RequestMethod.GET)
	public List<Issues> getAllIssues() {

		System.out.println("Logger : List all issues");

		List<Issues> issuesList = issuesService.getAllIssues();
		return issuesList;
	}

}
