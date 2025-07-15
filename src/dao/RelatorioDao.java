package dao;

import config.ConexaoMySql;
import model.Funcionario;
import model.Producao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDao {
    private static final Connection conn= ConexaoMySql.getConnection();

    public List<Funcionario>listarFuncionarioPorSetor(int idSetor){

            List<Funcionario> lista = new ArrayList<>();
            String sql = "SELECT*FROM funcionario WHERE id_setor = ?;";
           try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, idSetor);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    Funcionario f = new Funcionario();
                    f.setIdFuncionario(rs.getInt("id_funcionario"));
                    f.setNome(rs.getNString("nome"));
                    f.setSobrenome(rs.getNString("sobrenome"));
                    lista.add(f);

                }

        }catch(SQLException e ){
               System.out.println("Erro ao listar Funcionario por Setor:" + e.getMessage());
           }
           return lista;
    }
// producao data
    public List<Producao>listarProducaoPorData(String data){
        List<Producao> lista= new ArrayList<>();
        String sql= "SELECT * FROM producao WHERE data_producao = ?;";
        try(PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setString(1,data);
            ResultSet rs =stmt.executeQuery();

            while(rs.next()){
                Producao p = new Producao();
                p.setIdProducao(rs.getInt("id_producao"));
                p.setDataProducao(LocalDate.parse(rs.getNString("data_producao")));
                p.setQtd(rs.getInt("quantidade"));
                lista.add(p);


            }

        }catch (SQLException e){
            System.out.println("Erro ao listar a Producao por Data:" + e.getMessage());
        }
        return lista;


    }
    //produto funcionario

    public List<Produto> listarProdutoporFuncionario(int idFuncionario){
        List<Produto> lista = new ArrayList<>();
        String sql ="SELECT DISTINCT p .* FROM producao pr "+ "INNER JOIN produtos p  ON pr.id_produtos " +"WHERE pr .id_funcionario = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,idFuncionario);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("id_produtos"));
                prod.setNomeProduto(rs.getNString("nome_produto"));
                prod.setDescricao(rs.getNString("descricao"));

            }



        }catch (SQLException e ){
            System.out.println("Erro ao listar o Produto por Funcionario:" + e.getMessage());
        }
    }


}
