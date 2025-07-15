package dao;

import config.ConexaoMySql;
import dao.FuncionarioDao;
import model.Funcionario;
import model.Producao;
import model.Produto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProducaoDAO {

    private  Connection coon = ConexaoMySql.getConnection();
      private FuncionarioDao funcionarioDao = new FuncionarioDao();
      private ProdutoDAO produtoDAO = new ProdutoDAO();


    public ArrayList<Producao>listar(){
        ArrayList<Producao>  producoes = new ArrayList<>();
        String sql= "SELECT * FROM producao;";
        try( PreparedStatement ps = coon.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Integer id = rs.getInt("id_producao");
                Integer idProduto = rs.getInt("id_produto");
                Integer idFuncionario = rs.getInt("id_funcionario");
                Integer quantidade = rs.getInt("quantidade");
                LocalDate data = rs.getDate("data").toLocalDate();

                producoes.add(new Producao(id,idProduto,idFuncionario,data,quantidade));


            }
            return producoes;

        }catch (SQLException e ){
            System.out.println("Erro ao Listar model.Producao:" + e.getMessage());
        }
        return null;
    }
    public Producao buscarporId(Integer id){
        try {
            String sql = "SELECT * FROM produto WHERE id_producao= ?;";
            PreparedStatement ps = coon.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Integer idProduto = rs.getInt("id_produto");
                Integer idFuncionario = rs.getInt("id_funcionario");
                LocalDate data = LocalDate.parse(rs.getString("data_producao"));
                Integer quantidade = rs.getInt("quantidade");

                Produto produto= produtoDAO.buscarPorId(idProduto);
                Funcionario funcionario = funcionarioDao.buscarPorId();

                return new Producao(id,idProduto,idFuncionario,data,quantidade);



            }
        }catch (SQLException e){
            System.out.println("Erro ao buscar model.Producao por Id." + e.getMessage());
        }
        return  null;
    }

    public boolean cadastrar(Producao producao){
        String sql="INSERT INTO producao (id_produtos,id_funcionario,data,quantidade) VALUES(?,?,?,?);";
        try {
            PreparedStatement ps = coon.prepareStatement(sql);
            ps.setInt(1, producao.getIdProduto());
            ps.setInt(2, producao.getIdFuncionario());
            ps.setDate(3, Date.valueOf(producao.getDataProducao()));
            ps.setInt(4, producao.getQtd());
            int linhas = ps.executeUpdate();
            return linhas > 0;
        }catch (SQLException e){
            System.out.println("Erro ao cadastrar produção:" + e .getMessage());
        }
        return false;

    }
    public boolean atualizar(Producao producao){
        String sql = "UPDATE producao SET id_produtos = ? ,id_funcionario = ? ,data = ?, quantidade = ? WHERE id_producao = ? ;";
        try(PreparedStatement ps = coon.prepareStatement(sql)){
            ps.setInt(1,producao.getIdProduto());
            ps.setInt(2,producao.getIdFuncionario());
            ps.setDate(3,Date.valueOf(producao.getDataProducao()));
            ps.setInt(4,producao.getQtd());
            ps.setInt(5,producao.getIdProducao());
            int linhas = ps.executeUpdate();

            return  linhas > 0 ;

        }catch (SQLException e ){
            System.out.println("Erro ao atualizar produção:" + e .getMessage());
        }
        return  false;
    }

    public boolean remover(Integer id){
        String sql= "DELETE  FROM producao WHERE id_producao = ? ;";
        try {
            PreparedStatement ps = coon.prepareStatement(sql);
            ps.setInt(1, id);
            int linhas = ps.executeUpdate();
            return linhas > 0;
        }catch (SQLException e ){
            System.out.println("Erro ao remover a producao:" + e.getMessage());
        }
        return  false;
    }






}// final
