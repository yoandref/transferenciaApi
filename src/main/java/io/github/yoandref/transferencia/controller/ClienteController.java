package io.github.yoandref.transferencia.controller;

import io.github.yoandref.transferencia.dto.*;
import io.github.yoandref.transferencia.entity.Cliente;
import io.github.yoandref.transferencia.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/autentificaCliente")
    public ResponseEntity<?> consultaCliente(@RequestBody ClienteLoginDTO clienteLoginDTO) {
        this.clienteService.autentificaCliente(clienteLoginDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/trocaSenhaCliente/{cpf}")
    public ResponseEntity<?> trocaSenhaCliente(@PathVariable(value = "cpf") String cpf,
                                               @RequestBody TrocaSenhaClienteRequestDTO clienteTrocaSenhaRequestDTO) {
        AvisosDTO avisosDTO = this.clienteService.trocaSenhaCliente(clienteTrocaSenhaRequestDTO, cpf);
        return new ResponseEntity(avisosDTO, HttpStatus.OK);
    }

    @PatchMapping("/trocaNomeCliente/{cpf}")
    public ResponseEntity<?> trocaNomeCliente(@PathVariable(value = "cpf") String cpf,
                                               @RequestBody TrocaNomeClienteDTO trocaNomeClienteDTO) {
        this.clienteService.trocaNomeCliente(trocaNomeClienteDTO, cpf);
        return null;
    }
}
