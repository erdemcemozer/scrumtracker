package com.example.scrumtracker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author erdemcemozer
 */

@Getter
@Setter
@ToString
@Document
public class Users {

	@Id
	String id;
	String username;
	String password;
	// more user info will be added

}
