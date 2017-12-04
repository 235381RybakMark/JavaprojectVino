package Widoki;


import java.awt.BorderLayout;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;


import CRUDY.CRUDWINO;
import java.sql.Date;


public class VidokWin extends JPanel{
 public Date przewracanie(String pe){
     return Date.valueOf(pe);
 }
	private static final long serialVersionUID = 1L;

CRUDWINO a = new CRUDWINO();
private DefaultTableModel model;
private	JPanel inputPanel = new JPanel()	;	
private JTable table;
private JLabel NazwaL; 
private JLabel CenaL; 
private JLabel DateL; 
private JLabel DostL; 
private JTextField  Cena;
private JTextField  Nazwa;
private JTextField  Data;
private JTextField  Dost;



public VidokWin() {
    super();
    model = new DefaultTableModel(){

		private static final long serialVersionUID = 1L;

		@Override
        public boolean isCellEditable(int row, int column) {
           
           return false;
        }
    };
    model.addColumn("Id_Wino");
    model.addColumn("Nazwa");
    model.addColumn("Cena");
    model.addColumn("Data");
    model.addColumn("Dostęp");
    a.read(model);
 
    table = new JTable(model);
    table.removeColumn(table.getColumnModel().getColumn(0));

    
 //JTextfields   
Nazwa= new JTextField(15);
Cena= new JTextField(10);
Data= new JTextField(15);
Dost= new JTextField(10);
//JLabels
NazwaL = new JLabel("Nazwa");
CenaL = new JLabel("Cena");
DateL = new JLabel("Data porodukcji.");
DostL = new JLabel("W Dostępie");
table.addMouseListener(new MouseAdapter() {
	  public void mouseClicked(MouseEvent e) {
	    if (e.getClickCount() == 2) {
	    
	    
	     Nazwa.setText((String) (table.getModel().getValueAt(table.getSelectedRow(),1)));
	     Cena.setText( (String) (table.getModel().getValueAt(table.getSelectedRow(),2)));
             Data.setText( (String) (table.getModel().getValueAt(table.getSelectedRow(),3)));
             Dost.setText( (String) (table.getModel().getValueAt(table.getSelectedRow(),4)));
	    }
	  }
	});  

JButton addButton = new JButton("Dodaj");
    addButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent event) {
        int id;
    id=a.add(Nazwa.getText(),Cena.getText(),przewracanie(Data.getText()), Dost.getText(),inputPanel);
    	  
    if(id!=-1){	
    
       setmodel();
   
    }
      }
    });

   
    
    JButton removeButton = new JButton("Usuń");

    removeButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent event) {
    	 
    	  int row = table.getSelectedRow();
    	  if(row == -1){JOptionPane.showMessageDialog(inputPanel, "Kliknij na rekord ktory chcesz usunac");}else{
    	  int value = (int) (table.getModel().getValueAt(table.getSelectedRow(),0));
    	
    	 
    	  
    	  int answer = JOptionPane.showConfirmDialog(
    			  inputPanel,
    			    "Jestes pewien ze chcesz usunac ten rekord",
    			    "WARNING",
    			    JOptionPane.YES_NO_OPTION);
    		
    	  
    	  if(answer == JOptionPane.YES_OPTION){
    		 
    		
    
    	  
    	  a.delete(value);
    	  
    	 
    	  model.removeRow(table.getSelectedRow());
    	  }
      
      
    	  }
      }
    });

    JButton updateButton = new JButton("Zmień");
    updateButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent event) {
        	 int row = table.getSelectedRow();  
         	if(row == -1){JOptionPane.showMessageDialog(inputPanel, "Kliknij na rekord ktory chcesz zaktualizowac");}else{   
     int id=0;
        	
        	  int value = (int) (table.getModel().getValueAt(row,0));
        	id=a.update(value,Nazwa.getText(),Cena.getText(), przewracanie(Data.getText()), Dost.getText(),inputPanel);
      	  
    	
        	 if(id!=-1){	
         setmodel();
        	 }
         	}
        }
      });
    
    
    
 
    
    inputPanel.setLayout(new BorderLayout());
    JPanel subPanel = new JPanel();

    
  
  
    JScrollPane tableContainer = new JScrollPane(table);

    inputPanel.add(tableContainer, BorderLayout.CENTER);
    subPanel.add(addButton);
    subPanel.add(removeButton);


    subPanel.add(updateButton);
    
    subPanel.add(NazwaL);
    subPanel.add(Nazwa);
    subPanel.add(CenaL);
    subPanel.add(Cena);
    subPanel.add(DateL);
    subPanel.add(Data);
    subPanel.add(DostL);
    subPanel.add(Dost);
    
    inputPanel.add(subPanel, BorderLayout.SOUTH);

 


//    inputPanel.setSize(1000, 300);
  
    add(inputPanel);
  
  } 

 void  setmodel(){
		
 this.model = new DefaultTableModel(){
 private static final long serialVersionUID = 1L;
@Override
public boolean isCellEditable(int row, int column) {
 return false;
	        }
	
	  
	    
	    };
	    
	    model.addColumn("Id Wino");
	    model.addColumn("Nazwa");
	    model.addColumn("Cena");
             model.addColumn("Data Produkcji.");
              model.addColumn("W Dostepie");
	    


	    a.read(model);
	   this.table.setModel(model);
	    table.removeColumn(table.getColumnModel().getColumn(0));

}
}