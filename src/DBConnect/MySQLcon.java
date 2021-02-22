/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnect;

/**
 *
 * @author Bene
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLcon {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private void criadb() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if  (connect == null)
                connect = DriverManager.getConnection("jdbc:mysql://localhost/controledeevento?"
                                                      + "user=root&password=");
        } catch(Exception e) {
            throw e;
        }
    }
    
    public PreparedStatement preparaSQL(String sql) throws Exception{
        try {
            criadb();
            preparedStatement = connect.prepareStatement(sql);
            return preparedStatement;
        } catch(Exception e){
            throw e;
        }
    }
    
    public void executeupdate() throws Exception {
        try {
            if  (!preparedStatement.isClosed()) {
                preparedStatement.executeUpdate();
            }
        } catch(Exception e){
            throw e;
        } finally{
            close();
        }
    }
    
    public ResultSet ler() throws Exception{
        try {
            criadb();
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch(Exception e) {
            throw e;
        }
    }
    
    // You need to close the resultSet
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
    
}
