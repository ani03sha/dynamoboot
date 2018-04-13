package org.anirudh.redquark.dynamoboot.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.util.StringUtils;

/**
 * This class represents all the configurations that are required for connecting
 * with DynamoDB
 */
@Configuration
@EnableDynamoDBRepositories(basePackages = "org.anirudh.redquark.dynamoboot.repository")
public class DynamoDBConfig {

	/**
	 * End-point which needs to be connected to Dynamo DB
	 */
	@Value("${amazon.dynamodb.endpoint}")
	private String dbEndpoint;

	/**
	 * Access key of Dynamo DB (AWS)
	 */
	@Value("{amazon.aws.accesskey}")
	private String accessKey;

	/**
	 * Secret key of Dynamo DB (AWS)
	 */
	@Value("{amazon.aws.secretkey}")
	private String secretKey;

	/**
	 * Bean that returns an instance of Dynamo DB
	 * 
	 * @return {@link AmazonDynamoDB}
	 */
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {

		AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient(awsCredentials());

		if (StringUtils.isNullOrEmpty(dbEndpoint)) {
			dynamoDB.setEndpoint(dbEndpoint);
		}

		return dynamoDB;
	}

	/**
	 * Bean that returns and instance of AWSCredentials instance which is required
	 * to connect to AWS
	 * 
	 * @return {@link AWSCredentials}
	 */
	@Bean
	public AWSCredentials awsCredentials() {
		return new BasicAWSCredentials(accessKey, secretKey);
	}
}
