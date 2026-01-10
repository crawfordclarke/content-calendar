package com.crawford.content_calendar;

import com.crawford.content_calendar.model.Content;
import com.crawford.content_calendar.model.Status;
import com.crawford.content_calendar.model.Type;
import com.crawford.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ContentRepository contentRepository) {
		return args -> {
			if (contentRepository.count() == 0) {
				Content c = new Content(null,
						"Hello World",
						"My first automated post",
						Status.IDEA,
						Type.ARTICLE,
						LocalDateTime.now(),
						null,
						"" );
				contentRepository.save(c);
			}
		};
	}

}
