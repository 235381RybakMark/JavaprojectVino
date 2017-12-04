package Modele;
import java.sql.Date;
public class Wino {
	private Integer Id_Wino; 
	private String Nazwa;
	private Double Cena;
        private Date Date;
        private String Dost;
	
	public Wino(Integer Id_Wino, String Nazwa, String Cena, Date Date, String Dost) {
		this.Id_Wino = Id_Wino;
		this.Nazwa = Nazwa;
		this.Cena = Double.parseDouble(Cena);
                this.Date = Date;
                this.Dost = Dost;
	}
	
	public Wino(String Nazwa, String Cena, Date Date, String Dost) {
		
		this.Nazwa = Nazwa;
		this.Cena = Double.parseDouble(Cena);
		this.Date = Date;
                this.Dost = Dost;
	}
	
	
	public Wino() {}
	public void setId_Wino(int Id_Wino) {
		this.Id_Wino = Id_Wino;
	}
	
	public void setNazwa(String Wino) {
		this.Nazwa = Wino;
	}
	
	public void setCena(double Cena) {
		this.Cena = Cena;
	}
        public void setDate(Date Date) {
		this.Date = Date;
	}
        public void setDost(String Dost) {
            this.Dost = Dost;
	}

public Integer getId_Wino() {
		return Id_Wino;
	}
	
	public String getNazwa() {
		return Nazwa;
	}
	
	public double getCena() {
		return Cena;
	}
	public Date getDate() {
		return Date;
	}
	public String getDost() {
            if ("tak".equals(Dost)){
            return Dost;
            }
            if ("nie".equals(Dost)){
            return Dost;
            }
            else{
            return "Nie ma informacji";
            }
        }
}