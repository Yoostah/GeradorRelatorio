/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Colaborador;
import model.Grupo;
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
public class ColaboradorDAO {
    public void create(Colaborador c){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO colaborador (ID, NOME, GRUPO) VALUES (?,?,?)");
            stmt.setInt(1,c.getId());
            stmt.setString(2,c.getNome());
            stmt.setInt(3,Integer.parseInt(c.getGrupo()));
                        
            
            stmt.executeUpdate();
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Colaborador já cadastrado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + ex);
        } finally{
            AcessoDB.closeConnection(con,stmt);
        }
    }
    
    public boolean atualizar(Colaborador c, int id){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE colaborador set id = ?, nome = ?, grupo = ? where id = ?");
            stmt.setInt(1, c.getId());
            stmt.setString(2,c.getNome());
            stmt.setInt(3,Integer.parseInt(c.getGrupo()));
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
            AcessoDB.closeConnection(con,stmt);
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
            AcessoDB.closeConnection(con,stmt);
        }
    }
    
    public List<Colaborador> listar(){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Colaborador> colaboradores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT c.id, c.nome, g.nome FROM colaborador AS c JOIN grupo AS g ON c.grupo = g.id");
            rs = stmt.executeQuery();
            
            
            while (rs.next()){
                Colaborador c = new Colaborador();
                
                c.setId(rs.getInt("c.id"));
                c.setNome(rs.getString("c.nome"));
                c.setGrupo(rs.getString("g.nome"));
                
                colaboradores.add(c);
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            AcessoDB.closeConnection(con, stmt, rs);
        }
        
        return colaboradores;
    }
    
    public List<Colaborador> listarColaboradoresSemCadastro(){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Colaborador> colaboradores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT DISTINCT colaborador FROM pesquisa AS p WHERE (NOT EXISTS (SELECT id FROM colaborador AS c WHERE c.id = p.colaborador));");
            rs = stmt.executeQuery();
            
            
            while (rs.next()){
                Colaborador c = new Colaborador();
                
                c.setId(rs.getInt("colaborador"));
                
                
                colaboradores.add(c);
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            AcessoDB.closeConnection(con, stmt, rs);
        }
        
        return colaboradores;
    }
    
    public void createSemCadastro(int fixo, int id_colab){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO colaborador (id,nome,grupo) VALUE (?, CONCAT('COLABORADOR',' - ',id),?)");
            stmt.setInt(1,id_colab);
            stmt.setInt(2,fixo);
                        
            
            stmt.executeUpdate();
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Colaborador já cadastrado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + ex);
        } finally{
            AcessoDB.closeConnection(con,stmt);
        }
    }
}
