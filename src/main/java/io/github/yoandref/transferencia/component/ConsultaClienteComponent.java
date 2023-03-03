package io.github.yoandref.transferencia.component;

import io.github.yoandref.transferencia.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultaClienteComponent {

    private final ClienteRepository clienteRepository;

    public Boolean verificaSeClienteExiste(String cpf) {
        return this.verificaCpf(cpf);
    }

    public Boolean verificaCpfCliente(String cpf) {
        return this.verificaCpf(cpf);
    }

    public Boolean verificaSenhaCliente(String senha) {
        return this.clienteRepository.findBySenha(senha).isPresent();
    }

    private Boolean verificaCpf(String cpf) {
        return this.clienteRepository.findById(cpf).isPresent();
    }


}
