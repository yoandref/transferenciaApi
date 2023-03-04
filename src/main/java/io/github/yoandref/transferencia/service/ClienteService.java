package io.github.yoandref.transferencia.service;

import io.github.yoandref.transferencia.component.AlteraClienteComponent;
import io.github.yoandref.transferencia.component.ConsultaClienteComponent;
import io.github.yoandref.transferencia.component.CriaClienteComponent;
import io.github.yoandref.transferencia.dto.*;
import io.github.yoandref.transferencia.entity.Cliente;
import io.github.yoandref.transferencia.exception.ClienteInexistenteException;
import io.github.yoandref.transferencia.exception.DuplicidadeClienteException;
import io.github.yoandref.transferencia.exception.NovaSenhaInvalidaException;
import io.github.yoandref.transferencia.util.CriaAvisosUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ConsultaClienteComponent consultaClienteComponent;
    private final CriaClienteComponent criaClienteComponent;
    private final AlteraClienteComponent alteraClienteComponent;

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

    public AvisosDTO trocaSenhaCliente(TrocaSenhaClienteRequestDTO trocaSenhaClienteRequest, String cpf) {
        if(!confirmaSeNovasSenhasSaoIguais(trocaSenhaClienteRequest.getNovaSenha(), trocaSenhaClienteRequest.getNovaSenhaRepetida())) {
            throw new NovaSenhaInvalidaException("A nova senha e a confirmação da senha não conferem!");
        }
        if(this.verificaSeClienteExiste(cpf)) {
            throw new ClienteInexistenteException("Cliente inexistente");
        }
        this.alteraClienteComponent.alteraSenhaCliente(cpf, trocaSenhaClienteRequest.getNovaSenha());
        return CriaAvisosUtil.criaAvisos("Senha alterada com sucesso!");
    }

    public Cliente trocaNomeCliente(TrocaNomeClienteDTO trocaNomeClienteDTO, String cpf) {
        if(!consultaClienteComponent.verificaSeClienteExiste(cpf)) {
            throw new ClienteInexistenteException("Cliente inexistente");
        }
        Cliente cliente = this.alteraClienteComponent.alteraNomeCliente(cpf,
                trocaNomeClienteDTO.getNomeCliente(),
                trocaNomeClienteDTO.getNovoNomeCliente());
        return cliente;
    }
    private Boolean confirmaSeNovasSenhasSaoIguais(String novaSenha, String novaSenhaRepetida) {
        return novaSenha.equals(novaSenhaRepetida);
    }

    private Boolean verificaSeClienteExiste(String cpf) {
        return this.consultaClienteComponent.verificaSeClienteExiste(cpf);
    }
}
