package storage.impl;

import database.ConnectionFactory;
import domen.Paket;
import domen.Usluga;
import storage.StoragePaket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StorageDatabasePaket implements StoragePaket {
    @SuppressWarnings("JpaQueryApiInspection")
    @Override
    public Paket dodaj(Paket paket) throws Exception {
        if (paket == null) return null;
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "insert into paket (naziv) values (?)";
            PreparedStatement ps = connection.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,paket.getNaziv());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                int id = rs.getInt(1);
                paket.setPaketId(id);
                upit = "insert into usluga (tip, kolicina, cena, paket_id,naziv) values (?,?,?,?,?)";
                ps = connection.prepareStatement(upit);
                for (Usluga stavka: paket.getUsluge()) {
                    ps.setInt(1,stavka.getTip().ordinal()+1);
                 
                    System.out.println(stavka.getTip().ordinal());
                    ps.setDouble(2,stavka.getKolicina());
                    ps.setDouble(3,stavka.getCena());
                    ps.setInt(4,paket.getPaketId());
                    ps.setString(5,stavka.getNaziv());
                    ps.executeUpdate();
                }
            }
            connection.commit();
            rs.close();
            ps.close();
            return paket;

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Greska prilikom cuvanja paketa!\n" + ex.getMessage());
        }
    }

    @Override
    public List<Paket> dajSve() throws Exception {
        List<Paket> lista = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from paket");
            while(rs.next()){
                Paket paket = new Paket();
                paket.setNaziv(rs.getString("naziv"));
                paket.setPaketId(rs.getInt("paket_id"));
                paket.setUsluge(vratiUsluge(paket.getPaketId()));
                lista.add(paket);
            }
            rs.close();
            statement.close();
            return  lista;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja svih paketa iz baze!\n" + ex.getMessage());
        }

    }

    private ArrayList<Usluga> vratiUsluge(int paketId) throws Exception {

        ArrayList<Usluga> lista = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from usluga where paket_id = "+paketId);
            while(rs.next()){
                Usluga usluga = new Usluga();
                usluga.setCena(rs.getDouble("cena"));
                usluga.setKolicina(rs.getDouble("kolicina"));
                usluga.setNaziv(rs.getNString("naziv"));
                usluga.setPaket(paketId);
                usluga.setTip(rs.getInt("tip"));
                usluga.setUslugaId(rs.getInt("usluga_id"));

                lista.add(usluga);
            }


            return lista;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja usluga iz baze za paket id: !"+paketId+"\n" + ex.getMessage());
        }
    }

    @Override
    public Paket dajJedan(int paket_id) throws Exception {
        Paket paket = new Paket();

        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "select * from usluga paket where paket_id = (?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,paket_id);
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
                
                paket.setNaziv(rs.getString("naziv"));
                paket.setPaketId(rs.getInt("paket_id"));
                paket.setUsluge(vratiUsluge(paket.getPaketId()));
               
            }
            rs.close();
            ps.close();
            return  paket;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Greska prilikom vadjenja paketa iz baze!\n" + ex.getMessage());
        }
        
    }
}
