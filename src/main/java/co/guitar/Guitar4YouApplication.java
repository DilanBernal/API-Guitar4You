package co.guitar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "co.guitar4you.model" })
@EnableJpaRepositories(basePackages = { "co.guitar4you" })
@ComponentScan(basePackages = { "co.guitar4you.service", "co.guitar4you.controller", "co.guitar4you.dao", "co.guiar4you"})
public class Guitar4YouApplication {

	public static void main(String[] args) {
		SpringApplication.run(Guitar4YouApplication.class, args);
	}

}
