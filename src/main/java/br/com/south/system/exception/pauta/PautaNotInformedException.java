package br.com.south.system.exception.pauta;

import static br.com.south.system.constants.ErrorConstants.INFORMAR_ID_DA_PAUTA_ERROR;

public class PautaNotInformedException extends RuntimeException {

    public PautaNotInformedException() {
        super(INFORMAR_ID_DA_PAUTA_ERROR);
    }
}

