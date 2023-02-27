package io.github.yoandref.transferencia.component;

import io.github.yoandref.transferencia.entity.Cliente;
import io.github.yoandref.transferencia.entity.Conta;
import io.github.yoandref.transferencia.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CriaClienteComponent {

    private final ClienteRepository clienteRepository;
    private final CriaContaComponent criaContaComponent;

    public Cliente criaCliente(Cliente cliente) {
        Cliente novoCliente = clienteRepository.save(cliente);
        cliente.setConta(this.criaPrimeiraContaDoCliente(cliente));
        return novoCliente;
    }

    private List<Conta> criaPrimeiraContaDoCliente(Cliente cliente) {
        List<Conta> contaList = new ArrayList<>();
        contaList.add(this.criaContaComponent.criaNovaConta(cliente));
        return contaList;
    }

}
