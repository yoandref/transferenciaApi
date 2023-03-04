package io.github.yoandref.transferencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "CONTA")
public class Conta {

    @EmbeddedId
    private ContaChaveComposta contaChaveCompostaId;

    @Column(name = "CODIGO_BANCO")
    private String codigoBanco;

    @Column(name = "DATA_HORA_CRIACAO")
    private LocalDateTime dataHoraCriacao;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    @Column(name = "cpf")
    private String cpf;

}

