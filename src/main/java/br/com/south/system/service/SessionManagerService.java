package br.com.south.system.service;

import br.com.south.system.exception.pauta.PautaNotFoundException;
import br.com.south.system.model.Pauta;
import br.com.south.system.repository.Pautas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável por gerenciar uma sessão de votação em uma pauta.
 * A sessão de votação fica aberta por um tempo determinado através da API de ativação
 * esse tempo é pré-configurado no arquivo application.properties do Spring;
 */

@Service
public class SessionManagerService {

    private static final Logger log = LoggerFactory.getLogger(SessionManagerService.class);

    @Value("${configured.session.time}")
    private long voteSessionTime;

    @Autowired
    private Pautas pautas;

    @Async
    public void startPautaSession(Long pautaId) throws InterruptedException {

        log.info("Habilitando pauta para votação: " + pautaId);
        log.info("tempo de votação configurado: " + voteSessionTime);

        Optional<Pauta> pauta =  pautas.findById(pautaId);
        if(pauta == null){new PautaNotFoundException(pautaId);}

        Pauta pautaAtual = pauta.get();
        pautaAtual.setAtiva(true);
        pautas.save(pautaAtual);

        // Tempo da sessão para pauta pre-configurado em arquivo .properties
        Thread.sleep(voteSessionTime);

        pauta.get().setAtiva(false);
        pautas.save(pautaAtual);

    }

}
