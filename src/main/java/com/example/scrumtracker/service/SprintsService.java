package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Sprints;

import java.util.List;
import java.util.Optional;

/**
 * @author erdemcemozer
 */
public interface SprintsService {

	public String getSprintName(Sprints sprints);

	public List<Sprints> getAllSprints();

	public Sprints getLastSprint();

	public void createSprint(Sprints sprints);

	public void updateSprint(Sprints sprints, Integer totalIssue);

	public void deleteSprint(Sprints sprints);

	public Optional<Sprints> getSprint(Sprints sprint);
}
