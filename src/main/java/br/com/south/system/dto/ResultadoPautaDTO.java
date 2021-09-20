package br.com.south.system.dto;

public class ResultadoPautaDTO {

    private Long pautaId;
    private Integer votosAFavor;
    private Integer votosContra;

    public Long getPautaId() {
        return pautaId;
    }

    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
    }

    public Integer getVotosAFavor() {
        return votosAFavor;
    }

    public void setVotosAFavor(Integer votosAFavor) {
        this.votosAFavor = votosAFavor;
    }

    public Integer getVotosContra() {
        return votosContra;
    }

    public void setVotosContra(Integer votosContra) {
        this.votosContra = votosContra;
    }
}
