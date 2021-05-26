package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Issues;

import java.util.List;
import java.util.Optional;

/**
 * @author erdemcemozer
 */

public interface IssuesService {

	public void createIssue(Issues issues);

	public void updateIssue(Issues issues);

	public void deleteIssue(Issues issues);

	public List<Issues> getAllIssues();

	public Optional<Issues> getIssue(Issues issues);
}
