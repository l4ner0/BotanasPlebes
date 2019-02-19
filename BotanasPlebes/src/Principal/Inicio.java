/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controlador.ControladorSplashScreen;
import Vista.splash.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Usuario
 */
public class Inicio {
    public static void main(String[] args) {
        if(new Modelo.Control().comprobar()){
            SplashScreen splashScreen=new SplashScreen();
            String s = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
            try {
                javax.swing.UIManager.setLookAndFeel(s);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            ControladorSplashScreen controladorSplashScreen=new ControladorSplashScreen(splashScreen);
            controladorSplashScreen.iniciarSplashScreen();
        }else{
            System.exit(0);
        }
    }
}
