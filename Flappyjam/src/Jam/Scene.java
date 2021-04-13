package Jam;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Scene extends JPanel {
	
	// variables
	private ImageIcon IconFond;
	private Image imgFond;
	private final int LargeurFond = 140;
	
	public int xFond;
	
	// constructeur 
	public Scene() {
		
		super();
		this.IconFond = new ImageIcon(getClass() .getResource("/image/bandeFondEcran.png"));
		this.imgFond = this.IconFond.getImage();
		this.xFond = 0;
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
	
	public void paintComponent (Graphics g) {
		this.defilementFond(g);
	}
}
