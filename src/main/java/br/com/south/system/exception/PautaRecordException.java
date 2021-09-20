package br.com.south.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PautaRecordException extends RuntimeException {

    public PautaRecordException(String exception) {
        super(exception);
    }
}


