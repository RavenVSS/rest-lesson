package com.thewhite.restlesson.controller.mapper;

import com.thewhite.restlesson.controller.dto.CreateMessageDto;
import com.thewhite.restlesson.controller.dto.MessageDto;
import com.thewhite.restlesson.model.Message;
import com.thewhite.restlesson.service.argument.CreateMessageArgument;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Sergei Vorona
 */
@Mapper
public interface MessageMapper {

    CreateMessageArgument toCreateArgument(CreateMessageDto dto);

    MessageDto toDto(Message message);

    List<MessageDto> toDtoList(List<Message> messages);

}
