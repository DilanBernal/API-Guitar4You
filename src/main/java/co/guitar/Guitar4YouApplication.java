package co.guitar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "co.guitar.model" })
@EnableJpaRepositories(basePackages = { "co.guitar" })
@ComponentScan(basePackages = { "co.guitar.service",  "co.guitar.controller", "co.guitar.dao", "co.guitar"})
public class Guitar4YouApplication {

	public static void main(String[] args) {
		SpringApplication.run(Guitar4YouApplication.class, args);
	}

}
