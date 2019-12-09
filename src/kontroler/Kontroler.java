package kontroler;

import domen.Korisnik;
import domen.Paket;
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

public class Kontroler {
    private static Kontroler kont;
    private StorageKorisnik storageKorisnik;
    private StorageZaposleni storageZaposleni;
    private StoragePaket storagePaket;
    private StorageUgovor storageUgovor;

    private Kontroler() {
       storageKorisnik = new StorageDatabaseKorisnik();
       storageZaposleni = new StorageDatabaseZaposleni();
       storagePaket = new StorageDatabasePaket();
       storageUgovor = new StorageDatabaseUgovor();
    }

    public static Kontroler getKontroler() {
        if (kont == null)
            kont = new Kontroler();
        return kont;
    }

    public List<Zaposleni> dajSveZaposlene() throws Exception{
        return storageZaposleni.dajSve();
    }
    public List<Korisnik> dajSveKorisnike() throws Exception{
        return storageKorisnik.dajSve();
    }
    public void dodajKorisnika(Korisnik pom) throws  Exception{
        storageKorisnik.dodaj(pom);
    }
    public void izmeniKorisnika(Korisnik pom) throws Exception{
        storageKorisnik.izmeni(pom);
    }
    public void obrisiKorisnika(Korisnik pom) throws Exception{
        storageKorisnik.obrisi(pom);
    }

    public Paket dodajPaket(Paket paket) throws Exception{
        return storagePaket.dodaj(paket);
    }

    public List<Ugovor> dajSveUgovore() throws Exception {
        return storageUgovor.dajSve();
    }

    public List<Paket> dajSvePakete() throws Exception{
        return storagePaket.dajSve();
    }
    public Ugovor dodajUgovor(Ugovor ug) throws Exception{
        return storageUgovor.dodaj(ug);
    }
    public void raskini(Ugovor ug) throws Exception{
        storageUgovor.raskini(ug);
    }
}
