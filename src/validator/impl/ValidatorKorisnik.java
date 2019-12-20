package validator.impl;

import domen.Korisnik;
import domen.Ugovor;
import exception.ValidationException;


public class ValidatorKorisnik implements validator.Validator {

    @Override
    public void validate(Object value) throws ValidationException {

        try {
            Korisnik kor = (Korisnik) value;

            if (kor.getIme() == null || kor.getPrezime()== null ||kor.getAdresa()== null 
                    || kor.getIme().length() == 0 
                    || kor.getPrezime().length() == 0 || kor.getAdresa().length()== 0) {
                throw new Exception("Niste lepo uneli korisnika!");
            }
            char [] niz = kor.getIme().trim().concat(kor.getPrezime().trim()).toCharArray();
            for (char ch : niz) {
                if (!Character.isLetter(ch) && ch!='\'' && ch!=' ') throw new Exception("Niste lepo uneli korisnika!");
            }
            niz = kor.getAdresa().trim().toCharArray();
            for (char c : niz) {
                if (!Character.isDigit(c) && !Character.isLetter(c) && c!='\'' && c!=' ')
                 throw new Exception("Niste lepo uneli korisnika!");
            }   
            
        } catch (Exception ex) {
            throw new ValidationException(ex.getMessage());
        }
    }

}
