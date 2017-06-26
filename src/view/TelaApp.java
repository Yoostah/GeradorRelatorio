/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MaquinaDAO;
import model.Pesquisa;
import controller.PesquisaDAO;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import z_ux.JTableUtilities;
import view.SelecaoMaquinas.SelecaoMaquinas;
import view.framesCadastro.FrameCadastroColaborador;
import view.framesCadastro.FrameCadastroGrupo;
import view.framesCadastro.FrameCadastroMaquinas;
import view.framesRelatorio.FrameRelatorioColaborador;
import view.framesRelatorio.FrameRelatorioGeral;

/**
 *
 * @author Thulio
 */
public class TelaApp extends javax.swing.JFrame {
    
    GridBagLayout layout = new GridBagLayout();
    FrameCadastroMaquinas cadMaq;
    FrameCadastroGrupo cadGru;
    FrameCadastroColaborador cadColab;
    FrameRelatorioColaborador relColab;
    FrameRelatorioGeral relGeral;
    public static SelecaoMaquinas telaSelecaoMaq;
    /**
     * Creates new form TelaApp
     */
    public TelaApp() {
        initComponents();
        lerBanco();
        
        //Criação dos Paineis do Cadastro
        cadMaq = new FrameCadastroMaquinas();
        cadGru = new FrameCadastroGrupo();
        cadColab = new FrameCadastroColaborador();
        
        jPainelDinamicoCad.setLayout(layout);
    
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10;
        
        jPainelDinamicoCad.add(cadMaq, c);
        jPainelDinamicoCad.add(cadGru, c);
        jPainelDinamicoCad.add(cadColab,c);
        
        cadMaq.setVisible(false);
        cadGru.setVisible(false);
        cadColab.setVisible(false);
        
        //Criação dos Paineis do Relatório
        relColab = new FrameRelatorioColaborador();
        relGeral = new FrameRelatorioGeral();
        
        jPainelDinamicoRel.setLayout(layout);
        
        c.ipady = 70;
        c.ipadx = 20;
        
        jPainelDinamicoRel.add(relColab, c);
        jPainelDinamicoRel.add(relGeral, c);
        
        relColab.setVisible(false);
        relGeral.setVisible(false);
    }
    
    public void lerBanco() {
        DefaultTableModel modelo = (DefaultTableModel) jTableBD.getModel();
        JTableUtilities.setCellsAlignment(jTableBD, SwingConstants.LEFT);
        PesquisaDAO p = new PesquisaDAO();
        modelo.setNumRows(0);

        for (Pesquisa i : p.listar()) {

            modelo.addRow(new Object[]{
                i.getId(),
                i.getPesquisa(),
                i.getData(),
                i.getPergunta(),
                i.getResposta(),
                i.getId_colaborador()

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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCadastro = new javax.swing.JTable();
        jTabs = new javax.swing.JTabbedPane();
        jPanelBD = new javax.swing.JPanel();
        jPanelBtnBD = new javax.swing.JPanel();
        jBtnBDApagar = new javax.swing.JButton();
        jBtnBDLer = new javax.swing.JButton();
        jPanelTabelaBD = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBD = new javax.swing.JTable();
        jPanelRelatorio = new javax.swing.JPanel();
        jPanelBtnRel = new javax.swing.JPanel();
        jBtnRelGeral = new javax.swing.JButton();
        jBtnRelGrupo = new javax.swing.JButton();
        jPainelDinamicoRel = new javax.swing.JPanel();
        jPanelCadastro = new javax.swing.JPanel();
        jPanelBtnCad = new javax.swing.JPanel();
        jBtnCadColaborador = new javax.swing.JButton();
        jBtnCadGrupo = new javax.swing.JButton();
        jBtnCadMaq = new javax.swing.JButton();
        jPainelDinamicoCad = new javax.swing.JPanel();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jTableCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableCadastro);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(":: CORMED RELATÓRIOS ::");
        setResizable(false);

        jTabs.setBackground(new java.awt.Color(204, 204, 255));
        jTabs.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jPanelBtnBD.setBackground(new java.awt.Color(255, 204, 204));
        jPanelBtnBD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelBtnBD.setPreferredSize(new java.awt.Dimension(942, 91));

        jBtnBDApagar.setText("APAGAR");
        jBtnBDApagar.setMaximumSize(new java.awt.Dimension(67, 23));
        jBtnBDApagar.setMinimumSize(new java.awt.Dimension(67, 23));
        jBtnBDApagar.setPreferredSize(new java.awt.Dimension(67, 23));
        jBtnBDApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBDApagarActionPerformed(evt);
            }
        });

