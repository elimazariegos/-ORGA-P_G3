/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.proyecto_final_g3;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Samuel
 */
public class PrincipalBBMAN extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalBBMAN
     */
    Personaje personaje = new Personaje(0, 0);
    Personaje llave = new Personaje(9, 9);

    Personaje bomba = null;
    ArrayList<Personaje> bloques = new ArrayList<>();
    ArrayList<Enemigo> enemigos = new ArrayList();

    JLabel[][] lbl_bbman = new JLabel[12][12];
    int[][] logic_bbman = new int[12][12];
    ImageIcon img_bloque = new ImageIcon(getClass().getResource("/img/bloque.png"));
    ImageIcon img_personaje = new ImageIcon(getClass().getResource("/img/quieto.gif"));
    ImageIcon img_vida = new ImageIcon(getClass().getResource("/img/vida.png"));

    int numero_bloques = 50;

    public PrincipalBBMAN() {
        initComponents();
        Icon fd_bomba = new ImageIcon(img_vida.getImage().getScaledInstance(v1.getWidth(),
                v1.getHeight(), Image.SCALE_DEFAULT));
        v1.setIcon(fd_bomba);
        v2.setIcon(fd_bomba);
        v3.setIcon(fd_bomba);

        for (int i = 0; i < numero_bloques; i++) {

            int random_x = (int) (Math.random() * 12) + 1;
            int random_y = (int) (Math.random() * 12) + 1;

            if (random_x != personaje.getX() && random_y != personaje.getY()) {
                bloques.add(new Personaje(random_x, random_y));
            }
        }

        bloques.add(new Personaje(llave.getX(), llave.getY()));
        pintar();
        for (int i = 1; i < 10; i++) {
            Enemigo ene = new Enemigo(lbl_bbman, panel, bloques, i, i);
            ene.start();
            enemigos.add(ene);
        }
        Salida_Binaria bin = new Salida_Binaria(lbl_bbman);
        bin.start();

    }

    public void pintar() {
        for (int i = 0; i < lbl_bbman.length; i++) {
            for (int j = 0; j < lbl_bbman[0].length; j++) {
                Border border = LineBorder.createGrayLineBorder();
                JLabel lbl_pos = new JLabel();
                lbl_pos.setBounds(40 * i, 40 * j, 40, 40);
                lbl_pos.setBorder(border);
                if (j == personaje.getY() && i == personaje.getX()) {
                    logic_bbman[i][j] = 1;
                    Icon fd_personaje = new ImageIcon(img_personaje.getImage().getScaledInstance(lbl_pos.getWidth(),
                            lbl_pos.getHeight(), Image.SCALE_DEFAULT));
                    lbl_pos.setIcon(fd_personaje);

                } else if (j == llave.getY() && i == llave.getX()) {
                    logic_bbman[i][j] = 1;
                } else {
                    logic_bbman[i][j] = 0;
                }
                for (int k = 0; k < bloques.size(); k++) {
                    if (j == bloques.get(k).getY() && i == bloques.get(k).getX()) {
                        logic_bbman[i][j] = 1;
                        Icon fd_bloque = new ImageIcon(img_bloque.getImage().getScaledInstance(lbl_pos.getWidth(),
                                lbl_pos.getHeight(), Image.SCALE_DEFAULT));
                        lbl_pos.setIcon(fd_bloque);
                    }
                }
                lbl_pos.setName(null);

                lbl_bbman[i][j] = lbl_pos;
                panel.add(lbl_bbman[i][j]);
            }
        }
        panel.repaint();
    }

    public void poner_bomba() throws InterruptedException {
        Bomba bomba = new Bomba(lbl_bbman, bloques, enemigos,panel, personaje, personaje.getX(), personaje.getY(), v1, v2, v3);
        bomba.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        v1 = new javax.swing.JLabel();
        v2 = new javax.swing.JLabel();
        v3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(v1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(v2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(v3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(v1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(v2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(v3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelKeyPressed
        System.out.println("ASAS");
    }//GEN-LAST:event_panelKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_W) {
            Movimiento up = new Movimiento(lbl_bbman, bloques, 'U', personaje);
            up.start();
        }
        if (evt.getKeyCode() == KeyEvent.VK_S) {
            Movimiento down = new Movimiento(lbl_bbman, bloques, 'D', personaje);
            down.start();
        }
        if (evt.getKeyCode() == KeyEvent.VK_A) {
            Movimiento left = new Movimiento(lbl_bbman, bloques, 'L', personaje);
            left.start();
        }
        if (evt.getKeyCode() == KeyEvent.VK_D) {
            Movimiento down = new Movimiento(lbl_bbman, bloques, 'R', personaje);
            down.start();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F) {
            System.out.println("bumb");
            try {
                poner_bomba();
            } catch (InterruptedException ex) {
                Logger.getLogger(PrincipalBBMAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalBBMAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalBBMAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalBBMAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalBBMAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalBBMAN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private javax.swing.JLabel v1;
    private javax.swing.JLabel v2;
    private javax.swing.JLabel v3;
    // End of variables declaration//GEN-END:variables
}
