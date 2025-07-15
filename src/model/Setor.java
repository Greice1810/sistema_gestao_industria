package model;

public class Setor {
    private Integer idSetor;
    private String nomeSetor;
    private String responsavel;

    public Setor() {
    }

    public Setor(Integer idSetor, String nomeSetor, String responsavel) {
        this.idSetor = idSetor;
        this.nomeSetor = nomeSetor;
        this.responsavel = responsavel;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"idSetor\": \"" + idSetor + "\",\n" +
                "  \"nomeSetor\": \"" + nomeSetor + "\",\n" +
                "  \"responsavel\": \"" + responsavel + "\"\n" +
                "}";
    }
}
