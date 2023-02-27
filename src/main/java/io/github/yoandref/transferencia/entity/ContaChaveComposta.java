package io.github.yoandref.transferencia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContaChaveComposta {

    @Column(name = "NUMERO_CONTA")
    private String numeroConta;

    @Column(name = "AGENCIA")
    private String agencia;

    public ContaChaveComposta() {
    }

    public ContaChaveComposta(String numeroConta, String agencia) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }
}
