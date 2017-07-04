package view.SelecaoMaquinas;

import model.Maquina;
import controller.MaquinaDAO;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import view.TelaApp;

/**
 *
 * @author Thulio
 */
public class SelecaoMaquinas extends javax.swing.JDialog {

    public static TelaApp telaApp;
    public static BarraDeProgresso barraApp;
    public int maqImportadas;

    /**
     * Creates new form Filho
     */
    public SelecaoMaquinas(TelaApp parent, boolean modal) {
        super(parent, modal);
        this.telaApp = parent;
        this.setModal(modal);
        initComponents();
        lblConcluido.setVisible(false);
        lerMaquinas();
        progresso.setVisible(false);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //" If you have a pattern and create a date object that strictly matches your pattern, set lenient to false"
        sdf.setLenient(false);
        Date data = null;
        try {
            //Pega a data inicial escolhida pelo usuário;

            data = sdf.parse("01/01/2016");
        } catch (ParseException ex) {
            Logger.getLogger(SelecaoMaquinas.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDateInicial.setDate(data);

        DefaultTableModel modelo = (DefaultTableModel) jTableMaquinas.getModel();
        jTableMaquinas.setRowSorter(new TableRowSorter(modelo));

    }

    public void lerMaquinas() {
        DefaultTableModel modelo = (DefaultTableModel) jTableMaquinas.getModel();
        MaquinaDAO m = new MaquinaDAO();
        modelo.setNumRows(0);

        for (Maquina i : m.listar()) {

            modelo.addRow(new Object[]{
                i.getId(),
                i.getNome(),
                i.getCaminho(),
                i.getGrupo(),
                i.isImportar(),
                i.isImportado()
            });

        }
    }

    public void concluido() {
        lblConcluido.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBtnImportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaquinas = new javax.swing.JTable(){
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    //comment row, exclude heading
                    if(rowIndex != -1 && (colIndex == 1 || colIndex == 2 || colIndex == 3)){
                        tip = getValueAt(rowIndex, colIndex).toString();
                    }
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
            @Override
            public boolean isCellEditable(int row, int col) {

                MaquinaDAO m = new MaquinaDAO();
                boolean editable = true;
                if (col == 4 && Boolean.parseBoolean(jTableMaquinas.getValueAt(row, 4).toString()) == false) {
                    m.importar(Integer.parseInt(jTableMaquinas.getValueAt(row, 0).toString()), true);
                }else if (col == 4 && Boolean.parseBoolean(jTableMaquinas.getValueAt(row, 4).toString()) == true){
                    m.importar(Integer.parseInt(jTableMaquinas.getValueAt(row, 0).toString()), false);
                }
                return editable;
            }
        }
        ;
        jDateInicial = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        progresso = new javax.swing.JProgressBar();
        lblConcluido = new javax.swing.JLabel();
        jCheckTodos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("- IMPORTAÇÃO DE DADOS -");
        setIconImage(null);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 25)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELECIONE AS MÁQUINAS PARA IMPORTAR");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        jLabel1.setMaximumSize(new java.awt.Dimension(399, 34));
        jLabel1.setMinimumSize(new java.awt.Dimension(399, 34));
        jLabel1.setName(""); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(399, 34));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 574, 36));

        jBtnImportar.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/ler.png"))); // NOI18N
        jBtnImportar.setText("IMPORTAR");
        jBtnImportar.setToolTipText("Importar Máquinas selecionadas");
        jBtnImportar.setMaximumSize(new java.awt.Dimension(133, 57));
        jBtnImportar.setMinimumSize(new java.awt.Dimension(133, 57));
        jBtnImportar.setPreferredSize(new java.awt.Dimension(133, 57));
        jBtnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnImportarActionPerformed(evt);
            }
        });
        jBtnImportar.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnImportar.setVerticalTextPosition(SwingConstants.BOTTOM);
        jPanel1.add(jBtnImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 352, -1, 57));

        jTableMaquinas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableMaquinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CAMINHO", "GRUPO", "IMPORTAR?", "IMPORTADO?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMaquinas.setColumnSelectionAllowed(true);
        jTableMaquinas.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableMaquinas);
        jTableMaquinas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 147, 575, 195));

        jDateInicial.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jDateInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 117, 120, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel2.setText("DATA INICIAL DA IMPORTAÇÃO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 121, -1, -1));
        jPanel1.add(progresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 370, 385, -1));

        lblConcluido.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        lblConcluido.setText("CONCLUÍDO");
        jPanel1.add(lblConcluido, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 350, -1, -1));

        jCheckTodos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jCheckTodos.setText("TODOS");
        jCheckTodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckTodos.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jCheckTodos.setMaximumSize(new java.awt.Dimension(65, 25));
        jCheckTodos.setMinimumSize(new java.awt.Dimension(65, 25));
        jCheckTodos.setPreferredSize(new java.awt.Dimension(65, 25));
        jCheckTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckTodosActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnImportarActionPerformed
        jBtnImportar.setText("IMPORTANDO");
        jBtnImportar.setEnabled(false);

        MaquinaDAO m = new MaquinaDAO();

        int progImportacao[] = {0};
        int erro = 0;

        maqImportadas = 0;

        for (int linha = 0; linha < jTableMaquinas.getRowCount(); linha++) {
            int id = Integer.parseInt(jTableMaquinas.getValueAt(linha, 0).toString());
            boolean importar = Boolean.valueOf(jTableMaquinas.getValueAt(linha, 4).toString());
            boolean importado = Boolean.valueOf(jTableMaquinas.getValueAt(linha, 5).toString());
            if (importado == true && importar == false) {
                erro = 1;
            } else if (importado == false && importar == true) {
                maqImportadas++;
                m.importar(id, importar);

            }

        }

        if (erro == 1) {
            JOptionPane.showMessageDialog(null, "Erro! Máquinas previamente importadas não podem ser removidas da importação !", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else if (maqImportadas > 0) {
            if (jDateInicial.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Escolha a Data Inicial para importação!");
            } else {

                progresso.setVisible(true);
                Object[] options = {"Sim", "Não"};
                int resposta = JOptionPane.showOptionDialog(null, "Deseja importar as " + maqImportadas + " máquinas selecionadas?", "Importação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (resposta == 0) {
                    lblConcluido.setVisible(false);

                    progresso.setMaximum(maqImportadas);
                    progresso.setValue(0);

                    for (Maquina i : m.listarImportar()) {
                        ImportarDados imp = new ImportarDados(i, jDateInicial.getDate(), progImportacao, progresso, this);

                        Thread t1 = new Thread(imp);

                        t1.start();

                    }
                    jBtnImportar.setEnabled(true);
                    jBtnImportar.setText("IMPORTAR");
                } else {
                    lblConcluido.setVisible(false);
                    progresso.setVisible(false);
                    jBtnImportar.setEnabled(true);
                    jBtnImportar.setText("IMPORTAR");

                }

            }
        }
    }//GEN-LAST:event_jBtnImportarActionPerformed

    private void jCheckTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckTodosActionPerformed
        MaquinaDAO m = new MaquinaDAO();
        if (jCheckTodos.isSelected()) {
            for (int linha = 0; linha < jTableMaquinas.getRowCount(); linha++) {
                jTableMaquinas.setValueAt(true, linha, 4);
                m.importar(Integer.parseInt(jTableMaquinas.getValueAt(linha, 0).toString()), true);
            }

        } else {
            for (int linha = 0; linha < jTableMaquinas.getRowCount(); linha++) {
                if (Boolean.valueOf(jTableMaquinas.getValueAt(linha, 5).toString()) == false) {
                    jTableMaquinas.setValueAt(false, linha, 4);
                    m.importar(Integer.parseInt(jTableMaquinas.getValueAt(linha, 0).toString()), false);
                }

            }
        }


    }//GEN-LAST:event_jCheckTodosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelecaoMaquinas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecaoMaquinas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecaoMaquinas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecaoMaquinas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelecaoMaquinas dialog = new SelecaoMaquinas(telaApp, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnImportar;
    private javax.swing.JCheckBox jCheckTodos;
    private com.toedter.calendar.JDateChooser jDateInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMaquinas;
    private javax.swing.JLabel lblConcluido;
    private javax.swing.JProgressBar progresso;
    // End of variables declaration//GEN-END:variables

}
