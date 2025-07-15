package model;

import java.time.LocalDate;

public class Producao {
    private Integer idProducao;
    private Integer idProduto;
    private Integer idFuncionario;
    private LocalDate dataProducao;
    private Integer Qtd;



    public Producao(){}

    public Producao(Integer idProducao, Integer idProduto, Integer idFuncionario, LocalDate dataProducao, Integer qtd) {
        this.idProducao = idProducao;
        this.idProduto = idProduto;
        this.idFuncionario = idFuncionario;
        this.dataProducao = dataProducao;
        this.Qtd = qtd;
    }

    public Integer getIdProducao() {
        return idProducao;
    }

    public void setIdProducao(Integer idProducao) {
        this.idProducao = idProducao;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public LocalDate getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(LocalDate dataProducao) {
        this.dataProducao = dataProducao;
    }

    public Integer getQtd() {
        return Qtd;
    }

    public void setQtd(Integer qtd) {
        Qtd = qtd;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"idProducao\": \"" + idProducao + "\",\n" +
                "  \"idProduto\": \"" + idProduto + "\",\n" +
                "  \"idFuncionario\": \"" + idFuncionario + "\",\n" +
                "  \"dataProducao\": \"" + dataProducao + "\",\n" +
                "  \"Qtd\": \"" + Qtd + "\"\n" +
                "}";
    }
}