package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Announcements;
import com.example.scrumtracker.repository.AnnouncementsMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mkurfeyiz
 */

@Service
public class AnnouncementsServiceImpl implements AnnouncementsService {

	@Autowired
	private AnnouncementsMongoDao announcementsMongoDao;

	@Override
	public void createAnnouncement(Announcements announcements) {
		announcementsMongoDao.insert(announcements);
	}

	@Override
	public void updateAnnouncement(Announcements announcements) {
		if (announcementsMongoDao.existsById(announcements.getAnnouncementId())) {
			announcements.setAnnouncementTitle(announcements.getAnnouncementTitle());
			announcements.setAnnouncementDescription(announcements.getAnnouncementDescription());
			announcements.setReleaseDate(announcements.getReleaseDate());

			announcementsMongoDao.save(announcements);
		} else {
			System.out.println("Logger : Announcement not found!");
		}
	}

	@Override
	public void deleteAnnouncement(Announcements announcements) {
		if (announcementsMongoDao.existsById(announcements.getAnnouncementId())) {

			announcementsMongoDao.deleteById(announcements.getAnnouncementId());

		} else {
			System.out.println("Logger : Announcement not found!");
		}
	}

	@Override
	public List<Announcements> getAllAnnouncements() {
		return announcementsMongoDao.findAll();
	}
}
