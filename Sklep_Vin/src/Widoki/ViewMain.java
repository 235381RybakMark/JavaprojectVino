package Widoki;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import baza_danych.BAZA;
import javax.swing.*;
 
public class ViewMain {
          final static String PANEL0 = "WINO";
          public void dodajpanel(JFrame  pane) {
        
    	JTabbedPane Menu = new JTabbedPane();
        VidokWin fp = new VidokWin();
        Menu.add(fp);
        
        ChangeListener changeListener = new ChangeListener(){
            public void stateChanged(ChangeEvent changeEvent){
            	int index = Menu.getSelectedIndex();
           	if(index==0){ fp.setmodel(); }
            }
        };
          
        pane.add(Menu, BorderLayout.CENTER);
        Menu.addTab(PANEL0, fp);
    }
    private static void Menu() {
      
        JFrame panel = new JFrame("Sklep_Wino");
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        ViewMain view = new ViewMain();
        view.dodajpanel(panel);
      
       panel.pack();
        panel.setVisible(true);
    }
 
    public static void main(String[] args) {
    	BAZA era = new BAZA ();
        
    	  File f = new File("baza.db");

    	  if(f.exists()){
    		  System.out.println("Baza dannychistniee baza.db");
    	  }else{
    		  era.runz();  
                  System.out.println(" Baza dannych zostalastwozona baza.db");
    	  }
  
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               Menu();
            }
        });
    }
}






