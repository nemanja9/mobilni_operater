/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domen.Ugovor;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface ServiceUgovor {
     public List<Ugovor> dajSve() throws Exception;
     public Ugovor dodaj(Ugovor ugovor) throws Exception;
     public void raskini(Ugovor ugovor) throws Exception;
     public List<Ugovor>  dajSveZaKorisnika(int korisnik_id) throws Exception;
}
