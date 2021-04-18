package com.example.scrumtracker.controller;

import com.example.scrumtracker.service.IssuesService;
import com.example.scrumtracker.service.SprintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author erdemcemozer
 */

@RequestMapping("issues")
@RestController
public class DashboardController {

	@Autowired
	private IssuesService issuesService;

	@Autowired
	private SprintsService sprintsService;

	/*
	 * TODO dashboard will have sprint name, description for sprint, total issues,
	 * TODO how many in which state and analytics for issue priorities and types.
	 */
}
