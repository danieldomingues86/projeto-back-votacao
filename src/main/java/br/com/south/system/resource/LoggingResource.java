package br.com.south.system.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingResource {

    private Logger logger = LoggerFactory.getLogger(LoggingResource.class);

    @RequestMapping("/")
    public String index() {
        logger.info("Página inicial acionada");
        return "Bem vindo ao Sistema de Votação!";
    }
}
