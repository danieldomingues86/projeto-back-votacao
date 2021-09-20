package br.com.south.system.exception.pauta;

import static br.com.south.system.constants.ErrorConstants.CPF_ERROR;

public class CPFInvalidoException extends RuntimeException {

    public CPFInvalidoException(String mensagem) {
        super(CPF_ERROR + " " + mensagem);
    }

    public CPFInvalidoException() {
        super(CPF_ERROR);
    }
}
