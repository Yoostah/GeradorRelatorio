/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Colaborador;
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
public class ColaboradorDAO {
    public void create(Colaborador c){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO colaborador (ID, NOME, GRUPO) VALUES (?,?,?)");
            stmt.setInt(1,c.getId());
            stmt.setString(2,c.getNome());
            stmt.setString(3,c.getGrupo());
                        
            
            stmt.executeUpdate();
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Colaborador já cadastrado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + ex);
        } finally{
            AcessoDB.closeConnection(con);
        }
    }
    
    public boolean atualizar(Colaborador c, int id){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE colaborador set id = ?, nome = ?, grupo = ? where id = ?");
            stmt.setInt(1, c.getId());
            stmt.setString(2,c.getNome());
            stmt.setString(3,c.getGrupo());
            stmt.setInt(4, id);
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Colaborador atualizado com sucesso!");
            return true;
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Colaborador já cadastrado.");
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
            
            stmt = con.prepareStatement("DELETE FROM colaborador WHERE id = ?");
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Colaborador removido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar!" + ex);
        } finally{
            AcessoDB.closeConnection(con);
        }
    }
    
    public List<Colaborador> listar(){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Colaborador> colaboradores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM colaborador ORDER BY id");
            rs = stmt.executeQuery();
            
            
            while (rs.next()){
                Colaborador c = new Colaborador();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setGrupo(rs.getString("grupo"));
                
                colaboradores.add(c);
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            AcessoDB.closeConnection(con, stmt, rs);
        }
        
        return colaboradores;
    }
}
