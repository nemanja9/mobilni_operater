package storage.impl;

import database.ConnectionFactory;
import domen.Korisnik;
import domen.Paket;
import domen.Ugovor;
import domen.Zaposleni;
import kontroler.Kontroler;
import storage.StorageUgovor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StorageDatabaseUgovor implements StorageUgovor {
    @Override
    public List<Ugovor> dajSve() throws Exception {
        List<Ugovor> zaposleni = new ArrayList<>();
        try {
            String upit = "select * from ugovor";
            Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);

            while(rs.next()){
                Ugovor ug = new Ugovor();
                ug.setBrojTelefona(rs.getString("brojTelefona"));
                ug.setDatumDo(new Date(rs.getDate("datumDo").getTime()));
                ug.setDatumOd(new Date(rs.getDate("datumOd").getTime()));
                Korisnik pom = dajKorisnika(rs.getInt("korisnik_id"));
                if(pom==null) throw new Exception("Ne postoji korisnik sa id " + rs.getInt("korisnik_id"));
                ug.setKorisnik(pom);
                ug.setUgovorId(rs.getInt("ugovor_id"));
                ug.setNaziv(rs.getString("naziv"));
                Zaposleni pomZap = dajZaposlenog(rs.getInt("zaposleni_id"));
                if(pomZap==null) throw new Exception("Ne postoji zaposleni sa id " + rs.getInt("zaposleni_id"));
                ug.setZaposleni(pomZap);
                Paket pomPak = dajPaket(rs.getInt("paket_id"));
                if(pomPak==null) throw new Exception("Ne postoji paket sa id " + rs.getInt("paket_id"));
                ug.setPaket(pomPak);
                zaposleni.add(ug);
            }
            rs.close();
            statement.close();
        }catch (Exception ex){ ex.printStackTrace();
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja svih ugovora iz baze!\n" + ex.getMessage());
        }
        return zaposleni;

    }

    private Paket dajPaket(int paket_id) throws Exception {
        List<Paket> lista = Kontroler.getKontroler().dajSvePakete();
        for (Paket pak: lista
        ) {
            if (pak.getPaketId() == paket_id){
                return pak;
            }

        }
        return null;
    }

    private Zaposleni dajZaposlenog(int zaposleni_id) throws Exception {
        List<Zaposleni> lista = Kontroler.getKontroler().dajSveZaposlene();
        for (Zaposleni zap: lista
        ) {
            if (zap.getZaposleniId() == zaposleni_id){
                return zap;
            }

        }
        return null;
    }

    private Korisnik dajKorisnika(int korisnik_id) throws Exception {
        List<Korisnik> lista = Kontroler.getKontroler().dajSveKorisnike();
        for (Korisnik kor: lista
        ) {
            if (kor.getKorisnikId() == korisnik_id){
                return kor;
            }

        }
        return null;
    }

    @Override
    public Ugovor dodaj(Ugovor ugovor) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();

        String upit = "insert into ugovor (datumOd, datumDo, brojTelefona, naziv, paket_id, zaposleni_id, korisnik_id) values (?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.setDate(1,new java.sql.Date(ugovor.getDatumOd().getTime()));
        ps.setDate(2,new java.sql.Date(ugovor.getDatumDo().getTime()));
        ps.setString(3,ugovor.getBrojTelefona());
        ps.setString(4,ugovor.getNaziv());
        ps.setInt(5,ugovor.getPaket().getPaketId());
        ps.setInt(6,ugovor.getZaposleni().getZaposleniId());
        ps.setInt(7,ugovor.getKorisnik().getKorisnikId());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if (rs.next()) ugovor.setUgovorId(rs.getInt(1));
        connection.commit();
        ps.close();
        return ugovor;
    }

    @Override
    public void raskini(Ugovor ugovor) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String upit = "update ugovor set datumDo = ? where ugovor_id = ?";
        PreparedStatement ps = connection.prepareStatement(upit);
        Date datepom = new Date();
        ps.setDate(1,new java.sql.Date(new Date().getTime()));
        ps.setInt(2,ugovor.getUgovorId());
        ps.executeUpdate();
        connection.commit();
        ps.close();


    }

    @Override
    public List<Ugovor>  dajSveZaKorisnika(int korisnik_id) throws Exception {
        
        List<Ugovor> zaposleni = new ArrayList<>();
        Connection conn = ConnectionFactory.getInstance().getConnection();
        String upit = "select * from ugovor where korisnik_id = ?";
        PreparedStatement ps = conn.prepareStatement(upit);
        ps.setInt(1, korisnik_id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            try{
                Ugovor ug = new Ugovor();
                ug.setBrojTelefona(rs.getString("brojTelefona"));
                ug.setDatumDo(new Date(rs.getDate("datumDo").getTime()));
                ug.setDatumOd(new Date(rs.getDate("datumOd").getTime()));
                Korisnik pom = dajKorisnika(rs.getInt("korisnik_id"));
                if(pom==null) throw new Exception("Ne postoji korisnik sa id " + rs.getInt("korisnik_id"));
                ug.setKorisnik(pom);
                ug.setUgovorId(rs.getInt("ugovor_id"));
                ug.setNaziv(rs.getString("naziv"));
                Zaposleni pomZap = dajZaposlenog(rs.getInt("zaposleni_id"));
                if(pomZap==null) throw new Exception("Ne postoji zaposleni sa id " + rs.getInt("zaposleni_id"));
                ug.setZaposleni(pomZap);
                Paket pomPak = dajPaket(rs.getInt("paket_id"));
                if(pomPak==null) throw new Exception("Ne postoji paket sa id " + rs.getInt("paket_id"));
                ug.setPaket(pomPak);
                zaposleni.add(ug);
            } catch(Exception ex){
                 throw new Exception("Greska prilikom vadjenja ugovora iz baze!\n" + ex.getMessage());
            }
        }
        ps.close();
        rs.close();
        return zaposleni;
        
    }
    
    
}
