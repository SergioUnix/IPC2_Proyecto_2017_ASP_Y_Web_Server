/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones.Administrador;

import Operaciones.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ariel
 */
public class empresa_agregar {
    
    
     
    public empresa_agregar(){
    }
    
    public boolean agregar(String nombre,int Patente) throws SQLException{
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        
   String insertTableSQL = "Insert into empresa (nombre,Patente)VALUES"+ "(?,?)";
   
     

        try {
            dbConnection = new conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
          
            
            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, Patente);
            preparedStatement.executeUpdate();
            dbConnection.close();

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
}
    
    
    
}