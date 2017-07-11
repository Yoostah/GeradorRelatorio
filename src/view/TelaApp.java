/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ColaboradorDAO;
import view.SelecaoMaquinas.SelecaoMaquinas;
import controller.MaquinaDAO;
import model.Pesquisa;
import controller.PesquisaDAO;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Colaborador;
import z_ux.JTableUtilities;
import view.framesCadastro.FrameCadastroColaborador;
import view.framesCadastro.FrameCadastroGrupo;
import view.framesCadastro.FrameCadastroMaquinas;
import view.framesRelatorio.FrameRelatorioColaborador;
import view.framesRelatorio.FrameRelatorioGeral;
import view.menu.Sobre;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import view.framesCadastro.FrameCadastroPergunta;
import view.framesRelatorio.FrameRelatorioGeralColab;
import view.framesRelatorio.FrameRelatorioPerguntasGrupo;
import view.framesRelatorio.FrameRelatorioRespostasGrupo;
import view.menu.Configuracoes;

/**
 *
 * @author Thulio
 */
public class TelaApp extends javax.swing.JFrame {

    GridBagLayout layout = new GridBagLayout();
    FrameCadastroMaquinas cadMaq;
    FrameCadastroGrupo cadGru;
    FrameCadastroColaborador cadColab;
    FrameCadastroPergunta cadPerg;
    FrameRelatorioColaborador relColab;
    FrameRelatorioGeral relGeral;
    FrameRelatorioGeralColab relGeralColab;
    FrameRelatorioRespostasGrupo relRespGrupo;
    FrameRelatorioPerguntasGrupo relPergGrupo;
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
        cadPerg = new FrameCadastroPergunta();

        jPainelDinamicoCad.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10;

        jPainelDinamicoCad.add(cadMaq, c);
        jPainelDinamicoCad.add(cadGru, c);
        jPainelDinamicoCad.add(cadColab, c);
        jPainelDinamicoCad.add(cadPerg, c);

        cadMaq.setVisible(false);
        cadGru.setVisible(false);
        cadColab.setVisible(false);
        cadPerg.setVisible(false);

        //Criação dos Paineis do Relatório
        relColab = new FrameRelatorioColaborador();
        relGeral = new FrameRelatorioGeral();
        relGeralColab = new FrameRelatorioGeralColab();
        relRespGrupo = new FrameRelatorioRespostasGrupo();
        relPergGrupo = new FrameRelatorioPerguntasGrupo();

        jPainelDinamicoRel.setLayout(layout);

        c.ipady = 0;
        c.ipadx = 0;

        jPainelDinamicoRel.add(relColab, c);
        jPainelDinamicoRel.add(relGeral, c);
        jPainelDinamicoRel.add(relGeralColab, c);
        jPainelDinamicoRel.add(relRespGrupo, c);
        jPainelDinamicoRel.add(relPergGrupo, c);

