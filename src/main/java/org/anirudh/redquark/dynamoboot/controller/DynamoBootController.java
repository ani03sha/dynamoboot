package org.anirudh.redquark.dynamoboot.controller;

import java.util.Arrays;

import org.anirudh.redquark.dynamoboot.model.User;
import org.anirudh.redquark.dynamoboot.repository.DynamoBootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.Id;

/**
 * 
 * Controller
 *
 */
@RestController
public class DynamoBootController {

	@Autowired
	private DynamoBootRepository repository;

	/**
	 * Deletes all the elements in the database
	 * 
	 * @return {@link String}
	 */
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		repository.deleteAll();
		return "All items are deleted";
	}

	/**
	 * Saves a single and multiple users in the database
	 * 
	 * @return {@link String}
	 */
	@RequestMapping("/save")
	public String save() {

		/**
		 * Save a single user
		 */
		repository.save(new User("1", "Bruce", "Wayne"));

		/**
		 * Save a list of users
		 */
		repository.save(Arrays.asList(new User("2", "Clark", "Kent"), new User("3", "Diana", "Prince")));

		return "Save operation has been completed";
	}

	/**
	 * Finds all the users in the repository
	 * 
	 * @return {@link String}
	 */
	@RequestMapping("/findAll")
	public String findAll() {

		/**
		 * Initializing the string in which the result will be stored
		 */
		String result = "";

		/**
		 * Getting all the users from the database
		 */
		Iterable<User> users = repository.findAll();

		/**
		 * Iterating the users and adding them to the result list
		 */
		for (User user : users) {
			result = result + user.toString() + "<br>";
		}

		return result;
	}

	/**
	 * Finds a user based on id
	 * 
	 * @param id
	 * @return {@link Id}
	 */
	@RequestMapping("findById")
	public String findById(@RequestParam("id") String id) {

		/**
		 * Creating the string in which result will be stored
		 */
		String result = "";

		/**
		 * Getting results from the database based on id
		 */
		result = repository.findOne(id).toString();

		return result;
	}

	/**
	 * Finds the users based on last name passed
	 * 
	 * @param lastName
	 * @return {@link String}
	 */
	@RequestMapping("/findByLastName")
	public String fetchDataByLastName(@RequestParam("lastName") String lastName) {

		/**
		 * Creating the string in which the result will be stored
		 */
		String result = "";

		/**
		 * Iterating for getting all the users based on last name
		 */
		for (User user : repository.findUserByLastName(lastName)) {
			result = result + user.toString() + "<br>";
		}

		return result;
	}

}
