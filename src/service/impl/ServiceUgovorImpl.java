package service.impl;

import domen.Ugovor;
import exception.ValidationException;
import java.util.List;
import service.ServiceUgovor;
import storage.StorageUgovor;
import storage.impl.StorageDatabaseUgovor;
import validator.Validator;
import validator.impl.ValidatorUgovor;


public class ServiceUgovorImpl implements ServiceUgovor{

    private StorageUgovor storageUgovor;
    private Validator validator;

    public ServiceUgovorImpl() {
        storageUgovor = new StorageDatabaseUgovor();
    }
    
    
    @Override
    public List<Ugovor> dajSve() throws Exception {
        return storageUgovor.dajSve();
    }

    @Override
    public Ugovor dodaj(Ugovor ugovor) throws Exception {
        try{
        validator = new ValidatorUgovor();
        validator.validate(ugovor);
        return storageUgovor.dodaj(ugovor);
        } catch(ValidationException e){
            throw e;
        }
    }

    @Override
    public void raskini(Ugovor ugovor) throws Exception {
        storageUgovor.raskini(ugovor);
    }

    @Override
    public List<Ugovor> dajSveZaKorisnika(int korisnik_id) throws Exception {
        return storageUgovor.dajSveZaKorisnika(korisnik_id);
    }

}
