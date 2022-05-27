package com.narvane.myreport.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 *  Represent a set of data about the student grade performance
 */

@Getter
@Setter
@Document(collection = "report")
public class Report {

    @Id
    private String id;

    private Student student;

    private String period;

    private List<Average> averages;

}
