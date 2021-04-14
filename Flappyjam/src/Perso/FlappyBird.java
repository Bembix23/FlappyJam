package Perso;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FlappyBird {
	
	// Variables 
	private int largeurOiseau;
	private int hauteurOiseau;
	private int xOiseau; 
	private int YOiseau;
	private int dOiseau;
	private String strImage;
	private ImageIcon icoOiseau;
	private Image imgOiseau;
	
	
	// Constructeur 
	public FlappyBird(int xOiseau, int yOiseau, String strImage) {
		
		this.largeurOiseau = 34;
		this.hauteurOiseau = 24;
		this.xOiseau = xOiseau;
		this.YOiseau = yOiseau;
		this.strImage = strImage;
		this.icoOiseau = new ImageIcon(getClass() .getResource(this.strImage));
		this.imgOiseau = this.icoOiseau.getImage();
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
		this.YOiseau = this.YOiseau - this.dOiseau;
	}

}
