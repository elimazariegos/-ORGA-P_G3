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
public class Bomba extends Thread {

    JLabel[][] lbl_bbman = null;
    ArrayList<Personaje> bloques = null;
    Personaje bomba = null;
    Personaje personaje = null;
    JPanel panel = null;
    JLabel v1, v2, v3;
    ArrayList<Enemigo> enemigos;
    
    
    public Bomba(JLabel[][] lbl_bbman, ArrayList<Personaje> bloques, ArrayList<Enemigo> enemigos, JPanel panel,
            Personaje personaje, int x, int y, JLabel v1, JLabel v2, JLabel v3) {
        
        this.lbl_bbman = lbl_bbman;
        this.bloques = bloques;
        this.panel = panel;
        this.personaje = personaje;
        this.enemigos = enemigos;
        bomba = new Personaje(x, y);
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public void run() {

        ImageIcon img_bomba = new ImageIcon(getClass().getResource("/img/bomba.gif"));
        Icon fd_bomba = new ImageIcon(img_bomba.getImage().getScaledInstance(lbl_bbman[bomba.getX()][bomba.getY()].getWidth(),
                lbl_bbman[bomba.getX()][bomba.getY()].getHeight(), Image.SCALE_DEFAULT));

        lbl_bbman[bomba.getX()][bomba.getY()].setIcon(fd_bomba);
        lbl_bbman[bomba.getX()][bomba.getY()].setName("bb");
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bomba.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < bloques.size(); i++) {
            try {
                if (bloques.get(i) != null) {
                    if (bomba.getX() + 1 == bloques.get(i).getX() && bomba.getY() == bloques.get(i).getY()) {
                        lbl_bbman[bloques.get(i).getX()][bloques.get(i).getY()].setIcon(null);
                        bloques.remove(i);
                    }
                    if (bomba.getX() - 1 == bloques.get(i).getX() && bomba.getY() == bloques.get(i).getY()) {
                        lbl_bbman[bloques.get(i).getX()][bloques.get(i).getY()].setIcon(null);
                        bloques.remove(i);
                    }
                    if (bomba.getY() + 1 == bloques.get(i).getY() && bomba.getX() == bloques.get(i).getX()) {
                        lbl_bbman[bloques.get(i).getX()][bloques.get(i).getY()].setIcon(null);
                        bloques.remove(i);
                    }
                    if (bomba.getY() - 1 == bloques.get(i).getY() && bomba.getX() == bloques.get(i).getX()) {
                        lbl_bbman[bloques.get(i).getX()][bloques.get(i).getY()].setIcon(null);
                        bloques.remove(i);
                    }
                }
            } catch (Exception e) {

            }

        }

        if (bomba.getX() == personaje.getX() && bomba.getY() == personaje.getY()) {
            quitar_vida();
        }
        for (int i = 0; i < enemigos.size(); i++) {
            if(enemigos.get(i) != null){
                if(enemigos.get(i).getEnemigo().getX() == bomba.getX() && 
                        enemigos.get(i).getEnemigo().getY() == bomba.getY()){
                    enemigos.get(i).stop();
                    enemigos.remove(i);
                }
            }
        }
        lbl_bbman[bomba.getX()][bomba.getY()].setIcon(null);
        lbl_bbman[bomba.getX()][bomba.getY()].setName(null);
        panel.repaint();
    }

    public void quitar_vida() {
        if (personaje.getVidas() == 3) {
            v3.setIcon(null);
        } else if (personaje.getVidas() == 2) {
            v2.setIcon(null);
        }
        personaje.setVidas(personaje.getVidas() - 1);

    }
}
