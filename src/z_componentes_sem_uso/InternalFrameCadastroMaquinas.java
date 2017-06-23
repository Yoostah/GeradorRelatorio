/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_componentes_sem_uso;

import classes.Maquina;
import dao.MaquinaDAO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thulio
 */
public class InternalFrameCadastroMaquinas extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrameCadastroCliente
     */
    public InternalFrameCadastroMaquinas() {
        initComponents();
        lerMaquinas();
        
    }
    
    public void lerMaquinas() {
        DefaultTableModel modelo = (DefaultTableModel) jTableMaquinas.getModel();
        //JTableUtilities.setCellsAlignment(jTableMaquinas, SwingConstants.LEFT);
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
        jBtnMaqADD = new javax.swing.JButton();
        jBtnMaqDEL = new javax.swing.JButton();
        jBtnMaqUPD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaquinas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jTxtCaminho = new javax.swing.JTextField();
        jBtnCaminho = new javax.swing.JButton();
        jCGrupo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jBtnADD = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Máquinas");

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

        jBtnMaqDEL.setBackground(new java.awt.Color(255, 51, 51));
        jBtnMaqDEL.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnMaqDEL.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMaqDEL.setText("Deletar");
        jBtnMaqDEL.setBorder(null);
        jBtnMaqDEL.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnMaqDEL.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnMaqDEL.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnMaqDEL.setPreferredSize(new java.awt.Dimension(60, 60));

        jBtnMaqUPD.setBackground(new java.awt.Color(0, 0, 0));
        jBtnMaqUPD.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnMaqUPD.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMaqUPD.setText("Alterar");
        jBtnMaqUPD.setBorder(null);
        jBtnMaqUPD.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnMaqUPD.setMaximumSize(new java.awt.Dimension(60, 60));
        jBtnMaqUPD.setMinimumSize(new java.awt.Dimension(60, 60));
        jBtnMaqUPD.setPreferredSize(new java.awt.Dimension(60, 60));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jScrollPane1.setViewportView(jTableMaquinas);
        jTableMaquinas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableMaquinas.getColumnModel().getColumnCount() > 0) {
            jTableMaquinas.getColumnModel().getColumn(0).setMinWidth(50);
            jTableMaquinas.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableMaquinas.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableMaquinas.getColumnModel().getColumn(1).setMinWidth(100);
            jTableMaquinas.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableMaquinas.getColumnModel().getColumn(1).setMaxWidth(100);
            jTableMaquinas.getColumnModel().getColumn(2).setMinWidth(250);
            jTableMaquinas.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTableMaquinas.getColumnModel().getColumn(2).setMaxWidth(250);
            jTableMaquinas.getColumnModel().getColumn(3).setMinWidth(100);
            jTableMaquinas.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableMaquinas.getColumnModel().getColumn(3).setMaxWidth(100);
            jTableMaquinas.getColumnModel().getColumn(4).setResizable(false);
            jTableMaquinas.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE MÁQUINAS");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel2.setText("NOME:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel3.setText("CAMINHO:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel4.setText("GRUPO:");

        jTxtNome.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N

        jTxtCaminho.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N

        jBtnCaminho.setText("...");

        jCGrupo.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jCGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jBtnADD.setBackground(new java.awt.Color(255, 255, 255));
        jBtnADD.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jBtnADD.setText("ADD");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jCGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTxtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jCGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMaquinas;
    private javax.swing.JTextField jTxtCaminho;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
