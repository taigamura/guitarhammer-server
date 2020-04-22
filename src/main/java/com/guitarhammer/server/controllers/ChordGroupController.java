package com.guitarhammer.server.controllers;

import com.guitarhammer.server.models.ChordGroup;
import com.guitarhammer.server.repositories.ChordGroupRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "chordGroups",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ChordGroupController {
    private final ChordGroupRepository chordGroupRepository;

    public ChordGroupController(ChordGroupRepository chordGroupRepository) {
        this.chordGroupRepository = chordGroupRepository;
    }

    @GetMapping
    List<ChordGroup> all() {
        return chordGroupRepository.findAll();
    }
}
