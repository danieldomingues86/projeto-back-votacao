package br.com.south.system.exception.pauta;

import static br.com.south.system.constants.ErrorConstants.PAUTA_CLOSED_ERROR;

public class PautaClosedException extends RuntimeException {

    public PautaClosedException() {
        super(PAUTA_CLOSED_ERROR);
    }

}
