/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Banco;

import classes.Maquina;
import classes.Pesquisa;
import dao.MaquinaDAO;
import dao.PesquisaDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TelaApp;

/**
 *
 * @author Thulio
 */
public class SelecaoMaquinas extends javax.swing.JFrame {

    /**
     * Creates new form SelecaoMaquinas
     */
    public SelecaoMaquinas() {
        initComponents();
        lerMaquinas();
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
                i.isImportar()
            });

        }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaquinas = new javax.swing.JTable();
        jBtnImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELECIONE AS MÁQUINAS PARA IMPORTAR");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jTableMaquinas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableMaquinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CAMINHO", "GRUPO", "IMPORTAR?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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

        jBtnImportar.setText("IMPORTAR");
        jBtnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnImportar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jBtnImportar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnImportarActionPerformed
        //DefaultTableModel modelo = (DefaultTableModel) jTableMaquinas.getModel();
        MaquinaDAO m = new MaquinaDAO();
        
        for (int linha = 0; linha < jTableMaquinas.getRowCount(); linha++){
            int id = Integer.parseInt(jTableMaquinas.getValueAt(linha, 0).toString());
            boolean importar = Boolean.valueOf(jTableMaquinas.getValueAt(linha, 4).toString());
            m.importar(id, importar);
        }
        JOptionPane.showMessageDialog(null, "Máquinas selecionadas.");
        
        for (Maquina i : m.listar()){
            if (i.isImportar()){
                //File arquivos[];
                //Caminho onde estarao os arquivos resposta.txt estarão centralizados
                //File diretorio = new File("C:\\Users\\Thulio\\Desktop\\Relatórios\\arq_test\\CORMED_05.04.16");
                //Arquivos[] é preenchida com a lista de diretorios encontrados no diretorio informado
                //arquivos = diretorio.listFiles();

                //System.out.println("### Arquivos encontrados no diretório ###");
                //Percorre o arquivo imprimindo os arquivos encontrados
                //for (int i = 0; i < arquivos.length; i++) {
                   // System.out.println("arq.tostring "+arquivos[i].toString());

                    String dir = i.getCaminho();
                    File file = new File(dir);
                    for (String arq : file.list()) {
                        if (arq.endsWith(".txt")) {
                            System.out.println("------>" + arq + "<------");
                            try {
                                System.out.println("Importando dados de ("+dir+ "\\" + arq+")");
                                leitura(dir + "\\" + arq);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Não foi possível importar os dados da máquina "+i.getNome());
                            }
                        }
                    }
                //}
            }
        }
        
        
    }//GEN-LAST:event_jBtnImportarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        TelaApp n = new TelaApp();
        n.lerBanco();
        System.out.println("oloco bicho");
    }//GEN-LAST:event_formWindowClosing

    private static void leitura(String dir) throws Exception {
        String linha = "", conteudo = "";
        BufferedReader br = new BufferedReader(new FileReader(new File(dir)));
        PesquisaDAO banco = new PesquisaDAO();
        while ((linha = br.readLine()) != null) {
            if (!linha.isEmpty()) {
                //Divisão da linha da pesquisa por parametros
                String[] dados = linha.split(";");
                
                //Formatação da data
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                //" If you have a pattern and create a date object that strictly matches your pattern, set lenient to false"
                sdf.setLenient(false);
                Date data = sdf.parse(dados[2]+" "+dados[3]);
                //System.out.println(data);

                //Criação do objeto para guardar os dados no BD (String pesquisa, Date data, int pergunta, int resposta, int colaborador)
                Pesquisa p = new Pesquisa(dados[1], data, Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6].trim()));
                if (p.getData().getYear() > 115){
                    
                    banco.create(p);
                    
                }
                
            }
        }
        br.close();
    }
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
            java.util.logging.Logger.getLogger(SelecaoMaquinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecaoMaquinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecaoMaquinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecaoMaquinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecaoMaquinas().setVisible(true);
           
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnImportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMaquinas;
    // End of variables declaration//GEN-END:variables
}
