package io.github.yoandref.transferencia.controller;

import io.github.yoandref.transferencia.dto.ClienteRequestDTO;
import io.github.yoandref.transferencia.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/criarCliente")
    public ResponseEntity<?> criaCliente(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        this.clienteService.criaCliente(clienteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
