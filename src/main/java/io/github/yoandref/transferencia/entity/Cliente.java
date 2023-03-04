package io.github.yoandref.transferencia.entity;

import io.github.yoandref.transferencia.dto.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "CPF")
    private String cpf;
   
    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "SENHA")
    private String senha;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cpf")
    private List<Conta> conta;

    public static Cliente converter(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = new Cliente();
        cliente.setCpf(clienteRequestDTO.getCpf());
        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setSobrenome(clienteRequestDTO.getSobrenome());
        cliente.setSenha(clienteRequestDTO.getSenha());
        return cliente;
    }

}
