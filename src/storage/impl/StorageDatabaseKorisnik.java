package storage.impl;

import database.ConnectionFactory;
import domen.Korisnik;
import storage.StorageKorisnik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StorageDatabaseKorisnik implements StorageKorisnik {
    @Override
    public List<Korisnik> dajSve() throws Exception {
        ArrayList<Korisnik> lista = new ArrayList<>();
        try {
            String upit = "select * from korisnik";
            Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);

            while(rs.next()){
                Korisnik kor = new Korisnik();
                kor.setIme(rs.getString("ime"));
                kor.setPrezime(rs.getString("prezime"));
                kor.setAdresa(rs.getString("adresa"));
                kor.setKorisnikId(rs.getInt("korisnik_id"));
                lista.add(kor);
            }
            rs.close();
            statement.close();
        }catch (Exception ex){ ex.printStackTrace();
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja svih korisnika iz baze!\n" + ex.getMessage());
        }
        return lista;

    }

    @Override
    public void dodaj(Korisnik korisnik) throws Exception {
        if (korisnik == null) return;
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "insert into korisnik (ime, prezime, adresa) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,korisnik.getIme());
            ps.setString(2,korisnik.getPrezime());
            ps.setString(3,korisnik.getAdresa());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja svih zaposlenih iz baze!\n" + ex.getMessage());
        }

    }

    @Override
    public void izmeni(Korisnik korisnik) throws Exception {
        if (korisnik == null) return;
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "update korisnik set ime=?, prezime=?, adresa=? where korisnik_id = ?";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setString(1,korisnik.getIme());
            ps.setString(2,korisnik.getPrezime());
            ps.setString(3,korisnik.getAdresa());
            ps.setInt(4,korisnik.getKorisnikId());
            ps.executeUpdate();
            connection.commit();
            ps.close();


        } catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Greska prilikom izmene korisnika!\n" + ex.getMessage());
        }

    }

    @Override
    public void obrisi(Korisnik korisnik) throws Exception {
        if (korisnik == null) return;
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "delete from korisnik where korisnik_id = ?";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,korisnik.getKorisnikId());
            ps.execute();
            connection.commit();
            ps.close();

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Greska prilikom brisanja korisnika!\n" + ex.getMessage());
        }
    }
}
