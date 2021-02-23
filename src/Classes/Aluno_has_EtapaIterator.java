/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DBConnect.MySQLcon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Bene
 */
public class Aluno_has_EtapaIterator {
    
    public AlunosHasEtapa buscaLigaçãoPeloAluno(int pkAluno){
        MySQLcon conn = new MySQLcon();
        AlunosHasEtapa Resultado = new AlunosHasEtapa();
        try{
            String SQL = "SELECT fkAluno, fkEtapa, fkSala FROM Alunos_has_Etapa where fkAluno = ?";
            PreparedStatement prepstatement = conn.preparaSQL(SQL);
            prepstatement.setInt(1, pkAluno);
            ResultSet r = conn.ler();
            while (r.next()){
                Resultado.fkAluno = r.getInt("fkAluno");
                Resultado.fkEtapa = r.getInt("fkEtapa");
                Resultado.fkSala = r.getInt("fkSala");
            }
        }catch(Exception e){
            return null;
        }finally{
            conn.close();
        }
        return Resultado;
    }
    
}
