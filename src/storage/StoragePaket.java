package storage;

import domen.Paket;

import java.util.List;

public interface StoragePaket {

    public Paket dodaj(Paket paket) throws Exception;
    public List<Paket> dajSve() throws Exception;
    public Paket dajJedan(int paket_id) throws Exception;
    

}
