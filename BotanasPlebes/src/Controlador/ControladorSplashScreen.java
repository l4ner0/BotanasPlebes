/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.ModeloUsuarios;
import Vista.login.Login;
import Vista.splash.SplashScreen;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorSplashScreen {
    SplashScreen splashScreen=new SplashScreen();
    
    public ControladorSplashScreen( SplashScreen splashScreen){
        this.splashScreen=splashScreen;
    }
    
    public void iniciarSplashScreen(){
        splashScreen.setVisible(true);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        Login login=new Login();
        ModeloUsuarios modeloUsuarios=new ModeloUsuarios();
        ControladorLogin controladorLogin=new ControladorLogin(login, modeloUsuarios);
        controladorLogin.iniciarLogin();      
    }
}
