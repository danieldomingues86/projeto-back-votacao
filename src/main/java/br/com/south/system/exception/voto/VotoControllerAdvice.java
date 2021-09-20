package br.com.south.system.exception.voto;

import br.com.south.system.exception.pauta.PautaMalFormedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VotoControllerAdvice {

    @ResponseBody
    @ExceptionHandler(PautaMalFormedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String pautaMalFormedHandler(PautaMalFormedException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(VotoAlreadyDoneException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String votoAlreadyDoneHandler(VotoAlreadyDoneException ex) {
        return ex.getMessage();
    }

}

