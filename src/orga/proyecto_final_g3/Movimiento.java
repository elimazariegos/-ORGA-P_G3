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

/**
 *
 * @author Samuel
 */
public class Movimiento extends Thread {

    char direccion = ' ';
    JLabel[][] lbl_bbman = null;
    Personaje personaje = new Personaje(0, 0);
    ArrayList<Personaje> bloques = null;

    public Movimiento(JLabel[][] lbl_bbman, ArrayList<Personaje> bloques, char direccion, Personaje personaje) {
        this.lbl_bbman = lbl_bbman;
        this.bloques = bloques;
        this.direccion = direccion;
        this.personaje = personaje;
    }

    @Override
    public void run() {
        ImageIcon img_personaje = new ImageIcon(getClass().getResource("/img/personaje.png"));
        Icon fd_personaje = new ImageIcon(img_personaje.getImage().getScaledInstance(lbl_bbman[personaje.getX()][personaje.getY()].getWidth(),
                lbl_bbman[personaje.getX()][personaje.getY()].getHeight(), Image.SCALE_DEFAULT));

        if (direccion == 'U') {
            if (ver_siguiente('y', -1, personaje.getX(), personaje.getY()) == true) {
                if (personaje.getY() - 1 > -1) {
                    personaje.setX(personaje.getX());
                    personaje.setY(personaje.getY() - 1);
                    if (lbl_bbman[personaje.getX()][personaje.getY() + 1].getName() == null) {
                        lbl_bbman[personaje.getX()][personaje.getY() + 1].setIcon(null);
                    }
                    lbl_bbman[personaje.getX()][personaje.getY()].setIcon(fd_personaje);
                }
            }
        } else if (direccion == 'D') {
            if (ver_siguiente('y', 1, personaje.getX(), personaje.getY()) == true) {
                if (personaje.getY() + 1 < 12) {
                    personaje.setX(personaje.getX());
                    personaje.setY(personaje.getY() + 1);
                    if (lbl_bbman[personaje.getX()][personaje.getY() - 1].getName() == null) {
                        lbl_bbman[personaje.getX()][personaje.getY() - 1].setIcon(null);
                    }
                    lbl_bbman[personaje.getX()][personaje.getY()].setIcon(fd_personaje);
                }
            }
        } else if (direccion == 'L') {
            if (ver_siguiente('x', -1, personaje.getX(), personaje.getY()) == true) {
                if (personaje.getX() - 1 > -1) {
                    personaje.setX(personaje.getX() - 1);
                    personaje.setY(personaje.getY());
                    if (lbl_bbman[personaje.getX() + 1][personaje.getY()].getName() == null) {
                        lbl_bbman[personaje.getX() + 1][personaje.getY()].setIcon(null);
                    }
                    lbl_bbman[personaje.getX()][personaje.getY()].setIcon(fd_personaje);
                }
            }
        } else if (direccion == 'R') {
            if (ver_siguiente('x', 1, personaje.getX(), personaje.getY()) == true) {
                if (personaje.getX() + 1 < 12) {
                    personaje.setX(personaje.getX() + 1);
                    personaje.setY(personaje.getY());
                    if(lbl_bbman[personaje.getX() - 1][personaje.getY()].getName() == null){
                        lbl_bbman[personaje.getX() - 1][personaje.getY()].setIcon(null);
                    }
                    lbl_bbman[personaje.getX()][personaje.getY()].setIcon(fd_personaje);
                }
            }
        }

        try {
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean ver_siguiente(char xoy, int dir, int x, int y) {
        boolean estado = true;
        for (int i = 0; i < bloques.size(); i++) {
            if (xoy == 'x') {
                if ((bloques.get(i).getX() == x + dir && bloques.get(i).getY() == y)) {
                    estado = false;
                }
            } else {
                if ((bloques.get(i).getY() == y + dir && bloques.get(i).getX() == x)) {
                    estado = false;
                }

            }
        }
        return estado;
    }

}
