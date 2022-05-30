package com.narvane.myschool.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Data
public class EntityWithUUID {

    @Id
    @Type(type = "pg-uuid")
    protected UUID id;

    protected EntityWithUUID() {
        this.id = UUID.randomUUID();
    }

}
