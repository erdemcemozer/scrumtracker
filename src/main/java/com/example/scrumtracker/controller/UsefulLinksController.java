package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.UsefulLinks;
import com.example.scrumtracker.service.UsefulLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author erdemcemozer
 */

@RequestMapping("usefulLinks")
@RestController
public class UsefulLinksController {

	@Autowired
	UsefulLinksService usefulLinksService;

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public ResponseEntity<List<UsefulLinks>> listAll() {

		List<UsefulLinks> linksList = usefulLinksService.getAll();
		System.out.println("Logger : List all links!");
		return new ResponseEntity<>(linksList, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<UsefulLinks> addNew(@RequestBody UsefulLinks usefulLinks) {

		if (!ObjectUtils.isEmpty(usefulLinks)) {
			usefulLinksService.addNewLink(usefulLinks);
			System.out.println("Logger : Added a link!");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteLink(@RequestBody UsefulLinks usefulLinks) {

		/*
		* TODO
		*  We need to look for deleting an item from databas, mongo uses objectId not string for _id
		* */

		String linkId = usefulLinks.getId();
		if (linkId == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			boolean isDeleted = usefulLinksService.deleteById(linkId);
			System.out.println("Logger : Deleted a link!");
			return new ResponseEntity<>(isDeleted, HttpStatus.OK);
		}
	}
}
