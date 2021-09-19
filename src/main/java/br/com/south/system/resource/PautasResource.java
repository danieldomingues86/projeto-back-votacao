package br.com.south.system.resource;

import br.com.south.system.model.Pauta;
import br.com.south.system.repository.Pautas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe de Recursos/Serviços que contém os métodos necessários (APIs) para a votação.
 */

@RestController
@RequestMapping("/pautas")
public class PautasResource {

    @Autowired
    private Pautas pautas;

    @GetMapping
    public List<Pauta> listarPautas() {
        return pautas.findAll();
    }

}