package com.thewhite.restlesson.repository;

import com.thewhite.restlesson.model.Message;

import java.util.List;

/**
 * @author Sergei Vorona
 */
public interface MessageRepository {

    void create(Message message);

    Message findById(Long id);

    List<Message> findAll();

    long getNextId();
}
