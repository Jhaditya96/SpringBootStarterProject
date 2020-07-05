package com.javabeans.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Now in Main src we have a running servlet container but it doesn`t do anything.In order to handle certain
//requests.Now we want to handle certain requests and want that given this request I want my code to 
//execute that in Java servlet container,TO do that we need to use controller.

//A controller is basically a Java class that has certain annotations marked in it.

//These annotations lets spring know: 
//1.What is the URL that u r mapping into and
//2.What should happen when the request comes to that URL.

//So these annotations are gonna marked as controllers and it also provides this information about what URL
//access needs to trigger that controller to execute and then secondly we`re gonna write the method that
//needs to execute when the URL access needs to get triggered that controller to execute and secondly we`re 
//gonna write the method that needs to execute when the URL is called and we are gonna annotate it so it 
//maps to our URL.

@RestController // The RestController means that you can methods in here in this class which map
				// to URL
				// request which can map to a particular method so that this method executes
				// then the user
				// makes a request to that URL.

public class HelloController {
	@RequestMapping("/hello")
	// We want a request mapping to make request when this method request is made.
	// @RequestMapping maps only to the GET method by default.TO map to other.
	public String sayHi() {
		return "Hi";
	}

}
