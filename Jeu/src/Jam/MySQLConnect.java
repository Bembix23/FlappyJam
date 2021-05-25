package Jam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnect {

    Connection m_connexion;
        
    public MySQLConnect(String ip, String base, String login, String password) {
        try {
            String url = "jdbc:mysql://"+ip+"/"+base+"?serverTimezone=UTC";
            m_connexion=DriverManager.getConnection( url, "flappyjam", "flappyjam" );
        } catch(Exception exc) {
            System.err.println("Constructeur : "+exc.getMessage());
        }
    }

    
    public MySQLConnect(String base) {
        this("localhost", base, "flappyjam", "flappyjam");
    }
    
    public ResultSet select(String sql) {
        ResultSet res=null;
        try {
            Statement instruction = m_connexion.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch(Exception exc) {
            System.err.println("Pb sur la requete '"+sql+"'");
        }
        return res;
    }

}
