package storage.impl;

import database.ConnectionFactory;
import domen.Korisnik;
import domen.Racun;
import domen.Ugovor;
import kontroler.Kontroler;
import storage.StorageRacun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class StorageDatabaseRacun implements StorageRacun {


    @Override
    public void uplata(Racun racun) throws Exception {
        if (racun == null) return;
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "update racun set placen = true where racun_id = ?";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,racun.getRacunId());
            ps.executeUpdate();
            connection.commit();
            ps.close();


        } catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Greska prilikom uplate racuna!\n" + ex.getMessage());
        }


    }

    @Override
    public List<Racun> dajSve() throws Exception {
        ArrayList<Racun> lista = new ArrayList<>();
        try {
            String upit = "select * from racun";
            Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);

            while(rs.next()){
                Racun rac = new Racun();
                rac.setRacunId(rs.getInt("racun_id"));
                rac.setIznos(rs.getInt("iznos"));
                rac.setMesecGodina(new Date(rs.getDate("mesecGodina").getTime()));
                rac.setPlacen(rs.getBoolean("placen"));
                Ugovor pom = dajUgovor(rs.getInt("ugovor_id"));
                if(pom == null) throw new Exception("Ne postoji ugovor sa id-jem " + rs.getInt("ugovor_id"));
                rac.setUgovor(pom);
                Korisnik pom1 = dajKorisnika(rs.getInt("korisnik_id"));
                if(pom1 == null) throw new Exception("Ne postoji korisnik sa id-jem " + rs.getInt("korisnik_id"));
                rac.setKorisnik(pom1);
                lista.add(rac);

            }
            rs.close();
            statement.close();
        }catch (Exception ex){ ex.printStackTrace();
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja svih racuna iz baze!\n" + ex.getMessage());
        }
        return lista;

    }

    private Korisnik dajKorisnika(int korisnik_id) throws Exception{
        List<Korisnik> lista = Kontroler.getKontroler().dajSveKorisnike();
        for (Korisnik kor: lista
        ) {
            if (kor.getKorisnikId() == korisnik_id){
                return kor;
            }

        }
        return null;
    }

    private Ugovor dajUgovor(int ugovor_id) throws Exception {
        List<Ugovor> lista = Kontroler.getKontroler().dajSveUgovore();
        for (Ugovor ug: lista
             ) {
            if (ug.getUgovorId() == ugovor_id){
                return ug;
            }

        }
        return null;
    }
    
    @Override
    public List<Racun> dajSveNeplaceneZaKorisnikaZaJedanUgovor(int korisnik_id, int ugovor_id) throws Exception{
        ArrayList<Racun> lista = new ArrayList<>();
        try{
        Connection conn = ConnectionFactory.getInstance().getConnection();
        String upit = "Select * from racun where korisnik_id = ? and ugovor_id = ? and placen = false";
        PreparedStatement ps = conn.prepareStatement(upit);
        ps.setInt(1, korisnik_id);
        ps.setInt(2, ugovor_id);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            
                Racun rac = new Racun();
                rac.setRacunId(rs.getInt("racun_id"));
                rac.setIznos(rs.getInt("iznos"));
                rac.setMesecGodina(new Date(rs.getDate("mesecGodina").getTime()));
                rac.setPlacen(rs.getBoolean("placen"));
                Ugovor pom = dajUgovor(rs.getInt("ugovor_id"));
                if(pom == null) throw new Exception("Ne postoji ugovor sa id-jem " + rs.getInt("ugovor_id"));
                rac.setUgovor(pom);
                Korisnik pom1 = dajKorisnika(rs.getInt("korisnik_id"));
                if(pom1 == null) throw new Exception("Ne postoji korisnik sa id-jem " + rs.getInt("korisnik_id"));
                rac.setKorisnik(pom1);
                lista.add(rac);

            }
            rs.close();
            ps.close();
        }catch (Exception ex){ 
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja racuna iz baze!\n" + ex.getMessage());
        }
        return lista;

        
    }

    @Override
    public List<Racun> dajSveNeplaceneZaKorisnikaZaSveUgovore(int korisnik_id) throws Exception {
        ArrayList<Racun> lista = new ArrayList<>();
        try{
        Connection conn = ConnectionFactory.getInstance().getConnection();
        String upit = "Select * from racun where korisnik_id = ? and placen = false";
        PreparedStatement ps = conn.prepareStatement(upit);
        ps.setInt(1, korisnik_id);
  
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            
                Racun rac = new Racun();
                rac.setRacunId(rs.getInt("racun_id"));
                rac.setIznos(rs.getInt("iznos"));
                rac.setMesecGodina(new Date(rs.getDate("mesecGodina").getTime()));
                rac.setPlacen(rs.getBoolean("placen"));
                Ugovor pom = dajUgovor(rs.getInt("ugovor_id"));
                if(pom == null) throw new Exception("Ne postoji ugovor sa id-jem " + rs.getInt("ugovor_id"));
                rac.setUgovor(pom);
                Korisnik pom1 = dajKorisnika(rs.getInt("korisnik_id"));
                if(pom1 == null) throw new Exception("Ne postoji korisnik sa id-jem " + rs.getInt("korisnik_id"));
                rac.setKorisnik(pom1);
                lista.add(rac);

            }
            rs.close();
            ps.close();
        }catch (Exception ex){ 
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja racuna iz baze!\n" + ex.getMessage());
        }
        return lista;

        
    }
}
