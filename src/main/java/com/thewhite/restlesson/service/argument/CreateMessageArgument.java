package com.thewhite.restlesson.service.argument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * @author Sergei Vorona
 */
@Value
@Builder
@AllArgsConstructor(staticName = "of")
public class CreateMessageArgument {
    String text;
}
