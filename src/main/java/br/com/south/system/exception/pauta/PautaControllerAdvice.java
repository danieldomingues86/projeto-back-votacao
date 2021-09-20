package br.com.south.system.exception.pauta;

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
    @ExceptionHandler(PautaRecordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String pautaRecordHandler(PautaRecordException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PautaMalFormedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String pautaMalFormedHandler(PautaMalFormedException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PautaNotInformedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pautaEmptyHandler(PautaNotInformedException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PautaClosedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String votoAlreadyDoneHandler(PautaClosedException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CPFInvalidoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String cpfInvalidoHandler(CPFInvalidoException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CPFNotAllowedToVoteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String cpfNotAllowedToVoteHandler(CPFNotAllowedToVoteException ex) {
        return ex.getMessage();
    }

}
