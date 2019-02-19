/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.PrincipalAdministrador;
import Vista.alertas.WarningAlertSalir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorPrincipalAdministrador implements ActionListener{
    
    PrincipalAdministrador principalAdministrador=new PrincipalAdministrador();
    
    public ControladorPrincipalAdministrador(PrincipalAdministrador principalAdministrador){
        this.principalAdministrador=principalAdministrador;
        this.principalAdministrador.btnVentas.addActionListener(this);
        this.principalAdministrador.btnProductos.addActionListener(this);
        this.principalAdministrador.btnGastos.addActionListener(this);
        this.principalAdministrador.btnUsuarios.addActionListener(this);
        this.principalAdministrador.btnAbout.addActionListener(this);
        this.principalAdministrador.btnCerrarSesion.addActionListener(this);
    }
    
    public void iniciarPrincipalAdministrador(){
        principalAdministrador.setLocationRelativeTo(null);
        principalAdministrador.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==principalAdministrador.btnVentas){
            JOptionPane.showMessageDialog(principalAdministrador, "Le desite a ventas");
        }
        
        if(e.getSource()==principalAdministrador.btnProductos){
            JOptionPane.showMessageDialog(principalAdministrador, "Le desite a productos");
        }
        
        if(e.getSource()==principalAdministrador.btnGastos){
            JOptionPane.showMessageDialog(principalAdministrador, "Le desite a gastos");
        }
        
        if(e.getSource()==principalAdministrador.btnUsuarios){
            JOptionPane.showMessageDialog(principalAdministrador, "Le desite a usuarios");
        }
        
        if(e.getSource()==principalAdministrador.btnAbout){
            JOptionPane.showMessageDialog(principalAdministrador, "Le desite a acerca de");
        }
        
        if(e.getSource()==principalAdministrador.btnCerrarSesion){
            WarningAlertSalir wa = new WarningAlertSalir(principalAdministrador, true);
            wa.titulo.setText("¿ESTAS SEGURO?");
            wa.msj.setText("SE CERRARA LA SESIÓN ACTUAL");
            wa.msj1.setText("");
            wa.setVisible(true);

            if (WarningAlertSalir.salir) {
                System.exit(0);
            }
        }
    }
}
