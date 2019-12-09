package domen;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Racun {

    private int racunId;
    private int iznos;
    private Date mesecGodina;
    private boolean placen;
    private Ugovor ugovor;
    private Korisnik korisnik;

    public Racun() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racun racun = (Racun) o;
        return racunId == racun.racunId;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
        sdf.format(mesecGodina);
        return sdf + ": " +iznos;

    }

    public Racun(int racunId, int iznos, Date mesecGodina, boolean placen, Ugovor ugovor, Korisnik korisnik) {
        this.racunId = racunId;
        this.iznos = iznos;
        this.mesecGodina = mesecGodina;
        this.placen = placen;
        this.ugovor = ugovor;
        this.korisnik = korisnik;
    }

    public int getRacunId() {
        return racunId;
    }

    public void setRacunId(int racunId) {
        this.racunId = racunId;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public Date getMesecGodina() {
        return mesecGodina;
    }

    public void setMesecGodina(Date mesecGodina) {
        this.mesecGodina = mesecGodina;
    }

    public boolean isPlacen() {
        return placen;
    }

    public void setPlacen(boolean placen) {
        this.placen = placen;
    }

    public Ugovor getUgovor() {
        return ugovor;
    }

    public void setUgovor(Ugovor ugovor) {
        this.ugovor = ugovor;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
