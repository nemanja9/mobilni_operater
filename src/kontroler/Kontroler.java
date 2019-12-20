package kontroler;

import domen.Korisnik;
import domen.Paket;
import domen.Racun;
import domen.Ugovor;
import domen.Zaposleni;
import storage.StorageKorisnik;
import storage.StoragePaket;
import storage.StorageUgovor;
import storage.StorageZaposleni;
import storage.impl.StorageDatabaseKorisnik;
import storage.impl.StorageDatabasePaket;
import storage.impl.StorageDatabaseUgovor;
import storage.impl.StorageDatabaseZaposleni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import service.ServicePaket;
import service.ServiceUgovor;
import service.impl.ServicePaketImpl;
import service.impl.ServiceUgovorImpl;
import storage.StorageRacun;
import storage.impl.StorageDatabaseRacun;

public class Kontroler {

    private static Kontroler kont;
    private StorageKorisnik storageKorisnik;
    private StorageZaposleni storageZaposleni;
    private ServicePaket servicePaket;
    private ServiceUgovor serviceUgovor;
    private StorageRacun storageRacun;

    private Kontroler() {
        storageKorisnik = new StorageDatabaseKorisnik();
        storageZaposleni = new StorageDatabaseZaposleni();
        servicePaket = new ServicePaketImpl();
        serviceUgovor = new ServiceUgovorImpl();
        storageRacun = new StorageDatabaseRacun();
    }

    public static Kontroler getKontroler() {
        if (kont == null) {
            kont = new Kontroler();
        }
        return kont;
    }

    public List<Zaposleni> dajSveZaposlene() throws Exception {
        return storageZaposleni.dajSve();
    }

    public List<Korisnik> dajSveKorisnike() throws Exception {
        return storageKorisnik.dajSve();
    }

    public void dodajKorisnika(Korisnik pom) throws Exception {
        storageKorisnik.dodaj(pom);
    }

    public void izmeniKorisnika(Korisnik pom) throws Exception {
        storageKorisnik.izmeni(pom);
    }

    public void obrisiKorisnika(Korisnik pom) throws Exception {
        storageKorisnik.obrisi(pom);
    }

    public Paket dodajPaket(Paket paket) throws Exception {
        return servicePaket.dodaj(paket);
    }

    public List<Ugovor> dajSveUgovore() throws Exception {
        return serviceUgovor.dajSve();
    }

    public List<Paket> dajSvePakete() throws Exception {
        return servicePaket.dajSve();
    }

    public Ugovor dodajUgovor(Ugovor ug) throws Exception {
        return serviceUgovor.dodaj(ug);
    }

    public void raskini(Ugovor ug) throws Exception {
        serviceUgovor.raskini(ug);
    }

    public Zaposleni ulogujZaposlenog(String username, String password) throws Exception {
        List<Zaposleni> lista = dajSveZaposlene();
        for (Zaposleni zap : lista) {
            if (zap.getUsername().equalsIgnoreCase(username)) {
                if (zap.getPassword().equals(password)) {
                    return zap;
                } else {
                    throw new Exception("Lozinka nije dobro uneta");
                }
            }

        }
        throw new Exception("Ne postoji korisnik sa tim korisnickim imenom!");
    }

    public List<Korisnik> dajNekekorisnike(String ime, String prezime, String adresa) throws Exception {
        return storageKorisnik.dajNeke(ime, prezime, adresa);
    }

    public Paket dajJedanPaket(int id) throws Exception {
        return servicePaket.dajJedan(id);
    }

    public List<Ugovor> dajSveZaJednogKorisnika(int id) throws Exception {
        return serviceUgovor.dajSveZaKorisnika(id);
    }

    public List<Racun> dajSveNeplaceneZaKorisnika(int korisnik_id, int ugovor_id) throws Exception {
        return storageRacun.dajSveNeplaceneZaKorisnikaZaJedanUgovor(korisnik_id, ugovor_id);
    }

    public List<Racun> dajSveNeplaceneZaSveUgovore(int korisnik_id) throws Exception {
        return storageRacun.dajSveNeplaceneZaKorisnikaZaSveUgovore(korisnik_id);
    }

    public void uplatiRacun(Racun rac) throws Exception {
        storageRacun.uplata(rac);
    }
}
