package Jam;

import javax.swing.JFrame;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static JFrame fenetre;
	public static Scene scene;
	
	public static void main(String[] args) {
		
		fenetre = new JFrame ("FlappyJam");
		scene = new Scene();
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(300, 425);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                String BDD = "flappyjam";
                String url = "jdbc:mysql://localhost:8080/" + BDD;
                String user = "root";
                String passwd = "root";
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, passwd);
                    System.out.println("Connecter");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
            }
            
		});
		
	}

}
