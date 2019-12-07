package storage;

import domen.Korisnik;

import java.util.List;

public interface StorageKorisnik {

    public List <Korisnik> dajSve() throws Exception;
    public void dodaj(Korisnik korisnik) throws Exception;
    public void izmeni(Korisnik korisnik)throws Exception;
    public void obrisi(Korisnik korisnik)throws Exception;

}
