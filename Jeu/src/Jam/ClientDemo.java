package Jam;

import java.io.*;
import java.net.*;

public class ClientDemo {
	
	private static final String SERVER_HOST = "localhost";

    private Socket socketOfClient;
    private BufferedWriter os;
    private BufferedReader is;
	
	    public ClientDemo() {
		      try {
		          
		          this.socketOfClient = new Socket(SERVER_HOST, 9999);
		          this.os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
		          this.is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
	
		      } catch (IOException e) {
		          if(e.getClass() == UnknownHostException.class) System.err.println("Don't know about host " + SERVER_HOST);
		          System.err.println("Couldn't get I/O for the connection to " + SERVER_HOST);
		      }
	    }

	public void updateScore(int score) {
			try {
				this.os.write(score);			
				this.os.newLine();
				this.os.flush();
				
		           String responseLine;
		           while ((responseLine = is.readLine()) != null) {
		               System.out.println("Server: " + responseLine);
		               if (responseLine.indexOf("OK") != -1) {
		                   break;
		               }
		           }
		 
		           os.close();
		           is.close();
		           socketOfClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
	}
    
	public static void main(String[] args) {
    	System.out.println("Bienvenue sur FlappyJam");
    }  
}