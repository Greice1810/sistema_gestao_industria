package file;

import java.io.*;

public class LeituraNotas {

    public static void main(String[] args) {
        String caminho = "D:\\Projeto Final\\ProjetoFinalATZ\\src\\file\\notas.txt";
        File arquivo = new File(caminho);
        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
            String linha;
            Integer qtdlinha = 0;
            Double soma = 0.0, media= 0.0;
            br.readLine();
            while((linha= br.readLine())!= null){
                String[] colunas = linha.split(",");
                soma+= Double.parseDouble(colunas[1]);
                qtdlinha++;

            }
            media=soma/qtdlinha;
            System.out.println("Media Notas:" + media);



        }catch (FileNotFoundException e){
            System.out.println("Erro ao buscar arquivo:" + e.getMessage());

        }catch (IOException e){
            System.out.println("Erro ao abrir o arquivo:" + e.getMessage());
        }
    }
}
