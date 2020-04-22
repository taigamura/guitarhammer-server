package com.guitarhammer.server.services;

import com.guitarhammer.server.controllers.Manager;
import com.guitarhammer.server.models.Chord;
import com.guitarhammer.server.models.ChordGroup;
import com.guitarhammer.server.models.fretboards.ChordFret;
import com.guitarhammer.server.repositories.ChordGroupRepository;
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
            ChordRepository chordRepository,
            ChordGroupRepository chordGroupRepository
    ) throws Exception {
        return (String[] args) -> {

            String[] letters = {"A", "B", "C", "D", "E", "F", "G"};

            // Create Chord Groups
            for (String currLetter : letters) {
                ChordGroup currChordGroup = new ChordGroup();
                currChordGroup.setGroupName(currLetter);
                chordGroupRepository.save(currChordGroup);
            }

            // Load Power Chords - Base 6
            for (String currLetter : letters) {
                Chord currChord = new Chord();
                ChordGroup currChordGroup = chordGroupRepository.findByGroupName(currLetter);

                currChord.setName(currLetter.concat("-5"));

                ChordFret cf = null;
                switch (currLetter) {
                    case "A":
                        cf = new ChordFret(-1, -1, -1, -1, 7, 5);
                        break;
                    case "B":
                        cf = new ChordFret(-1, -1, -1, -1, 9, 7);
                        break;
                    case "C":
                        cf = new ChordFret(-1, -1, -1, -1, 10, 8);
                        break;
                    case "D":
                        cf = new ChordFret(-1, -1, -1, -1, 12, 10);
                        break;
                    case "E":
                        cf = new ChordFret(-1, -1, -1, -1, 2, 0);
                        break;
                    case "F":
                        cf = new ChordFret(-1, -1, -1, -1, 3, 1);
                        break;
                    case "G":
                        cf = new ChordFret(-1, -1, -1, -1, 5, 3);
                        break;
                }
                currChord.setChordGroup(currChordGroup);
                currChord.setRoot(Manager.getRoot(cf));
                chordRepository.save(currChord);
            }

            // Load Power Chords - Base 5
            for (String currLetter : letters) {
                Chord currChord = new Chord();
                ChordGroup currChordGroup = chordGroupRepository.findByGroupName(currLetter);

                currChord.setName(currLetter.concat("-5"));

                ChordFret cf = null;
                switch (currLetter) {
                    case "A":
                        cf = new ChordFret(-1, -1, -1, 2, 0, -1);
                        break;
                    case "B":
                        cf = new ChordFret(-1, -1, -1, 4, 2, -1);
                        break;
                    case "C":
                        cf = new ChordFret(-1, -1, -1, 5, 3, -1);
                        break;
                    case "D":
                        cf = new ChordFret(-1, -1, -1, 7, 5, -1);
                        break;
                    case "E":
                        cf = new ChordFret(-1, -1, -1, 9, 7, -1);
                        break;
                    case "F":
                        cf = new ChordFret(-1, -1, -1, 10, 8, -1);
                        break;
                    case "G":
                        cf = new ChordFret(-1, -1, -1, 12, 10, -1);
                        break;
                }
                currChord.setChordGroup(currChordGroup);
                currChord.setRoot(Manager.getRoot(cf));
                chordRepository.save(currChord);
            }

            // Load Power Chords - Base 6 - Power
            for (String currLetter : letters) {
                Chord currChord = new Chord();
                ChordGroup currChordGroup = chordGroupRepository.findByGroupName(currLetter);

                currChord.setName(currLetter.concat("-5"));

                ChordFret cf = null;
                switch (currLetter) {
                    case "A":
                        cf = new ChordFret(-1, -1, -1, 7, 7, 5);
                        break;
                    case "B":
                        cf = new ChordFret(-1, -1, -1, 9, 9, 7);
                        break;
                    case "C":
                        cf = new ChordFret(-1, -1, -1, 10, 10, 8);
                        break;
                    case "D":
                        cf = new ChordFret(-1, -1, -1, 12, 12, 10);
                        break;
                    case "E":
                        cf = new ChordFret(-1, -1, -1, 2, 2, 0);
                        break;
                    case "F":
                        cf = new ChordFret(-1, -1, -1, 3, 3, 1);
                        break;
                    case "G":
                        cf = new ChordFret(-1, -1, -1, 5, 5, 3);
                        break;
                }
                currChord.setChordGroup(currChordGroup);
                currChord.setRoot(Manager.getRoot(cf));
                chordRepository.save(currChord);
            }

            // Load Power Chords - Base 5 - Power
            for (String currLetter : letters) {
                Chord currChord = new Chord();
                ChordGroup currChordGroup = chordGroupRepository.findByGroupName(currLetter);

                currChord.setName(currLetter.concat("-5"));

                ChordFret cf = null;
                switch (currLetter) {
                    case "A":
                        cf = new ChordFret(-1, -1, 2, 2, 0, -1);
                        break;
                    case "B":
                        cf = new ChordFret(-1, -1, 4, 4, 2, -1);
                        break;
                    case "C":
                        cf = new ChordFret(-1, -1, 5, 5, 3, -1);
                        break;
                    case "D":
                        cf = new ChordFret(-1, -1, 7, 7, 5, -1);
                        break;
                    case "E":
                        cf = new ChordFret(-1, -1, 9, 9, 7, -1);
                        break;
                    case "F":
                        cf = new ChordFret(-1, -1, 10, 10, 8, -1);
                        break;
                    case "G":
                        cf = new ChordFret(-1, -1, 12, 12, 10, -1);
                        break;
                }
                currChord.setRoot(Manager.getRoot(cf));
                currChord.setChordGroup(currChordGroup);
                chordRepository.save(currChord);
            }
        };
    }
}
