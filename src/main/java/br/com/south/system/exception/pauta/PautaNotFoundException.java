package br.com.south.system.exception.pauta;

public class PautaNotFoundException extends RuntimeException {

    public PautaNotFoundException(Long id) {
        super("Não foi possivel encontrar uma pauta com o id: " + id);
    }
}

