package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Issues;
import com.example.scrumtracker.repository.IssuesMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author erdemcemozer
 */

@Service
public class IssuesServiceImpl implements IssuesService {

	@Autowired
	private IssuesMongoDao issuesMongoDao;

	@Override
	public void createIssue(Issues issues) {
		issuesMongoDao.save(issues);
	}

	@Override
	public void updateIssue(Issues issues) {

		if (issuesMongoDao.existsById(issues.getId())) {
			issues.setIssueTitle(issues.getIssueTitle());
			issues.setIssueDesc(issues.getIssueDesc());
			issues.setIssueType(issues.getIssueType());

			issuesMongoDao.save(issues);
		} else {
			System.out.println("Error : No issue exist by that id.");
		}
	}

	@Override
	public void deleteIssue(Issues issues) {

		if (issuesMongoDao.existsById(issues.getId())) {
			issuesMongoDao.deleteById(issues.getId());
		} else {
			System.out.println("Error : No issue found for deleting.");
		}
	}

	@Override
	public List<Issues> getAllIssues() {
		return issuesMongoDao.findAll();
	}

}
