package domen;

import java.util.ArrayList;

public class Paket {
    private int paketId;
    private String naziv;
    private ArrayList<Usluga> usluge;


    public Paket(int paketId, String naziv, ArrayList<Usluga> usluge) {
        this.paketId = paketId;
        this.naziv = naziv;
        this.usluge = usluge;
    }

    public Paket() {

    }

    public ArrayList<Usluga>  getUsluge() {
        return usluge;
    }

    public void setUsluge(ArrayList<Usluga> usluge) {
        this.usluge = usluge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paket paket = (Paket) o;
        return paketId == paket.paketId;
    }

    @Override
    public String toString() {
        return naziv;
    }

    public int getPaketId() {
        return paketId;
    }

    public void setPaketId(int paketId) {
        this.paketId = paketId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
