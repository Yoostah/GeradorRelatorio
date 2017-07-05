/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.conexao.AcessoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pergunta;

/**
 *
 * @author Thulio
 */
public class PerguntaDAO {
       
    public boolean atualizar(Pergunta p, int id){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE perguntas set pergunta = ? where id = ?");
            stmt.setString(1,p.getPergunta());
            stmt.setInt(2, id);
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pergunta atualizada com sucesso!");
            return true;
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
            return false;
        } finally{
            AcessoDB.closeConnection(con,stmt);
        }
    }
    
    
    public List<Pergunta> listar(){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pergunta> perguntas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM perguntas ORDER BY id");
            rs = stmt.executeQuery();
            
            
            while (rs.next()){
                Pergunta p = new Pergunta();
                
                p.setId(rs.getInt("id"));
                p.setPergunta(rs.getString("pergunta"));
                
                perguntas.add(p);
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            AcessoDB.closeConnection(con, stmt, rs);
        }
        
        return perguntas;
    }
}
