package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Announcements;

import java.util.List;

/**
 * @author mkurfeyiz
 */

public interface AnnouncementsService {

	public void createAnnouncement(Announcements announcements);

	public void updateAnnouncement(Announcements announcements);

	public void deleteAnnouncement(Announcements announcements);

	public List<Announcements> getAllAnnouncements();

}
