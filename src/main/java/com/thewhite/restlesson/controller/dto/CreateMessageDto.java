package com.thewhite.restlesson.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * @author Sergei Vorona
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "ДТО для создания сообщения")
public class CreateMessageDto {

    @Schema(description = "Текст сообщения", requiredMode = REQUIRED)
    String text;
}
