package storage.impl;

import database.ConnectionFactory;
import domen.Zaposleni;
import storage.StorageZaposleni;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StorageDatabaseZaposleni implements StorageZaposleni {
    @Override
    public List<Zaposleni> dajSve() throws Exception {
        List<Zaposleni> zaposleni = new ArrayList<>();
        try {
            String upit = "select * from zaposleni";
            Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(upit);

            while(rs.next()){
                Zaposleni zap = new Zaposleni();
                zap.setIme(rs.getString("ime"));
                zap.setPrezime(rs.getString("prezime"));
                zap.setPassword(rs.getString("password"));
                zap.setUsername(rs.getString("username"));
                zap.setZaposleniId(rs.getInt("zaposleni_id"));
                zaposleni.add(zap);
            }
            rs.close();
            statement.close();
        }catch (Exception ex){ ex.printStackTrace();
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja svih zaposlenih iz baze!\n" + ex.getMessage());
        }
        return zaposleni;
    }
}
