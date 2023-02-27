package io.github.yoandref.transferencia.component;

import io.github.yoandref.transferencia.entity.ContaChaveComposta;
import io.github.yoandref.transferencia.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultaContaComponent {

    private final ContaRepository contaRepository;

    public Boolean verificaSeContaExiste(String numeroConta, String agencia){
        return this.contaRepository.findById(new ContaChaveComposta(numeroConta, agencia)).isPresent();
    }

}
