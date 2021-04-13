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
	
	// constructeur 
	public Scene() {
		
		super();
		this.IconFond = new ImageIcon(getClass() .getResource("/image/bandeFondEcran.png"));
		this.imgFond = this.IconFond.getImage();
		
	}
	
	// methodes 
	public void paintComponent (Graphics g) {
		g.drawImage(this.imgFond, 0, 0, null);
		g.drawImage(this.imgFond, this.LargeurFond, 0, null);
	}
}
