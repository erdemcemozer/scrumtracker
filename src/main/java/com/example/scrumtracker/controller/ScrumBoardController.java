package com.example.scrumtracker.controller;

import com.example.scrumtracker.service.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author erdemcemozer
 */

@RequestMapping("board")
@RestController
public class ScrumBoardController {

	@Autowired
	private IssuesService issuesService;
}
