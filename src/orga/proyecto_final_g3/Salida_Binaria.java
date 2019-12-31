/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.proyecto_final_g3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Samuel
 */
public class Salida_Binaria extends Thread {

    JLabel[][] lbl_bbman = null;
    int[][] binaria = new int[12][12];

    public Salida_Binaria(JLabel[][] lbl_bbman) {
        this.lbl_bbman = lbl_bbman;
    }

    @Override
    public void run() {

        while (true) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (lbl_bbman[i][j].getIcon() != null) {
                        binaria[i][j] = 1;
                    } else {
                        binaria[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    System.out.print(binaria[i][j]);
                }
                System.out.println("");
            }
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Salida_Binaria.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("\n\n");
        }

    }

}
