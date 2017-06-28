/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.SelecaoMaquinas;

import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author Thulio
 */
public class BarraDeProgresso implements Runnable {

    public JProgressBar jProgressBar1;

    @Override
    public void run() {
        System.out.println("t2");

        jProgressBar1.setValue(jProgressBar1.getValue() + 1);
        

    }
}
