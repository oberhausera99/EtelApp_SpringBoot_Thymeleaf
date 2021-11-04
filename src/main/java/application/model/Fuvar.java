package application.model;

import java.io.Serializable;

public class Fuvar implements Serializable{

    private static final long serialVersionUID = 1L;

    int rendelesid;
    int futarid;
    int id;

    public Fuvar(){
    }

    public Fuvar(int rendelesid, int futarid, int id) {
        this.rendelesid = rendelesid;
        this.futarid = futarid;
        this.id=id;
    }

    public Fuvar(int rendelesid, int futarid) {
        this.rendelesid = rendelesid;
        this.futarid = futarid;
    }

    public int getFutarid() {
        return futarid;
    }

    public void setFutarid(int futarid) {
        this.futarid = futarid;
    }

    public int getId() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getRendelesid() {
        return rendelesid;
    }

    public void setRendelesid(int rendelesid) {
        this.rendelesid = rendelesid;
    }


    @Override
    public String toString() {
        return "Fuvar [rendelesID=" + rendelesid + ", futarID=" + futarid + ", ID=" + id + "]";
    }

}
