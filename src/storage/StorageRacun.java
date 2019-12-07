package storage;

import domen.Racun;

import java.util.List;

public interface StorageRacun {

    public void uplata(Racun racun);
    public List <Racun> dajSve()throws Exception;


}
