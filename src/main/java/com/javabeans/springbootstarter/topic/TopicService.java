package com.javabeans.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

//Part B:Creating Spring Data JPA Repository
//In this you have to tell JPA that hey I want to save and read the topic instance.So you a data service 
//to do these things.
//Steps:
//1.To get the topic repository instance into my topic service so that I can make calls to the topic
//	repository from the service.The best way to get an instance from a service class is by auto wiring it.
@Service
public class TopicService {

	// Part B:
	private TopicRepository topicRepository;
	// This will inject an instance of the topic repository to it so when I write my
	// methods I can use its
	// fields here easily.

	// static initialization block
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			// Constructor on Topic class to create topic object
			new Topic("Spring", "Spring Boot", "Spring Description"),
			new Topic("Java", "Core Java", "Advanced Java Description"),
			new Topic("JS", "Javascript", "JavaScript Description")));
	// NOTE:
	// The framework sees the embedded Derby dB in the classpath and assumes that to
	// be the dB to connect to
	// No connection infor. necessary.

	public List<Topic> getAllTopics() {

		// Part B:
		// return topics;
		List<Topic> topics = new ArrayList<>();// Creating a new Topics list
		topicRepository.findAll()// iterating over to the result of all the database
				.forEach(topics::add);// and each of them is populating this topic list with add element
		return topics;
		// It basically gets all the instances from the table.
	}

	// This is basically going through id and iterate over list and match id that
	// match id given as input
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	// Post Service
	public void addTopic(Topic topic) {
		// topics.add(topic);
		topicRepository.save(topic);
	}

	public void putTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {// loop through the whole topics
			Topic t = topics.get(i);// get the id from service
			if (t.getId().equals(id)) {// check with each id if it matches with the id given in URL
				topics.set(i, topic);// when it does its gonna update it at that location in that list
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
