/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.framesCadastro;

import classes.Colaborador;
import classes.Grupo;
import dao.ColaboradorDAO;
import dao.GrupoDAO;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import ux.JTableUtilities;

/**
 *
 * @author Thulio
 */
public class FrameCadastroColaborador extends javax.swing.JPanel {
    
    //Variavel para controlar se o botao ADD fara uma inclusão ou alteração
    static int op;
    
    /**
     * Creates new form FrameCadastroMaquinas2
     */
    public FrameCadastroColaborador() {
        initComponents();
        lerColaboradores();
        
        
        //Colocar os Grupos Cadastrados no banco no JCBox
        GrupoDAO g = new GrupoDAO();
        
        for (Grupo i : g.listar()) {
            jCGrupo.addItem(i.getNome());
        }
        
        //Esconder os Campos ao Iniciar Frame
        esconderCampos();
    }
    
    public void lerColaboradores() {
        DefaultTableModel modelo = (DefaultTableModel) jTableColaboradores.getModel();
        JTableUtilities.setCellsAlignment(jTableColaboradores, SwingConstants.LEFT);
        ColaboradorDAO c = new ColaboradorDAO();
        modelo.setNumRows(0);

        for (Colaborador i : c.listar()) {

            modelo.addRow(new Object[]{
                i.getId(),
                i.getNome(),
                i.getGrupo()
            });

        }

    }
    
    public void esconderCampos(){
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jTxtNome.setVisible(false);
        jTxtID.setVisible(false);
        jPanelBtnADD.setVisible(false);
        jCGrupo.setVisible(false);
        
    }

    public void mostrarCampos(){
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jTxtNome.setVisible(true);
        jTxtID.setVisible(true);
        jPanelBtnADD.setVisible(true);
        jCGrupo.setVisible(true);
        
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
        jBtnMaqADD = new javax.swing.JButton();
        jBtnMaqDEL = new javax.swing.JButton();
        jBtnMaqUPD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableColaboradores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jTxtID = new javax.swing.JTextField();
        jCGrupo = new javax.swing.JComboBox<>();
        jPanelBtnADD = new javax.swing.JPanel();
        jBtnADD = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(698, 369));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBotoes.setBackground(new java.awt.Color(153, 153, 153));

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

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtnMaqDEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnMaqADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnMaqUPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jBtnMaqADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnMaqDEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnMaqUPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        add(jPanelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 375));

        jTableColaboradores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableColaboradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "GRUPO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableColaboradores.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableColaboradores);
        if (jTableColaboradores.getColumnModel().getColumnCount() > 0) {
            jTableColaboradores.getColumnModel().getColumn(0).setMinWidth(100);
            jTableColaboradores.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableColaboradores.getColumnModel().getColumn(0).setMaxWidth(100);
            jTableColaboradores.getColumnModel().getColumn(2).setMinWidth(200);
            jTableColaboradores.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableColaboradores.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 171, 574, 195));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE COLABORADOR");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 17, 574, 36));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel2.setText("NOME:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 86, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel3.setText("ID:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 117, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel4.setText("GRUPO:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 148, -1, -1));

        jTxtNome.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        add(jTxtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 83, 290, -1));

        jTxtID.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        add(jTxtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 114, 290, -1));

        jCGrupo.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jCGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "( Escolha um Grupo )" }));
        add(jCGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 145, 289, -1));

        jPanelBtnADD.setBackground(new java.awt.Color(204, 204, 204));

        jBtnADD.setBackground(new java.awt.Color(255, 255, 255));
        jBtnADD.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnADD.setText("ADD");
        jBtnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnADDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBtnADDLayout = new javax.swing.GroupLayout(jPanelBtnADD);
        jPanelBtnADD.setLayout(jPanelBtnADDLayout);
        jPanelBtnADDLayout.setHorizontalGroup(
            jPanelBtnADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnADDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnADD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBtnADDLayout.setVerticalGroup(
            jPanelBtnADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnADDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnADD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanelBtnADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 66, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnMaqADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaqADDActionPerformed
        //Habilitar Botoões
        mostrarCampos();
        
        op = 1;
    }//GEN-LAST:event_jBtnMaqADDActionPerformed

    private void jBtnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnADDActionPerformed
        ColaboradorDAO cdao = new ColaboradorDAO();
        Colaborador c = new Colaborador();
        if (jTxtNome.getText().isEmpty() || jTxtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencher todos os Campos!");
        }else if (jCGrupo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Escolha um Grupo!");
        }else{
            if (op == 1){
                c.setNome(jTxtNome.getText());
                c.setId(Integer.parseInt(jTxtID.getText()));
                c.setGrupo(jCGrupo.getSelectedItem().toString());
                cdao.create(c);
                lerColaboradores();

                jTxtNome.setText("");
                jTxtID.setText("");
                jCGrupo.setSelectedIndex(0);

            } else {
                //Pega ID do item Selecionado na tabela
                int selecionado = (Integer.parseInt(jTableColaboradores.getValueAt(jTableColaboradores.getSelectedRow(), 0).toString()));

                c.setNome(jTxtNome.getText().toUpperCase());
                c.setId(Integer.parseInt(jTxtID.getText()));
                c.setGrupo(jCGrupo.getSelectedItem().toString());
                cdao.atualizar(c, selecionado);
                lerColaboradores();

                jTxtNome.setText("");
                jTxtID.setText("");
                jCGrupo.setSelectedIndex(0);

                esconderCampos();

                //Habilitar seleção de linhas novamente
                jTableColaboradores.setEnabled(true);
            }    
        }
    }//GEN-LAST:event_jBtnADDActionPerformed

    private void jBtnMaqDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaqDELActionPerformed
        ColaboradorDAO cdao = new ColaboradorDAO();
        
        if (jTableColaboradores.getSelectedRow() != -1) {
            //DELETAR OS DADOS
            
            int selecionado = (Integer.parseInt(jTableColaboradores.getValueAt(jTableColaboradores.getSelectedRow(), 0).toString()));

            //CHAMAR O OBJETO QUE MANIPULA O BANCO DE DADOS
            cdao.deletar(selecionado);
            lerColaboradores();

        }else {
            JOptionPane.showMessageDialog(null, "Escolha um Colaborador para deletar!");
            
        }
    }//GEN-LAST:event_jBtnMaqDELActionPerformed

    private void jBtnMaqUPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaqUPDActionPerformed
        //LER OS DADOS DA LINHA SELECIOANDA
        if (jTableColaboradores.getSelectedRow() != -1) {
            //Travar a seleção de outra linha da tabela antes da alteração ser enviada
            jTableColaboradores.setEnabled(false);
            //Mostrar campos ocultos
            mostrarCampos();
            
            jTxtNome.setText(jTableColaboradores.getValueAt(jTableColaboradores.getSelectedRow(), 1).toString());
            jTxtID.setText(jTableColaboradores.getValueAt(jTableColaboradores.getSelectedRow(), 0).toString());
            jCGrupo.setSelectedItem(jTableColaboradores.getValueAt(jTableColaboradores.getSelectedRow(), 2).toString());
            
            op = 2;
        
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um Colaborador para alterar!");
            
        }
    }//GEN-LAST:event_jBtnMaqUPDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnADD;
    private javax.swing.JButton jBtnMaqADD;
    private javax.swing.JButton jBtnMaqDEL;
    private javax.swing.JButton jBtnMaqUPD;
    private javax.swing.JComboBox<String> jCGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelBtnADD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableColaboradores;
    private javax.swing.JTextField jTxtID;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
