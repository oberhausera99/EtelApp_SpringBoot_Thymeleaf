package application.model;

import java.io.Serializable;

public class Kapcsolat implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    int id;
    String velemeny;
    int ertekeles;
    String felhasznalo;
 
    public Kapcsolat(){
    }
 
    public Kapcsolat(int id, String velemeny, int ertelekes,  String felhasznalo) {
        this.id = id;
        this.velemeny = velemeny;
        this.ertekeles = ertekeles;
        this.felhasznalo = felhasznalo;
    }
    
    public Kapcsolat(String velemeny, int ertekeles, String felhasznalo) {
        this.velemeny = velemeny;
        this.ertekeles = ertekeles;
        this.felhasznalo = felhasznalo;
    }
    
    public String getFelhasznalo() {
        return felhasznalo;
    }
    
    public void setFelhasznalo(String felhasznalo) {
        this.felhasznalo = felhasznalo;
    }
 
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getVelemeny() {
        return velemeny;
    }
    
    public void setVelemeny(String velemeny) {
        this.velemeny = velemeny;
    }
    
    public int getErtekeles() {
        return ertekeles;
    }
    
    public void setErtekeles(int ertekeles) {
        this.ertekeles = ertekeles;
    }

	@Override
	public String toString() {
		return "Kapcsolat [id=" + id + ", velemeny=" + velemeny + ", ertekeles=" + ertekeles +", felhasznalo=" + felhasznalo + "]";
	}
 
}
