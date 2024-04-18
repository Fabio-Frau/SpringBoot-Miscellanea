package com.fabiofrau.Jpa_Project;

import com.fabiofrau.Jpa_Project.models.Author;
import com.fabiofrau.Jpa_Project.models.Video;
import com.fabiofrau.Jpa_Project.repositories.AuthorRepository;
import com.fabiofrau.Jpa_Project.repositories.VideoRepository;
import com.fabiofrau.Jpa_Project.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@SpringBootApplication
public class JpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository
	) {
		return args -> {
			for(int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				Author author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.name().username() + "@email.com")
						.build();

				//repository.saveAndFlush(author);
			}

//			Author author = Author.builder()
//					.id(1)
//					.firstName("Fabio")
//					.lastName("Frau")
//					.age(32)
//					.email("fabio@email.com")
//					.build();
//			repository.saveAndFlush(author);

//			repository.updateAuthor(220,1);
//
//			repository.updateAllAuthorsAges(550);

			//repository.findByNamedQuery(35).forEach(System.out::println);

			Specification<Author> spec = Specification.where(AuthorSpecification.hasAge(35))
					.and(AuthorSpecification.firstnameLike("Ge"));

			repository.findAll(spec);

//			Video video = Video.builder()
//					.name("abc")
//					.length(5)
//					.build();
//			videoRepository.saveAndFlush(video);
		};
	}

}
