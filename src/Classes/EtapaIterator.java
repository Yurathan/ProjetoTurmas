/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DBConnect.MySQLcon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Bene
 */
public class EtapaIterator {
    
    public Etapa buscaEtapaPelaPk(int pk){
        MySQLcon sqlcon = new MySQLcon();
        Etapa etapa = new Etapa();
        try{
            String sql = "select * from etapa where pkEtapa = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setInt(1, pk);
            ResultSet result = sqlcon.ler();
            while (result.next()){
                etapa.setPkEtapa(Integer.parseInt(result.getString("pkEtapa")));
                etapa.setDescricao(result.getString("Descricao"));
            }
            
        } catch(Exception e){

        } finally{
            sqlcon.close();
        }
        return etapa;
    }        
}
