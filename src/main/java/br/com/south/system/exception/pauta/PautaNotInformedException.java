package br.com.south.system.exception.pauta;

public class PautaNotInformedException extends RuntimeException {

    public PautaNotInformedException() {
        super("Favor informar o id da pauta");
    }
}

