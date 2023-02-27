package io.github.yoandref.transferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class DuplicidadeClienteException extends RuntimeException{

    public DuplicidadeClienteException(String message) {
        super(message);
    }
}
