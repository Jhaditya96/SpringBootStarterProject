package com.javabeans.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//To create RESTFul MVC 
//1.Create a controller
@RestController

public class TopicController {
	// How do Controller ask for the instance of that service from singleton
	// TopicService?
	// Annotation is to show the dependency to TopicService by declaring the
	// dependency
	@Autowired
	private TopicService topicservice;

	// GET REQUEST
	// 2.Map your request to a method and your business logic will execute as
	// expected.
	@RequestMapping("/topics")
	public List<Topic> getAllTopic() {
		return topicservice.getAllTopics();
	}

	/*
	 * GET REQUEST input parameter is id Annotation is written so id is in the link
	 * & is passed to getTopic(id) and used further
	 */
	@RequestMapping("/topics/{id}")
	/*
	 * id is a variable so in {} form in given path and maps with the following but
	 * what do we do when both name are not same?Then we use @PathVariable("foo") to
	 * tell it but usually not recommended.
	 */

	/*
	 * i.e. id and then by using annotation @PathVariable we told MVC that what part
	 * of the request pay load {id} you need to pick in order to pass to this(String
	 * id) to use for SpringMVC.
	 */

	public Topic getTopic(@PathVariable String id) {
		// In order to tell spring that the id above is same as this we used this
		// annotation.
		return topicservice.getTopic(id);
	}

	// POST REQUEST
	// Another API to call POST request in topics
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	/*
	 * But unlike in line 35 I do not have {id} variable to use from my URL.So,
	 * Since I have a custom method to handle POST requests,I need to add value
	 * property as well,that from URL so the reason for value in @RequestMapping(..
	 * , value = "/topics")
	 */
	/*
	 * Hey Spring MVC get the request body and pass to me as a topic instance... The
	 * above line 46 tells us that....^-^Map this method(from line 48 to down) to
	 * any request that says POST request to "/topics" URL. When POST request
	 * happens to this URL public void addTopic is going to get executed^-^ .
	 */

	// In this method what we need is to get that POST body,Convert it into topic
	// instance and then add that
	// to the list in the TopicService.As we did in line 40 we passed an argument
	// that we wanted in argument
	// I have configured to run this method to happen when there is a POST request
	// in URL:"/topic"
	public void addTopic(@RequestBody Topic topic) {
		// @RequestBody is getting the object from Topic(request pay load) and convert
		// it into a topic instance
		// i.e. Topic - > topic(instance).This annotation tells your SpringMVC that your
		// request pay load
		// is gonna contains a JSON representation of TOPIC instance,take this instance
		// (topic) and convert it
		// pass it to the addTopic() method when this URL(at line 53) is mapped anyway
		// and so you will get an
		// instance of the topic that`s already ready for you to add.But this method
		// exists in TopicService.
		// So GOTO that class
		topicservice.addTopic(topic);
	}

	// UPDATE REQUEST
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		// But as above we have an additional variable with
		// our path so additional part is added with @RequestBody i.e. @PathVariable for
		// id
		topicservice.putTopic(id, topic);
	}

	// DELETION REQUEST
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicservice.deleteTopic(id);
	}

}
