package io.github.yoandref.transferencia.component;

import io.github.yoandref.transferencia.entity.Cliente;
import io.github.yoandref.transferencia.entity.Conta;
import io.github.yoandref.transferencia.entity.ContaChaveComposta;
import io.github.yoandref.transferencia.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CriaContaComponent {

    private final ContaRepository contaRepository;

    public Conta criaNovaConta(Cliente cliente) {
        String numeroConta = RandomStringUtils.randomNumeric(8);
        String agencia = RandomStringUtils.randomNumeric(4);

        Conta conta = new Conta();
        conta.setContaChaveCompostaId(new ContaChaveComposta(numeroConta, agencia));
        conta.setCodigoBanco("0000");
        conta.setDataHoraCriacao(LocalDateTime.now());
        conta.setCpf(cliente.getCpf());
        conta.setSaldo(BigDecimal.ZERO);
        return this.contaRepository.save(conta);
    }

}
