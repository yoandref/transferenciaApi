package io.github.yoandref.transferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ClienteInexistenteException extends RuntimeException{

    public ClienteInexistenteException(String message) {
        super(message);
    }
}
