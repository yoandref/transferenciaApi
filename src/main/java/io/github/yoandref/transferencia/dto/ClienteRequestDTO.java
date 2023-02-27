package io.github.yoandref.transferencia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDTO {

    private String cpf;
    private String nome;
    private String sobrenome;
    private String senha;


}
