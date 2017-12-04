package CRUDY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Modele.Wino;
import java.sql.Date;

public class CRUDWINO{
	
 public Date przewracanie(String pe){
     return Date.valueOf(pe);
 }
    
 public static final String DRIVER = "org.sqlite.JDBC";
 public static final String DB_URL = "jdbc:sqlite:baza.db";
 private static Connection conn;
 private static Statement stmt;
	
	public void read(DefaultTableModel model){
	   try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
	        } catch (SQLException e) {
	            System.err.println("Problem z otwarciem polaczenia");
	            e.printStackTrace();
	        }
		try {
        		ResultSet result = stmt.executeQuery("SELECT * FROM Wino");
                	Wino FULL =new Wino();
                        while(result.next()) {
                        FULL.setId_Wino(result.getInt("Id_Wino"));
                        FULL.setNazwa(result.getString("Nazwa"));
                        FULL.setCena(result.getDouble("Cena"));
                        FULL.setDate(przewracanie(result.getString("Date")));
                        FULL.setDost(result.getString("Dost"));

           Object[] full = {FULL.getId_Wino(),FULL.getNazwa(),FULL.getCena(),FULL.getDate(),FULL.getDost()};
           model.addRow(full); 
         }
         } 
        catch (SQLException e) {
             System.err.println("Blad przy wykonywaniu SELECT");
             e.printStackTrace();
         }
           try {
           stmt.close();
           } 
           catch (SQLException e) {
               System.err.println("SQLException");
               e.printStackTrace();
           }
}
	public void delete(int id){
        try {
            conn = DriverManager.getConnection(DB_URL);
	    stmt = conn.createStatement();
        } 
        catch (SQLException e) {
	            System.err.println("Problem z otwarciem polaczenia");
	            e.printStackTrace();
	        }
     
		Wino DELETE = new Wino();
		DELETE.setId_Wino(id);
        	String sql =("DELETE FROM Wino WHERE Id_Wino = "+DELETE.getId_Wino());
		 try {
        		stmt.executeUpdate(sql);
                 } 
                 catch (SQLException e1) {
                 e1.printStackTrace();
		}
        try {

            stmt.close();

        } 
        catch (SQLException e) {
            System.err.println("SQLException");
            e.printStackTrace();
        }
}
	public int add(String Nazwa, String Cena, Date Date, String Dost, JPanel inputPanel){
		int flag=0;
		try {
	            conn = DriverManager.getConnection(DB_URL);
	            stmt = conn.createStatement();
	        }
                catch (SQLException e) {
	        System.err.println("Problem z otwarciem polaczenia");
	        e.printStackTrace();
	        }
		
		if(flag==0){
                Wino ADD = new Wino(Nazwa, Cena, Date, Dost);
		String sql = null;
		sql=("INSERT INTO WINO (Nazwa,Cena,Date,Dost) VALUES ('"+ADD.getNazwa()+"','"+ADD.getCena()+"','"+ADD.getDate()+"','"+ADD.getDost()+"')");
				 try {
					stmt.executeUpdate(sql);
				} 
                                 catch (SQLException e1) {
                              	JOptionPane.showMessageDialog(inputPanel, "Taki produkt juz istnieje!"); 
				}
	
		}
 try {
 stmt.close();
     } 
         catch (SQLException e) {
         System.err.println("SQLException");
         e.printStackTrace();
     }
	
     return flag;
}
	
public int update(int id, String Nazwa, String Cena, Date Date, String Dost, JPanel inputPanel){
	String sql;
	int flag=0;
	try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
      
if(flag==0){
	
	Wino UPDATE = new Wino(id, Nazwa, Cena, Date, Dost);	
  
	sql=("UPDATE WINO SET Nazwa ='"+UPDATE.getNazwa()+"',Cena='"+UPDATE.getCena()+"',Dost='"+UPDATE.getDost()+"',Date='"+UPDATE.getDate()+"' WHERE Id_Wino="+UPDATE.getId_Wino());	
	
	
	try {
		stmt.executeUpdate(sql);
	} catch (SQLException e1) {
		         flag=1;JOptionPane.showMessageDialog(inputPanel, "Taki produkt juz istnieje"); 

	}
				
	}
	try {
 stmt.close();
     } catch (SQLException e) {
         System.err.println("SQLException");
     }

return flag;
    }
}