package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Issues;
import com.example.scrumtracker.model.Sprints;
import com.example.scrumtracker.repository.SprintsMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

			return sprintId;
		} else {
			System.out.println("Logger : Requested sprint not found.");
		}
		return null;
	}

	@Override
	public List<Sprints> getAllSprints() {
		return sprintsMongoDao.findAll();
	}

	@Override
	public Sprints getLastSprint() {

		List<Sprints> allSprints = sprintsMongoDao.findAll();
		Integer lastSprintNumber = allSprints.size();
		if (lastSprintNumber.equals(0)) {
			System.out.println("ERROR : Sprints not found!");
		} else {
			Sprints lastSprint = sprintsMongoDao.findAll().get(lastSprintNumber);
			return lastSprint;
		}
		return null;
	}

	@Override
	public void createSprint(Sprints sprints) {
		sprintsMongoDao.save(sprints);
	}

	@Override
	public void updateSprint(Sprints sprints) {

		if (sprintsMongoDao.existsById(sprints.getSprintId())) {
			sprints.setSprintDesc(sprints.getSprintDesc());
			sprints.setSprintName(sprints.getSprintName());

			sprintsMongoDao.save(sprints);
		} else {
			System.out.println("Error : No sprint exist by that id.");
		}
	}

	@Override
	public void deleteSprint(Sprints sprints) {

		if (sprintsMongoDao.existsById(sprints.getSprintId())) {
			sprintsMongoDao.deleteById(sprints.getSprintId());
		} else {
			System.out.println("Error : No sprints found for deleting.");
		}
	}

}
