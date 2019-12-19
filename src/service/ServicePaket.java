/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domen.Paket;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface ServicePaket {

    public Paket dodaj(Paket paket) throws Exception;

    public List<Paket> dajSve() throws Exception;

    public Paket dajJedan(int paket_id) throws Exception;

}
