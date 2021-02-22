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
public class SalaInterator {
    MySQLcon sqlcon = new MySQLcon();
    public void adicionaSala(Salas sala){
        MySQLcon sqlcon = new MySQLcon();
        if  (atingiuLimite()){
            JOptionPane.showMessageDialog(null, "A quantidade de áreas de evento atingiu o máximo (2).");
            return;
        }
        
        try{
            String sql = "Insert INTO Salas(Descricao, Lotacao) Values ( ?, ?)";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, sala.getDescrição());
            prepstatement.setInt(2, sala.getLotação());
            sqlcon.executeupdate();
        }catch(Exception e){
            
        } finally {
            sqlcon.close();
        }        
    }
    
    
    private boolean atingiuLimite() {
        int retorno = 0;
        try{
            String sql = "Select COUNT(*) FROM Salas";
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
    
        public int buscaPKsala(Salas sala){
        MySQLcon sqlcon = new MySQLcon();
        int pk = 0;
        try{
            String sql = "SELECT pkSala FROM Salas WHERE Descricao LIKE ? AND lotacao = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, sala.getDescrição());
            prepstatement.setInt(2, sala.getLotação());
            ResultSet result = sqlcon.ler();
            while (result.next()){
                sala.setPkSala(result.getInt("pksala"));
                pk = result.getInt("pksala");
            }
        } catch(Exception e){
            
        } finally{
            sqlcon.close();
        }
        return pk;
    }
        
    public void alteraSala(Salas sala){
        MySQLcon sqlcon = new MySQLcon();
        try{
            String sql = "UPDATE Salas set descricao = ?, lotacao = ? where pkSala = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, sala.getDescrição());
            prepstatement.setInt(2, sala.getLotação());
            prepstatement.setInt(3, sala.getPkSala());
            sqlcon.executeupdate();
        }catch(Exception e){
            
        }finally{
            sqlcon.close();
        }
    }
    
        public Salas buscaSalaPelaPk(int pk){
        MySQLcon sqlcon = new MySQLcon();
        Salas sala = new Salas();
        try{
            String sql = "select * from Salas where pkSala = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setInt(1, pk);
            ResultSet result = sqlcon.ler();
            while (result.next()){
                sala.setPkSala(Integer.parseInt(result.getString("pkSala")));
                sala.setDescrição(result.getString("Descricao"));
                sala.setLotação(Integer.parseInt(result.getString("Lotacao")));
            }
            
        } catch(Exception e){

        } finally{
            sqlcon.close();
        }
        return sala;
    }
}
