package application.model;

import java.io.Serializable;

public class Kapcsolat implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    int id;
    String velemeny;
    int ertekeles;
 
    public Kapcsolat(){
    }
 
    public Kapcsolat(int id, String velemeny, int ertelekes) {
        this.id = id;
        this.velemeny = velemeny;
        this.ertekeles = ertekeles;
    }
    
    public Kapcsolat(String velemeny, int ertekeles) {
        this.velemeny = velemeny;
        this.ertekeles = ertekeles;
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
		return "Futár [id=" + id + ", velemeny=" + velemeny + ", ertekeles=" + ertekeles + "]";
	}
 
}
