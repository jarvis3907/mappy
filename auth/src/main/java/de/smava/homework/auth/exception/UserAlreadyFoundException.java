package de.smava.homework.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserAlreadyFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
