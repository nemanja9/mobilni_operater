package validator.impl;
import domen.Ugovor;
import exception.ValidationException;

public class ValidatorUgovor implements validator.Validator {

    @Override
    public void validate(Object value) throws ValidationException {

        try {
            Ugovor ug = (Ugovor) value;

            if (ug.getBrojTelefona() == null || (ug.getBrojTelefona().length() != 9 && ug.getBrojTelefona().length() != 10)) {
                throw new Exception("Niste lepo uneli ugovor!");
            }
            char [] niz = ug.getBrojTelefona().toCharArray();
            for (char ch : niz) {
                if (!Character.isDigit(ch)) throw new Exception("Niste lepo uneli ugovor!");
            }
            if (ug.getDatumDo() == null || ug.getDatumOd() == null || ug.getKorisnik() == null || ug.getZaposleni() == null
                    || ug.getPaket() == null) {
                throw new Exception("Niste lepo uneli ugovor!");
            }
            

           
        } catch (Exception ex) {
            throw new ValidationException(ex.getMessage());
        }
    }

}
