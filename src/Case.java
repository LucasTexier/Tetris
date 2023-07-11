
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class Case {
 public Color fond = Color.white;
 Color jeu;
 public Case(){
     
 }
 public Case(Color fond){
     this.fond=fond;
 }
    void dessineToi(int ligne, int col, Dimension ech, Graphics g) {
        // contour 
        g.setColor(Color.black);
        g.drawRect(ech.width*col, ech.height*ligne, ech.width, ech.height);
        // centre 
        g.setColor(fond);
        g.fillRect(ech.width*col+2, ech.height*ligne+2, ech.width-4, ech.height-4);
        // dessiner souris
    }
    void couleurDeFond(Color red){
        this.fond=red;
    } 

    void dessineToi2(int ligne, int col, Dimension ech, Graphics g) {
         g.setColor(jeu);
         g.fillRect(ech.width*col+2, ech.height*ligne+2, ech.width-4, ech.height-4);  
    }
}
