package dao;

import config.ConexaoMySql;
import model.Setor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SetorDao {

    private Connection conn = ConexaoMySql.getConnection();

    public ArrayList<Setor> listar() {
        try {
            ArrayList<Setor> setores = new ArrayList<>();
            String sql = "SELECT*FROM setor;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id_setor");
                String nome = rs.getString("nome_setor");
                String responsavel = rs.getString("responsavel");

                setores.add(new Setor(id, nome, responsavel));
            }

                return setores;
        } catch (SQLException e) {
            System.out.println("Erro ao listar o cliente:" + e.getMessage());
        }
        return null;
    }

    public Setor buscarPorId(Integer id) {

        try {
            String sql = "SELECT *FROM setor WHERE id_setor = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();



            if (rs.next()) {
                Integer idSetor = rs.getInt("id_setor");
                String nome = rs.getString("nome_setor");
                String responsavel = rs.getString("responsavel");
                Setor setor = new Setor(idSetor, nome, responsavel);

                return setor;
            }

        } catch (SQLException e){
            System.out.println("erro ao buscar o setor ID." + e.getMessage());


        }
        return null;
    }

    public boolean cadastrar(Setor setor) {
        try {
            String sql = "INSERT INTO setor (nome_setor, responsavel) VALUES(?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, setor.getNomeSetor());
            ps.setString(2, setor.getResponsavel());
            int qtdLinha = ps.executeUpdate();

            if(qtdLinha > 0){
                return  true;
            }

        }catch (SQLException e ){
            System.out.println("ERRO AO CADASTRAR."+ e .getMessage());

        }
        return false;
    }

    public boolean atualizar(Setor setor) {
        try {
        String sql="UPDATE setor  SET nome_setor= ?, responsavel = ?  WHERE id_setor = ?; ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,setor.getNomeSetor());
        ps.setString(2, setor.getResponsavel());
        ps.setInt(3,setor.getIdSetor());
        int qtdAtualizacoes = ps.executeUpdate();


        if(qtdAtualizacoes > 0){
            return  true;
        }

        }catch (SQLException e){
            System.out.println("ERRO AO ATUALIZAR O SETOR."+ e.getMessage());

        }

        return false;
    }

    public boolean remover(Integer id) {
        try {
            String sql = "DELETE FROM setor WHERE id_setor = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            Setor setorRetornado=buscarPorId(id);

            if(setorRetornado != null){
                ps.executeUpdate();

                return  true;
            }



        }catch (SQLException e ){
            System.out.println("ERRO AO DELETAR." + e.getMessage());
        }



        return false;
    }


}


