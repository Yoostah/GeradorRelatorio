/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.framesCadastro;

import model.Grupo;
import model.Maquina;
import controller.GrupoDAO;
import controller.MaquinaDAO;
import static java.awt.Event.DELETE;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import z_ux.JTableUtilities;

/**
 *
 * @author Thulio
 */
public class FrameCadastroMaquinas extends javax.swing.JPanel {

    //Variavel para controlar se o botao ADD fara uma inclusão ou alteração
    static int op;

    /**
     * Creates new form FrameCadastroMaquinas2
     */
    public FrameCadastroMaquinas() {
        initComponents();
        lerMaquinas();

        //Colocar os Grupos Cadastrados no banco no JCBox
        GrupoDAO g = new GrupoDAO();

        for (Grupo i : g.listar()) {
            jCGrupo.addItem(i.getNome());
        }

        //Esconder os Campos ao Iniciar Frame
        esconderCampos();
    }

    public void lerMaquinas() {
        DefaultTableModel modelo = (DefaultTableModel) jTableMaquinas.getModel();
        JTableUtilities.alinharColuna(jTableMaquinas, SwingConstants.CENTER, 0);
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

    public void esconderCampos() {
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jTxtNome.setVisible(false);
        jTxtCaminho.setVisible(false);
        jPanelBtnADD.setVisible(false);
        jCGrupo.setVisible(false);
        jBtnCaminho.setVisible(false);

    }

    public void mostrarCampos() {
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jTxtNome.setVisible(true);
        jTxtCaminho.setVisible(true);
        jPanelBtnADD.setVisible(true);
        jCGrupo.setVisible(true);
        jBtnCaminho.setVisible(true);

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
        jLabel5 = new javax.swing.JLabel();
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
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jTxtCaminho = new javax.swing.JTextField();
        jBtnCaminho = new javax.swing.JButton();
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
        jBtnMaqADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/add.png"))); // NOI18N
        jBtnMaqADD.setToolTipText("Adicionar nova Máquina");
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
        jBtnMaqADD.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnMaqADD.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnMaqDEL.setBackground(new java.awt.Color(255, 51, 51));
        jBtnMaqDEL.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnMaqDEL.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMaqDEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/deletar.png"))); // NOI18N
        jBtnMaqDEL.setToolTipText("Deletar Máquina");
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
        jBtnMaqDEL.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnMaqDEL.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnMaqUPD.setBackground(new java.awt.Color(204, 204, 204));
        jBtnMaqUPD.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnMaqUPD.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMaqUPD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/edit.png"))); // NOI18N
        jBtnMaqUPD.setToolTipText("Editar Máquina");
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
        jBtnMaqUPD.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnMaqUPD.setHorizontalTextPosition(SwingConstants.CENTER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/teste2.png"))); // NOI18N

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
                .addComponent(jBtnMaqADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnMaqDEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jBtnMaqUPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBotoesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(jPanelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 375));

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
                false, false, false, false, false
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
        jTableMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableMaquinasMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMaquinas);
        jTableMaquinas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableMaquinas.getColumnModel().getColumnCount() > 0) {
            jTableMaquinas.getColumnModel().getColumn(0).setMinWidth(50);
            jTableMaquinas.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableMaquinas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableMaquinas.getColumnModel().getColumn(1).setMinWidth(120);
            jTableMaquinas.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTableMaquinas.getColumnModel().getColumn(1).setMaxWidth(120);
            jTableMaquinas.getColumnModel().getColumn(3).setMinWidth(100);
            jTableMaquinas.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableMaquinas.getColumnModel().getColumn(3).setMaxWidth(100);
            jTableMaquinas.getColumnModel().getColumn(4).setMinWidth(75);
            jTableMaquinas.getColumnModel().getColumn(4).setPreferredWidth(75);
            jTableMaquinas.getColumnModel().getColumn(4).setMaxWidth(75);
        }
        // assume JTable is named "table"
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = jTableMaquinas.getInputMap(condition);
        ActionMap actionMap = jTableMaquinas.getActionMap();

        // DELETE is a String constant that for me was defined as "Delete"
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), DELETE);
        actionMap.put(DELETE, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                jBtnMaqDEL.doClick();
            }
        });

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 171, 574, 195));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 25)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE MÁQUINAS");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 17, 574, 36));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel2.setText("NOME:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 86, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel3.setText("CAMINHO:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 117, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel4.setText("GRUPO:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 148, -1, -1));

        jTxtNome.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        add(jTxtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 83, 290, -1));

        jTxtCaminho.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        add(jTxtCaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 114, 290, -1));

        jBtnCaminho.setText("...");
        jBtnCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCaminhoActionPerformed(evt);
            }
        });
        add(jBtnCaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 114, 20, 20));

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

    private void jBtnMaqADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaqADDActionPerformed
        //Habilitar Botoões
        mostrarCampos();

        op = 1;
    }//GEN-LAST:event_jBtnMaqADDActionPerformed

    private void jBtnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnADDActionPerformed
        MaquinaDAO mdao = new MaquinaDAO();
        Maquina m = new Maquina();
        if (jTxtNome.getText().isEmpty() || jTxtCaminho.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencher todos os Campos!");
        } else if (jCGrupo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Escolha um Grupo!");
        } else {
            if (op == 1) {
                m.setNome(jTxtNome.getText().toUpperCase());
                m.setCaminho(jTxtCaminho.getText());
                m.setGrupo(jCGrupo.getSelectedItem().toString());
                mdao.create(m);
                lerMaquinas();

                jTxtNome.setText("");
                jTxtCaminho.setText("");
                jCGrupo.setSelectedIndex(0);

            } else {
                //Pega ID do item Selecionado na tabela
                int selecionado = (Integer.parseInt(jTableMaquinas.getValueAt(jTableMaquinas.getSelectedRow(), 0).toString()));

                m.setNome(jTxtNome.getText().toUpperCase());
                m.setCaminho(jTxtCaminho.getText());
                m.setGrupo(jCGrupo.getSelectedItem().toString());
                mdao.atualizar(m, selecionado);
                lerMaquinas();

                jTxtNome.setText("");
                jTxtCaminho.setText("");
                jCGrupo.setSelectedIndex(0);

                esconderCampos();

                //Habilitar seleção de linhas novamente
                jTableMaquinas.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jBtnADDActionPerformed

    private void jBtnMaqDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaqDELActionPerformed
        MaquinaDAO mdao = new MaquinaDAO();

        if (jTableMaquinas.getSelectedRow() != -1) {
            //DELETAR OS DADOS

            int selecionado = (Integer.parseInt(jTableMaquinas.getValueAt(jTableMaquinas.getSelectedRow(), 0).toString()));

            //CHAMAR O OBJETO QUE MANIPULA O BANCO DE DADOS
            mdao.deletar(selecionado);
            lerMaquinas();

        } else {
            JOptionPane.showMessageDialog(null, "Escolha uma Máquina para deletar!");

        }
    }//GEN-LAST:event_jBtnMaqDELActionPerformed

    private void jBtnMaqUPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMaqUPDActionPerformed
        //LER OS DADOS DA LINHA SELECIOANDA
        if (jTableMaquinas.getSelectedRow() != -1) {
            //Travar a seleção de outra linha da tabela antes da alteração ser enviada
            jTableMaquinas.setEnabled(false);
            //Mostrar campos ocultos
            mostrarCampos();

            jTxtNome.setText(jTableMaquinas.getValueAt(jTableMaquinas.getSelectedRow(), 1).toString());
            jTxtCaminho.setText(jTableMaquinas.getValueAt(jTableMaquinas.getSelectedRow(), 2).toString());
            jCGrupo.setSelectedItem(jTableMaquinas.getValueAt(jTableMaquinas.getSelectedRow(), 3).toString());

            //TODO Fazer a leitura do campo boolean
            op = 2;

        } else {
            JOptionPane.showMessageDialog(null, "Escolha uma Máquina para alterar!");

        }
    }//GEN-LAST:event_jBtnMaqUPDActionPerformed

    private void jBtnCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCaminhoActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(FrameCadastroMaquinas.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            jTxtCaminho.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_jBtnCaminhoActionPerformed

    private void jTableMaquinasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMaquinasMouseEntered
        //DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        //String pathValue = jTableMaquinas.getValueAt(jTableMaquinasMouseEntered(evt), 2);
        //renderer.setToolTipText("Click for combo box");
        //jTableMaquinas.getColumnModel().getColumn(2).setCellRenderer(renderer);
    }//GEN-LAST:event_jTableMaquinasMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnADD;
    private javax.swing.JButton jBtnCaminho;
    private javax.swing.JButton jBtnMaqADD;
    private javax.swing.JButton jBtnMaqDEL;
    private javax.swing.JButton jBtnMaqUPD;
    private javax.swing.JComboBox<String> jCGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelBtnADD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMaquinas;
    private javax.swing.JTextField jTxtCaminho;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
