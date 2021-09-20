package br.com.south.system.resource;

import br.com.south.system.exception.PautaMalFormedException;
import br.com.south.system.exception.PautaNotFoundException;
import br.com.south.system.model.Pauta;
import br.com.south.system.repository.Pautas;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe de Recursos/Serviços que contém os métodos necessários (APIs) para a votação.
 */

@RestController
@RequestMapping("/pautas")
public class PautasResource {

    private final Logger log = LoggerFactory.getLogger(LoggingResource.class);

    @Autowired
    private Pautas pautas;

    @PostMapping(value = "/cadastrarPauta")
    public ResponseEntity<Pauta> cadastrarPauta(@RequestBody Pauta pauta)  {

        log.info("Assunto da Pauta: " + pauta.getAssunto());

        if(StringUtils.isEmpty(pauta.getAssunto())){
            throw new PautaMalFormedException();
        }

        pautas.save(pauta);
        log.info("pauta: " + pauta.getAssunto() + " salva com sucesso");
        return ResponseEntity.status(HttpStatus.OK).body(pauta);
    }

    @GetMapping("/resultadoPauta/{id}")
    public Pauta resultadoPauta(@PathVariable Long id) {
        return pautas.findById(id).orElseThrow(() -> new PautaNotFoundException(id));
    }


    @GetMapping("/listarPautas")
    public List<Pauta> listarPautas() {
        return pautas.findAll();
    }



}