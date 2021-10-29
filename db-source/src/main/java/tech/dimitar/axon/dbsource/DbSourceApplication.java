package tech.dimitar.axon.dbsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "tech.dimitar")
public class DbSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbSourceApplication.class, args);
	}

}
