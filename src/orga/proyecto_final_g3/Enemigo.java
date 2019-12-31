/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.proyecto_final_g3;

import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Samuel
 */
public class Enemigo extends Thread {

    JLabel[][] lbl_bbman = null;
    JPanel panel = null;
    ArrayList<Personaje> bloques = null;
    Personaje enemigo = null;

    public Enemigo(JLabel[][] lbl_bbman, JPanel panel, ArrayList<Personaje> bloques, int x, int y) {
        this.lbl_bbman = lbl_bbman;
        this.panel = panel;
        this.bloques = bloques;
        enemigo = new Personaje(x, y);
    }

    public boolean ver_siguiente(int dir, int x, int y) {
        boolean estado = true;
        for (int i = 0; i < bloques.size(); i++) {
            if ((bloques.get(i).getX() == x + dir && bloques.get(i).getY() == y)) {
                estado = false;
            }
        }
        return estado;
    }

    @Override
    public void run() {
        int dir = 0;
        while (true) {
            if (dir == 0) {
                if (enemigo.getX() + 1 < 12 && ver_siguiente(1, enemigo.getX(), enemigo.getY())) {
                    enemigo.setX(enemigo.getX() + 1);
                } else {
                    dir = 1;
                }
            } else {
                if (enemigo.getX() - 1 > -1 && ver_siguiente(-1, enemigo.getX(), enemigo.getY())) {
                    enemigo.setX(enemigo.getX() - 1);
                } else {
                    dir = 0;
                }
            }

            ImageIcon img_bomba = new ImageIcon(getClass().getResource("/img/enemigo.gif"));
            Icon fd_bomba = new ImageIcon(img_bomba.getImage().getScaledInstance(lbl_bbman[enemigo.getX()][enemigo.getY()].getWidth(),
                    lbl_bbman[enemigo.getX()][enemigo.getY()].getHeight(), Image.SCALE_DEFAULT));
            lbl_bbman[enemigo.getX()][enemigo.getY()].setIcon(fd_bomba);
            try {
                sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(Enemigo.class.getName()).log(Level.SEVERE, null, ex);
            }
            lbl_bbman[enemigo.getX()][enemigo.getY()].setIcon(null);
            
        }

        //To change body of generated methods, choose Tools | Templates.
    }

}
