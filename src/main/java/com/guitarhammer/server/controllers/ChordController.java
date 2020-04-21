package com.guitarhammer.server.controllers;

import com.guitarhammer.server.models.Chord;
import com.guitarhammer.server.repositories.ChordRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "chords",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ChordController {
    private final ChordRepository chordRepository;

    public ChordController(ChordRepository chordRepository) {
        this.chordRepository = chordRepository;
    }

    @GetMapping
    List<Chord> all() {
        return chordRepository.findAll();
    }
}
