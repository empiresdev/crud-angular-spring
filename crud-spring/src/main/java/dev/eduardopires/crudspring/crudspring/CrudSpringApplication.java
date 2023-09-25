package dev.eduardopires.crudspring.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.eduardopires.crudspring.crudspring.model.Course;
import dev.eduardopires.crudspring.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();

			Course c1 = new Course();
			c1.setName("Angular com Spring");
			c1.setCategory("front-end");
			courseRepository.save(c1);

			Course c2 = new Course();
			c2.setName("Flutter com Dart");
			c2.setCategory("mobile");
			courseRepository.save(c2);
		};
	}

}
