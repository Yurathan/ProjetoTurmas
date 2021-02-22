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
public class DistribuidorIterator {
        
    int QuantidadeAlunosSala1 = 0; 
    int QuantidadeAlunosSala2 = 0;
    AlunoetapaIterator alunoeetapaiterator = new AlunoetapaIterator();
    
    public boolean IsValidoAlunosELotacaoMaxima(){
        MySQLcon sqlcon = new MySQLcon();
        int quantidadeAlunos = 0;
        int lotacaoSalas = 0;
        int lotacaocafe = 0;
        //obtem dados
        try{
            String sql = "Select COUNT(*) from Alunos";
            PreparedStatement alunostatement = sqlcon.preparaSQL(sql);
            ResultSet result = sqlcon.ler();
            while (result.next()){
                quantidadeAlunos = Integer.parseInt(result.getString(1));               
            }
            sqlcon.close();
            String sql2 = "Select SUM(Lotacao) FROM Salas";
            PreparedStatement salastatement = sqlcon.preparaSQL(sql2);
            result = sqlcon.ler();
            while (result.next()){
                lotacaoSalas = Integer.parseInt(result.getString(1));
            }
            sqlcon.close();
            String sql3 = "select SUM(lotacao) FROM cafe";
            PreparedStatement cafestatement = sqlcon.preparaSQL(sql3);
            result = sqlcon.ler();
            while (result.next()){
                lotacaocafe = Integer.parseInt(result.getString(1));
            }
        } catch(Exception e){

        } finally {
            sqlcon.close();
        }
        //processo de validação
        if  (quantidadeAlunos > lotacaoSalas){
            JOptionPane.showMessageDialog(null, "quantidade de alunos maior que a quantidade de lotação nas salas");
            return false;
        }
        
        if  (quantidadeAlunos > lotacaocafe){
            JOptionPane.showMessageDialog(null, "quantidade de alunos maior que a lotação das áreas de café");
            return false;
        }
        
        JOptionPane.showMessageDialog(null, "validação da quantidade de alunos vs lotação máxima está ok.");
        return true;
    }
    
    public boolean IsValidoDistribuiçãoPorLotacao(){
        //com base na regra de negócio solicitada no teste, a diferneça na quantidade de alunos entre sala é no máximo de 1
        MySQLcon sqlcon = new MySQLcon();
        int totalAlunos = 0;
        try{
            String sql = "Select COUNT(*) from Alunos";
            PreparedStatement alunostatement = sqlcon.preparaSQL(sql);
            ResultSet result = sqlcon.ler();
            while (result.next()){
                totalAlunos = result.getInt(1);
                float alunospsala = Float.parseFloat(result.getString(1));
                alunospsala = alunospsala/2;
                QuantidadeAlunosSala1 = Math.round(alunospsala);
                QuantidadeAlunosSala2 = (int) alunospsala;
            }
            sqlcon.close();
            String sql2 = "Select Descricao,Lotacao FROM Salas";
            PreparedStatement salastatement = sqlcon.preparaSQL(sql2);
            result = sqlcon.ler();
            int sala = 0;
            while (result.next()){
                sala ++;
                if  (sala == 1){
                    if  (QuantidadeAlunosSala1 > result.getInt(2)){
                        JOptionPane.showMessageDialog(null, "A lotação da sala " + result.getString(1) + " é inferior a quantidade necessária para alunos");
                        return false;
                    }
                }else{
                    if  (QuantidadeAlunosSala2 > result.getInt(2)){
                        JOptionPane.showMessageDialog(null, "A lotação da sala " + result.getString(1) + " é inferior a quantidade necessária para alunos");
                        return false;
                    }
                }
            }
            sqlcon.close();
            String sql3 = "select descricao,lotacao FROM cafe";
            PreparedStatement cafestatement = sqlcon.preparaSQL(sql3);
            result = sqlcon.ler();
            int cafe = 0;
            while (result.next()){
                cafe ++;
                if  (sala == 1){
                    if  (QuantidadeAlunosSala1 > result.getInt(2)){
                        JOptionPane.showMessageDialog(null, "A lotação da área de café " + result.getString(1) + " é inferior a quantidade necessária para alunos");
                        return false;
                    }
                }else{
                    if  (QuantidadeAlunosSala2 > result.getInt(2)){
                        JOptionPane.showMessageDialog(null, "A lotação da área de cafe " + result.getString(1) + " é inferior a quantidade necessária para alunos");
                        return false;
                    }
                }
            }
        } catch(Exception e){

        } finally {
            sqlcon.close();
        }        
        return true;
    }
    
