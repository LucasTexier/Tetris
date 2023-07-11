
import java.awt.*; 
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JTextPane;
import javax.swing.Timer;

/*
 It is not the lastest version of the project unfortunately the wetransfer links have expired ... and the project was done a year ago.
 But, you will find our report with the final design ! However this version contains all the last functionnalities (except history, music and speed choice).

 * @author Lucas
 */
public class Plateau extends Canvas implements MouseListener, MouseMotionListener, KeyListener, ActionListener,CaseColor {
    int p = 1, compteur ;
    Case[][] mat = new Case[20][10];
     Case ext=new Case(Color.black);
    Dimension ech;
    Timer t = new Timer(500, this);
    double timer =0 ;
    Point souris;
    Forme A = new rectangle(5,1,this) ;
    int score=0;
    
    
    @Override
    // 
    public Dimension getPreferredSize(){
        return new Dimension(mat[0].length*20,mat.length*20);
    }
    @Override
    public Dimension getMinimumSize(){
        return getPreferredSize();
    }

    public Plateau() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        // Création des cases 
        for (int ligne = 0; ligne < mat.length; ligne++) {
            for (int col = 0; col < mat[ligne].length; col++) {
                mat[ligne][col] = new Case();
            }

        }

    }
    public Color getCaseColor(int x,int y){
        if(x<0||x>=mat[0].length||y<0||y>=mat.length) return ext.fond;
        return mat[y][x].fond;
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics gr) {
        requestFocus();
       BufferedImage bi= new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
       Graphics g=bi.getGraphics();
       int taille=Math.min(getWidth() / mat[0].length, getHeight() / mat.length);
            ech = new Dimension(taille,taille);
        
        // Dessine toutes les cases 
        for (int ligne = 0; ligne < mat.length; ligne++) {
            for (int col = 0; col < mat[ligne].length; col++) {
                mat[ligne][col].dessineToi(ligne, col, ech, g);
            }
        }
        //

        A.dessineRectangle(ech, g);
        if(A.mouvementPossible(0, 0)== false){
            gameOver(g);
        }
        gr.drawImage(bi, 0, 0, this);
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point pt = e.getPoint();// Position x,y où j'ai cliqué
        pt.x /= ech.width;
        pt.y /= ech.height;
        mat[pt.y][pt.x].couleurDeFond(Color.YELLOW);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == 38) {
            if(A.tournePossible()){
            A.tourne() ;
        }
        }
        if (e.getKeyCode() == 40) {
            if(A.mouvementPossible(0, 1)){
            A.centre.y++; 
            score++;
            }
        }
        if (e.getKeyCode() == 37) {
            if(A.mouvementPossible(-1, 0)){
            A.centre.x--;                
            }
        }        
        if (e.getKeyCode() == 39) {
            if(A.mouvementPossible(1, 0)){
            A.centre.x++;                
            }
        }
        if (e.getKeyCode() == 32) {
            if (t.isRunning()) {
                t.stop();
            } else {
                t.start();
            }

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(A.mouvementPossible(0, 1)){
            A.descendre();
        repaint();}
        else{
            for(int i = 0; i< A.al.size() ; i++){
                mat[A.centre.y + A.al.get(i).y][A.centre.x + A.al.get(i).x].couleurDeFond(A.c);
   
        }
        p = (int) (Math.random()* 7);
        if(p == 0){
            A = new groscarre(5,1,this) ;
        }
        else if (p == 1){
            A = new rectangle(5,1,this) ;
        }
        else if (p == 2){
            A = new piecetrois(5,1,this) ;
        }
        else if (p == 3){
            A = new piecequatre(5,1,this) ;
        }
        else if (p == 4){
            A = new piececinq(5,1,this) ;
        }
        else if (p == 5){
            A = new piecesix(5,1,this) ;
        }
        else if (p == 6){
            A = new piecesept(5,1,this) ;
        }
        
        }
       Vidertableau(mat);
       timer += (double) (t.getDelay()*0.001) ;
        afficheur_score.setText(""+score);
        afficheur_timer.setText(""+timer);
       
    }
    int compteurtab=0;
    
    private void Vidertableau(Case[][] mat) {
    int compteurligne=0; 
     for (int ligne = 0; ligne < mat.length; ligne++) {
            for (int col = 0; col < mat[ligne].length; col++) {
                if(mat[ligne][col].fond != Color.WHITE){
                    compteurtab++;                
          if(compteurtab== mat[ligne].length){
              compteurligne++;
             for(int i=ligne;i>= 1;i--){
                 for (int col2 = 0; col2 < mat[ligne].length; col2++) {                 
                mat[i][col2].fond=mat[i-1][col2].fond;
                compteurtab = 0 ;
             }
          }
        }
         
     }
     }
    compteurtab = 0 ;
}
     if(compteurligne==1)score+=40;
     if(compteurligne==2)score+=100;
     if(compteurligne==3)score+=300;
     if(compteurligne==4)score+=1200;
}
JTextPane afficheur_score,afficheur_timer ;
    void afficheurs(JTextPane afficheur_score, JTextPane afficheur_timer) {
        this.afficheur_score = afficheur_score;
        this.afficheur_timer=afficheur_timer;
    }

    void Recommencer(Case[][] mat) {
        
        this.score=0;
        this.timer=0;
        
        for (int ligne = 0; ligne < mat.length; ligne++) {
            for (int col = 0; col < mat[ligne].length; col++) {
                mat[ligne][col].couleurDeFond(WHITE);
            }  
        }
       if (t.isRunning()) {
                t.stop();
            }
       repaint();
       p = (int) (Math.random()* 7);
        if(p == 0){
            A = new groscarre(5,1,this) ;
        }
        else if (p == 1){
            A = new rectangle(5,1,this) ;
        }
        else if (p == 2){
            A = new piecetrois(5,1,this) ;
        }
        else if (p == 3){
            A = new piecequatre(5,1,this) ;
        }
        else if (p == 4){
            A = new piececinq(5,1,this) ;
        }
        else if (p == 5){
            A = new piecesix(5,1,this) ;
        }
        else if (p == 6){
            A = new piecesept(5,1,this) ;
        }
        afficheur_score.setText(""+score);
        afficheur_timer.setText(""+timer);
    }

    private void GameOver(Case[][] mat) {
       for (int ligne = 0; ligne < mat.length; ligne++) {
            for (int col = 0; col < mat[ligne].length; col++) {
                mat[ligne][col].couleurDeFond(BLACK);
            }  
        }
      t.stop(); 
       repaint();
       
    }
    public void gameOver(Graphics g) {
		//Score
		t.stop();
                
                g.setColor(Color.BLACK);
	        
                g.fillRect(0,0,ech.width*mat.length*2,ech.height*mat[0].length*2);
                
                g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, ech.width));
		g.drawString("Score: "+score,(mat[0].length-3)*ech.width/2,(mat.length+2)*ech.height/2 );
		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, ech.width));
		
                g.drawString("GameOver ",(mat[0].length-4)*ech.width/2,(mat.length-2)/2*ech.height );
    }
    
}


interface CaseColor{
    public Color getCaseColor(int x,int y);
}
