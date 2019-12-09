package storage;

import domen.Ugovor;

import java.util.List;

public interface StorageUgovor {

    public List<Ugovor> dajSve() throws Exception;
    public Ugovor dodaj(Ugovor ugovor) throws Exception;
    public void raskini(Ugovor ugovor)throws Exception;
}
