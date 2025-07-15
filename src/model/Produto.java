package model;

public class Produto {
    private Integer idProduto;
    private String nomeProduto;
    private String Descricao;

    public Produto(Integer idProduto, String nomeProduto, String descricao) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        Descricao = descricao;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"idProduto\": \"" + idProduto + "\",\n" +
                "  \"nomeProduto\": \"" + nomeProduto + "\",\n" +
                "  \"Descricao\": \"" + Descricao + "\"\n" +
                "}";
    }
}