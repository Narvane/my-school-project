package com.narvane.myschool.domain.subject;

import com.narvane.myschool.domain.EntityWithUUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject extends EntityWithUUID {

    private String name;

}
