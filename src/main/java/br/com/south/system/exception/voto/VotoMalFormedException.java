package br.com.south.system.exception.voto;

import static br.com.south.system.constants.ErrorConstants.VOTO_RECORD_ERROR;

public class VotoMalFormedException extends RuntimeException {

    public VotoMalFormedException() {
        super(VOTO_RECORD_ERROR);
    }
}
