package com.guitarhammer.server.services;

import com.guitarhammer.server.models.Chord;
import com.guitarhammer.server.repositories.ChordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.guitarhammer.server.repositories")
@EntityScan("com.guitarhammer.server.models")
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*")
                        .allowedOrigins("http://localhost:3000");
            }
        };
    }

    @Bean
    @Transactional
    public CommandLineRunner run(
            ChordRepository chordRepository
    ) throws Exception {
        return (String[] args) -> {

            String[] letters = {"A", "B", "C", "D", "E", "F", "G"};

            // Load Power Chords
            for (String currLetter : letters) {
                String chordName = currLetter.concat("-5");
                System.out.println(chordName);
            }

            Chord A = new Chord();
            chordRepository.save(A);
        };
    }
}
