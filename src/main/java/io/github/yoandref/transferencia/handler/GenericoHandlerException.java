package io.github.yoandref.transferencia.handler;

import io.github.yoandref.transferencia.dto.AvisosDTO;
import io.github.yoandref.transferencia.exception.ClienteInexistenteException;
import io.github.yoandref.transferencia.exception.DuplicidadeClienteException;
import io.github.yoandref.transferencia.exception.NovaSenhaInvalidaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericoHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            ClienteInexistenteException.class,
            DuplicidadeClienteException.class,
            NovaSenhaInvalidaException.class
    })
    public ResponseEntity<Object> handlerGenerico(RuntimeException ex, WebRequest webRequest) {
        AvisosDTO avisosDTO = new AvisosDTO();
        avisosDTO.setMensagem(ex.getMessage());
        return handleExceptionInternal(ex, avisosDTO, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, webRequest);
    }
}
