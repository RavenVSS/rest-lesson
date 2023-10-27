package com.thewhite.restlesson.controller.dto;

import lombok.*;

/**
 * @author Sergei Vorona
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMessageDto {

    String text;
}
