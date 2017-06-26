/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Grupo;
import conexao.AcessoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thulio
 */
public class GrupoDAO {
    public void create(Grupo g){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO grupo (NOME) VALUES (?)");
            stmt.setString(1,g.getNome());
                        
            
            stmt.executeUpdate();
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Grupo já cadastrado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + ex);
        } finally{
            AcessoDB.closeConnection(con);
        }
    }
    
    public boolean atualizar(Grupo g, int id){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE grupo set nome = ? where id = ?");
            stmt.setString(1,g.getNome());
            stmt.setInt(2, id);
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Grupo atualizado com sucesso!");
            return true;
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Grupo já cadastrado.");
            return false;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
            return false;
        } finally{
            AcessoDB.closeConnection(con);
        }
    }
    
    public void deletar(int id){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM grupo WHERE id = ?");
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Grupo removido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar!" + ex);
        } finally{
            AcessoDB.closeConnection(con);
        }
    }
    
    public List<Grupo> listar(){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Grupo> grupos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM grupo ORDER BY id");
            rs = stmt.executeQuery();
            
            
            while (rs.next()){
                Grupo g = new Grupo();
                
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("nome"));
                
                grupos.add(g);
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            AcessoDB.closeConnection(con, stmt, rs);
        }
        
        return grupos;
    }
}
