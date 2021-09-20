package br.com.south.system.exception.pauta;

import static br.com.south.system.constants.ErrorConstants.CPF_NOT_ALLOWED_ERROR;

public class CPFNotAllowedToVoteException extends RuntimeException {

    public CPFNotAllowedToVoteException() {
        super(CPF_NOT_ALLOWED_ERROR);
    }
}
