package storage;

import domen.Ugovor;

import java.util.List;

public interface StorageUgovor {

    public List<Ugovor> DajSve() throws Exception;
    public void dodaj(Ugovor korisnik) throws Exception;
    public void raskini(Ugovor ugovor)throws Exception;
}
