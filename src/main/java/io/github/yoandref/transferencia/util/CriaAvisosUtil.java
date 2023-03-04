package io.github.yoandref.transferencia.util;

import io.github.yoandref.transferencia.dto.AvisosDTO;

public class CriaAvisosUtil {

    public static AvisosDTO criaAvisos(String msg) {
        AvisosDTO avisosDTO = new AvisosDTO();
        avisosDTO.setMensagem(msg);
        return avisosDTO;
    }

}
