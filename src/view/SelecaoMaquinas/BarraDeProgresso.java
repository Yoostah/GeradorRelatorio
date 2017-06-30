/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.SelecaoMaquinas;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import static view.SelecaoMaquinas.SelecaoMaquinas.telaApp;

/**
 *
 * @author Thulio
 */
public class BarraDeProgresso implements Runnable {

    public SelecaoMaquinas selMaq;
    public JProgressBar jProgressBar1;
    public int progresso[];

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

                } catch (InterruptedException e) {
                }
            }
        });
        try {
            Thread.sleep(300);
            selMaq.lerMaquinas();
            //telaApp.refreshTabela();
            telaApp.lerBanco();

        } catch (Exception e) {
        }

    }
}
