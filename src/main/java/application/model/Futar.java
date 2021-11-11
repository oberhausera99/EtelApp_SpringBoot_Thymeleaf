package application.model;

import java.io.Serializable;

public class Futar implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    int id;
    String name;
    int alkalmazott_miota;
    boolean elerheto;
 
    public Futar(){
    }
 
    public Futar(int id, String name, int alkalmazott_miota, boolean elerheto) {
        this.id = id;
        this.name = name;
        this.alkalmazott_miota = alkalmazott_miota;
        this.elerheto = elerheto;
    }
    
    public Futar(String name, int alkalmazott_miota) {
        this.name = name;
        this.alkalmazott_miota = alkalmazott_miota;
    }
 
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAlkalmazott_miota() {
        return alkalmazott_miota;
    }
    
    public void setAlkalmazott_miota(int alkalmazott_miota) {
        this.alkalmazott_miota = alkalmazott_miota;
    }
    
    public boolean isElerheto() {
    	return elerheto;
    }
    
    public void setElerheto(boolean elerheto) {
    	this.elerheto = elerheto;
    }

	@Override
	public String toString() {
		return "Futár [id=" + id + ", name=" + name + ", alkalmazott_miota=" + alkalmazott_miota + ", elerheto=" + elerheto + "]";
	}
 
}
