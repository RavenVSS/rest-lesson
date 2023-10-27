package com.thewhite.restlesson.repository;

import com.thewhite.restlesson.model.Entity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Репозиторий с "базой данных" в памяти.
 *
 * @author Sergei Vorona
 */
@Component
public class EntityRepositoryImpl implements EntityRepository {

    private final Map<Long, Entity> myPerfectDb = new HashMap<>();

    @Override
    public void create(Entity entity) {
        myPerfectDb.put(entity.getId(), entity);
    }

    @Override
    public Entity findById(Long id) {
        return myPerfectDb.get(id);
    }

    @Override
    public List<Entity> findAll() {
        return new ArrayList<>(myPerfectDb.values());
    }
}
