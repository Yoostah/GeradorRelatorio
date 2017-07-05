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
public class ImportarDadosDiretoBD implements Runnable {

    public SelecaoMaquinas selMaq;
    private Maquina i = new Maquina();
    private Date dataform = new Date();
    int progresso[] = null;
    JProgressBar pbar;
    MaquinaDAO m = new MaquinaDAO();

    public ImportarDadosDiretoBD(Maquina g, Date data_inicial, int prog[], JProgressBar barra, SelecaoMaquinas maqApp) {
        this.i = g;
        this.dataform = data_inicial;
        this.progresso = prog;
        this.pbar = barra;
        this.selMaq = maqApp;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            if (i.isImportar() && !i.isImportado()) {
                String dir = i.getCaminho();
                File file = new File(dir);
                try {
                    for (String arq : file.list()) {
                        if (arq.endsWith(".txt")) {
                            System.out.println("------>" + arq + "<------");
                            try {
                                //System.out.println("Importando dados de (" + dir + "\\" + arq + ")");
                                leitura(dir + "\\" + arq, i.getNome(), i.getGrupo(), dataform);
                                m.importado(i.getId(), true);
                                progresso[0] += 1;
                                Thread.sleep(1000);
                            } catch (Exception ex) {
                                //selMaq.maqImportadas--;
                                progresso[0] += 1;
                                JOptionPane.showMessageDialog(null, "Não foi possível importar os dados da máquina " + i.getNome());
                            }
                        }
                    }

                    BarraDeProgresso bp = new BarraDeProgresso(pbar, progresso, selMaq);
                    Thread t2 = new Thread(bp);
                    t2.start();
                } catch (Exception ex) {
                    progresso[0] += 1;
                    JOptionPane.showMessageDialog(null, "Não foi possível importar os dados da máquina " + i.getNome());
                }
            }
        } catch (Exception e) {
        }

    }

    public void leitura(String dir, String maquina, String grupo, Date dataForm) throws Exception {
        String linha = "";
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

                Date data = sdf.parse(dados[2] + " " + dados[3]);

                //Se a data do registro for maior que a data informada no jCalendar fazer a inclusão do objeto no banco
                if (DateTimeComparator.getDateOnlyInstance().compare(data_inicial, data) <= 0) {
                    //Criação do objeto para guardar os dados no BD (String pesquisa, Date data, int pergunta, int resposta, int colaborador)
                    Pesquisa p = new Pesquisa(dados[1], data, Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6].trim()), maquina, grupo, Integer.parseInt(dados[4]));
                    banco.create(p);

                }
            }
        }
        br.close();
    }
}