        jBtnBDLer.setText("LER");
        jBtnBDLer.setMaximumSize(new java.awt.Dimension(67, 23));
        jBtnBDLer.setMinimumSize(new java.awt.Dimension(67, 23));
        jBtnBDLer.setPreferredSize(new java.awt.Dimension(67, 23));
        jBtnBDLer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBDLerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBtnBDLayout = new javax.swing.GroupLayout(jPanelBtnBD);
        jPanelBtnBD.setLayout(jPanelBtnBDLayout);
        jPanelBtnBDLayout.setHorizontalGroup(
            jPanelBtnBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnBDLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jBtnBDLer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnBDApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBtnBDLayout.setVerticalGroup(
            jPanelBtnBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnBDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBtnBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnBDApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBDLer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableBD.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PESQUISA", "DATA", "PERGUNTA", "RESPOSTA", "COLABORADOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBD.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTableBD);
        jTableBD.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableBD.getColumnModel().getColumnCount() > 0) {
            jTableBD.getColumnModel().getColumn(0).setMinWidth(70);
            jTableBD.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTableBD.getColumnModel().getColumn(0).setMaxWidth(70);
            jTableBD.getColumnModel().getColumn(1).setMinWidth(150);
            jTableBD.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTableBD.getColumnModel().getColumn(1).setMaxWidth(150);
            jTableBD.getColumnModel().getColumn(2).setMinWidth(120);
            jTableBD.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTableBD.getColumnModel().getColumn(2).setMaxWidth(120);
            jTableBD.getColumnModel().getColumn(3).setMinWidth(80);
            jTableBD.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableBD.getColumnModel().getColumn(3).setMaxWidth(80);
            jTableBD.getColumnModel().getColumn(4).setMinWidth(80);
            jTableBD.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTableBD.getColumnModel().getColumn(4).setMaxWidth(80);
            jTableBD.getColumnModel().getColumn(5).setResizable(false);
            jTableBD.getColumnModel().getColumn(5).setPreferredWidth(350);
        }

