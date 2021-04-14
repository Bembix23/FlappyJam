package Objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tuyaux {
	
	// DECLARATION VARIABLES
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	private String strImage;
	private ImageIcon icoTuyaux;
	private Image imgTuyaux;
	
	// DECLARATION CONSTRUCTEUR
	public Tuyaux(int x, int y, String strImage) {
		this.largeur = 50;
		this.hauteur = 300;
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		
		this.icoTuyaux = new ImageIcon(getClass().getResource(this.strImage));
		this.imgTuyaux = this.icoTuyaux.getImage();
	}
	
	// Getter
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public int getLargeur() {return largeur;}
	
	public int getHauteur() {return hauteur;}
	
	public Image getImgTuyaux() {return imgTuyaux;}
	
	
	// Setter
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}
	
	
}
