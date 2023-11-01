package com.thewhite.restlesson.api.messages;

import com.thewhite.restlesson.api.ErrorDto;
import com.thewhite.restlesson.api.messages.dto.CreateMessageDto;
import com.thewhite.restlesson.api.messages.dto.MessageDto;
import com.thewhite.restlesson.api.messages.mapper.MessageMapper;
import com.thewhite.restlesson.model.Message;
import com.thewhite.restlesson.service.MessageService;
import com.thewhite.restlesson.service.argument.CreateMessageArgument;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@Tag(name = "Контроллер для работы с сообщениями")
public class MessageController {

    private final MessageService service;
    private final MessageMapper mapper;

    @PostMapping("create")
    @Operation(description = "Создать сообщение")
    public MessageDto create(@RequestBody CreateMessageDto dto) {
        CreateMessageArgument argument = mapper.toCreateArgument(dto);

        return mapper.toDto(service.create(argument));
    }

    @GetMapping("search")
    @Operation(description = "Найти сообщения")
    public List<MessageDto> search(@RequestParam("searchText") String searchText) {
        List<Message> messages = service.search(searchText);

        return mapper.toDtoList(messages);
    }

    @GetMapping("{id}")
    @Operation(description = "Получить сообщение")
    @ApiResponse(description = "Сообщение не найдено", responseCode = "404",
                 content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorDto.class)))
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
