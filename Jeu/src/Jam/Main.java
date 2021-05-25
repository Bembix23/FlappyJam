package Jam;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

	public static JFrame fenetre;
	public static JFrame f;
	public static Scene scene;
	
	public static void main(String[] args){
		
		f = new JFrame("MenuFlappyJam");
		f.setSize(425, 425);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		f.setLayout(new GridLayout(3, 3));
		
		 JButton b = new JButton("Start with blue Bird");
		 JButton b1 = new JButton("Start with red Bird");
		 JButton b2 = new JButton("Start with yellow Bird");
		 JButton b3 = new JButton("Start with Captain america");
		 JButton b4 = new JButton("Start with Jedi Bird");
		 JButton b5 = new JButton("Start with iron man");
		 b.addActionListener(Main::actionPerformed);
		 b1.addActionListener(Main::actionPerformed);
		 b2.addActionListener(Main::actionPerformed);
		 b3.addActionListener(Main::actionPerformed);
		 b4.addActionListener(Main::actionPerformed);
		 b5.addActionListener(Main::actionPerformed);
		
		f.getContentPane().add(b);
	    f.getContentPane().add(b1);
	    f.getContentPane().add(b2);
	    f.getContentPane().add(b3);
	    f.getContentPane().add(b4);
	    f.getContentPane().add(b5);
		
		f.setVisible(true);
	}
	
	public static void actionPerformed(ActionEvent e) {
		
		fenetre = new JFrame ("FlappyJam");
		scene = new Scene();
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(300, 425);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);
		
		
		
		


	}

}
