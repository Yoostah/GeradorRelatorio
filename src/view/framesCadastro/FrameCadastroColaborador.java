/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.framesCadastro;

import model.Colaborador;
import model.Grupo;
import controller.ColaboradorDAO;
import controller.GrupoDAO;
import java.awt.BorderLayout;
import static java.awt.Event.DELETE;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import z_ux.JTableUtilities;

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
        JTableUtilities.alinharColuna(jTableColaboradores, SwingConstants.CENTER, 0);
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
        jBtnColabADD = new javax.swing.JButton();
        jBtnColabDEL = new javax.swing.JButton();
        jBtnColabUPD = new javax.swing.JButton();
        textura = new javax.swing.JLabel();
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
        setMinimumSize(new java.awt.Dimension(698, 377));
        setPreferredSize(new java.awt.Dimension(698, 369));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBotoes.setBackground(new java.awt.Color(153, 153, 153));

        jBtnColabADD.setBackground(new java.awt.Color(153, 204, 255));
        jBtnColabADD.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnColabADD.setForeground(new java.awt.Color(255, 255, 255));
        jBtnColabADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/add.png"))); // NOI18N
        jBtnColabADD.setToolTipText("Adicionar novo Colaborador");
        jBtnColabADD.setBorder(null);
        jBtnColabADD.setBorderPainted(false);
        jBtnColabADD.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jBtnColabADD.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnColabADD.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnColabADD.setPreferredSize(new java.awt.Dimension(60, 60));
        jBtnColabADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnColabADDActionPerformed(evt);
            }
        });
        jBtnColabADD.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnColabADD.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnColabDEL.setBackground(new java.awt.Color(255, 51, 51));
        jBtnColabDEL.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnColabDEL.setForeground(new java.awt.Color(255, 255, 255));
        jBtnColabDEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/deletar.png"))); // NOI18N
        jBtnColabDEL.setToolTipText("Deletar Colaborador");
        jBtnColabDEL.setBorder(null);
        jBtnColabDEL.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnColabDEL.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnColabDEL.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnColabDEL.setPreferredSize(new java.awt.Dimension(60, 60));
        jBtnColabDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnColabDELActionPerformed(evt);
            }
        });
        jBtnColabDEL.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnColabDEL.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnColabUPD.setBackground(new java.awt.Color(204, 204, 204));
        jBtnColabUPD.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnColabUPD.setForeground(new java.awt.Color(255, 255, 255));
        jBtnColabUPD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/edit.png"))); // NOI18N
        jBtnColabUPD.setToolTipText("Editar Colaborador");
        jBtnColabUPD.setBorder(null);
        jBtnColabUPD.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnColabUPD.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnColabUPD.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnColabUPD.setPreferredSize(new java.awt.Dimension(60, 60));
        jBtnColabUPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnColabUPDActionPerformed(evt);
            }
        });
        jBtnColabUPD.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnColabUPD.setHorizontalTextPosition(SwingConstants.CENTER);

        textura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/teste2.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtnColabDEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnColabADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnColabUPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBotoesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(textura)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jBtnColabADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnColabDEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnColabUPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBotoesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(textura)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
            jTableColaboradores.getColumnModel().getColumn(0).setMinWidth(50);
            jTableColaboradores.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableColaboradores.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableColaboradores.getColumnModel().getColumn(2).setMinWidth(200);
            jTableColaboradores.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableColaboradores.getColumnModel().getColumn(2).setMaxWidth(200);
        }
        // assume JTable is named "table"
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = jTableColaboradores.getInputMap(condition);
        ActionMap actionMap = jTableColaboradores.getActionMap();

        // DELETE is a String constant that for me was defined as "Delete"
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), DELETE);
        actionMap.put(DELETE, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                jBtnColabDEL.doClick();
            }
        });

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 171, 574, 195));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 25)); // NOI18N
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

    private void jBtnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnADDActionPerformed
        ColaboradorDAO cdao = new ColaboradorDAO();
        Colaborador c = new Colaborador();
        if (jTxtNome.getText().isEmpty() || jTxtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencher todos os Campos!");
        }else if (jCGrupo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Escolha um Grupo!");
        }else{
            if (op == 1){
                c.setNome(jTxtNome.getText().toUpperCase());
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

    private void jBtnColabADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnColabADDActionPerformed
        //Habilitar Botoões
        mostrarCampos();

        op = 1;
    }//GEN-LAST:event_jBtnColabADDActionPerformed

    private void jBtnColabDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnColabDELActionPerformed
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
    }//GEN-LAST:event_jBtnColabDELActionPerformed

    private void jBtnColabUPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnColabUPDActionPerformed
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
    }//GEN-LAST:event_jBtnColabUPDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnADD;
    private javax.swing.JButton jBtnColabADD;
    private javax.swing.JButton jBtnColabDEL;
    private javax.swing.JButton jBtnColabUPD;
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
    private javax.swing.JLabel textura;
    // End of variables declaration//GEN-END:variables
}
