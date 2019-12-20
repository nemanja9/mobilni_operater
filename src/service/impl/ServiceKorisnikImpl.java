package service.impl;

import domen.Korisnik;
import exception.ValidationException;
import java.util.List;
import service.ServiceKorisnik;
import storage.StorageKorisnik;
import storage.impl.StorageDatabaseKorisnik;
import validator.Validator;
import validator.impl.ValidatorKorisnik;

public class ServiceKorisnikImpl implements ServiceKorisnik {

    private StorageKorisnik storageKorisnik;
    private Validator validator;

    public ServiceKorisnikImpl() {
        storageKorisnik = new StorageDatabaseKorisnik();
    }

    @Override
    public List<Korisnik> dajSve() throws Exception {
        return storageKorisnik.dajSve();
    }

    @Override
    public void dodaj(Korisnik korisnik) throws Exception {
        try {
            validator = new ValidatorKorisnik();
            validator.validate(korisnik);
            storageKorisnik.dodaj(korisnik);
        } catch (ValidationException e) {
            throw e;
        }
    }

    @Override
    public void izmeni(Korisnik korisnik) throws Exception {
    storageKorisnik.izmeni(korisnik);
    }

    @Override
    public void obrisi(Korisnik korisnik) throws Exception {
        storageKorisnik.obrisi(korisnik);
    }

    @Override
    public List<Korisnik> dajNeke(String ime, String prezime, String adresa) throws Exception {
        return storageKorisnik.dajNeke(ime, prezime, adresa);
    }

}
