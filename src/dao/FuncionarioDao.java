package dao;

import config.ConexaoMySql;
import model.Funcionario;
import model.Setor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDao {

    private Connection conn = ConexaoMySql.getConnection();
    private SetorDao setorDao = new SetorDao();

    public ArrayList<Funcionario> listar(){
        try {
            ArrayList<Funcionario> funcionarios = new ArrayList<>();
            String sql = "SELECT * FROM funcionario;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();

            while(rs.next()){
                Integer idSetor = rs.getInt("id_setor");
                String sobrenome = rs.getString("sobrenome");
                String nome= rs.getString("nome");
                Integer id = rs.getInt("id_funcionario");

                Setor setor = setorDao.buscarPorId(idSetor);

                System.out.println(setor);

                funcionarios.add(new Funcionario(id,nome,sobrenome,setor));

            }
            return  funcionarios;

        }catch (SQLException e){
            System.out.println("Erro ao Listar o funcionario:" + e.getMessage());
        }



        return null;}

    public Funcionario buscarPorId(){
        try {


            String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            Integer id = 3;
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Integer idFuncionario = rs.getInt("id_funcionario");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                Integer idSetor = rs.getInt("id_setor");
                Setor setor = setorDao.buscarPorId(idSetor);

                Funcionario funcionario = new Funcionario(id,nome,sobrenome,setor);
                return funcionario;
            }


        }catch (SQLException e ){
            System.out.println("ERRO A BUSCAR ID."+ e.getMessage());
        }
        return  null;
    }

public boolean cadastrar(Funcionario funcionario){
        try{

        String sql= "INSERT INTO funcionario (nome,sobrenome,id_funcionario) VALUES (?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,funcionario.getNome());
        ps.setString(2,funcionario.getSobrenome());
        ps.setInt(3,funcionario.getIdFuncionario());


        int qtdlinha= ps.executeUpdate();

        if(qtdlinha > 0){

            return  true;
        }

        }catch (SQLException e ){
            System.out.println("ERRO A CADASTRAR." + e.getMessage());
        }
        return false;
}

public boolean atualizar(){
        return true;
}

public boolean remover(){
        return true;
}



}
