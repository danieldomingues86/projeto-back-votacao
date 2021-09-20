package br.com.south.system.exception;

import static br.com.south.system.constants.ErrorConstants.PAUTA_RECORD_ERROR;

public class PautaMalFormedException extends RuntimeException {

    public PautaMalFormedException() {
        super(PAUTA_RECORD_ERROR);
    }
}
