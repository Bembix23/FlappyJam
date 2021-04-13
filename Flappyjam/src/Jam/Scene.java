package Jam;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Objets.Tuyaux;

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
	
	
	private final int LargeurFond = 140;
	private final int DistanceTuyaux = 250;
	private final int EcartTuyaux = 120;
	
	public int xFond;
	private int dxTuyaux;
	private int xTuyaux;
	
	// constructeur 
	public Scene() {
		
		super();
		this.IconFond = new ImageIcon(getClass() .getResource("/image/bandeFondEcran.png"));
		this.imgFond = this.IconFond.getImage();
		this.xFond = 0;
		this.xTuyaux = 100;
		this.dxTuyaux = 0;
		
		this.tuyauHaut1 = new Tuyaux(this.xTuyaux, -150, "/image/tuyauHaut.png");
		this.tuyauBas1 = new Tuyaux(this.xTuyaux, 250, "/image/tuyauBas.png");
		this.tuyauHaut2 = new Tuyaux(this.xTuyaux + this.DistanceTuyaux, -150,"/image/tuyauHaut.png");
		this.tuyauBas2 = new Tuyaux(this.xTuyaux + this.DistanceTuyaux, 250, "/image/tuyauBast.png");
		this.tuyauHaut3 = new Tuyaux(this.xTuyaux + this.DistanceTuyaux *2, -150, "/image/tuyauHaut.png");
		this.tuyauBas3 = new Tuyaux(this.xTuyaux + this.DistanceTuyaux *2, 250, "/image/tuyauBas.png");
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
		
	}
	
	public void paintComponent (Graphics g) {
		this.defilementFond(g);
		this.defilementTuyaux(g);
	}
}
