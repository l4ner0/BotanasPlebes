/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Bean.BeanUsuarios;
import Util.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ModeloUsuarios {
    Connection cn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
   public int validarCredenciales(String usuario, String pass) {
       int idUsuario=-1;
        try {
            Conexion conexion=new Conexion();
            cn=conexion.getConexion();
           try (CallableStatement cst = cn.prepareCall("{call ValidarCredenciales(?,?)}")) {
               cst.setString(1, usuario);
               cst.setString(2, pass);
               rs=cst.executeQuery();
               if(rs.next()){
                    idUsuario=rs.getInt(1);
               }
           }
            cn.close();
            cn=null;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return idUsuario;
    }
   
   public BeanUsuarios buscarUsuario(int idUsuario){
       BeanUsuarios objUsuarios=new BeanUsuarios();
       try {
            Conexion conexion=new Conexion();
            cn=conexion.getConexion();
           try (CallableStatement cst = cn.prepareCall("{call BuscarUsuario(?)}")) {
               cst.setInt(1, idUsuario);
               rs=cst.executeQuery();
               if(rs.next()){
                    objUsuarios.setIdUsuario(rs.getInt(1));
                    objUsuarios.setUsuario(rs.getString(2));
                    objUsuarios.setTipoUsuario(rs.getString(4));
               }
           }
            cn.close();
            cn=null;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
       return objUsuarios;
   }
   
   /*
    public static void main(String[] args){
        ModeloUsuarios modelo=new ModeloUsuarios();
        BeanUsuarios usuarios=new BeanUsuarios();
        int idUsuario=modelo.validarCredenciales("diego", "1d234");
        usuarios=modelo.buscarUsuario(idUsuario);
        System.out.println("ID:"+usuarios.getIdUsuario()+"  USUARIO: "+usuarios.getUsuario()+"  TIPO: "+usuarios.getTipoUsuario());
        
    }*/
}
