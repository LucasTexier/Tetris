

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
class carre {
    int x,y; 
    carre(int x, int y ){
        this.x=x;
        this.y=y;
    }
     void dessineCarré(Point centre, Dimension ech, Graphics g, Color c) {
        // contour 
        g.setColor(Color.black);
        g.drawRect(ech.width*(x+centre.x), ech.height*(y+centre.y), ech.width, ech.height);
        // centre 
        g.setColor(c);
        g.fillRect(ech.width*(x+centre.x)+2, ech.height*(y+centre.y)+2, ech.width-4, ech.height-4);
         
    }

    void tourne() {
        int pivot=-1*x;
        x=this.y;
        y=pivot;
    }
}
