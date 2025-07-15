package model;

public class Funcionario {

    private Integer idFuncionario;
    private String nome;
    private String sobrenome;
    private Setor setor;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario, String nome, String sobrenome, Setor setor) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.setor = setor;
    }


    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {

        return "{\n" +
                "  \"idFuncionario\": \"" + idFuncionario + "\",\n" +
                "  \"nome\": \"" + nome + "\",\n" +
                "  \"sobrenome\": \"" + sobrenome + "\",\n" +
                "  \"setor\": \"" + setor + "\"\n" +
                "}";
    }

}
