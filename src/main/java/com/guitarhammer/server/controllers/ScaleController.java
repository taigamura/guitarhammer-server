package com.guitarhammer.server.controllers;

import com.guitarhammer.server.models.Scale;
import com.guitarhammer.server.repositories.ScaleRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(
        value = "scales",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ScaleController {
    private final ScaleRepository scaleRepository;

    public ScaleController(ScaleRepository scaleRepository) {
        this.scaleRepository = scaleRepository;
    }

    @GetMapping
    List<Scale> all() {
        return scaleRepository.findAll();
    }
}
