
/*
 * Splash.java
 *
 * 
 */
package com.syscv.utd.presentacion;

import com.syscv.utd.recursos.JPColor;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;


/**
 *
 * @author jarteaga
 */
public class Splash extends javax.swing.JFrame implements Runnable{

   Thread hilo;
   
   int num = 0;
  
    public Splash() 
    {
        initComponents();
        Color c1 = new Color(66,111,166);
        Color c2 = new Color(102,174,118);
        JPColor jpmicolor = new JPColor(c1,c2);
        jpmicolor.setSize(this.getSize());        
        jPanel1.add(jpmicolor); 
        
        
    }
    
     @SuppressWarnings("unchecked")
    @Override
    public Image getIconImage() 
      {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("com/syscv/utd/recursos/icono_1.png"));
        return retValue;
    }
 
     public void progresoBarra() {
    while (num < 1000) {
      jPB_barra.setValue(num);
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
      }
      num += 100;
    }
    
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPB_barra = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Control de Vehiculos - UTDVVCC versión (1.0)");
        setIconImage(getIconImage());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPB_barra.setMaximum(1000);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Sistema Control Vehiculos");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("V.1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("SCV  esta cargando,espere por favor.........");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPB_barra, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(214, 214, 214))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPB_barra, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void run()
{
    this.setLocationRelativeTo(null);
    this.setVisible(true);
        try {
            progresoBarra();
            hilo.sleep(700);
            this.dispose();
            
            MDIPrincipal principal = new MDIPrincipal(); // Inicializa la ventana con los menús de la aplicación
            principal.setLocationRelativeTo(null);
            principal.setVisible(false);//Frame Principal No arranca visible
            principal.setExtendedState(JFrame.MAXIMIZED_BOTH);//Frame toma el tramaño de la resolución de la pantalla
            principal.iniciarSistema();
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
          catch (Exception ex) {
            ex.printStackTrace(); // Registra en la salida de linea de comandos, si hay un error en la inicialización del sistema
        }
}



    public static void main(String args[]) throws ParseException {
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;");
                    break;
                }
            }
            UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jPB_barra;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
    
}
