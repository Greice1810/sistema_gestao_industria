import dao.FuncionarioDao;
import model.Funcionario;

import java.util.ArrayList;

public class AppIndustria {


    public static void main(String[] args) {

//        dao.SetorDao setorDao= new dao.SetorDao();
//       ArrayList<model.Setor> setores = setorDao.listar();
//
//        for (model.Setor setor:setores){
//           System.out.println(setor);
//        }
//
//
//        System.out.println("________________________");
//      model.Setor setor = setorDao.buscarPorId(5);
//        System.out.println(setor);
//
//
//        System.out.println("________________________");
//        model.Setor novoSetor = new model.Setor();
//        novoSetor.setIdSetor(6);
//        novoSetor.setNomeSetor("Recursos Humanos");
//        novoSetor.setResponsavel("Fabio");

       //boolean foiAtualizado = setorDao.atualizar(novoSetor);
        //System.out.println("foi atualizado?"+ foiAtualizado);


       // boolean foiCadastrado = setorDao.cadastrar(novoSetor);

       // System.out.println("Foi Cadastrado?"+foiCadastrado);


        System.out.println("------------------");

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        ArrayList<Funcionario> funcionarios =funcionarioDao.listar();

        for(Funcionario funcionario: funcionarios){
            System.out.println(funcionario);
        }

       System.out.println("________________________");
        Funcionario funcionario = funcionarioDao.buscarPorId();
      System.out.println(funcionario);


        System.out.println("______________________");

        boolean foicadastrado = funcionarioDao.cadastrar(funcionario);
                System.out.println("Foi Cadastrado?" + foicadastrado);
    }
}
