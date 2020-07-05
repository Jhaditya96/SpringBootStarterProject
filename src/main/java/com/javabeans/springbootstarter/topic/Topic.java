package com.javabeans.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

//PartA:To create Spring Data JPA Repository
//With this annotation JPA knows to create a table and that table is gonna have same variables as
@Entity // this class has.
public class Topic {

//Part A:
	      // Field level annotation which says that whatever member variable that
	     // corresponds to the column
	@Id // that I want to be primary key column I mark that member variable class with
	   // @Id.
	private String id;
	private String name;
	private String description;

	// NOTE:So with these two annotations Id and Entity JPA can create a topic
   // instance to Row instance in
  // table and vice versa also.

	// Constructors 1.No-Arg constructor 2.Arg constructor to initialize the
	public Topic() {

	}

	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
