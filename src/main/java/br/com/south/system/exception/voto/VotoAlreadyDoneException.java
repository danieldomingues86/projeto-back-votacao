package br.com.south.system.exception.voto;

import static br.com.south.system.constants.ErrorConstants.VOTO_ALREADY_DONE_ERROR;

public class VotoAlreadyDoneException extends RuntimeException {

    public VotoAlreadyDoneException() {
        super(VOTO_ALREADY_DONE_ERROR);
    }
}
