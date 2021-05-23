package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Announcements;
import com.example.scrumtracker.model.MeetingResults;
import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.service.AnnouncementsService;
import com.example.scrumtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author mkurfeyiz
 */

@RestController
@RequestMapping(path = "/announcements")
public class AnnouncementsController {

    @Autowired
    private AnnouncementsService announcementsService;

    @RequestMapping(value = "/createAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<Users> createAnnouncement(@RequestBody Announcements announcements) {

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        announcements.setAnnouncementId(id);

        System.out.println("Logger : Announcement controller create.");
        if (!ObjectUtils.isEmpty(announcements)) {
            announcementsService.createAnnouncement(announcements);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/updateAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<Users> updateAnnouncement(@RequestBody Announcements announcements) {

        System.out.println("Logger : Announcement controller update.");
        if (!ObjectUtils.isEmpty(announcements)) {
            announcementsService.updateAnnouncement(announcements);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/deleteAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<Users> deleteAnnouncement(@RequestBody Announcements announcements) {

        System.out.println("Logger : Announcement controller delete.");
        if (!ObjectUtils.isEmpty(announcements)) {
            announcementsService.deleteAnnouncement(announcements);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/getAnnouncements", method = RequestMethod.GET)
    public List<Announcements> getAllAnnouncements() {

        System.out.println("Logger : Listing all announcements");

        List<Announcements> announcementsList = announcementsService.getAllAnnouncements();
        return announcementsList;
    }

}
