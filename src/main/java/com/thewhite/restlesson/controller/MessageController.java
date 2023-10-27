package com.thewhite.restlesson.controller;

import com.thewhite.restlesson.controller.dto.CreateMessageDto;
import com.thewhite.restlesson.controller.dto.MessageDto;
import com.thewhite.restlesson.controller.mapper.MessageMapper;
import com.thewhite.restlesson.model.Message;
import com.thewhite.restlesson.service.MessageService;
import com.thewhite.restlesson.service.argument.CreateMessageArgument;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sergei Vorona
 */
@RestController
@RequestMapping("messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService service;
    private final MessageMapper mapper;

    @PostMapping("create")
    public void create(@RequestBody CreateMessageDto dto) {
        CreateMessageArgument argument = mapper.toCreateArgument(dto);

        service.create(argument);
    }

    @GetMapping("create")
    public void create(@RequestParam("text") String text) {
        service.create(CreateMessageArgument.of(text));
    }

    @GetMapping("{id}")
    public MessageDto get(@PathVariable("id") Long id) {
        Message message = service.getExisting(id);

        return mapper.toDto(message);
    }

    @GetMapping("all")
    public List<MessageDto> getAll() {
        List<Message> messages = service.getAll();

        return mapper.toDtoList(messages);
    }
}
