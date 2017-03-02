package com.rappi.cube.config;

import com.rappi.cube.exception.CubeException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.inject.Inject;
import java.nio.file.AccessDeniedException;
import java.util.Locale;

/**
 * Created by lpadilha on 6/20/16.
 */
@ControllerAdvice
public class ControllerValidationHandler {

    enum MessageType {
        SUCCESS, INFO, WARNING, ERROR
    }

    class Message {
        private final MessageType type;
        private final String message;

        Message(MessageType type, String message) {
            this.type = type;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public MessageType getType() {
            return type;
        }
    }

    @Inject
    private MessageSource msgSource;

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Message processValidationError(MethodArgumentNotValidException ex) {
        return processFieldError(ex.getBindingResult().getFieldError());
    }

    public Message processFieldError(FieldError error) {
        Locale locale = LocaleContextHolder.getLocale();
        String msg = msgSource.getMessage(error.getDefaultMessage(), null, locale);
        return new Message(MessageType.ERROR, msg);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CubeException.class)
    public Message handleException(CubeException ex) {
        return new Message(MessageType.ERROR, ex.message());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public Message handleExceptionAccessDenied(AccessDeniedException ex) {
        return new Message(MessageType.ERROR, ex.getCause().toString());
    }
}


