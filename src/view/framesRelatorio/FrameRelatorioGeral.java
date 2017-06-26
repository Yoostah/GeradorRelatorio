/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.framesRelatorio;

import model.Grupo;
import controller.conexao.AcessoDB;
import controller.GrupoDAO;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Thulio
 */
public class FrameRelatorioGeral extends javax.swing.JPanel {
    
        
    /**
     * Creates new form FrameCadastroGrupo
     */
    public FrameRelatorioGeral() {
        initComponents();
        
        //Colocar os Grupos Cadastrados no banco no JCBox
        GrupoDAO g = new GrupoDAO();
        
        for (Grupo i : g.listar()) {
            jCGrupo.addItem(i.getNome());
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
        jPanel2 = new javax.swing.JPanel();
        jBtnGerar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCGrupo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateInicial = new com.toedter.calendar.JDateChooser();
        jDateFinal = new com.toedter.calendar.JDateChooser();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(698, 188));
        setMinimumSize(new java.awt.Dimension(698, 188));
        setPreferredSize(new java.awt.Dimension(698, 188));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 183));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RELATÓRIO GERAL");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jBtnGerar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnGerar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnGerar.setText("GERAR");
        jBtnGerar.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel4.setText("GRUPO:");

        jCGrupo.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jCGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "( Escolha um Grupo )" }));
        jCGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCGrupoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel5.setText("DATA:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel3.setText("A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3)
                                .addGap(21, 21, 21)
                                .addComponent(jDateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jCGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jDateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGerarActionPerformed
        if (jCGrupo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Selecione um Grupo!");
        
        }else if (jDateInicial.getDate() == null || jDateFinal.getDate() == null){
            JOptionPane.showMessageDialog(this, "Preencha corretamente os campos Data Inicial e Data Final!");
        
        }else{
            Connection con = AcessoDB.getConnection();
            
            try {
                String data_inicial = new SimpleDateFormat("dd/MM/yyyy").format(jDateInicial.getDate());
                String data_final = new SimpleDateFormat("dd/MM/yyyy").format(jDateFinal.getDate());

                //Map com os parametro da query
                Map map = new HashMap();
                map.put("data_inicial",data_inicial);
                map.put("data_final",data_final);
                //map.put("grupo",jCGrupo.getSelectedItem().toString());

                //Carregando o Relatório
                InputStream jasper2 = this.getClass().getResourceAsStream("/_relatorios/Geral.jasper");

                //Passando os dados para a query e a conexao ao relatorio
                JasperPrint p = JasperFillManager.fillReport(jasper2,map, con);
                JasperViewer view = new JasperViewer(p, false);
                view.setVisible(true);
                view.toFront();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao gerar Relatório ( "+e+" )");
            }
        }
    }//GEN-LAST:event_jBtnGerarActionPerformed

    private void jCGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCGrupoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnGerar;
    private javax.swing.JComboBox<String> jCGrupo;
    private com.toedter.calendar.JDateChooser jDateFinal;
    private com.toedter.calendar.JDateChooser jDateInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
