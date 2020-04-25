package com.guitarhammer.server.controllers;

import org.json.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Manager {

//    public static int getRoot(ChordFret cf) {
//        List<Integer> possibleRoots = Arrays.stream(new int[]{0, 3, 5, 7, 9, 12, 15, 17, 19, 21, 23, 25})
//                .boxed()
//                .collect(Collectors.toList());
//        List<Integer> strings = new ArrayList<>();
//        strings.add(0, cf.getFirstString());
//        strings.add(1, cf.getSecondString());
//        strings.add(2, cf.getThirdString());
//        strings.add(3, cf.getFourthString());
//        strings.add(4, cf.getFifthString());
//        strings.add(5, cf.getSixthString());
//        List<Integer> filtered = strings.stream()
//                .filter(n -> (n >= 0))
//                .sorted()
//                .collect(Collectors.toList());
//        return possibleRoots.stream()
//                .filter(n -> (n <= filtered.get(0)))
//                .min(Comparator.comparingInt(i -> Math.abs(i - filtered.get(0))))
//                .orElseThrow(() -> new NotFoundException("Root not found"));
//    }

    public static List<JSONObject> readChordDb() {
        String parentPath = "C:/Users/taiga/PP/GuitarHammer/chords-db@tombatossals_Apr25_2020";
        File parentDir = new File(parentPath);
        List<JSONObject> allChordJsonObj = new ArrayList<>();
        for (File chordDir : Objects.requireNonNull(parentDir.listFiles())) {
            for (File currChord : Objects.requireNonNull(chordDir.listFiles())) {
                try {
                    String currPath = parentPath + "/" + chordDir.getName() + "/" + currChord.getName();
                    String fileText = Files.readString(Paths.get(currPath));
                    if (fileText.contains("import")) continue;
                    JSONObject obj = new JSONObject(fileText.replace("export default ", ""));
                    allChordJsonObj.add(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return allChordJsonObj;
    }
}
