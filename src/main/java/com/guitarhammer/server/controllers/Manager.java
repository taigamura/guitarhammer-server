package com.guitarhammer.server.controllers;

import com.guitarhammer.server.controllers.exceptions.NotFoundException;
import com.guitarhammer.server.controllers.exceptions.NoteNotFound;
import com.guitarhammer.server.models.fretboards.ChordFret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Manager {

    public static int getRoot(ChordFret cf) {
        List<Integer> possibleRoots = Arrays.stream(new int[]{0, 3, 5, 7, 9, 12, 15, 17, 19, 21, 23, 25})
                .boxed()
                .collect(Collectors.toList());
        List<Integer> strings = new ArrayList<>();
        strings.add(0, cf.getFirstString());
        strings.add(1, cf.getSecondString());
        strings.add(2, cf.getThirdString());
        strings.add(3, cf.getFourthString());
        strings.add(4, cf.getFifthString());
        strings.add(5, cf.getSixthString());
        List<Integer> filtered = strings.stream()
                .filter(n -> (n >= 0))
                .sorted()
                .collect(Collectors.toList());
        return possibleRoots.stream()
                .filter(n -> (n <= filtered.get(0)))
                .min(Comparator.comparingInt(i -> Math.abs(i - filtered.get(0))))
                .orElseThrow(() -> new NotFoundException("Root not found"));
    }
}
