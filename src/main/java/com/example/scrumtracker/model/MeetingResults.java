package com.example.scrumtracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author mkurfeyiz
 */

@Getter
@Setter
@ToString
@Document
public class MeetingResults {

	@Id
	String meetingId;
	String meetingType;
	String title;
	String description;
	// Used that annotation to submit a proper date in json
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	Date meetingDate;
}
