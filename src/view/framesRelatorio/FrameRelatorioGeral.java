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
import javax.swing.SwingConstants;
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

        atualizarJCBGrupo();

    }

    public void esconderBtnRelatorio() {
        jBtnGerar.setVisible(false);
    }

    public void mostrarBtnRelatorio() {
        jBtnGerar.setVisible(true);
    }

    public void atualizarJCBGrupo() {
        //Colocar os Grupos Cadastrados no banco no JCBox
        GrupoDAO g = new GrupoDAO();
        jCGrupo.removeAllItems();
        jCGrupo.addItem("( Escolha um Grupo )");
        for (Grupo i : g.listar()) {
            jCGrupo.addItem(i.getId() + "-  " + i.getNome());
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
        textura = new javax.swing.JLabel();
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

        textura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/teste.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 25)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RELATÓRIO GERAL POR GRUPO");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jBtnGerar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnGerar.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jBtnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_imagens/gerar_relatorio.png"))); // NOI18N
        jBtnGerar.setText("GERAR");
        jBtnGerar.setToolTipText("Gerar Relatório");
        jBtnGerar.setBorder(null);
        jBtnGerar.setIconTextGap(10);
        jBtnGerar.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jBtnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGerarActionPerformed(evt);
            }
        });
        jBtnGerar.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnGerar.setVerticalTextPosition(SwingConstants.BOTTOM);

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
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jDateInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jDateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(45, 45, 45)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jCGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3))))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGerarActionPerformed
        if (jCGrupo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um Grupo!");

        } else if (jDateInicial.getDate() == null || jDateFinal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Preencha corretamente os campos Data Inicial e Data Final!");

        } else {
            jBtnGerar.setText("GERANDO");
            jBtnGerar.setEnabled(false);
            Connection con = AcessoDB.getConnection();

            String[] grupo = jCGrupo.getSelectedItem().toString().split("-  ");
            String g = "";
            for (int i = 1; i < grupo.length; i++) {
                g += (grupo[i]);

            }

            try {
                String data_inicial = new SimpleDateFormat("dd/MM/yyyy").format(jDateInicial.getDate());
                String data_final = new SimpleDateFormat("dd/MM/yyyy").format(jDateFinal.getDate());

                //Map com os parametro da query
                Map map = new HashMap();
                map.put("data_inicial", data_inicial);
                map.put("data_final", data_final);
                map.put("grupo", g);
                map.put("imagem", "_imagens/CORMED_200.png");

                //Carregando o Relatório
                InputStream jasper = this.getClass().getResourceAsStream("/_relatorios/Geral_Setor.jasper");

                //Passando os dados para a query e a conexao ao relatorio
                JasperPrint p = JasperFillManager.fillReport(jasper, map, con);
                JasperViewer view = new JasperViewer(p, false);
                if (p.getPages().isEmpty()) {
                    // Se o JasperViewer constructor não tiver páginas, ele irá mostrar "the document has no pages"
                    // e e vez de abrir o jasperviewer vazio ele simplesmente não exibe e retorna.
                    jBtnGerar.setText("GERAR");
                    jBtnGerar.setEnabled(true);
                    return;
                }
                view.setVisible(true);
                view.toFront();
                jBtnGerar.setText("GERAR");
                jBtnGerar.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao gerar Relatório ( " + e + " )");
                jBtnGerar.setText("GERAR");
                jBtnGerar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jBtnGerarActionPerformed


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
    private javax.swing.JLabel textura;
    // End of variables declaration//GEN-END:variables
}
