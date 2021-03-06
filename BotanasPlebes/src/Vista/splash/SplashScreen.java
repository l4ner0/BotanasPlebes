/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.splash;

import Controlador.ControladorLogin;
import Modelo.ModeloUsuarios;
import Vista.alertas.AWTUtilities;
import Vista.alertas.FadeEffect;
import Vista.login.Login;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Rojeru San
 */
public class SplashScreen extends javax.swing.JFrame implements Runnable {
    private Thread tiempo = null;

    /**
     * Creates new form Splash
     */
    public SplashScreen() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Vista/imgSplash/logo-icono.png")).getImage());
        this.setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrame(this, 50, 0.1f);
        tiempo = new Thread(this);
        tiempo.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imgSplash/logo-splash.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {     
            Thread.sleep(6000);
            FadeEffect.fadeOutFrameSplash(this, 50, 0.1f);
        } catch (InterruptedException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