    public void distribuiAlunosEntreCafe(){
        MySQLcon alunoscon = new MySQLcon();
        MySQLcon cafecon = new MySQLcon();
        AlunoInterator alunointeratator = new AlunoInterator();
        try{
            String sqlAluno = "Select pkAluno From Alunos";
            String sqlCafe = "Select pkCafe,Lotacao From Cafe";
            PreparedStatement alunosta = alunoscon.preparaSQL(sqlAluno);
            PreparedStatement cafesta = cafecon.preparaSQL(sqlCafe);
            ResultSet alunoR = alunoscon.ler();
            ResultSet cafeR = cafecon.ler();
            
            int cntaluno = 0;
            
            while (cafeR.next()){
                cntaluno = 0;
                while (alunoR.next()){                
                    cntaluno ++;
                    alunointeratator.setaCafeParaAluno(alunoR.getInt(1), cafeR.getInt("pkCafe"));
                    if  (cntaluno > cafeR.getInt("Lotacao")){
                        break;
                    }
                    if  (cntaluno > QuantidadeAlunosSala1){
                        break;
                    }
                }
            }
        }catch(Exception e){
            
        }finally{
            alunoscon.close();
            cafecon.close();
        }
    }
    
    public void distribuiAlunosEntreSalas(){
        MySQLcon etapacon = new MySQLcon();
        MySQLcon salacon = new MySQLcon();
        MySQLcon alunocon = new MySQLcon();
        try{
            //carrega dados
            String sqletapa = "SELECT  pkEtapa FROM Etapa";
            String sqlsala = "SELECT pkSala FROM Salas";
            String sqlAluno = "Select pkAluno From Alunos";
            
            PreparedStatement etapaStatement = etapacon.preparaSQL(sqletapa);
            PreparedStatement salaStatement = salacon.preparaSQL(sqlsala);
            PreparedStatement alunoStatement = alunocon.preparaSQL(sqlAluno);
            
            ResultSet etapaR = etapacon.ler();
            ResultSet salaR = salacon.ler();
            ResultSet alunoR = alunocon.ler();
            
            int pksala1 = 0;
            int pksala2 = 0;
            int etapa = 0;
            int sala = 0;
            int cntaluno = 0;
            int alunodistribuido = 0;
            while (etapaR.next()){
                etapa ++;
                if  (etapa == 2) {
                    alunoR.beforeFirst();
                }
                while(salaR.next()){
                    sala ++;
                    if  (sala == 1){
                        pksala1 = salaR.getInt(1);
                    }else{
                        pksala2 = salaR.getInt(1);
                    }
                    alunodistribuido = 0;
                    cntaluno = 0;
                    if  (etapa == 1){
                        while(alunoR.next()){
                            alunodistribuido ++;
                            alunoeetapaiterator.LigaAlunaASalaEFase(alunoR.getInt(1), salaR.getInt(1), etapaR.getInt(1));
                            if  (sala == 1){
                                if  (QuantidadeAlunosSala1 == alunodistribuido){
                                    break;
                                }
                            }else{
                                if  (QuantidadeAlunosSala2 == alunodistribuido){
                                    break;
                                }
                            }
                        }    
                    }else{
                        while(alunoR.next()){
                            cntaluno++;
                            if  (sala == 1) {
                                if  (cntaluno <= (Math.round(QuantidadeAlunosSala1/2))){
                                    alunoeetapaiterator.LigaAlunaASalaEFase(alunoR.getInt(1), etapaR.getInt(1), pksala1);
                                }else{
                                    alunoeetapaiterator.LigaAlunaASalaEFase(alunoR.getInt(1), etapaR.getInt(1), pksala2);                            
                                }
                                if  (cntaluno == QuantidadeAlunosSala1) break;
                            }else{
                                if  (cntaluno <= (int)(QuantidadeAlunosSala2/2)){
                                    alunoeetapaiterator.LigaAlunaASalaEFase(alunoR.getInt(1), etapaR.getInt(1), pksala1);
                                }else{
                                    alunoeetapaiterator.LigaAlunaASalaEFase(alunoR.getInt(1), etapaR.getInt(1), pksala2);
                                }
                            }
                        }
                    }
                }
            }
        }catch(Exception e){
            
        }finally{
            etapacon.close();
            salacon.close();
            alunocon.close();
        }
    }
}
