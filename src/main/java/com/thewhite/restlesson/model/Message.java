package com.thewhite.restlesson.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

/**
 * Сущность - сообщение
 *
 * @author Sergei Vorona
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Message {

    Long id;

    String text;

}
