package br.com.south.system.constants;

public class ErrorConstants {

    public static final String PAUTA_RECORD_ERROR = "Dados faltando para criação da pauta, favor revise se os dados foram fornecidos.";
    public static final String PAUTA_CLOSED_ERROR = "Está pauta está fechada para votação, é necessario ativá-la para que se possa votar.";

    public static final String VOTO_RECORD_ERROR = "Dados faltando para confirmar o voto, favor revise se os dados foram fornecidos.";
    public static final String VOTO_ALREADY_DONE_ERROR = "O associado já votou nessa pauta, votar duas vezes na mesma pauta não é permitido.";

    public static final String CPF_ERROR = "CPF Informado é invalido, favor informar um cpf válido (utilize apenas numeros)";
    public static final String CPF_NOT_ALLOWED_ERROR = "CPF válido mas sem permissão de votação.";
}
