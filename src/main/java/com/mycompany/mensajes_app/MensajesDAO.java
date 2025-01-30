/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jo
 */
public class MensajesDAO {
    
    public static void crearMEnsajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje,autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");
            } catch (Exception ex) {
                 System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void leerMensajesDB(){
         Conexion db_conection = new Conexion();
         PreparedStatement ps = null;
             ResultSet rs = null;
         try(Connection conexion = db_conection.get_connection()) {
            String query = "SELECT * FROM mensajes";
             ps = conexion.prepareStatement(query);
             rs = ps.executeQuery();
             
             while(rs.next()){
                 System.out.println(
                         "ID " + rs.getInt("id_mensaje") +
                         " Mensaje " + rs.getString("mensaje") + 
                         " Autor " + rs.getString("autor_mensaje") +
                         " Fecha " + rs.getString("fecha_mensaje"));
             }
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_conection = new Conexion();
        try(Connection conexion = db_conection.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes WHERE mensajes.id_mensaje = ?";
                ps = conexion.prepareCall(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("Mensaje borrado");
            }catch (Exception ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje) {
        Conexion db_connection = new Conexion();
        try(Connection conexion = db_connection.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE mensajes.id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se actualizo");
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
}
