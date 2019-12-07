package domen;

import java.util.Objects;

public class Korisnik {

    private int korisnikId;
    private String ime;
    private String prezime;
    private String adresa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return korisnikId == korisnik.korisnikId;
    }

    public Korisnik(int korisnikId, String ime, String prezime, String adresa) {
        this.korisnikId = korisnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
