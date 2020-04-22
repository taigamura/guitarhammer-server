package com.guitarhammer.server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.guitarhammer.server.models.fretboards.ChordFret;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chord {
    @Id
    @GeneratedValue
    Long id;

    String name;

    Integer root;

    ChordFret tab;

    @ManyToOne
    @JoinColumn(name = "chordGroup_id")
    @JsonBackReference(value = "chordGroup_chords")
    ChordGroup chordGroup;
}
