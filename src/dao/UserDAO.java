/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usu21
 */
public class UserDAO {
    
    private Connection conexion;
    private void conectar(){
        try {
            String url ="jdbc:mysql://localhost:3306/mensajeria";
            String user = "root";
            String pass="jeveris";
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
