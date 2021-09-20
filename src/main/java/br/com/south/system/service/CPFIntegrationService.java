package br.com.south.system.service;

import br.com.south.system.exception.pauta.CPFInvalidoException;
import br.com.south.system.exception.pauta.CPFNotAllowedToVoteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CPFIntegrationService {

    private static final Logger logger = LoggerFactory.getLogger(CPFIntegrationService.class);

    public static final String STATUS_ABLE_TO_VOTE = "{\"status\":\"ABLE_TO_VOTE\"}";
    public static final String STATUS_UNABLE_TO_VOTE = "{\"status\":\"UNABLE_TO_VOTE\"}";

    private final RestTemplate restTemplate;

    public CPFIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public boolean validateCPF(Long cpfInformado) throws HttpClientErrorException {

        logger.info("Validando CPF do associado");

        String url = String.format("https://user-info.herokuapp.com/users/%s", cpfInformado);

        try{

            final String response = restTemplate.getForObject(url, String.class);

            if(response.equals(STATUS_ABLE_TO_VOTE)){
                return true;
            }else if(response.equals(STATUS_UNABLE_TO_VOTE)){
                throw new CPFNotAllowedToVoteException();
            }

        }catch(HttpClientErrorException e){
            throw new CPFInvalidoException(e.getMessage());
        }

        return false;
    }

}
