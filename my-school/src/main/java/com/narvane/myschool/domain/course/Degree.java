package com.narvane.myschool.domain.course;

import com.narvane.myschool.domain.subject.Subject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "degree_id_seq")
    @SequenceGenerator(name = "degree_id_seq", sequenceName = "degree_id_seq")
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="degree_subject", joinColumns=@JoinColumn(name="degree_id"), inverseJoinColumns=@JoinColumn(name="subject_id"))
    private List<Subject> subjects;

}
