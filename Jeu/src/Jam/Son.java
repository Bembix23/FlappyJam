package Jam;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Son {
	private Clip clip;
	
	private Son(String son) {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
			clip = AudioSystem.getClip();
			clip.open(audio);
		}	catch (Exception e) {}
	}
	
	public Clip getClip() {return clip;}
	
	public void play () {clip.start();}
	
	public void stop () {clip.stop();}
	
	public static void playSound(String son) {
		Son s = new Son(son);
		s.play();
	}
}
