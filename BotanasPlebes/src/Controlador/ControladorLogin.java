/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bean.BeanUsuarios;
import Modelo.ModeloUsuarios;
import Vista.PrincipalAdministrador;
import Vista.login.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorLogin implements ActionListener{
    Login login=new Login();
    ModeloUsuarios modeloUsuarios=new ModeloUsuarios();
    
    public ControladorLogin(Login login, ModeloUsuarios modeloUsuarios){
        this.login=login;
        this.modeloUsuarios=modeloUsuarios;
        this.login.btnIniciar.addActionListener(this);
    }
    
    public void iniciarLogin(){
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login.btnIniciar){
            if(validarFormulario()){
                String usuario=login.txtUsuario.getText();
                String password=login.txtPassword.getText();
                int idUsuario=modeloUsuarios.validarCredenciales(usuario, password);
                if(idUsuario>0){
                    BeanUsuarios beanUsuarios=modeloUsuarios.buscarUsuario(idUsuario);
                    PrincipalAdministrador principalAdministrador=new PrincipalAdministrador();
                    ControladorPrincipalAdministrador controladorPrincipalAdministrador=new ControladorPrincipalAdministrador(principalAdministrador);
                    controladorPrincipalAdministrador.iniciarPrincipalAdministrador();
                    login.dispose();
//                    JOptionPane.showMessageDialog(login, "ID: "+beanUsuarios.getIdUsuario()+"  USUARIO: "+beanUsuarios.getUsuario()+"  TIPO: "+beanUsuarios.getTipoUsuario());
                }else{
                    login.lblInfo.setText("¡ USUARIO O CONTRASEÑA INCORRECTOS !");
                    login.txtUsuario.requestFocus();
                }
            }else{
                login.lblInfo.setText("¡ USUARIO Y CONTRASEÑA REQUERIDOS !");
                login.txtUsuario.requestFocus();
            }
        }
    }
    
    public boolean validarFormulario(){
        boolean respuesta=true;
        String usuario=login.txtUsuario.getText();
        String password=login.txtPassword.getText();
        if(usuario.equals("")||password.equals("")){
            respuesta=false;
        }
        return respuesta;
    }
}
