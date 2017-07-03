/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.framesCadastro;

import model.Grupo;
import controller.GrupoDAO;
import static java.awt.Event.DELETE;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import z_ux.JTableUtilities;

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
        JTableUtilities.centralizarHeader(jTableGrupos);
        JTableUtilities.alinharColuna(jTableGrupos, SwingConstants.CENTER, 0);
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

        jPanelBotoes = new javax.swing.JPanel();
        jBtnGruADD = new javax.swing.JButton();
        jBtnGruDEL = new javax.swing.JButton();
        jBtnGruUPD = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
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

        jPanelBotoes.setBackground(new java.awt.Color(153, 153, 153));

        jBtnGruADD.setBackground(new java.awt.Color(153, 204, 255));
        jBtnGruADD.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnGruADD.setForeground(new java.awt.Color(255, 255, 255));
        jBtnGruADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/add.png"))); // NOI18N
        jBtnGruADD.setToolTipText("Adicionar novo Grupo");
        jBtnGruADD.setBorder(null);
        jBtnGruADD.setBorderPainted(false);
        jBtnGruADD.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jBtnGruADD.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnGruADD.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnGruADD.setPreferredSize(new java.awt.Dimension(60, 60));
        jBtnGruADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGruADDActionPerformed(evt);
            }
        });
        jBtnGruADD.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnGruADD.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnGruDEL.setBackground(new java.awt.Color(255, 51, 51));
        jBtnGruDEL.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnGruDEL.setForeground(new java.awt.Color(255, 255, 255));
        jBtnGruDEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/deletar.png"))); // NOI18N
        jBtnGruDEL.setToolTipText("Deletar Grupo");
        jBtnGruDEL.setBorder(null);
        jBtnGruDEL.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnGruDEL.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnGruDEL.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnGruDEL.setPreferredSize(new java.awt.Dimension(60, 60));
        jBtnGruDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGruDELActionPerformed(evt);
            }
        });
        jBtnGruDEL.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnGruDEL.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnGruUPD.setBackground(new java.awt.Color(204, 204, 204));
        jBtnGruUPD.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnGruUPD.setForeground(new java.awt.Color(255, 255, 255));
        jBtnGruUPD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/edit.png"))); // NOI18N
        jBtnGruUPD.setToolTipText("Editar Grupo");
        jBtnGruUPD.setBorder(null);
        jBtnGruUPD.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnGruUPD.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnGruUPD.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnGruUPD.setPreferredSize(new java.awt.Dimension(60, 60));
        jBtnGruUPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGruUPDActionPerformed(evt);
            }
        });
        jBtnGruUPD.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnGruUPD.setHorizontalTextPosition(SwingConstants.CENTER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/teste2.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtnGruDEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnGruADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnGruUPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBotoesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jBtnGruADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnGruDEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnGruUPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBotoesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(jPanelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 375));

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
            jTableGrupos.getColumnModel().getColumn(0).setMinWidth(50);
            jTableGrupos.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableGrupos.getColumnModel().getColumn(0).setMaxWidth(50);
        }
        // assume JTable is named "table"
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = jTableGrupos.getInputMap(condition);
        ActionMap actionMap = jTableGrupos.getActionMap();

        // DELETE is a String constant that for me was defined as "Delete"
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), DELETE);
        actionMap.put(DELETE, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                jBtnGruDEL.doClick();
            }
        });

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 171, 574, 195));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 25)); // NOI18N
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
        jBtnADD.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/add_btn.png"))); // NOI18N
        jBtnADD.setText("SALVAR");
        jBtnADD.setBorder(null);
        jBtnADD.setIconTextGap(10);
        jBtnADD.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnADDActionPerformed(evt);
            }
        });
        jBtnADD.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnADD.setVerticalTextPosition(SwingConstants.BOTTOM);

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

    private void jBtnGruADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGruADDActionPerformed
        //Habilitar Botoões
        mostrarCampos();

        op = 1;
    }//GEN-LAST:event_jBtnGruADDActionPerformed

    private void jBtnGruDELActionPerformed(java.awt.event.ActionEvent evt) {                                           
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
    }                                          

    private void jBtnMaqUPDActionPerformed(java.awt.event.ActionEvent evt) {                                           
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
    }                                          

    private void jBtnGruUPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGruUPDActionPerformed
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
    }//GEN-LAST:event_jBtnGruUPDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnADD;
    private javax.swing.JButton jBtnGruADD;
    private javax.swing.JButton jBtnGruDEL;
    private javax.swing.JButton jBtnGruUPD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGrupos;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
