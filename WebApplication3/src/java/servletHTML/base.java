/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletHTML;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Kemry
 */
public class base {
    Connection con = null;
    Statement state;
    ResultSet res;
    
    public base(){
        
    }
    public void conecta(){
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost/Lab3","root","JAKETHEDOG1234");
        System.out.println("conectado");
        
        }catch(Exception e){
            System.out.print("no conectado");
        }
    }
    public void cierra() throws SQLException{
        con.close();
    }
    public int update(String update) throws SQLException{
        state = con.createStatement();
        return state.executeUpdate(update);
    }
    public ResultSet query(String query) throws SQLException{
        state = con.createStatement();
        return state.executeQuery(query);
    }
}