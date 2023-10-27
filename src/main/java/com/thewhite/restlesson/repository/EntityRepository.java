package com.thewhite.restlesson.repository;

import com.thewhite.restlesson.model.Entity;

import java.util.List;

/**
 * @author Sergei Vorona
 */
public interface EntityRepository {

    void create(Entity entity);

    Entity findById(Long id);

    List<Entity> findAll();
}
