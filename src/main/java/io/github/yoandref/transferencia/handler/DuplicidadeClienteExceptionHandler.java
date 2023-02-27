package io.github.yoandref.transferencia.handler;

import io.github.yoandref.transferencia.dto.AvisosDTO;
import io.github.yoandref.transferencia.exception.DuplicidadeClienteException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DuplicidadeClienteExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DuplicidadeClienteException.class})
    public ResponseEntity<Object> handlerDuplicidade(RuntimeException ex, WebRequest webRequest) {
        AvisosDTO avisosDTO = new AvisosDTO();
        avisosDTO.setMensagem("Cliente já possui cadastro!");
        return handleExceptionInternal(ex, avisosDTO, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, webRequest);
    }

}
