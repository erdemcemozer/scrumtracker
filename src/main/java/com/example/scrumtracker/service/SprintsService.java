package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Sprints;

import java.util.List;

/**
 * @author erdemcemozer
 */
public interface SprintsService {

	public String getSprintName(Sprints sprints);

	public List<Sprints> getAllSprints();

	public Sprints getLastSprint();
}
