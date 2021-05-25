package Jam;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Objets.Tuyaux;
import Perso.FlappyBird;

public class Scene extends JPanel {
	
	// variables
	private ImageIcon IconFond;
	private Image imgFond;
	
	public Tuyaux tuyauHaut1;
	public Tuyaux tuyauBas1;
	public Tuyaux tuyauHaut2;
	public Tuyaux tuyauBas2;
	public Tuyaux tuyauHaut3;
	public Tuyaux tuyauBas3;
	
	public FlappyBird flappyBird;
	
	private int score;
	private Font police;
	
	private final int LargeurFond = 140;
	private final int DistanceTuyaux = 250;
	private final int EcartTuyaux = 120;
	
	public int xFond;
	private int xTuyaux;
	public boolean gameOver;
	
	private Random TuyauxHasard;
	
	private ClientDemo clientDemo;
	
	// constructeur 
	public Scene() {
		
		super();
		
		this.clientDemo = new ClientDemo();
		this.IconFond = new ImageIcon(getClass() .getResource("/image/bandeFondEcran.png"));
		this.imgFond = this.IconFond.getImage();
		this.xFond = 0;
		this.xTuyaux = 400;
		this.gameOver = false;
		
		this.tuyauHaut1 = new Tuyaux(this.xTuyaux, -150, "/image/tuyauHaut.png");
		this.tuyauBas1 = new Tuyaux(this.xTuyaux, 250, "/image/tuyauBas.png");
		this.tuyauHaut2 = new Tuyaux(this.xTuyaux + this.DistanceTuyaux, -150,"/image/tuyauHaut.png");
		this.tuyauBas2 = new Tuyaux(this.xTuyaux + this.DistanceTuyaux, 250, "/image/tuyauBas.png");
		this.tuyauHaut3 = new Tuyaux(this.xTuyaux + this.DistanceTuyaux *2, -150, "/image/tuyauHaut.png");
		this.tuyauBas3 = new Tuyaux(this.xTuyaux + this.DistanceTuyaux *2, 250, "/image/tuyauBas.png");
		
		this.flappyBird = new FlappyBird(100, 150, "/image/flappy2.png");
		
		TuyauxHasard = new Random();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		this.score = 0;
		this.police = new Font("Courier", Font.BOLD, 30);
		
		Thread DefilementEcran = new Thread(new Defilement());
		DefilementEcran.start();
	}
	
	// methodes 
	
	private void defilementFond(Graphics g) {
		if(this.xFond == -this.LargeurFond) {
			this.xFond = 0;
		}
		g.drawImage(this.imgFond, this.xFond, 0, null);
		g.drawImage(this.imgFond, this.xFond + this.LargeurFond, 0, null);
		g.drawImage(this.imgFond, this.xFond + this.LargeurFond * 2, 0, null);
		g.drawImage(this.imgFond, this.xFond + this.LargeurFond * 3, 0, null);
	}
	
