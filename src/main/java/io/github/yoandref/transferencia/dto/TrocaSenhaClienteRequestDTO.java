package io.github.yoandref.transferencia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrocaSenhaClienteRequestDTO {

    private String senhaAtual;
    private String novaSenha;
    private String novaSenhaRepetida;

}
