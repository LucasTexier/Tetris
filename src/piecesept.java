import java.awt.Color;
import static java.awt.Color.ORANGE;
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


class piecesept extends Forme{
    piecesept(int centrex, int centrey, CaseColor cc){
        super(centrex, centrey, cc,Color.ORANGE) ;
        al.add(new carre(-1, 0)) ;
        al.add(new carre(0, -1)) ;
        al.add(new carre(1, -1)) ;
    }
}
