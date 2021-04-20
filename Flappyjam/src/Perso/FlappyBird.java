package Perso;

import java.awt.Image;

import javax.swing.ImageIcon;

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
			this.icoOiseau = new ImageIcon(getClass() .getResource("/image/oiseau2.png"));
			this.imgOiseau = this.icoOiseau.getImage();
			this.YOiseau = this.YOiseau - 3;
			
		} else if (dOiseau > 5) {
			this.YOiseau = this.YOiseau - 2;
		} else if (dOiseau > 1) {
			this.YOiseau = this.YOiseau - 1;
		} else if (dOiseau == 1) {
			this.icoOiseau = new ImageIcon(getClass() .getResource("/image/oiseau1.png"));
			this.imgOiseau = this.icoOiseau.getImage();
		}
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
