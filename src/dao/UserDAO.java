/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author usu21
 */
public class UserDAO {
    
    private Connection conexion;
    
    public void insertUser (User user) throws MyException{
        conectar();
        try {
           
            String insert = "insert into user values (?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, user.getUsername() );
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getSurname());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new MyException("Error al insertar: " +ex.getLocalizedMessage());
        }finally{
            desconectar();
        }
    }
    
    private void conectar() throws MyException{
        try {
            String url ="jdbc:mysql://localhost:3306/mensajeria";
            String user = "root";
            String pass="jeveris";
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            throw new MyException("Error al conectar " + ex.getLocalizedMessage());
        }
    }
    
    private void desconectar() throws MyException{
        try{
            conexion.close();
        }catch (SQLException ex){
            throw new MyException("Error al desconectar " +ex.getLocalizedMessage());
        
        }
    }
    
}
