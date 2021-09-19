package br.com.south.system.resource;

import br.com.south.system.model.Pauta;
import br.com.south.system.repository.Pautas;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Classe de Recursos/Serviços que contém os métodos necessários (APIs) para a votação.
 */

@RestController
@RequestMapping("/pautas")
public class PautasResource {

    private Logger logger = LoggerFactory.getLogger(LoggingResource.class);

    @Autowired
    private Pautas pautas;

    @PostMapping
    public Pauta cadastrarPauta(@Valid @RequestBody Pauta pauta) {
        logger.info("Gravando nova pauta");
        return pautas.save(pauta);
    }

    @GetMapping
    public List<Pauta> listarPautas() {
        return pautas.findAll();
    }

}