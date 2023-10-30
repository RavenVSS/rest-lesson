package com.thewhite.restlesson.api.messages;

import com.thewhite.restlesson.api.messages.dto.CreateMessageDto;
import com.thewhite.restlesson.api.messages.dto.MessageDto;
import com.thewhite.restlesson.api.messages.mapper.MessageMapper;
import com.thewhite.restlesson.model.Message;
import com.thewhite.restlesson.service.MessageService;
import com.thewhite.restlesson.service.argument.CreateMessageArgument;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер сообщений
 *
 * @author Sergei Vorona
 */
@RestController
@RequestMapping("messages")
@RequiredArgsConstructor
@Tag(name = "Контроллер для работы с обращениями")
public class MessageController {

    private final MessageService service;
    private final MessageMapper mapper;

    @PostMapping("create")
    @Operation(description = "Создать сообщение")
    public MessageDto create(@RequestBody CreateMessageDto dto) {
        CreateMessageArgument argument = mapper.toCreateArgument(dto);

        return mapper.toDto(service.create(argument));
    }

    @GetMapping("create")
    @Operation(description = "Создать сообщение")
    public MessageDto create(@RequestParam("text") String text) {
        Message message = service.create(CreateMessageArgument.of(text));

        return mapper.toDto(message);
    }

    @GetMapping("{id}")
    @Operation(description = "Получить сообщение")
    public MessageDto get(@Parameter(description = "id сообщения")
                          @PathVariable("id") Long id) {
        Message message = service.getExisting(id);

        return mapper.toDto(message);
    }

    @GetMapping("all")
    @Operation(description = "Получить все сообщения")
    public List<MessageDto> getAll() {
        List<Message> messages = service.getAll();

        return mapper.toDtoList(messages);
    }
}
