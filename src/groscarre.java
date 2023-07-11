/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
import java.awt.Color;
import static java.awt.Color.PINK;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */


class groscarre extends Forme{
    groscarre(int centrex, int centrey, CaseColor cc){
        super(centrex, centrey, cc, Color.PINK) ;
        al.add(new carre(0, -1)) ;
        al.add(new carre(1, -1)) ;
        al.add(new carre(1, 0)) ;
    }
}
