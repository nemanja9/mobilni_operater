package storage;

import domen.Racun;

import java.util.List;

public interface StorageRacun {

    public void uplata(Racun racun) throws Exception;
    public List <Racun> dajSve()throws Exception;
    public List<Racun> dajSveNeplaceneZaKorisnikaZaJedanUgovor(int korisnik_id, int ugovor_id) throws Exception;
    public List<Racun> dajSveNeplaceneZaKorisnikaZaSveUgovore(int korisnik_id) throws Exception;


}
