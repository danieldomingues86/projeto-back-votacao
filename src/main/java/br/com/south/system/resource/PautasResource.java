package br.com.south.system.resource;

import br.com.south.system.dto.ResultadoPautaDTO;
import br.com.south.system.exception.pauta.PautaMalFormedException;
import br.com.south.system.exception.pauta.PautaNotFoundException;
import br.com.south.system.exception.pauta.PautaNotInformedException;
import br.com.south.system.exception.voto.VotoAlreadyDoneException;
import br.com.south.system.exception.voto.VotoMalFormedException;
import br.com.south.system.model.Associado;
import br.com.south.system.model.Pauta;
import br.com.south.system.repository.Associados;
import br.com.south.system.repository.Pautas;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static br.com.south.system.utils.HTTPUtils.generateHttpHeader;

/**
 * Classe de Recursos/Serviços que contém os métodos necessários (APIs) para a votação.
 */

@RestController
@RequestMapping("/pautas")
public class PautasResource {

    private final Logger log = LoggerFactory.getLogger(LoggingResource.class);

    @Autowired
    private Pautas pautas;

    @Autowired
    private Associados associados;

    /**
     * Método responsável por permitir cadastrar uma nova pauta
     * na base de dados
     * @param pauta
     */

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

    /**
     * Método responsável por permitir que um Associado vote em uma pauta Específica.
     * A votação só é valida caso o Associado ainda não tenha votado nessa pauta.
     * @param pautaId
     * @param associado
     */

    @PostMapping(value = "/votarNaPauta/{pautaId}")
    public ResponseEntity<String> votarNaPauta(@PathVariable Long pautaId, @RequestBody Associado associado)  {

        log.info("Registrando voto na Pauta: " + pautaId);

        if(pautaId == null) {
            throw new PautaNotInformedException();
        }

        Optional<Pauta> pautaEncontrada =  pautas.findById(pautaId);
        if(pautaEncontrada == null){
            pautas.findById(pautaId).orElseThrow(() -> new PautaNotFoundException(pautaId));
        }

        if(associado.getCpf() == null || StringUtils.isEmpty(associado.getVoto())){
            throw new VotoMalFormedException();
        }

        boolean associadoJaVotouNaPauta = associadoJaVotouNessaPauta(pautaEncontrada.get(), associado);

        if(associadoJaVotouNaPauta){
            throw new VotoAlreadyDoneException();
        }

        associado.setPauta(pautaEncontrada.get());
        associados.save(associado);
        log.info("Voto do associado: " + associado.getCpf() + " na pauta: " + pautaId + " confirmado!");

        return new ResponseEntity<>("Voto do associado: " + associado.getCpf() + " na pauta: " + pautaId + " confirmado!", generateHttpHeader(), HttpStatus.OK);
    }

    /**
     * Método que verifica se associado já votou nessa pauta,
     * caso positivo retonar exceção customizada
     *
     * @param pautaEncontrada
     * @param associado
     */
    private boolean associadoJaVotouNessaPauta(Pauta pautaEncontrada, Associado associado) {

        Optional <Associado> associadoEncontrado = associados.findByCpf(associado.getCpf());

        if(!associadoEncontrado.isEmpty())
            if(associadoEncontrado.get().getPauta().getId().equals(pautaEncontrada.getId())){
                return true;
        }

        return false;
    }

    @GetMapping("/contabilizarVotos/{pautaId}")
    public ResponseEntity<ResultadoPautaDTO> resultadoPauta(@PathVariable Long pautaId) {

        Optional<Pauta> pautaEncontrada =  pautas.findById(pautaId);
        if(pautaEncontrada == null){
            pautas.findById(pautaId).orElseThrow(() -> new PautaNotFoundException(pautaId));
        }

        ResultadoPautaDTO resultadoPauta = new ResultadoPautaDTO();
        resultadoPauta.setPautaId(pautaId);
        resultadoPauta.setVotosAFavor(associados.totalResults("Sim", pautaId));
        resultadoPauta.setVotosContra(associados.totalResults("Não", pautaId));

        return new ResponseEntity<ResultadoPautaDTO>(resultadoPauta,HttpStatus.OK);
    }

    /**
     * Método responsável por listar todas as pautas existentes na base de dados.
     */

    @GetMapping("/listarPautas")
    public List<Pauta> listarPautas() {
        return pautas.findAll();
    }




}