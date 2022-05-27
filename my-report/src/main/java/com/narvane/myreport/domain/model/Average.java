package com.narvane.myreport.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Average {

    private Double value;

    private Subject subject;

    private List<Grade> grades;
}
