package com.example.scrumtracker.service;

import com.example.scrumtracker.model.UsefulLinks;

import java.util.List;

/**
 * @author erdemcemozer
 */

public interface UsefulLinksService {

	public List<UsefulLinks> getAll();

	public void addNewLink(UsefulLinks usefulLinks);

}
