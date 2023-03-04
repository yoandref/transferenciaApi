package io.github.yoandref.transferencia.component;

import io.github.yoandref.transferencia.dto.AvisosDTO;
import io.github.yoandref.transferencia.entity.Cliente;
import io.github.yoandref.transferencia.exception.ClienteInexistenteException;
import io.github.yoandref.transferencia.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AlteraClienteComponent {

    private final ClienteRepository clienteRepository;

    public Cliente alteraSenhaCliente(String cpf, String novaSenha) {
        Optional<Cliente> clienteOptional = this.clienteRepository.findById(cpf);
        if(clienteOptional.isEmpty()) {
            throw new ClienteInexistenteException("Cliente não encontrado!");
        }
        Cliente cliente = clienteOptional.get();
        cliente.setSenha(novaSenha);
        return this.clienteRepository.save(cliente);
    }

    public Cliente alteraNomeCliente(String cpf, String primeiroNomeAtual, String novoPrimeiroNome) {
        Optional<Cliente> optionalCliente = this.clienteRepository.findByCpfAndNome(cpf, primeiroNomeAtual);
        if(optionalCliente.isEmpty()) {
            throw new ClienteInexistenteException("Cliente não encontrado!");
        }
        Cliente cliente = optionalCliente.get();
        cliente.setNome(novoPrimeiroNome);
        return this.clienteRepository.save(cliente);
    }


}
