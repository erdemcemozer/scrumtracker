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
public class UsefulLinks {

	@Id
	String id;
	String linkName;
	String linkDescription;
}
