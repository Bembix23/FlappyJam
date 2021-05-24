package Perso;

import java.awt.Image;

import javax.swing.ImageIcon;

import Objets.Tuyaux;

public class FlappyBird implements Runnable {
	
	// Variables 
	private int largeurOiseau;
	private int hauteurOiseau;
	private int xOiseau; 
	private int YOiseau;
	private int dOiseau;
	private String strImage;
	private ImageIcon icoOiseau;
	private Image imgOiseau;
	private final int PAUSE = 10;
	
	
	// Constructeur 
	public FlappyBird(int xOiseau, int yOiseau, String strImage) {
		
		this.largeurOiseau = 34;
		this.hauteurOiseau = 24;
		this.xOiseau = xOiseau;
		this.YOiseau = yOiseau;
		this.strImage = strImage;
		this.icoOiseau = new ImageIcon(getClass() .getResource(this.strImage));
		this.imgOiseau = this.icoOiseau.getImage();
		
		Thread BattementAiles = new Thread(this);
		BattementAiles.start();
	}
	

	// Getter
	public int getxOiseau() {return xOiseau;}
	public int getYOiseau() {return YOiseau;}
	public int getLargeurOiseau() {return largeurOiseau;}
	public int getHauteurOiseau() {return hauteurOiseau;}
	public Image getImgOiseau() {return imgOiseau;}
	
	// Setter
	
	public void setYOiseau(int yOiseau) {YOiseau = yOiseau;}
	public void setxOiseau(int xOiseau) {this.xOiseau = xOiseau;}
	
	
	// Methode 
	public void monte() {
		
		this.dOiseau = 50;
	}
	
	private void Ailes(int dOiseau) {
		
		if (dOiseau > 10) {
			this.icoOiseau = new ImageIcon(getClass() .getResource("/image/flappy1.png"));
			this.imgOiseau = this.icoOiseau.getImage();
			this.YOiseau = this.YOiseau - 3;
			
		} else if (dOiseau > 5) {
			this.YOiseau = this.YOiseau - 2;
		} else if (dOiseau > 1) {
			this.YOiseau = this.YOiseau - 1;
		} else if (dOiseau == 1) {
			this.icoOiseau = new ImageIcon(getClass() .getResource("/image/flappy2.png"));
			this.imgOiseau = this.icoOiseau.getImage();
		}
	}
	
	
	public boolean collision(Tuyaux tuyaux) {
		if(tuyaux.getY() < 50) {
			if(this.YOiseau <= tuyaux.getY() + tuyaux.getHauteur() && this.xOiseau + this.largeurOiseau >= tuyaux.getX() && 
					this.xOiseau <= tuyaux.getX() + tuyaux.getLargeur()){return true;}
			else{return false;}
		} else
			if(this.YOiseau + this.hauteurOiseau >= tuyaux.getY() && this.xOiseau + this.largeurOiseau >= tuyaux.getX() && 
			this.xOiseau <= tuyaux.getX() + tuyaux.getLargeur()){return true;}
		     else{return false;}
	}


	@Override
	public void run() {

		while(true) {
			
			this.Ailes(dOiseau);
			this.dOiseau--;
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {}
		}
	}

}
