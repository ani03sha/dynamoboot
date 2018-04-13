package org.anirudh.redquark.dynamoboot.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * 
 * Model class which represents a user
 *
 */
@DynamoDBTable(tableName = "User")
public class User {

	/**
	 * Unique ID of a user
	 */
	private String id;

	/**
	 * First name of a user
	 */
	private String firstName;

	/**
	 * Last name of a user
	 */
	private String lastName;

	/**
	 * Default constructor
	 */
	public User() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public User(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the id
	 */
	@DynamoDBHashKey(attributeName = "Id")
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	@DynamoDBAttribute(attributeName = "FirstName")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@DynamoDBAttribute(attributeName = "LastName")
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
