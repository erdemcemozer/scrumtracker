package com.example.scrumtracker.service;

import com.example.scrumtracker.model.UsefulLinks;
import com.example.scrumtracker.repository.UsefulLinksMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author erdemcemozer
 */

@Service
public class UsefulLinksServiceImpl implements UsefulLinksService {

	@Autowired
	UsefulLinksMongoDao usefulLinksMongoDao;

	@Override
	public List<UsefulLinks> getAll() {
		return usefulLinksMongoDao.findAll();
	}

	@Override
	public void addNewLink(UsefulLinks usefulLinks) {
		usefulLinksMongoDao.save(usefulLinks);
	}

	@Override
	public boolean deleteById(String linkId) {
		usefulLinksMongoDao.deleteById(linkId);
		return true;
	}
}
