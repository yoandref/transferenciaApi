package io.github.yoandref.transferencia.service;

import io.github.yoandref.transferencia.component.ConsultaClienteComponent;
import io.github.yoandref.transferencia.component.CriaClienteComponent;
import io.github.yoandref.transferencia.dto.ClienteLoginDTO;
import io.github.yoandref.transferencia.dto.ClienteRequestDTO;
import io.github.yoandref.transferencia.dto.TrocaSenhaClienteRequestDTO;
import io.github.yoandref.transferencia.entity.Cliente;
import io.github.yoandref.transferencia.exception.ClienteInexistenteException;
import io.github.yoandref.transferencia.exception.DuplicidadeClienteException;
import io.github.yoandref.transferencia.exception.NovaSenhaInvalidaException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ConsultaClienteComponent consultaClienteComponent;
    private final CriaClienteComponent criaClienteComponent;

    public Cliente criaCliente(ClienteRequestDTO clienteRequest) {
        if(this.verificaSeClienteExiste(clienteRequest.getCpf())) {
            throw new DuplicidadeClienteException("Cliente com o CPF " + clienteRequest.getCpf() + " já cadastrado!");
        }
        return this.criaClienteComponent.criaCliente(Cliente.converter(clienteRequest));
    }

    public Boolean autentificaCliente(ClienteLoginDTO clienteLoginDTO) {
        if(!this.verificaSeClienteExiste(clienteLoginDTO.getCpf())) {
            throw new ClienteInexistenteException("Cliente inexistente");
        }
        Boolean statusUsuario = this.consultaClienteComponent.verificaCpfCliente(clienteLoginDTO.getCpf());
        Boolean statusSenha = this.consultaClienteComponent.verificaSenhaCliente(clienteLoginDTO.getSenha());

        return statusSenha && statusUsuario;
    }

    public void trocaSenhaCliente(TrocaSenhaClienteRequestDTO trocaSenhaClienteRequest, String cpf) {
        if(!confirmaSeNovasSenhasSaoIguais(trocaSenhaClienteRequest.getNovaSenha(), trocaSenhaClienteRequest.getNovaSenhaRepetida())) {
            throw new NovaSenhaInvalidaException("A nova senha e a confirmação da senha não conferem!");
        }
        if(this.verificaSeClienteExiste(cpf)) {
            throw new ClienteInexistenteException("Cliente inexistente");
        }


    }

    private Boolean confirmaSeNovasSenhasSaoIguais(String novaSenha, String novaSenhaRepetida) {
        return novaSenha.equals(novaSenhaRepetida);
    }

    private Boolean verificaSeClienteExiste(String cpf) {
        return this.consultaClienteComponent.verificaSeClienteExiste(cpf);
    }
}
