package domen;

public class Usluga {

    private int uslugaId;
    private UslugaTip tip;
    private double kolicina;
    private double cena;
    private int paket;
    private String naziv;

    public Usluga() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usluga usluga = (Usluga) o;
        return uslugaId == usluga.uslugaId;
    }


    public int getUslugaId() {
        return uslugaId;
    }

    public void setUslugaId(int uslugaId) {
        this.uslugaId = uslugaId;
    }

    public UslugaTip getTip() {
        return tip;
    }

    public void setTip(int tip) {
        switch (tip){
            case 0: this.tip = this.tip.GB;
            break;
            case 1: this.tip = this.tip.MIN;
                        break;

            case 2: this.tip = this.tip.SMS;
                        break;

        }
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPaket() {
        return paket;
    }

    public void setPaket(int paket) {
        this.paket = paket;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Usluga{" +
                "uslugaId=" + uslugaId +
                ", tip=" + tip +
                ", kolicina=" + kolicina +
                ", cena=" + cena +
                ", paket=" + paket +
                ", naziv='" + naziv + '\'' +
                '}';
    }

    public Usluga(int uslugaId, UslugaTip tip, double kolicina, double cena, int paket, String naziv) {
        this.uslugaId = uslugaId;
        this.tip = tip;
        this.kolicina = kolicina;
        this.cena = cena;
        this.paket = paket;
        this.naziv = naziv;
    }
}
