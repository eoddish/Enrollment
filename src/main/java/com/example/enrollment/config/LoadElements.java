package com.example.enrollment.config;

import com.example.enrollment.models.Element;
import com.example.enrollment.models.SystemItemType;
import com.example.enrollment.repositories.ElementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
@Configuration
public class LoadElements {
    private static final Logger log = LoggerFactory.getLogger(LoadElements.class);

    @Bean
    CommandLineRunner initDatabase(ElementRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Element("hello", "hello", "hello", 10, SystemItemType.FOLDER)));
        };
    }
}
