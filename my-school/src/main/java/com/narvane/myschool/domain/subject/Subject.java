package com.narvane.myschool.domain.subject;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_id_seq")
    @SequenceGenerator(name = "subject_id_seq", sequenceName = "subject_id_seq")
    @Column(name = "id")
    private Long id;

    private String name;

}
