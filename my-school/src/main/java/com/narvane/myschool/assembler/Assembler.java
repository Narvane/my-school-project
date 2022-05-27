package com.narvane.myschool.assembler;

import org.springframework.data.domain.Page;

import java.util.Collection;

public interface Assembler<Entity, Input, Model> {

    Entity assembleEntity(Input input);

    Model assembleModel(Entity entity);

    Collection<Entity> assembleEntityCollection(Collection<Input> input);

    Collection<Model> assembleModelCollection(Collection<Entity> entity);

    Page<Model> assemblePageModel(Page<Entity> entities);

}
