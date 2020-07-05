package com.javabeans.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

//Part C:Creating Spring Data JPA Repository
//This is my Data Service and I am gonna create methods to do all the operations:
//public class TopicRepository {
public interface TopicRepository extends CrudRepository<Topic, String>
{
	// 1.getAllTopics()
	// 2.getTopic(String id)
	// 3.updateTopic(Topic t)
	// 4.deleteTopic(String id)
	// So as we know all these functions you are gonna have same body atleast basic
	// structure so instead of
	// writing it again and again Spring Boot came up with new functionality.
	// A.Change class to interface TopicRepository`s as done above...and extend your custom repository
	// CrudRepository

	
}
