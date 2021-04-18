package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Sprints;
import com.example.scrumtracker.repository.SprintsMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author erdemcemozer
 */

@Service
public class SprintsServiceImpl implements SprintsService {

	@Autowired
	private SprintsMongoDao sprintsMongoDao;

	@Override
	public String getSprintName(Sprints sprints) {

		String sprintId = sprints.getSprintId();
		if (sprintsMongoDao.existsById(sprints.getSprintId())) {

			return null;
		} else {
			System.out.println("Logger : Requested sprint not found.");
		}
		return null;
	}
}
