package com.guitarhammer.server.models;

import com.guitarhammer.server.models.fretboards.ChordFret;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chord {
    @Id
    @GeneratedValue
    Long id;

    String name;

    ChordFret tab;
}
