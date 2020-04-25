package com.guitarhammer.server.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scale {
    @Id
    @GeneratedValue
    Long id;

    String scaleName;

    @Column(name = "data", length = 1024)
    String data;
}
