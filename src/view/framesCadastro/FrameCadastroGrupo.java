/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.framesCadastro;

import classes.Grupo;
import dao.GrupoDAO;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import ux.JTableUtilities;

/**
 *
 * @author Thulio
 */
public class FrameCadastroGrupo extends javax.swing.JPanel {
    
    //Variavel para controlar se o botao ADD fara uma inclusão ou alteração
    static int op;
    
    /**
     * Creates new form FrameCadastroGrupo
     */
    public FrameCadastroGrupo() {
        initComponents();
        lerGrupos();
        
        //Esconder os Campos ao Iniciar Frame
        esconderCampos();
    }

    public void lerGrupos() {
        DefaultTableModel modelo = (DefaultTableModel) jTableGrupos.getModel();
        JTableUtilities.setCellsAlignment(jTableGrupos, SwingConstants.LEFT);
        GrupoDAO g = new GrupoDAO();
        modelo.setNumRows(0);

        for (Grupo i : g.listar()) {

            modelo.addRow(new Object[]{
                i.getId(),
                i.getNome()
            });
        }
    }
    
    public void esconderCampos(){
        jLabel2.setVisible(false);
        jTxtNome.setVisible(false);
        jPanel2.setVisible(false);
    }
    
    public void mostrarCampos(){
        jLabel2.setVisible(true);
        jTxtNome.setVisible(true);
        jPanel2.setVisible(true);
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
        jBtnMaqADD = new javax.swing.JButton();
        jBtnMaqDEL = new javax.swing.JButton();
        jBtnMaqUPD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGrupos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jBtnADD = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(698, 369));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jBtnMaqADD.setBackground(new java.awt.Color(153, 204, 255));
        jBtnMaqADD.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnMaqADD.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMaqADD.setText("Adicionar");
        jBtnMaqADD.setBorder(null);
        jBtnMaqADD.setBorderPainted(false);
        jBtnMaqADD.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jBtnMaqADD.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnMaqADD.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnMaqADD.setPreferredSize(new java.awt.Dimension(60, 60));
        jBtnMaqADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMaqADDActionPerformed(evt);
            }
        });

        jBtnMaqDEL.setBackground(new java.awt.Color(255, 51, 51));
        jBtnMaqDEL.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnMaqDEL.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMaqDEL.setText("Deletar");
        jBtnMaqDEL.setBorder(null);
        jBtnMaqDEL.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnMaqDEL.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnMaqDEL.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnMaqDEL.setPreferredSize(new java.awt.Dimension(60, 60));
        jBtnMaqDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMaqDELActionPerformed(evt);
            }
        });

        jBtnMaqUPD.setBackground(new java.awt.Color(0, 0, 0));
        jBtnMaqUPD.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnMaqUPD.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMaqUPD.setText("Alterar");
        jBtnMaqUPD.setBorder(null);
        jBtnMaqUPD.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnMaqUPD.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnMaqUPD.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnMaqUPD.setPreferredSize(new java.awt.Dimension(60, 60));
        jBtnMaqUPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMaqUPDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtnMaqDEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnMaqADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnMaqUPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jBtnMaqADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnMaqDEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnMaqUPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 375));

        jTableGrupos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableGrupos.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableGrupos);
        if (jTableGrupos.getColumnModel().getColumnCount() > 0) {
            jTableGrupos.getColumnModel().getColumn(0).setMinWidth(100);
            jTableGrupos.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableGrupos.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 171, 574, 195));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE GRUPO");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 17, 574, 36));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel2.setText("NOME:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 86, -1, -1));

        jTxtNome.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        add(jTxtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 83, 290, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jBtnADD.setBackground(new java.awt.Color(255, 255, 255));
        jBtnADD.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnADD.setText("ADD");
        jBtnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnADDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnADD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnADD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 66, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnMaqADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaqADDActionPerformed
        mostrarCampos();
        op = 1;
    }//GEN-LAST:event_jBtnMaqADDActionPerformed

    private void jBtnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnADDActionPerformed
        GrupoDAO gdao = new GrupoDAO();
        Grupo g = new Grupo();
        if (jTxtNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencher todos os Campos!");
        }else{
            if (op == 1){
                g.setNome(jTxtNome.getText().toUpperCase());
                gdao.create(g);
                lerGrupos();

                jTxtNome.setText("");

            } else {
                //Pega ID do item Selecionado na tabela
                int selecionado = (Integer.parseInt(jTableGrupos.getValueAt(jTableGrupos.getSelectedRow(), 0).toString()));

                g.setNome(jTxtNome.getText().toUpperCase());
                gdao.atualizar(g, selecionado);
                lerGrupos();

                jTxtNome.setText("");

                esconderCampos();

                //Habilitar seleção de linhas novamente
                jTableGrupos.setEnabled(true);
            }   
        }
    }//GEN-LAST:event_jBtnADDActionPerformed

    private void jBtnMaqDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaqDELActionPerformed
        GrupoDAO gdao = new GrupoDAO();
        
        if (jTableGrupos.getSelectedRow() != -1) {
            //DELETAR OS DADOS
            
            int selecionado = (Integer.parseInt(jTableGrupos.getValueAt(jTableGrupos.getSelectedRow(), 0).toString()));

            //CHAMAR O OBJETO QUE MANIPULA O BANCO DE DADOS
            gdao.deletar(selecionado);
            lerGrupos();

        }else {
            JOptionPane.showMessageDialog(null, "Escolha um Grupo para deletar!");
        }
    }//GEN-LAST:event_jBtnMaqDELActionPerformed

    private void jBtnMaqUPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaqUPDActionPerformed
        //LER OS DADOS DA LINHA SELECIOANDA
        if (jTableGrupos.getSelectedRow() != -1) {
            //Travar a seleção de outra linha da tabela antes da alteração ser enviada
            jTableGrupos.setEnabled(false);
            //Mostrar campos ocultos
            mostrarCampos();
            
            jTxtNome.setText(jTableGrupos.getValueAt(jTableGrupos.getSelectedRow(), 1).toString());
            
            op = 2;
        
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um Grupo para alterar!");
        }
    }//GEN-LAST:event_jBtnMaqUPDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnADD;
    private javax.swing.JButton jBtnMaqADD;
    private javax.swing.JButton jBtnMaqDEL;
    private javax.swing.JButton jBtnMaqUPD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGrupos;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
