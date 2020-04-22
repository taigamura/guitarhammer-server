package com.guitarhammer.server.models.fretboards;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ChordFret {

    Integer firstString;

    Integer secondString;

    Integer thirdString;

    Integer fourthString;

    Integer fifthString;

    Integer sixthString;
}
