
import java.awt.Color;
import static java.awt.Color.GREEN;
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
public class Forme {
    Color c;
    Point centre;
    ArrayList<carre> al = new ArrayList<>();
    CaseColor cc;

    Forme(int centrex, int centrey, CaseColor cc, Color couleur) {
        centre = new Point(centrex, centrey);
        al.add(new carre(0, 0));
        this.cc = cc;
        c = couleur;
    }

    void dessineRectangle(Dimension ech, Graphics g) {
        // contour 

        previsu(ech, g);
        for (int i = 0; i < al.size(); i++) {
            al.get(i).dessineCarré(centre, ech, g, c);
        }
    }

    void tourne() {
        for (carre c : al) {
            c.tourne();
        }
    }

    void descendre() {
        centre.y++;
    }

    boolean mouvementPossible(int abscisse, int ordonnee) {
        int a = al.size();
        for (int i = 0; i < al.size(); i++) {
            if (cc.getCaseColor(al.get(i).x + abscisse + centre.x, al.get(i).y + ordonnee + centre.y) != Color.WHITE) {
                return false;
            }
        }
        return true;
    }

    boolean tournePossible() {
        for (int i = 1; i < al.size(); i++) {
            if (cc.getCaseColor(al.get(i).y + centre.x, al.get(i).x + centre.y) != Color.WHITE) {
                return false;
            }
        }
        return true;
    }

    void previsu(Dimension ech, Graphics g) {
        int a = 0;
        while (mouvementPossible(0, a)) {
            a++;
        }
        a--;
        Point cp = new Point(centre.x, centre.y + a);
        for (int i = 0; i < al.size(); i++) {
            al.get(i).dessineCarré(cp, ech, g, Color.lightGray);
        }
    }
}
