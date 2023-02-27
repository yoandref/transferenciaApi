package io.github.yoandref.transferencia.service;

import io.github.yoandref.transferencia.component.ConsultaClienteComponent;
import io.github.yoandref.transferencia.component.CriaClienteComponent;
import io.github.yoandref.transferencia.dto.ClienteRequestDTO;
import io.github.yoandref.transferencia.entity.Cliente;
import io.github.yoandref.transferencia.exception.DuplicidadeClienteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ConsultaClienteComponent consultaClienteComponent;
    private final CriaClienteComponent criaClienteComponent;

    public Cliente criaCliente(ClienteRequestDTO clienteRequest) {
        Boolean clienteExiste = consultaClienteComponent.verificaSeClienteExiste(clienteRequest.getCpf());
        if(clienteExiste) {
            throw new DuplicidadeClienteException("Cliente com o CPF " + clienteRequest.getCpf() + " já cadastrado!");
        }
        return this.criaClienteComponent.criaCliente(Cliente.converter(clienteRequest));
    }

}