        javax.swing.GroupLayout jPanelTabelaBDLayout = new javax.swing.GroupLayout(jPanelTabelaBD);
        jPanelTabelaBD.setLayout(jPanelTabelaBDLayout);
        jPanelTabelaBDLayout.setHorizontalGroup(
            jPanelTabelaBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        );
        jPanelTabelaBDLayout.setVerticalGroup(
            jPanelTabelaBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabelaBDLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addGap(281, 281, 281))
        );

        javax.swing.GroupLayout jPanelBDLayout = new javax.swing.GroupLayout(jPanelBD);
        jPanelBD.setLayout(jPanelBDLayout);
        jPanelBDLayout.setHorizontalGroup(
            jPanelBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBtnBD, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
            .addComponent(jPanelTabelaBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelBDLayout.setVerticalGroup(
            jPanelBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBDLayout.createSequentialGroup()
                .addComponent(jPanelBtnBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelTabelaBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabs.addTab("BANCO DE DADOS", jPanelBD);

        jPanelRelatorio.setBackground(new java.awt.Color(102, 102, 102));

        jPanelBtnRel.setBackground(new java.awt.Color(102, 102, 102));
        jPanelBtnRel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelBtnRel.setPreferredSize(new java.awt.Dimension(942, 91));

        jBtnRelGeral.setText("GERAL");
        jBtnRelGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRelGeralActionPerformed(evt);
            }
        });

        jBtnRelGrupo.setText("GRUPO");
        jBtnRelGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRelGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBtnRelLayout = new javax.swing.GroupLayout(jPanelBtnRel);
        jPanelBtnRel.setLayout(jPanelBtnRelLayout);
        jPanelBtnRelLayout.setHorizontalGroup(
            jPanelBtnRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnRelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jBtnRelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRelGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(709, Short.MAX_VALUE))
        );
        jPanelBtnRelLayout.setVerticalGroup(
            jPanelBtnRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnRelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBtnRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnRelGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPainelDinamicoRel.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPainelDinamicoRelLayout = new javax.swing.GroupLayout(jPainelDinamicoRel);
        jPainelDinamicoRel.setLayout(jPainelDinamicoRelLayout);
        jPainelDinamicoRelLayout.setHorizontalGroup(
            jPainelDinamicoRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPainelDinamicoRelLayout.setVerticalGroup(
            jPainelDinamicoRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRelatorioLayout = new javax.swing.GroupLayout(jPanelRelatorio);
        jPanelRelatorio.setLayout(jPanelRelatorioLayout);
        jPanelRelatorioLayout.setHorizontalGroup(
            jPanelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBtnRel, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
            .addComponent(jPainelDinamicoRel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelRelatorioLayout.setVerticalGroup(
            jPanelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRelatorioLayout.createSequentialGroup()
                .addComponent(jPanelBtnRel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPainelDinamicoRel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        jTabs.addTab("RELATÓRIOS", jPanelRelatorio);

        jPanelBtnCad.setBackground(new java.awt.Color(204, 204, 255));
        jPanelBtnCad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelBtnCad.setPreferredSize(new java.awt.Dimension(950, 91));

        jBtnCadColaborador.setText("COLABORADOR");
        jBtnCadColaborador.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jBtnCadColaborador.setMaximumSize(new java.awt.Dimension(67, 23));
        jBtnCadColaborador.setMinimumSize(new java.awt.Dimension(67, 23));
        jBtnCadColaborador.setPreferredSize(new java.awt.Dimension(67, 23));
        jBtnCadColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadColaboradorActionPerformed(evt);
            }
        });

        jBtnCadGrupo.setText("GRUPO");
        jBtnCadGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadGrupoActionPerformed(evt);
            }
        });

        jBtnCadMaq.setText("MÁQUINA");
        jBtnCadMaq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadMaqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBtnCadLayout = new javax.swing.GroupLayout(jPanelBtnCad);
        jPanelBtnCad.setLayout(jPanelBtnCadLayout);
        jPanelBtnCadLayout.setHorizontalGroup(
            jPanelBtnCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnCadLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jBtnCadColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnCadGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnCadMaq, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(601, Short.MAX_VALUE))
        );
        jPanelBtnCadLayout.setVerticalGroup(
            jPanelBtnCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnCadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBtnCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCadColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCadGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCadMaq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPainelDinamicoCad.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPainelDinamicoCadLayout = new javax.swing.GroupLayout(jPainelDinamicoCad);
        jPainelDinamicoCad.setLayout(jPainelDinamicoCadLayout);
        jPainelDinamicoCadLayout.setHorizontalGroup(
            jPainelDinamicoCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPainelDinamicoCadLayout.setVerticalGroup(
            jPainelDinamicoCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBtnCad, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
            .addComponent(jPainelDinamicoCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addComponent(jPanelBtnCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPainelDinamicoCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabs.addTab("CADASTRO", jPanelCadastro);

        jMenu.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jMenu1.setText("Arquivo");
        jMenu1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jMenu.add(jMenu1);

        jMenu2.setText("Sobre");
        jMenu2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jMenu.add(jMenu2);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBDApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBDApagarActionPerformed
        String message = "DESEJA REALMENTE APAGAR O BANCO DE DADOS ? ";
        String title = "CONFIRME OPERAÇÃO";
        // display the JOptionPane showConfirmDialog
        int resposta = JOptionPane.showConfirmDialog(jPanelBD, message, title, JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION)
        {
            PesquisaDAO dao = new PesquisaDAO();
            dao.truncarBD();
            MaquinaDAO m = new MaquinaDAO();
            m.resetarImportados();
        }
        lerBanco();
    }//GEN-LAST:event_jBtnBDApagarActionPerformed

    private void jBtnCadGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadGrupoActionPerformed
        cadColab.setVisible(false);
        cadMaq.setVisible(false);
        cadGru.setVisible(true);
        FrameCadastroGrupo g = new FrameCadastroGrupo();
        g.lerGrupos();
    }//GEN-LAST:event_jBtnCadGrupoActionPerformed

    private void jBtnCadMaqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadMaqActionPerformed
        cadColab.setVisible(false);
        cadGru.setVisible(false);
        cadMaq.setVisible(true);
        FrameCadastroMaquinas m = new FrameCadastroMaquinas();
        m.lerMaquinas();
    }//GEN-LAST:event_jBtnCadMaqActionPerformed

    private void jBtnCadColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadColaboradorActionPerformed
        cadGru.setVisible(false);
        cadMaq.setVisible(false);
        cadColab.setVisible(true);
        FrameCadastroColaborador f = new FrameCadastroColaborador();
        f.lerColaboradores();
    }//GEN-LAST:event_jBtnCadColaboradorActionPerformed

    private void jBtnRelGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRelGeralActionPerformed
        relColab.setVisible(false);
        relGeral.setVisible(true);
    }//GEN-LAST:event_jBtnRelGeralActionPerformed

    private void jBtnRelGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRelGrupoActionPerformed
        relGeral.setVisible(false);
        relColab.setVisible(true);
    }//GEN-LAST:event_jBtnRelGrupoActionPerformed

    private void jBtnBDLerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBDLerActionPerformed
        telaSelecaoMaq = new SelecaoMaquinas(this, true);
        telaSelecaoMaq.setVisible(true);
    }//GEN-LAST:event_jBtnBDLerActionPerformed

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
            java.util.logging.Logger.getLogger(TelaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBDApagar;
    private javax.swing.JButton jBtnBDLer;
    private javax.swing.JButton jBtnCadColaborador;
    private javax.swing.JButton jBtnCadGrupo;
    private javax.swing.JButton jBtnCadMaq;
    private javax.swing.JButton jBtnRelGeral;
    private javax.swing.JButton jBtnRelGrupo;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPainelDinamicoCad;
    private javax.swing.JPanel jPainelDinamicoRel;
    private javax.swing.JPanel jPanelBD;
    private javax.swing.JPanel jPanelBtnBD;
    private javax.swing.JPanel jPanelBtnCad;
    private javax.swing.JPanel jPanelBtnRel;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelRelatorio;
    private javax.swing.JPanel jPanelTabelaBD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBD;
    private javax.swing.JTable jTableCadastro;
    private javax.swing.JTabbedPane jTabs;
    // End of variables declaration//GEN-END:variables
}
