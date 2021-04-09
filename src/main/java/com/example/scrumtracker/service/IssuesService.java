package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Issues;

import java.util.List;

/**
 * @author erdemcemozer
 */

public interface IssuesService {

	public void createIssue(Issues issues);

	public void updateIssue(Issues issues);

	public void deleteIssue(Issues issues);

	public List<Issues> getAllIssues();
}
