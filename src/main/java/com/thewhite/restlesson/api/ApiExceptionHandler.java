package com.thewhite.restlesson.api;

import com.thewhite.restlesson.exception.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author Sergei Vorona
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * При появлении исключения {@link NotFoundException} возвращает статус 404 и сообщение об ошибке.
     */
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody ErrorDto processNotFoundException(NotFoundException exception) {
        return ErrorDto.of(exception.getMessage());
    }
}
