package application.model;

public class Rendeles {
	private String nev;
	private int ar;
	private String erkezesiIdo;
	
	public Rendeles(String nev, int ar, String erkezesiIdo) {
		this.nev = nev;
		this.ar = ar;
		this.erkezesiIdo = erkezesiIdo;
	}
	public Rendeles() {
		
	}
	
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	
	public int getAr() {
		return ar;
	}
	public void setAr(int ar) {
		this.ar = ar;
	}
	
	public String getErkezesiIdo() {
		return erkezesiIdo;
	}
	public void setErkezesiIdo(String erkezesiIdo) {
		this.erkezesiIdo = erkezesiIdo;
	}
}
