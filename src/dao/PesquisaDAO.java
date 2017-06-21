/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Pesquisa;
import conexao.AcessoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Thulio
 */
public class PesquisaDAO {
    public void create(Pesquisa p){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            //Converte o formato de Date para um formato aceito no BD
            SimpleDateFormat formatacao = new SimpleDateFormat("yyyy-MM-dd");
            
            stmt = con.prepareStatement("INSERT INTO pesquisa (PESQUISA, PERGUNTA, RESPOSTA, COLABORADOR, DATA) VALUES (?,?,?,?,?)");
            stmt.setString(1,p.getPesquisa());
            stmt.setInt(2, p.getPergunta());
            stmt.setInt(3, p.getResposta());
            stmt.setInt(4, p.getColaborador());
            stmt.setString(5, formatacao.format(p.getData()));
            
            stmt.executeUpdate();
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Pesquisa já cadastrada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        } finally{
            AcessoDB.closeConnection(con);
        }
    }
    
    public void truncarBD(){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("TRUNCATE pesquisa");
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Banco apagado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar Banco!" + ex);
        } finally{
            AcessoDB.closeConnection(con);
        }
    }
}
