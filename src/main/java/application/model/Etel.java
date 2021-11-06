package application.model;


public class Etel {
	
	   
	    String nev;
	    int ar;
	    
	    public Etel() {
	    	
	    }
	    
	    @Override
	    public final int hashCode() {
	        int result = 17;
	        if (nev != null) {
	            result = 31 * result + nev.hashCode();
	        }
	        result = 31 * result + ar;
	        return result;
	    }
	    
	    @Override
	    public boolean equals(Object o) {
	 
	        if (o == this) {
	            return true;
	        }
	 
	        if (!(o instanceof Etel)) {
	            return false;
	        }
	         
	        Etel e = (Etel) o;
	         
	        return this.nev.equals(e.nev) && this.ar == e.ar;
	    }
	    
		public Etel(String nev, int ar) {
			this.nev = nev;
			this.ar = ar;
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

		@Override
		public String toString() {
			return "Etel [nev=" + nev + ", ar=" + ar + "]";
		}
	 
	}
