package com.guitarhammer.server.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChordGroup {
    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    String groupName;

    @OneToMany(mappedBy = "chordGroup", cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonManagedReference(value = "chordGroup_chords")
    List<Chord> chords = new ArrayList<>();
}
