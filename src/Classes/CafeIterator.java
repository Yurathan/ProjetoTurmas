/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DBConnect.MySQLcon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bene
 */
public class CafeIterator {
    
    public void alteraCafe(Cafe cafe){
        MySQLcon sqlcon = new MySQLcon();
        try{
            String sql = "UPDATE cafe set descricao = ?, lotacao = ? where pkcafe = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, cafe.getDescricao());
            prepstatement.setInt(2, cafe.getLotacao());
            prepstatement.setInt(3, cafe.getPkcafe());
            sqlcon.executeupdate();
        }catch(Exception e){
            
        }finally{
            sqlcon.close();
        }
    }
    
    public void adicionaCafe(Cafe cafe){
        MySQLcon sqlcon = new MySQLcon();
        if  (atingiuLimite()){
            JOptionPane.showMessageDialog(null, "A quantidade de áreas para o café atingiu o máximo (2).");
            return;
        }
        
        try{
            String sql = "Insert INTO Cafe(Descricao, Lotacao) Values ( ?, ?)";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, cafe.getDescricao());
            prepstatement.setInt(2, cafe.getLotacao());
            sqlcon.executeupdate();
        }catch(Exception e){
            
        } finally {
            sqlcon.close();
        }
    }
    
    public int buscaPKPelaDescricao(String descricao){
         MySQLcon sqlcon = new MySQLcon();
        int pk = 0;
        try{
            String sql = "SELECT pkcafe FROM cafe WHERE Descricao = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, descricao);
            ResultSet result = sqlcon.ler();
            while (result.next()){
                pk = result.getInt("pkcafe");
            }
        } catch(Exception e){
            
        } finally{
            sqlcon.close();
        }
        return pk;       
    }
    
    public int buscaPKcafe(Cafe cafe){
        MySQLcon sqlcon = new MySQLcon();
        int pk = 0;
        try{
            String sql = "SELECT pkcafe FROM cafe WHERE Descricao = ? AND lotacao = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, cafe.getDescricao());
            prepstatement.setInt(2, cafe.getLotacao());
            ResultSet result = sqlcon.ler();
            while (result.next()){
                cafe.setPkcafe(result.getInt("pkcafe"));
                pk = result.getInt("pkcafe");
            }
        } catch(Exception e){
            
        } finally{
            sqlcon.close();
        }
        return pk;
    }
    
    private boolean atingiuLimite() {
        MySQLcon sqlcon = new MySQLcon();
        int retorno = 0;
        try{
            String sql = "Select COUNT(*) FROM CAFE";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            ResultSet result = sqlcon.ler();
            while (result.next()){
                retorno = Integer.parseInt(result.getString(1));               
            }
            sqlcon.close();
        } catch(Exception e){

        } finally {
            sqlcon.close();
        }
        return retorno == 2;
    }
    
    public Cafe buscacafePelaPk(int pk){
        MySQLcon sqlcon = new MySQLcon();
        Cafe cafe = new Cafe();
        try{
            String sql = "select * from Cafe where pkcafe = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setInt(1, pk);
            ResultSet result = sqlcon.ler();
            while (result.next()){
                cafe.setPkcafe(Integer.parseInt(result.getString("pkcafe")));
                cafe.setDescricao(result.getString("Descricao"));
                cafe.setLotacao(Integer.parseInt(result.getString("Lotacao")));
            }
            
        } catch(Exception e){

        } finally{
            sqlcon.close();
        }
        return cafe;
    }
}
