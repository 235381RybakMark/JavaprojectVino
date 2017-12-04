package baza_danych;
import java.sql.*;
public class BAZA{

    
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:baza.db";
    
    private static Connection conn;
    private static Statement stmt;
    private static Statement stmq;
    
   
   public void runz(){

    	String sql;
 
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
        
      
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            conn.setAutoCommit(false);
            stmq = conn.createStatement();
           
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
       
        String createUCZEN="CREATE TABLE IF NOT EXISTS Wino(Id_Wino INTEGER PRIMARY KEY AUTOINCREMENT,Nazwa VARCHAR(30),Cena DOUBLE(4,2), Date DATE, Dost VARCHAR(6))";
        try {
            stmt.execute(createUCZEN);

        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli KLIENT");
            e.printStackTrace();
        } 
        
        
        try {
                sql="INSERT INTO Wino(Nazwa,Cena,Date,Dost) VALUES ('Fresko','11.00','2017-11-06','Jest');";
            stmt.execute(sql);
                sql="INSERT INTO Wino(Nazwa,Cena"
                        + ",Date,Dost) VALUES ('Kote','22.00','2017-11-09','Nie ma');";
            stmt.execute(sql);
        
       } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu ucznia");
            e.printStackTrace();
        }        
        
        
        try {
            
    conn.commit();
    stmt.close();
    stmq.close();
        } catch (SQLException e) {
            System.err.println("SQLException");
            e.printStackTrace();
        }
      
         System.out.println("Stworzono baza.db");
        
        }
    }
