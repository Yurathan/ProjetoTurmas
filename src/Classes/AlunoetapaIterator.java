/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DBConnect.MySQLcon;
import java.sql.PreparedStatement;

/**
 *
 * @author Bene
 */
public class AlunoetapaIterator {
    MySQLcon sqlcon = new MySQLcon();
    
    public void LigaAlunaASalaEFase(int pkALuno, int pkEtapa, int pkSala){
        try{
            String sql = "Insert into Alunos_has_etapa(fkAluno, fkEtapa, fkSala) Values (?,?,?)";
            MySQLcon sqlcon = new MySQLcon();
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setInt(1, pkALuno);
            prepstatement.setInt(2, pkEtapa);
            prepstatement.setInt(3, pkSala);
            sqlcon.executeupdate();
        } catch(Exception e){

        } finally {
            sqlcon.close();
        }        
    }
}
