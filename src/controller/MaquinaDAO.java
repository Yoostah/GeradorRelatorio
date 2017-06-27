/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Maquina;
import controller.conexao.AcessoDB;
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
public class MaquinaDAO {
    public void create(Maquina m){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO maquinas (NOME, CAMINHO, GRUPO, IMPORTAR) VALUES (?,?,?,?)");
            stmt.setString(1,m.getNome());
            stmt.setString(2,m.getCaminho());
            stmt.setString(3,m.getGrupo());
            stmt.setBoolean(4,false);
            
            
            stmt.executeUpdate();
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Máquina já cadastrada.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + ex);
        } finally{
            AcessoDB.closeConnection(con,stmt);
        }
    }
    
    public boolean atualizar(Maquina m, int id){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE maquinas set nome = ?, caminho = ?, grupo = ?, importar = ? where id = ?");
            stmt.setString(1,m.getNome());
            stmt.setString(2,m.getCaminho());
            stmt.setString(3, m.getGrupo());
            stmt.setBoolean(4, m.isImportar());
            stmt.setInt(5, id);
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Máquina atualizada com sucesso!");
            return true;
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Máquina já cadastrada.");
            return false;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
            return false;
        } finally{
            AcessoDB.closeConnection(con,stmt);
        }
    }
    
    public void deletar(int id){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM maquinas WHERE id = ?");
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Máquina removida com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar!" + ex);
        } finally{
            AcessoDB.closeConnection(con,stmt);
        }
    }
    
    public List<Maquina> listar(){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Maquina> maquinas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM maquinas ORDER BY id");
            rs = stmt.executeQuery();
            
            
            while (rs.next()){
                Maquina m = new Maquina();
                
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setCaminho(rs.getString("caminho"));
                m.setGrupo(rs.getString("grupo"));
                m.setImportar(rs.getBoolean("importar"));
                m.setImportado(rs.getBoolean("importado"));
                
                maquinas.add(m);
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            AcessoDB.closeConnection(con, stmt, rs);
        }
        
        return maquinas;
    }
    
    public boolean importar(int id, boolean importar){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE maquinas set importar = ? where id = ?");
            stmt.setBoolean(1, importar);
            stmt.setInt(2, id);
           
            
            stmt.executeUpdate();
            return true;
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
            return false;
        } finally{
            AcessoDB.closeConnection(con,stmt);
        }
    }
    public boolean importado(int id, boolean importado){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE maquinas set importado = ? where id = ?");
            stmt.setBoolean(1, importado);
            stmt.setInt(2, id);
           
            
            stmt.executeUpdate();
            return true;
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
            return false;
        } finally{
            AcessoDB.closeConnection(con,stmt);
        }
    }
    
    public void resetarImportados(){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE maquinas SET importado = false");
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
        } finally{
            AcessoDB.closeConnection(con, stmt);
        }
    }
}
