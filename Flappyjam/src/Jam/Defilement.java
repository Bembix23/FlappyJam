package Jam;

public class Defilement implements Runnable  {

	private final int PAUSE = 5;
	
	@Override
	public void run() {
		
		while (true) {
			Main.scene.xFond--;
			Main.scene.repaint();
			try {
				Thread.sleep(this.PAUSE);
			} catch (InterruptedException e) {}
		}
		
	}

}
