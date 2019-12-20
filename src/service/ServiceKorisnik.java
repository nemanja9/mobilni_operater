/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domen.Korisnik;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface ServiceKorisnik {
    public List <Korisnik> dajSve() throws Exception;
    public void dodaj(Korisnik korisnik) throws Exception;
    public void izmeni(Korisnik korisnik)throws Exception;
    public void obrisi(Korisnik korisnik)throws Exception;
    public List<Korisnik> dajNeke(String ime, String prezime, String adresa) throws Exception;

    
}
