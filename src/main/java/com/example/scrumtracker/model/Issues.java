package com.example.scrumtracker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author erdemcemozer
 */

@Document
@Getter
@Setter
@ToString
public class Issues {

	@Id
	String id;
	String issueTitle;
	String issueDesc;
	String issueType;
	String issueSprintName;
	String issuePriority;
	String issueEstimation;
	String issueStatus;
	String issueOwner;

}
