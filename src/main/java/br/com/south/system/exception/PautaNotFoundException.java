package br.com.south.system.exception;

public class PautaNotFoundException extends RuntimeException {

    public PautaNotFoundException(Long id) {
        super("Não foi possivel encontrar uma pauta com o id: " + id);
    }
}

