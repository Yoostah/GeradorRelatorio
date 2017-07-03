/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pesquisa;
import controller.conexao.AcessoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Colaborador;

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
            
            stmt = con.prepareStatement("INSERT INTO pesquisa (PESQUISA, PERGUNTA, RESPOSTA, COLABORADOR, DATA, GRUPO, MAQUINA, TEXTOP) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setString(1,p.getPesquisa());
            stmt.setInt(2, p.getPergunta());
            stmt.setInt(3, p.getResposta());
            stmt.setInt(4, p.getId_colaborador());
            stmt.setString(5, formatacao.format(p.getData()));
            stmt.setString(6, (p.getGrupo()));
            stmt.setString(7, (p.getMaquina()));
            stmt.setInt(8, p.getTextop());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        } finally{
            AcessoDB.closeConnection(con,stmt);
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
            AcessoDB.closeConnection(con,stmt);
        }
    }
    
    public List<Pesquisa> listar(){
        Connection con = AcessoDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pesquisa> pesquisa = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM pesquisa ORDER BY id");
            rs = stmt.executeQuery();
            
            
            while (rs.next()){
                Pesquisa p = new Pesquisa();
                
                p.setId(rs.getInt("id"));
                p.setPesquisa(rs.getString("pesquisa"));
                p.setData(rs.getDate("data"));
                p.setPergunta(rs.getInt("pergunta"));
                p.setResposta(rs.getInt("resposta"));
                p.setId_colaborador(rs.getInt("colaborador"));
                p.setGrupo(rs.getString("grupo"));
                p.setMaquina(rs.getString("maquina"));
                p.setTextop(rs.getInt("textop"));
                
                pesquisa.add(p);
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            AcessoDB.closeConnection(con, stmt, rs);
        }
        
        return pesquisa;
    }
    
    
}
