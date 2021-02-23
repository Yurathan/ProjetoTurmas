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
public class AlunoIterator {
    public void adicionaAluno(Alunos aluno) throws Exception{
        MySQLcon sqlcon = new MySQLcon();
        try{
            String sql = "Insert into Alunos(NomeCompleto) Values (?)";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, aluno.getNomeCompleto());
            sqlcon.executeupdate();
        } catch(Exception e){
            throw e;
        } finally {
            sqlcon.close();
        }
    }
    
    public void setaCafeParaAluno(int pkAluno, int pkCafe) throws Exception{
        MySQLcon sqlcon = new MySQLcon();
        try{
            String sql = "Update Alunos set Cafe_pkcafe = ? where pkAluno = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setInt(1, pkCafe);
            prepstatement.setInt(2, pkAluno);
            sqlcon.executeupdate();
        }catch(Exception e){
            
        }finally{
            sqlcon.close();
        }
           
    }
    
    public void alteraAluno(Alunos aluno) throws Exception{
        MySQLcon sqlcon = new MySQLcon();
        try{
            String sql = "Update Alunos set NomeCompleto = ? where pkAluno = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, aluno.getNomeCompleto());
            prepstatement.setInt(2, aluno.getPkAluno());
            sqlcon.executeupdate();
        } catch(Exception e) {
            throw e;
        }finally{
            sqlcon.close();
        }    
    }
    
    public Alunos buscaAlunoPeloNome(String nome){
        MySQLcon sqlcon = new MySQLcon();
        Alunos R = new Alunos();
        try{
            String sql = "SELECT pkAluno"+
                         "  FROM alunos"+
                         " WHERE Alunos.NomeCompleto LIKE %?%";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, nome);
            ResultSet resultset = sqlcon.ler();
            while (resultset.next()){
                R = buscaAlunoPelaPk(resultset.getInt("pkAluno"));
            }
        } catch(Exception e){
          return null;   
        }finally{
            sqlcon.close();
        }
        return R;
    }
    
    public Alunos buscaAlunoPelaPk(int pk){
        MySQLcon sqlcon = new MySQLcon();
        Alunos aluno = new Alunos();
        try{
            String sql = "select * from alunos where pkAluno = ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setInt(1, pk);
            ResultSet result = sqlcon.ler();
            while (result.next()){
                aluno.setPkAluno(Integer.parseInt(result.getString("pkAluno")));
                aluno.setNomeCompleto(result.getString("NomeCompleto"));
            }
            
        } catch(Exception e){

        } finally{
            sqlcon.close();
        }
        return aluno;
    }
    
    public Integer retornaPKnovoAluno(Alunos aluno) throws Exception{
        MySQLcon sqlcon = new MySQLcon();
        try{
            String sql = "Select pkAluno from alunos where NomeCompleto LIKE ?";
            PreparedStatement prepstatement = sqlcon.preparaSQL(sql);
            prepstatement.setString(1, aluno.getNomeCompleto());
            ResultSet result = sqlcon.ler();
            String retorno = "-1";
            while (result.next()){
                retorno = result.getString(1);               
            }
            sqlcon.close();
            return Integer.parseInt(retorno);
        } catch(Exception e){
            throw e;
        } finally {
            sqlcon.close();
        }       
    }
}
