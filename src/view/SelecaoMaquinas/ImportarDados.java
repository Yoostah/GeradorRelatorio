/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.SelecaoMaquinas;

import controller.MaquinaDAO;
import controller.PesquisaDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import model.Maquina;
import model.Pesquisa;
import org.joda.time.DateTimeComparator;

/**
 *
 * @author Thulio
 */
public class ImportarDados implements Runnable {

    public SelecaoMaquinas selMaq;
    private Maquina i = new Maquina();
    private Date dataform = new Date();
    volatile int progresso[] = null;
    JProgressBar pbar;
    MaquinaDAO m = new MaquinaDAO();

    public ImportarDados(Maquina g, Date data_inicial, int prog[], JProgressBar barra, SelecaoMaquinas maqApp) {
        this.i = g;
        this.dataform = data_inicial;
        this.progresso = prog;
        this.pbar = barra;
        this.selMaq = maqApp;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                //Thread.sleep(1000);
                if (i.isImportar() && !i.isImportado()) {
                    String dir = i.getCaminho();
                    File file = new File(dir);
                    if (file.list() != null) {

                        try {
                            for (String arq : file.list()) {
                                if (arq.endsWith(".txt")) {
                                    System.out.println("------>" + arq + "<------");
                                    try {
                                        //System.out.println("Importando dados de (" + dir + "\\" + arq + ")");
                                        progresso[0] += 1;
                                        leitura(dir + "\\" + arq, i.getNome(), i.getGrupo(), dataform);
                                        m.importado(i.getId(), true);
                                        System.out.println("Try 1: " + i.getNome() + " /" + progresso[0]);
                                        //Thread.sleep(1000);
                                    } catch (Exception ex) {
                                        progresso[0] += 1;
                                        System.out.println("Catch1: " + i.getNome() + " /" + progresso[0]);
                                        JOptionPane.showMessageDialog(null, "Não foi possível importar os dados da máquina " + i.getNome());

                                    }
                                }
                            }

                            BarraDeProgresso bp = new BarraDeProgresso(pbar, progresso, selMaq);
                            Thread t2 = new Thread(bp);
                            t2.start();
                        } catch (Exception ex) {

                        }

                    } else {
                        progresso[0] += 1;
                        System.out.println("Catch 2: " + i.getNome() + " /" + progresso[0]);
                        selMaq.maquinasComErro(i.getNome());
                        if (progresso[0] == selMaq.maqImportadas) {
                            selMaq.concluido();
                            selMaq.completarBarra();
                            selMaq.finalizado();
                            BarraDeProgresso bp = new BarraDeProgresso(pbar, progresso, selMaq);
                            Thread t2 = new Thread(bp);
                            t2.start();

                        }
                    }

                }
            } catch (Exception e) {
            }

        }

    }

    public String leitura(String dir, String maquina, String grupo, Date dataForm) throws Exception {
        String linha = "", conteudo = "";;
        BufferedReader br = new BufferedReader(new FileReader(new File(dir)));
        PesquisaDAO banco = new PesquisaDAO();
        while ((linha = br.readLine()) != null) {
            if (!linha.isEmpty() && linha.length() >= 39) {
                //Divisão da linha da pesquisa por parametros
                String[] dados = linha.split(";");

                //Formatação da data
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                //" If you have a pattern and create a date object that strictly matches your pattern, set lenient to false"
                sdf.setLenient(false);

                //Pega a data inicial escolhida pelo usuário;
                Date data_inicial = dataForm;

                Date datas = sdf.parse(dados[2] + " " + dados[3]);

                //Se a data do registro for maior que a data informada no jCalendar fazer a inclusão do objeto no banco
                if (DateTimeComparator.getDateOnlyInstance().compare(data_inicial, datas) <= 0) {
                    //Criação do objeto para guardar os dados no BD (String pesquisa, Date data, int pergunta, int resposta, int colaborador)
                    //Pesquisa p = new Pesquisa(dados[1], datas, Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6].trim()), maquina, grupo, Integer.parseInt(dados[4]));
                    //banco.create(p);

                    String[] d = dados[2].split("/");

                    String data = (d[2] + "/" + d[1] + "/" + d[0]);

                    linha = "" + "\t" + dados[1] + "\t" + data + "\t" + Integer.parseInt(dados[4]) + "\t" + Integer.parseInt(dados[5]) + "\t" + grupo + "\t" + Integer.parseInt(dados[6].trim()) + "\t" + maquina + "\t" + Integer.parseInt(dados[4]);
                    conteudo = new StringBuilder(conteudo).append(linha.concat("\n")).toString();
                    escrever(linha);
                }
            }
        }
        br.close();
        return conteudo;
    }

    private void escrever(String s) {
        File dir = new File("C:\\SISAT-v2");
        File arq = new File(dir, "log.txt");

        try {

            //neste ponto criamos o arquivo fisicamente
            arq.createNewFile();

            //Devemos passar no construtor do FileWriter qual arquivo
            // vamos manipular.
            // Esse construtor aceita dois tipos de parâmetros,
            // File ou String.
            //O parâmetro true indica que reescrevemos no arquivo
            // sem apagar o que já existe.
            // O false apagaria o conteúdo do arquivo e escreveria
            // o novo conteúdo.
            // Se não usar o 2° parâmetro, ele por padrão será false.
            //O mais importante, essa linha abre o fluxo do arquivo 
            FileWriter fileWriter = new FileWriter(arq, true);

            //Agora vamos usar a classe PrintWriter para escrever
            //fisicamente no arquivo.
            //Precisamos passar o objeto FileReader em seu construtor
            PrintWriter printWriter = new PrintWriter(fileWriter);

            //Agora vamos escrever no arquivo com o método  println(),
            // que nos permite escrever linha a linha no arquivo
            printWriter.println(s);
            //printWriter.write("\n");
            //printWriter.print("\r\n");

            //o método flush libera a escrita no arquivo
            printWriter.flush();

            //No final precisamos fechar o arquivo
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
