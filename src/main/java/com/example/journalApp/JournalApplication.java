package com.example.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JournalApplication {

	public static void main(String[] args) {
		System.setProperty("spring.data.mongodb.uri",
				"mongodb+srv://nahovig506:cLxkpdk3GnIUeTuk@cluster0.5hk1byf.mongodb.net/journaldb?retryWrites=true&w=majority&appName=Cluster0");
		SpringApplication.run(JournalApplication.class, args);
	}

	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}

}
//If you want to make it clean, create a package "config" with a java file ex:TransactionalManagement class and annotate that java class with @Configuration.
// you can write this @Bean function there and write the @EnableTransactionManagement below the @Configuration annotation right there it will work the same.