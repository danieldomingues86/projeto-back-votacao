package br.com.south.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PautaControllerAdvice {

    @ResponseBody
    @ExceptionHandler(PautaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pautaNotFoundHandler(PautaNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PautaMalFormedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String pautaMalFormedHandler(PautaMalFormedException ex) {
        return ex.getMessage();
    }

}
