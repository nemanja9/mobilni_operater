package storage;

import domen.Paket;

import java.util.List;

public interface StoragePaket {

    public void dodaj(Paket paket) throws Exception;
    public List<Paket> dajSve() throws Exception;

}
