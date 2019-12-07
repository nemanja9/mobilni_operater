package domen;

import java.util.Date;
import java.util.Objects;

public class Ugovor {

    private  int ugovorId;
    private Date datumOd;
    private Date datumDo;
    private String brojTelefona;
    private String naziv;
    private Paket paket;
    private Zaposleni zaposleni;
    private Korisnik korisnik;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ugovor ugovor = (Ugovor) o;
        return ugovorId == ugovor.ugovorId;
    }
    

    public int getUgovorId() {
        return ugovorId;
    }

    public void setUgovorId(int ugovorId) {
        this.ugovorId = ugovorId;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Ugovor(int ugovorId, Date datumOd, Date datumDo, String brojTelefona, String naziv, Paket paket, Zaposleni zaposleni, Korisnik korisnik) {
        this.ugovorId = ugovorId;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.brojTelefona = brojTelefona;
        this.naziv = naziv;
        this.paket = paket;
        this.zaposleni = zaposleni;
        this.korisnik = korisnik;
    }
}
