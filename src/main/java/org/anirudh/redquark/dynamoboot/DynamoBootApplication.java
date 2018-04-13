package org.anirudh.redquark.dynamoboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "org.anirudh.redquark.dynamoboot" })
public class DynamoBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamoBootApplication.class, args);
	}
}
