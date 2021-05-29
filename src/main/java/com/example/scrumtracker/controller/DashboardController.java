package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Issues;
import com.example.scrumtracker.model.Sprints;
import com.example.scrumtracker.service.IssuesService;
import com.example.scrumtracker.service.SprintsService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("dashboard")
@RestController
public class DashboardController {

	@Autowired
	private IssuesService issuesService;

	@Autowired
	private SprintsService sprintsService;

	Integer totalIssues = 0;
	List<Issues> issuesOnSprint = null;

	@RequestMapping(value = "/getLastSprintInfo", method = RequestMethod.GET)
	public Sprints getLastSprintInfo() {
		System.out.println("yep we are in");
		Sprints lastSprint = sprintsService.getLastSprint();
		List<Issues> issuesList = issuesService.getAllIssues();

		if (lastSprint == null) {
			return null;
		} else {
			String sprintName = lastSprint.getSprintName();

			for (Issues issues : issuesList) {
				if (sprintName.equals(issues.getIssueSprintName())) {
					totalIssues++;
				}
			}
			lastSprint.setSprintTotalIssue(totalIssues);

			return lastSprint;
		}
	}

	@RequestMapping(value = "/getSelectedSprint", method = RequestMethod.GET)
	public Optional<Sprints> getSelectedSprint(@RequestBody Sprints sprints) {
		if (!ObjectUtils.isEmpty(sprints)) {
			return sprintsService.getSprint(sprints);
		}
		return null;
	}

	@RequestMapping(value = "/getIssuesForSprint", method = RequestMethod.GET)
	public List<Issues> getIssuesOnSprint(@RequestBody Sprints sprints) {

		List<Issues> issuesList = issuesService.getAllIssues();

		String sprintName = sprints.getSprintName();

		for (Issues issues : issuesList) {
			if (sprintName.equals(issues.getIssueSprintName())) {
				issuesOnSprint.add(issues);
			}
		}

		return issuesOnSprint;
	}

	/*
	 * TODO dashboard will have sprint name, description for sprint, total issues,
	 * TODO how many in which state and analytics for issue priorities and types.
	 */
}
