/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriohmc;

import classes.Pesquisa;
import dao.PesquisaDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thulio
 */
public class RelatorioHMC {

    /**
     * @param args the command line arguments
     */
    static List pesquisas = new ArrayList();
    
    public static void main(String[] args) throws ParseException {
        
        File arquivos[];
        File diretorio = new File("C:\\Users\\Thulio\\Documents\\NetBeansProjects\\RelatorioHMC\\arq_test\\CORMED_05.04.16");
        arquivos = diretorio.listFiles();

        System.out.println("### Arquivos encontrados no diretório ###");
        for (int i = 0; i < arquivos.length; i++) {
            System.out.println(arquivos[i].toString());

            String dir = arquivos[i].toString();
            File file = new File(dir);
            for (String arq : file.list()) {
                if (arq.endsWith(".txt")) {
                    System.out.println("------>" + arq + "<------");
                    try {
                        System.out.println(leitura(dir + "\\" + arq));
                    } catch (Exception ex) {
                    }
                }
            }
        }

//        for (int i = 0; i < pesquisas.size(); i++){
//            System.out.println(pesquisas.get(i).toString());
//        }
        
    }

    private static String leitura(String dir) throws Exception {
        String linha = "", conteudo = "";
        BufferedReader br = new BufferedReader(new FileReader(new File(dir)));
        PesquisaDAO banco = new PesquisaDAO();
        while ((linha = br.readLine()) != null) {
            if (!linha.isEmpty()) {
                //Divisão da linha da pesquisa por parametros
                String[] dados = linha.split(";");
                
                //Formatação da data
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                sdf.setLenient(false);
                Date data = sdf.parse(dados[2]+" "+dados[3]);
                //System.out.println(data);

                //Criação do objeto para guardar os dados no BD (String pesquisa, Date data, int pergunta, int resposta, int colaborador)
                Pesquisa p = new Pesquisa(dados[1], data, Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6].trim()));
                banco.create(p);
            }
        }
        br.close();
        return conteudo;
    }

}
