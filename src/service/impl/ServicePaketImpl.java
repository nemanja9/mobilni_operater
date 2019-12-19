package service.impl;

import domen.Paket;
import exception.ValidationException;
import java.util.List;
import service.ServicePaket;
import storage.StoragePaket;
import storage.impl.StorageDatabasePaket;
import validator.Validator;
import validator.impl.ValidatorPaket;


public class ServicePaketImpl implements ServicePaket{

    private StoragePaket storagePaket;
    private Validator validator;
    public ServicePaketImpl() {
        storagePaket = new StorageDatabasePaket();
    }

    
    @Override
    public Paket dodaj(Paket paket) throws Exception {
        try {
            validator = new ValidatorPaket();
            validator.validate(paket);
            return storagePaket.dodaj(paket);
        } catch (ValidationException e) {
            throw e;
        }
    }

    @Override
    public List<Paket> dajSve() throws Exception {
        return storagePaket.dajSve();
    }

    @Override
    public Paket dajJedan(int paket_id) throws Exception {
        return storagePaket.dajJedan(paket_id);
    }

}
