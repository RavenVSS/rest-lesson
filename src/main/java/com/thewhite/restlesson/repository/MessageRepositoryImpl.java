package com.thewhite.restlesson.repository;

import com.thewhite.restlesson.model.Message;
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
public class MessageRepositoryImpl implements MessageRepository {

    private final Map<Long, Message> myPerfectDb = new HashMap<>();
    private long nextId = 0L;

    @Override
    public Message create(Message message) {
        myPerfectDb.put(message.getId(), message);
        return message;
    }

    @Override
    public Message findById(Long id) {
        return myPerfectDb.get(id);
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(myPerfectDb.values());
    }

    /**
     * Генерирует уникальный идентификатор
     */
    @Override
    public long getNextId() {
        return ++nextId;
    }
}