	private void defilementTuyaux(Graphics g) {
		// tuyau1
	    this.tuyauHaut1.setX(this.tuyauHaut1.getX() - 1);
		this.tuyauBas1.setX(this.tuyauHaut1.getX());
		
		if(this.tuyauHaut1.getX() == -100){
	    	this.tuyauHaut1.setX(this.tuyauHaut3.getX() + this.DistanceTuyaux);
	    	this.tuyauHaut1.setY(-100 - 10 * this.TuyauxHasard.nextInt(18));
	    	this.tuyauBas1.setY(this.tuyauHaut1.getY() + this.tuyauHaut1.getHauteur() + this.EcartTuyaux);
	    }		
		g.drawImage(this.tuyauHaut1.getImgTuyaux(), this.tuyauHaut1.getX(), this.tuyauHaut1.getY(), null);
		g.drawImage(this.tuyauBas1.getImgTuyaux(), this.tuyauBas1.getX(), this.tuyauBas1.getY(), null);
		
		// tuyau2
		this.tuyauHaut2.setX(this.tuyauHaut2.getX() - 1);
		this.tuyauBas2.setX(this.tuyauHaut2.getX());
		
		if(this.tuyauHaut2.getX() == -100){
			this.tuyauHaut2.setX(this.tuyauHaut1.getX() + this.DistanceTuyaux);
			this.tuyauHaut2.setY(-100 - 10 * this.TuyauxHasard.nextInt(18));
	    	this.tuyauBas2.setY(this.tuyauHaut2.getY() + this.tuyauHaut2.getHauteur() + this.EcartTuyaux);
		}		
		g.drawImage(this.tuyauHaut2.getImgTuyaux(), this.tuyauHaut2.getX(), this.tuyauHaut2.getY(), null);
		g.drawImage(this.tuyauBas2.getImgTuyaux(), this.tuyauBas2.getX(), this.tuyauBas2.getY(), null);
		
		// tuyau3
		this.tuyauHaut3.setX(this.tuyauHaut3.getX() - 1);
		this.tuyauBas3.setX(this.tuyauHaut3.getX());
		
		if(this.tuyauHaut3.getX() == -100){
			this.tuyauHaut3.setX(this.tuyauHaut2.getX() + this.DistanceTuyaux);
			this.tuyauHaut3.setY(-100 - 10 * this.TuyauxHasard.nextInt(18));
	    	this.tuyauBas3.setY(this.tuyauHaut3.getY() + this.tuyauHaut3.getHauteur() + this.EcartTuyaux);
		}		
		g.drawImage(this.tuyauHaut3.getImgTuyaux(), this.tuyauHaut3.getX(), this.tuyauHaut3.getY(), null);
		g.drawImage(this.tuyauBas3.getImgTuyaux(), this.tuyauBas3.getX(), this.tuyauBas3.getY(), null);
		
	}
	
	private boolean collisionFlappy(){
        boolean gameOver = false;
		// Collision Tuyau 1
		if(this.flappyBird.getxOiseau() + this.flappyBird.getLargeurOiseau() > this.tuyauBas1.getX() - 10 && 
				this.flappyBird.getxOiseau() < this.tuyauBas1.getX() + this.tuyauBas1.getLargeur() + 10){
			gameOver = this.flappyBird.collision(this.tuyauBas1);
			if(gameOver == false){gameOver = this.flappyBird.collision(this.tuyauHaut1);}
		}else{
			// Collision Tuyau 2
			if(this.flappyBird.getxOiseau() + this.flappyBird.getLargeurOiseau() > this.tuyauBas2.getX() - 10 && this.flappyBird.getxOiseau() < this.tuyauBas2.getX() + this.tuyauBas2.getLargeur() + 10){
				gameOver = this.flappyBird.collision(this.tuyauBas2);
				if(gameOver == false){gameOver = this.flappyBird.collision(this.tuyauHaut2);}			
		    }else{
				// Collision Tuyau 3
			    if(this.flappyBird.getxOiseau() + this.flappyBird.getLargeurOiseau() > this.tuyauBas3.getX() - 10 && this.flappyBird.getxOiseau() < this.tuyauBas3.getX() + this.tuyauBas3.getLargeur() + 10){
			    	gameOver = this.flappyBird.collision(this.tuyauBas3);
				    if(gameOver == false){gameOver = this.flappyBird.collision(this.tuyauHaut3);}
			}else{
				// Collision Sol
				if(this.flappyBird.getYOiseau() < 0 || this.flappyBird.getYOiseau() + this.flappyBird.getHauteurOiseau() > 355){gameOver = true;}else{gameOver = false;}
		        }
		    }
	    }
		return gameOver;
	}
	
	private void score() {
		if(this.tuyauBas1.getX() + this.tuyauBas1.getLargeur() == 95 || this.tuyauBas2.getX() + this.tuyauBas2.getLargeur() == 95 ||
				this.tuyauBas3.getX() + this.tuyauBas3.getLargeur() == 95) {
			clientDemo.updateScore(++this.score);
			Son.playSound("/son/point.wav");
		}
	}
	
	public void paintComponent (Graphics g) {
		this.defilementFond(g);
		this.defilementTuyaux(g);
		this.score();
		g.setFont(police);
		g.setColor(Color.red);
		g.drawString("" + score, 140, 50);
		this.gameOver = this.collisionFlappy();
		this.flappyBird.setYOiseau(this.flappyBird.getYOiseau() + 1);
		g.drawImage(this.flappyBird.getImgOiseau(), this.flappyBird.getxOiseau(), this.flappyBird.getYOiseau(), null);
		if(this.gameOver == true) {g.drawString("Fin du jeu", 60, 200);
		Son.playSound("/son/hit.wav");}
	}
}
