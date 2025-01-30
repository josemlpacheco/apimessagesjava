/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author jo
 */
public class mensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String msj = sc.nextLine();
        System.out.println("Escribe el autor del mensaje");
        String autor = sc.nextLine();
        Mensajes msjOb = new Mensajes();
        msjOb.setMensaje(msj);
        msjOb.setAutor_mensaje(autor);
        
        MensajesDAO.crearMEnsajeDB(msjOb);
    }
    public static void listarMensajes(){
    MensajesDAO.leerMensajesDB();
    }
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el id del mensaje");
        int id_msj = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_msj);
    }
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el mensaje");
        String msj = sc.nextLine();
        System.out.println("Escribe el id del mensaje");
        int id_msj = sc.nextInt();
        Mensajes mensaje = new Mensajes();
        mensaje.setId_mensaje(id_msj);
        mensaje.setMensaje(msj);
        MensajesDAO.actualizarMensajeDB(mensaje);
    }
}
