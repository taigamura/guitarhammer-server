package com.guitarhammer.server.models;

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

    String chordName;

    @Column(name = "data", length = 1024)
    String data;
}
