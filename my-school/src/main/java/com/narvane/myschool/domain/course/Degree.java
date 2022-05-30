package com.narvane.myschool.domain.course;

import com.narvane.myschool.domain.EntityWithUUID;
import com.narvane.myschool.domain.subject.Subject;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Degree extends EntityWithUUID {

    private String name;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="degree_subject", joinColumns=@JoinColumn(name="degree_id"), inverseJoinColumns=@JoinColumn(name="subject_id"))
    private List<Subject> subjects;

}