        relColab.setVisible(false);
        relGeral.setVisible(false);
        relGeralColab.setVisible(false);
        relRespGrupo.setVisible(false);
        relPergGrupo.setVisible(false);

    }

    public void lerBanco() {
        DefaultTableModel modelo = (DefaultTableModel) jTableBD.getModel();
        JTableUtilities.alinharColuna(jTableBD, SwingConstants.LEFT, 0);
        JTableUtilities.alinharColuna(jTableBD, SwingConstants.CENTER, 1);
        JTableUtilities.alinharColuna(jTableBD, SwingConstants.CENTER, 2);
        JTableUtilities.alinharColuna(jTableBD, SwingConstants.CENTER, 3);
        JTableUtilities.alinharColuna(jTableBD, SwingConstants.CENTER, 4);
        JTableUtilities.alinharColuna(jTableBD, SwingConstants.CENTER, 5);
        JTableUtilities.alinharColuna(jTableBD, SwingConstants.CENTER, 7);
        JTableUtilities.centralizarHeader(jTableBD);

        PesquisaDAO p = new PesquisaDAO();
        modelo.setNumRows(0);

        for (Pesquisa i : p.listar()) {

            modelo.addRow(new Object[]{
                i.getId(),
                i.getPesquisa(),
                i.getData(),
                i.getPergunta(),
                i.getResposta(),
                i.getId_colaborador(),
                i.getGrupo(),
                i.getMaquina()
            });

        }
        
    }

    
    public void classificarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTableBD.getModel();
        jTableBD.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);
        lerBanco();
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
        logoFSFX = new javax.swing.JLabel();
        logoHMC = new javax.swing.JLabel();
        jPanelTabelaBD = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBD = new javax.swing.JTable();
        jCheckBoxClassificadores = new javax.swing.JCheckBox();
        jPanelRelatorio = new javax.swing.JPanel();
        jPanelBtnRel = new javax.swing.JPanel();
        jBtnRelGeral = new javax.swing.JButton();
        jBtnRelGrupo = new javax.swing.JButton();
        logoHMC1 = new javax.swing.JLabel();
        logoFSFX1 = new javax.swing.JLabel();
        jBtnRelPergunta = new javax.swing.JButton();
        jBtnRelGeralColab = new javax.swing.JButton();
        jBtnRelResposta = new javax.swing.JButton();
        jPainelDinamicoRel = new javax.swing.JPanel();
        jPanelCadastro = new javax.swing.JPanel();
        jPanelBtnCad = new javax.swing.JPanel();
        jBtnCadColaborador = new javax.swing.JButton();
        jBtnCadMaq = new javax.swing.JButton();
        jBtnCadGrupo = new javax.swing.JButton();
        logoHMC2 = new javax.swing.JLabel();
        logoFSFX2 = new javax.swing.JLabel();
        jBtnCadPerg = new javax.swing.JButton();
        jPainelDinamicoCad = new javax.swing.JPanel();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemConfigBD = new javax.swing.JMenuItem();
        jMenuItemConfigUsuarios = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSobreSobre = new javax.swing.JMenuItem();

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
        setTitle("::   SISTEMA DE CONTROLE DE SATISFAÇÃO - CORMED / WINNER   ::");
        setAutoRequestFocus(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabs.setBackground(new java.awt.Color(204, 204, 255));
        jTabs.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTabs.setPreferredSize(new java.awt.Dimension(950, 636));

        jPanelBD.setBackground(new java.awt.Color(102, 102, 102));

        jPanelBtnBD.setBackground(new java.awt.Color(153, 153, 153));
        jPanelBtnBD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelBtnBD.setPreferredSize(new java.awt.Dimension(942, 91));

        jBtnBDApagar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnBDApagar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnBDApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/deletar_bd.png"))); // NOI18N
        jBtnBDApagar.setText("APAGAR");
        jBtnBDApagar.setToolTipText("Apagar registros importados");
        jBtnBDApagar.setMaximumSize(new java.awt.Dimension(67, 23));
        jBtnBDApagar.setMinimumSize(new java.awt.Dimension(67, 23));
        jBtnBDApagar.setPreferredSize(new java.awt.Dimension(67, 23));
        jBtnBDApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBDApagarActionPerformed(evt);
            }
        });
        jBtnBDApagar.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnBDApagar.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnBDLer.setBackground(new java.awt.Color(255, 255, 255));
        jBtnBDLer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnBDLer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/ler.png"))); // NOI18N
        jBtnBDLer.setText("LER");
        jBtnBDLer.setToolTipText("Ler máquinas cadastradas");
        jBtnBDLer.setMaximumSize(new java.awt.Dimension(67, 23));
        jBtnBDLer.setMinimumSize(new java.awt.Dimension(67, 23));
        jBtnBDLer.setPreferredSize(new java.awt.Dimension(67, 23));
        jBtnBDLer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBDLerActionPerformed(evt);
            }
        });
        jBtnBDLer.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnBDLer.setHorizontalTextPosition(SwingConstants.CENTER);

        logoFSFX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/fsfx.png"))); // NOI18N

        logoHMC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/logo-hmc.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBtnBDLayout = new javax.swing.GroupLayout(jPanelBtnBD);
        jPanelBtnBD.setLayout(jPanelBtnBDLayout);
        jPanelBtnBDLayout.setHorizontalGroup(
            jPanelBtnBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnBDLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jBtnBDLer, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnBDApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBtnBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoHMC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoFSFX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelBtnBDLayout.setVerticalGroup(
            jPanelBtnBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnBDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBtnBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBtnBDLayout.createSequentialGroup()
                        .addComponent(logoFSFX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoHMC))
                    .addGroup(jPanelBtnBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnBDApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnBDLer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTabelaBD.setBackground(new java.awt.Color(102, 102, 102));

        jTableBD.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PESQUISA", "DATA", "PERGUNTA", "RESPOSTA", "COLABORADOR", "GRUPO", "MAQUINA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            jTableBD.getColumnModel().getColumn(0).setMinWidth(60);
            jTableBD.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTableBD.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableBD.getColumnModel().getColumn(1).setMinWidth(100);
            jTableBD.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableBD.getColumnModel().getColumn(1).setMaxWidth(100);
            jTableBD.getColumnModel().getColumn(2).setMinWidth(100);
            jTableBD.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableBD.getColumnModel().getColumn(2).setMaxWidth(100);
            jTableBD.getColumnModel().getColumn(3).setMinWidth(80);
            jTableBD.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableBD.getColumnModel().getColumn(3).setMaxWidth(80);
            jTableBD.getColumnModel().getColumn(4).setMinWidth(80);
            jTableBD.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTableBD.getColumnModel().getColumn(4).setMaxWidth(80);
            jTableBD.getColumnModel().getColumn(5).setMinWidth(110);
            jTableBD.getColumnModel().getColumn(5).setPreferredWidth(110);
            jTableBD.getColumnModel().getColumn(5).setMaxWidth(110);
            jTableBD.getColumnModel().getColumn(7).setMinWidth(225);
            jTableBD.getColumnModel().getColumn(7).setPreferredWidth(225);
            jTableBD.getColumnModel().getColumn(7).setMaxWidth(225);
        }

        javax.swing.GroupLayout jPanelTabelaBDLayout = new javax.swing.GroupLayout(jPanelTabelaBD);
        jPanelTabelaBD.setLayout(jPanelTabelaBDLayout);
        jPanelTabelaBDLayout.setHorizontalGroup(
            jPanelTabelaBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabelaBDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTabelaBDLayout.setVerticalGroup(
            jPanelTabelaBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabelaBDLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jCheckBoxClassificadores.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBoxClassificadores.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jCheckBoxClassificadores.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxClassificadores.setText("ADICIONAR CLASSIFICADORES");
        jCheckBoxClassificadores.setToolTipText("Adiciona classificadores na tabela");
        jCheckBoxClassificadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxClassificadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBDLayout = new javax.swing.GroupLayout(jPanelBD);
        jPanelBD.setLayout(jPanelBDLayout);
        jPanelBDLayout.setHorizontalGroup(
            jPanelBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBtnBD, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
            .addComponent(jPanelTabelaBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelBDLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jCheckBoxClassificadores)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBDLayout.setVerticalGroup(
            jPanelBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBDLayout.createSequentialGroup()
                .addComponent(jPanelBtnBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxClassificadores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTabelaBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/_imagens/bd.png"));
        } catch (IOException e) {
        }
        jTabs.addTab("BANCO DE DADOS", jPanelBD);
        setIconImage(img);

        jPanelRelatorio.setBackground(new java.awt.Color(102, 102, 102));

        jPanelBtnRel.setBackground(new java.awt.Color(153, 153, 153));
        jPanelBtnRel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelBtnRel.setPreferredSize(new java.awt.Dimension(942, 91));

        jBtnRelGeral.setBackground(new java.awt.Color(153, 255, 153));
        jBtnRelGeral.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnRelGeral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/geral.png"))); // NOI18N
        jBtnRelGeral.setText("GERAL");
        jBtnRelGeral.setToolTipText("Gerar relatório Geral por Grupo");
        jBtnRelGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRelGeralActionPerformed(evt);
            }
        });
        jBtnRelGeral.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnRelGeral.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnRelGrupo.setBackground(new java.awt.Color(255, 204, 102));
        jBtnRelGrupo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnRelGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/user.png"))); // NOI18N
        jBtnRelGrupo.setText("COLABORADOR");
        jBtnRelGrupo.setToolTipText("Gerar relatório de Colaborador por Grupo");
        jBtnRelGrupo.setBorder(null);
        jBtnRelGrupo.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnRelGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRelGrupoActionPerformed(evt);
            }
        });
        jBtnRelGrupo.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnRelGrupo.setHorizontalTextPosition(SwingConstants.CENTER);

        logoHMC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/logo-hmc.png"))); // NOI18N

        logoFSFX1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/fsfx.png"))); // NOI18N

        jBtnRelPergunta.setBackground(new java.awt.Color(102, 204, 255));
        jBtnRelPergunta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnRelPergunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/Pergunta.png"))); // NOI18N
        jBtnRelPergunta.setText("PERGUNTA");
        jBtnRelPergunta.setToolTipText("Gerar relatório de Perguntas por Grupo");
        jBtnRelPergunta.setBorder(null);
        jBtnRelPergunta.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnRelPergunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRelPerguntaActionPerformed(evt);
            }
        });
        jBtnRelPergunta.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnRelPergunta.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnRelGeralColab.setBackground(new java.awt.Color(153, 255, 153));
        jBtnRelGeralColab.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnRelGeralColab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/geral.png"))); // NOI18N
        jBtnRelGeralColab.setText("COLABORADOR");
        jBtnRelGeralColab.setToolTipText("Gerar relatório Geral por Grupo dos Colaboradores");
        jBtnRelGeralColab.setBorder(null);
        jBtnRelGeralColab.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnRelGeralColab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRelGeralColabActionPerformed(evt);
            }
        });
        jBtnRelGeralColab.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnRelGeralColab.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnRelResposta.setBackground(new java.awt.Color(102, 204, 255));
        jBtnRelResposta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnRelResposta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/Resposta.png"))); // NOI18N
        jBtnRelResposta.setText("RESPOSTA");
        jBtnRelResposta.setToolTipText("Gerar relatório de Respostas por Grupo");
        jBtnRelResposta.setBorder(null);
        jBtnRelResposta.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnRelResposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRelRespostaActionPerformed(evt);
            }
        });
        jBtnRelResposta.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnRelResposta.setHorizontalTextPosition(SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelBtnRelLayout = new javax.swing.GroupLayout(jPanelBtnRel);
        jPanelBtnRel.setLayout(jPanelBtnRelLayout);
        jPanelBtnRelLayout.setHorizontalGroup(
            jPanelBtnRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnRelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jBtnRelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRelGeralColab, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRelGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRelPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRelResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBtnRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoHMC1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoFSFX1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelBtnRelLayout.setVerticalGroup(
            jPanelBtnRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnRelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBtnRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBtnRelLayout.createSequentialGroup()
                        .addComponent(logoFSFX1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoHMC1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBtnRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnRelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnRelGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnRelPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnRelGeralColab, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnRelResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPainelDinamicoRel.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPainelDinamicoRelLayout = new javax.swing.GroupLayout(jPainelDinamicoRel);
        jPainelDinamicoRel.setLayout(jPainelDinamicoRelLayout);
        jPainelDinamicoRelLayout.setHorizontalGroup(
            jPainelDinamicoRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 945, Short.MAX_VALUE)
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
                .addGap(51, 51, 51)
                .addComponent(jPainelDinamicoRel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );

        jTabs.addTab("RELATÓRIOS", jPanelRelatorio);

        jPanelBtnCad.setBackground(new java.awt.Color(153, 153, 153));
        jPanelBtnCad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelBtnCad.setPreferredSize(new java.awt.Dimension(950, 91));

        jBtnCadColaborador.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCadColaborador.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnCadColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/user.png"))); // NOI18N
        jBtnCadColaborador.setText("COLABORADOR");
        jBtnCadColaborador.setToolTipText("Cadastrar Colaborador");
        jBtnCadColaborador.setBorder(null);
        jBtnCadColaborador.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jBtnCadColaborador.setMaximumSize(new java.awt.Dimension(67, 23));
        jBtnCadColaborador.setMinimumSize(new java.awt.Dimension(67, 23));
        jBtnCadColaborador.setPreferredSize(new java.awt.Dimension(67, 23));
        jBtnCadColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadColaboradorActionPerformed(evt);
            }
        });
        jBtnCadColaborador.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnCadColaborador.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnCadMaq.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCadMaq.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnCadMaq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/pc.png"))); // NOI18N
        jBtnCadMaq.setText("MÁQUINA");
        jBtnCadMaq.setToolTipText("Cadastrar Máquina");
        jBtnCadMaq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadMaqActionPerformed(evt);
            }
        });
        jBtnCadMaq.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnCadMaq.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnCadGrupo.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCadGrupo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnCadGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/geral.png"))); // NOI18N
        jBtnCadGrupo.setText("GRUPO");
        jBtnCadGrupo.setToolTipText("Cadastrar Grupo");
        jBtnCadGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadGrupoActionPerformed(evt);
            }
        });
        jBtnCadGrupo.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnCadGrupo.setHorizontalTextPosition(SwingConstants.CENTER);

        logoHMC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/logo-hmc.png"))); // NOI18N

        logoFSFX2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/fsfx.png"))); // NOI18N

        jBtnCadPerg.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCadPerg.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnCadPerg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/Pergunta.png"))); // NOI18N
        jBtnCadPerg.setText("PERGUNTA");
        jBtnCadPerg.setToolTipText("Cadastrar Máquina");
        jBtnCadPerg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadPergActionPerformed(evt);
            }
        });
        jBtnCadPerg.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnCadPerg.setHorizontalTextPosition(SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelBtnCadLayout = new javax.swing.GroupLayout(jPanelBtnCad);
        jPanelBtnCad.setLayout(jPanelBtnCadLayout);
        jPanelBtnCadLayout.setHorizontalGroup(
            jPanelBtnCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnCadLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jBtnCadColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnCadGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnCadMaq, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnCadPerg, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBtnCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoHMC2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoFSFX2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelBtnCadLayout.setVerticalGroup(
            jPanelBtnCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnCadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBtnCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBtnCadLayout.createSequentialGroup()
                        .addComponent(logoFSFX2)
                        .addGap(12, 12, 12)
                        .addComponent(logoHMC2))
                    .addGroup(jPanelBtnCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnCadColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnCadGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnCadMaq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnCadPerg, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPainelDinamicoCad.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPainelDinamicoCadLayout = new javax.swing.GroupLayout(jPainelDinamicoCad);
        jPainelDinamicoCad.setLayout(jPainelDinamicoCadLayout);
        jPainelDinamicoCadLayout.setHorizontalGroup(
            jPainelDinamicoCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 945, Short.MAX_VALUE)
        );
        jPainelDinamicoCadLayout.setVerticalGroup(
            jPainelDinamicoCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelDinamicoCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelBtnCad, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addComponent(jPanelBtnCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPainelDinamicoCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabs.addTab("CADASTRO", jPanelCadastro);

        ImageIcon iconBd = new ImageIcon( getClass().getResource("/_imagens/bd.png") );
        jTabs.setIconAt(0, iconBd);

        ImageIcon iconRel = new ImageIcon( getClass().getResource("/_imagens/relatorio.png") );
        jTabs.setIconAt(1, iconRel);

        ImageIcon iconCad = new ImageIcon( getClass().getResource("/_imagens/cadastro.png") );
        jTabs.setIconAt(2, iconCad);

        jTabs.addChangeListener(new ChangeListener() { //add the Listener

            public void stateChanged(ChangeEvent e) {
                if(jTabs.getSelectedIndex() == 1){
                    //Atualizar os JCBOX caso tenho sido feita alguma alteração
                    relPergGrupo.atualizarJCBGrupo();
                    relPergGrupo.atualizarJCBPergunta();
                    relColab.atualizarJCBGrupo();
                    relColab.atualizarJCBColaboradorGrupo();
                    relGeral.atualizarJCBGrupo();
                    relGeralColab.atualizarJCBGrupo();
                    relRespGrupo.atualizarJCBGrupo();

                    ColaboradorDAO c = new ColaboradorDAO();
                    if (!c.listarColaboradoresSemCadastro().isEmpty()){

                        int resp = JOptionPane.showConfirmDialog(null, "<html><body align=center>EXISTEM COLABORADORES NÃO CADASTRADOS NO SISTEMA.<br><br>Gostaria de cadastrá-los?", "ERRO", JOptionPane.ERROR_MESSAGE,JOptionPane.YES_NO_OPTION);

                        if (resp == 0){
                            for (Colaborador i : c.listarColaboradoresSemCadastro()){
                                c.createSemCadastro(999,i.getId());
                            }

                            relColab.mostrarBtnRelatorio();
                            relGeral.mostrarBtnRelatorio();
                            relGeralColab.mostrarBtnRelatorio();
                            relPergGrupo.mostrarBtnRelatorio();
                            relRespGrupo.mostrarBtnRelatorio();

                            JOptionPane.showMessageDialog(null, "<html><body align=center>COLABORADORES CADASTRADOS.<br><br>Especifique o grupo dos Colaboradores inseridos na Aba CADASTRO !");
                        }else{
                            relColab.esconderBtnRelatorio();
                            relGeral.esconderBtnRelatorio();
                            relGeralColab.esconderBtnRelatorio();
                            relPergGrupo.esconderBtnRelatorio();
                            relRespGrupo.esconderBtnRelatorio();
                        }
                    }

                }else if(jTabs.getSelectedIndex() == 2){
                    cadColab.lerColaboradores();
                    cadGru.lerGrupos();
                    cadPerg.lerPerguntas();
                    cadMaq.lerMaquinas();

                }
            }
        });

        getContentPane().add(jTabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, 639));

        jMenu.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jMenu1.setText("CONFIGURAR");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItemConfigBD.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jMenuItemConfigBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/database.png"))); // NOI18N
        jMenuItemConfigBD.setText("Banco de Dados");
        jMenuItemConfigBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfigBDActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemConfigBD);

        jMenuItemConfigUsuarios.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jMenuItemConfigUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/user-icon.png"))); // NOI18N
        jMenuItemConfigUsuarios.setText("Usuários");
        jMenu1.add(jMenuItemConfigUsuarios);

        jMenu.add(jMenu1);

        jMenu2.setText("SOBRE");
        jMenu2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItemSobreSobre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jMenuItemSobreSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/info.png"))); // NOI18N
        jMenuItemSobreSobre.setText("Sobre o Software");
        jMenuItemSobreSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreSobreActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSobreSobre);

        jMenu.add(jMenu2);

        setJMenuBar(jMenu);

        getAccessibleContext().setAccessibleName(":: CORMED SISAT 2.0 ::");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBDApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBDApagarActionPerformed
        String message = "<html><body align=center>DESEJA REALMENTE APAGAR OS REGISTROS CADASTRADOS ? ";
        String title = "CONFIRME OPERAÇÃO";
        // display the JOptionPane showConfirmDialog
        int resposta = JOptionPane.showConfirmDialog(jPanelBD, message, title, JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            
            //Apagar o arquivo com os registros;
            File dir = new File("C:\\SISAT-v2");
            File arq = new File(dir, "log.txt");
            arq.delete();
            
            jCheckBoxClassificadores.setEnabled(true);
            jCheckBoxClassificadores.setSelected(false);
            jTableBD.setRowSorter(null);
            PesquisaDAO dao = new PesquisaDAO();
            dao.truncarBD();
            MaquinaDAO m = new MaquinaDAO();
            m.resetarImportados();
        }
        lerBanco();
    }//GEN-LAST:event_jBtnBDApagarActionPerformed

    private void jBtnCadGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadGrupoActionPerformed
        cadColab.setVisible(false);
        cadPerg.setVisible(false);
        cadMaq.setVisible(false);
        cadGru.setVisible(true);
    }//GEN-LAST:event_jBtnCadGrupoActionPerformed

    private void jBtnCadMaqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadMaqActionPerformed
        cadColab.setVisible(false);
        cadPerg.setVisible(false);
        cadGru.setVisible(false);
        cadMaq.setVisible(true);
        cadMaq.lerMaquinas();
    }//GEN-LAST:event_jBtnCadMaqActionPerformed

    private void jBtnCadColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadColaboradorActionPerformed
        cadGru.setVisible(false);
        cadPerg.setVisible(false);
        cadMaq.setVisible(false);
        cadColab.setVisible(true);
        cadColab.lerColaboradores();
    }//GEN-LAST:event_jBtnCadColaboradorActionPerformed

    private void jBtnRelGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRelGeralActionPerformed
        relColab.setVisible(false);
        relPergGrupo.setVisible(false);
        relRespGrupo.setVisible(false);
        relGeralColab.setVisible(false);
        relGeral.setVisible(true);
    }//GEN-LAST:event_jBtnRelGeralActionPerformed

    private void jBtnRelGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRelGrupoActionPerformed
        relGeral.setVisible(false);
        relPergGrupo.setVisible(false);
        relRespGrupo.setVisible(false);
        relGeralColab.setVisible(false);
        relColab.setVisible(true);
    }//GEN-LAST:event_jBtnRelGrupoActionPerformed

    private void jBtnBDLerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBDLerActionPerformed
        telaSelecaoMaq = new SelecaoMaquinas(this, true);
        telaSelecaoMaq.setVisible(true);
    }//GEN-LAST:event_jBtnBDLerActionPerformed

    private void jCheckBoxClassificadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxClassificadoresActionPerformed
        classificarTabela();
        jCheckBoxClassificadores.setEnabled(false);
    }//GEN-LAST:event_jCheckBoxClassificadoresActionPerformed

    private void jMenuItemSobreSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreSobreActionPerformed
        Sobre s = new Sobre();
        //this.add(s);
        s.setVisible(true);
    }//GEN-LAST:event_jMenuItemSobreSobreActionPerformed

    private void jMenuItemConfigBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfigBDActionPerformed
        Configuracoes c = new Configuracoes();
        //this.add(s);
        c.setVisible(true);
    }//GEN-LAST:event_jMenuItemConfigBDActionPerformed

    private void jBtnRelPerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRelPerguntaActionPerformed
        relGeral.setVisible(false);
        relRespGrupo.setVisible(false);
        relColab.setVisible(false);
        relGeralColab.setVisible(false);
        relPergGrupo.setVisible(true);
    }//GEN-LAST:event_jBtnRelPerguntaActionPerformed

    private void jBtnRelGeralColabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRelGeralColabActionPerformed
        relGeral.setVisible(false);
        relRespGrupo.setVisible(false);
        relPergGrupo.setVisible(false);
        relColab.setVisible(false);
        relGeralColab.setVisible(true);
    }//GEN-LAST:event_jBtnRelGeralColabActionPerformed

    private void jBtnRelRespostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRelRespostaActionPerformed
        relGeral.setVisible(false);
        relPergGrupo.setVisible(false);
        relColab.setVisible(false);
        relGeralColab.setVisible(false);
        relRespGrupo.setVisible(true);
    }//GEN-LAST:event_jBtnRelRespostaActionPerformed

    private void jBtnCadPergActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadPergActionPerformed
        cadColab.setVisible(false);
        cadGru.setVisible(false);
        cadMaq.setVisible(false);
        cadPerg.setVisible(true);
    }//GEN-LAST:event_jBtnCadPergActionPerformed

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
    private javax.swing.JButton jBtnCadPerg;
    private javax.swing.JButton jBtnRelGeral;
    private javax.swing.JButton jBtnRelGeralColab;
    private javax.swing.JButton jBtnRelGrupo;
    private javax.swing.JButton jBtnRelPergunta;
    private javax.swing.JButton jBtnRelResposta;
    private javax.swing.JCheckBox jCheckBoxClassificadores;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItemConfigBD;
    private javax.swing.JMenuItem jMenuItemConfigUsuarios;
    private javax.swing.JMenuItem jMenuItemSobreSobre;
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
    private javax.swing.JLabel logoFSFX;
    private javax.swing.JLabel logoFSFX1;
    private javax.swing.JLabel logoFSFX2;
    private javax.swing.JLabel logoHMC;
    private javax.swing.JLabel logoHMC1;
    private javax.swing.JLabel logoHMC2;
    // End of variables declaration//GEN-END:variables
}
