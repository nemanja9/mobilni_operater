/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.impl;

import domen.Paket;
import domen.Usluga;
import exception.ValidationException;
import validator.Validator;

/**
 *
 * @author student1
 */
public class ValidatorPaket implements Validator {

    @Override
    public void validate(Object value) throws ValidationException {
        try {
            Paket paket = (Paket) value;

            boolean sviSu0Din = true;
         
            boolean sviSu0Kol = true;
        
            for (Usluga u : paket.getUsluge()) {
                if ((u.getCena() == 0 && u.getKolicina() != 0) || (u.getCena() != 0 && u.getKolicina() == 0)) {
                    throw new Exception("Niste lepo uneli paket!");
                }
                if (u.getCena() > 0) {
                    sviSu0Din = false;
                }
                if (u.getKolicina() > 0) {
                    sviSu0Kol = false;
                }
            }
           
            if (sviSu0Din || sviSu0Kol) {
                throw new Exception("Niste lepo uneli paket!");
            }
        } catch (Exception ex) {
            throw new ValidationException(ex.getMessage());
        }
    }

}
