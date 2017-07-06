/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.SelecaoMaquinas;

import controller.PesquisaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import static view.SelecaoMaquinas.SelecaoMaquinas.telaApp;
import view.TelaApp;

/**
 *
 * @author Thulio
 */
public class BarraDeProgresso implements Runnable {

    public SelecaoMaquinas selMaq;
    public JProgressBar jProgressBar1;
    public int progresso[];
    public TelaApp tela = new TelaApp();

    public BarraDeProgresso(JProgressBar barra, int progresso[], SelecaoMaquinas parent) {
        this.jProgressBar1 = barra;
        this.progresso = progresso;
        this.selMaq = parent;
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(100);
                    jProgressBar1.setValue(progresso[0]);
                    selMaq.lerMaquinas();

                } catch (Exception e) {
                }
            }
        });

        if (progresso[0] == selMaq.maqImportadas) {
            try {
                Thread.sleep(3000);
                selMaq.concluido();
                selMaq.finalizado();
                Confirmacao conf = Confirmacao.getInstance(selMaq);
                conf.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(BarraDeProgresso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
