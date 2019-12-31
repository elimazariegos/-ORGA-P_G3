/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.proyecto_final_g3;

/**
 *
 * @author Samuel
 */
public class Personaje {
    private int x;
    private int y;
    private int vidas;

    public Personaje(int x, int y) {
        this.x = x;
        this.y = y;
        this.vidas = 3;
    }

    public Personaje() {
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
