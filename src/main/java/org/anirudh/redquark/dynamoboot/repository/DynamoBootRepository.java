package org.anirudh.redquark.dynamoboot.repository;

import java.util.List;

import org.anirudh.redquark.dynamoboot.model.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.amazonaws.services.dynamodbv2.xspec.L;

/**
 * 
 * A marker interface that extends the CrudRepository interface. This interface
 * is used to connect the Spring Boot application to the desired database.
 */
@EnableScan
public interface DynamoBootRepository extends CrudRepository<User, String> {

	/**
	 * 
	 * @param lastName
	 * @return {@link L}
	 */
	List<User> findUserByLastName(String lastName);
}
