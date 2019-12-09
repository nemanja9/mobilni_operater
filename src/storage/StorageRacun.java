package storage;

import domen.Racun;

import java.util.List;

public interface StorageRacun {

    public void uplata(Racun racun) throws Exception;
    public List <Racun> dajSve()throws Exception;


}
