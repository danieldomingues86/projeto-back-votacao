package br.com.south.system.exception.pauta;

import static br.com.south.system.constants.ErrorConstants.PAUTA_NOT_FOUND_ERROR;

public class PautaNotFoundException extends RuntimeException {

    public PautaNotFoundException(Long id) {
        super(PAUTA_NOT_FOUND_ERROR + id);
    }
}

