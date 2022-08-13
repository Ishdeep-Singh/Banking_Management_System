/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ishdeep Singh, Ravneet, Kruti, Vishwa, Harmanpreet, Kawaljeet
 */
import java.sql.*;
import java.util.Properties;

import javax.swing.JOptionPane;
public class JdbcConnection {
    static Connection conn = null;
    static PropertiesLoad propertyLoadObject = PropertiesLoad.getPropertyFileInstance();
    static Properties prop = propertyLoadObject.properties;
    /**
     * 
     * @apiNote Method used to create a Db session and generating the session ID
     * @return Connection object
     */
    public static Connection ConnectDb(){
    	if(conn == null) {
    		try{
    	           Class.forName("org.sqlite.JDBC");
    	           conn=DriverManager.getConnection("jdbc:sqlite:"+prop.getProperty("sqliteDbFileLocation")+"bank.sqlite");
    	           System.out.println(conn);
    	           
    	        }
    		catch(Exception e){
    	           JOptionPane.showMessageDialog(null, e);
    	    }
    	}
        
        return conn;
    }
    
    /**
     * @apiNote Method is returning the static connection object which is containing the DB session Id
     * @return Connection object
     */
    public static Connection getConnection() {
    	
    		return ConnectDb();
    	
    }
}
