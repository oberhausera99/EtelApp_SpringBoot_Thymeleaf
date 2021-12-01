package application.model;

public class Rendeles {
	private String nev;
	private int ar;
	private String erkezesiIdo;
	private String felhnev;
	private String szallitasiCim;
	int id;
	
	public Rendeles(String nev, int ar, String erkezesiIdo, String felhnev, int id) {
		this.nev = nev;
		this.ar = ar;
		this.erkezesiIdo = erkezesiIdo;
		this.felhnev = felhnev;
	}
	public Rendeles() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public String getFelhnev() {
		return felhnev;
	}
	public void setFelhnev(String felhnev) {
		this.felhnev = felhnev;
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
	
	public String getSzallitasiCim() {
		return szallitasiCim;
	}
	public void setSzallitasiCim(String szallitasiCim) {
		this.szallitasiCim = szallitasiCim;
	}
}
