/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.conexao;

/**
 *
 * @author Thulio
 */
import _propriedades.CarregarConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @author Thulio
 * @since 2017
 */
public class AcessoDB {

    private static CarregarConfig p = new CarregarConfig();
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://" + p.getValor("host") + ":" + p.getValor("porta") + "/" + p.getValor("db");
    private static final String USER = p.getValor("login");
    private static final String PASS = p.getValor("senha");

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            //throw new RuntimeException("Erro na conexão: ", ex);
            JOptionPane.showMessageDialog(null, "<html><body align=center>Erro de conexão com o banco de dados!<br>( "+ex+" )");
            System.exit(1);
            return null;
        }
    }
    

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AcessoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AcessoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
