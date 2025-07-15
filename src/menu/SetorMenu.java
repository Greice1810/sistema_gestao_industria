package menu;

import dao.SetorDao;
import model.Setor;

import java.util.ArrayList;
import java.util.Scanner;


public class SetorMenu {

    private static SetorDao dao = new SetorDao();
    private static Scanner scanner = new Scanner(System.in);

    public  static void main(String[] args) {

        int opcao;
        do{
            System.out.println(" \n --- MENU SETOR---");
            System.out.println(" [1] Listar Setores");
            System.out.println(" [2] Buscar model.Setor por ID");
            System.out.println(" [3] Cadastrar model.Setor");
            System.out.println(" [4] Atualizar  model.Setor");
            System.out.println(" [5] Remover model.Setor");
            System.out.println(" [0] Sair");
            System.out.println("Escolha uma opção: ");
            opcao= scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    listarSetores();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3 :
                    cadastrarSetor();
                    break;
                case 4:
                    atualizarSetor();
                    break;
                case 5:
                    removerSetor();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Invalida!!");



            }



        }while (opcao!=0);

    }
    private static void listarSetores(){
        ArrayList<Setor> setores = dao.listar();
        if(setores != null && ! setores.isEmpty()){
            for (Setor setor:setores){
                System.out.println(setor);
            }

        }else{
            System.out.println("Nenhum setor encontrado.");
        }
    }
    private  static  void buscarPorId() {
        System.out.print("Digite o ID do setor: ");
        int id = scanner.nextInt();
        Setor setor = dao.buscarPorId(id);
        if (setor != null) {
            System.out.println(setor);

        } else {
            System.out.println("model.model.Setor nao encontrado.");
            return;
        }


        }
    private static void cadastrarSetor () {
        System.out.print("Novo nome do setor: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Responsavel: ");
        String responsavel = scanner.nextLine();
        Setor setor = new Setor(null, nome,responsavel);
        if (dao.cadastrar(setor)) {
            System.out.println("model.model.Setor cadastrado com sucesso!");

        } else {
            System.out.println("Erro ao Cadastrar o setor.");
        }

        }

        private static void atualizarSetor(){
            System.out.println("ID do setor a atualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Setor setor= dao.buscarPorId(id);
            if(setor== null) {
                System.out.println("model.model.Setor nao encontrado.");
                return;
            }
                System.out.print("Novo nome do model.Setor: ");
               String nome = scanner.nextLine();
                System.out.print("Novo responsavel: ");
                String responsavel = scanner.nextLine();
                setor.setNomeSetor(nome);
                setor.setResponsavel(responsavel);

                if(dao.atualizar(setor)){
                    System.out.println("model.model.Setor atualizado com sucesso!!");

                }else{
                    System.out.println("Erro ao atualizar o setor. ");
                }


        }
      private  static void removerSetor(){
          System.out.print("ID do setor a Remover: ");
          int id = scanner.nextInt();
          if(dao.remover(id)){
              System.out.println("model.model.Setor removido com sucesso!!");
          }else{
              System.out.println("Erro ao remover o model.Setor: ");
          }

      }





        }//final




