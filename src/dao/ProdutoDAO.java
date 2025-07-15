package dao;

import config.ConexaoMySql;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    private Connection conn = ConexaoMySql.getConnection();

    public ArrayList<Produto> listar() {
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            String sql = "SELECT * FROM  produto;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id_produto");
                String nome = rs.getNString("nome");
                String descricao = rs.getNString("descricao");

                Produto produto = new Produto(id, nome, descricao);
                produtos.add(produto);
            }
            return produtos;

        } catch (SQLException e) {
            System.out.println("Erro ao listar os Produtos:" + e.getMessage());
            return null;
        }
    }

    public Produto buscarPorId(Integer id) {
try {
    String sql = "SELECT *FROM  produto WHERE id_produto = ?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();

}catch (SQLException e ){
    System.out.println("Erro ao buscar produto pelo Id:" + e .getMessage());
}
return  null;
    }

    public boolean cadastrar(Produto produto){
        try {
            String sql = " INSERT INTO produto (nome, descricao) VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNomeProduto());
            ps.setString(2, produto.getDescricao());
            int qtdLinha = ps.executeUpdate();

            return qtdLinha > 0;

        }catch (SQLException e ){
            System.out.println("Erro a cadastrar model.Produto:" + e.getMessage());

            return  false;

        }




    }
    public boolean atualizar(Produto produto){
        String sql = "UPDATE produto SET nome = ?, descricao = ?, WHERE id_ produto = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNomeProduto());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getIdProduto());
            int qtdAtualizacoes = ps.executeUpdate();

            return qtdAtualizacoes > 0;



        }catch (SQLException e ){
            System.out.println("Erro ao atualizar o model.Produto" + e.getMessage());
        }
        return  false;
    }

    public boolean remover(Integer id){
        try {
            String sql = "DELETE FROM produtos WHERE id_produto=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Produto produtoRetornado = buscarPorId(id);
            if(produtoRetornado!= null){
                ps.executeUpdate();
                return  true;

            }


        }catch (SQLException e ){
            System.out.println("Erro ao Deletar o model.Produto:" + e.getMessage());
        }
        return  false;
    }





}// final