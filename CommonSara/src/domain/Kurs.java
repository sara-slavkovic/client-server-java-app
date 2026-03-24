/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Kurs implements GenericEntity {

    private int idKursa;
    private String nazivKursa;
    private int trajanjeUNedeljama;
    private TipSminkanja tipSminkanja;
    private Predavac predavac;

    public Kurs() {
    }

    public Kurs(int idKursa, String nazivKursa, int trajanjeUNedeljama, TipSminkanja tipSminkanja, Predavac predavac) {
        this.idKursa = idKursa;
        this.nazivKursa = nazivKursa;
        this.trajanjeUNedeljama = trajanjeUNedeljama;
        this.tipSminkanja = tipSminkanja;
        this.predavac = predavac;
    }

    public int getIdKursa() {
        return idKursa;
    }

    public void setIdKursa(int idKursa) {
        this.idKursa = idKursa;
    }

    public String getNazivKursa() {
        return nazivKursa;
    }

    public void setNazivKursa(String nazivKursa) {
        this.nazivKursa = nazivKursa;
    }

    public int getTrajanjeUNedeljama() {
        return trajanjeUNedeljama;
    }

    public void setTrajanjeUNedeljama(int trajanjeUNedeljama) {
        this.trajanjeUNedeljama = trajanjeUNedeljama;
    }

    public TipSminkanja getTipSminkanja() {
        return tipSminkanja;
    }

    public void setTipSminkanja(TipSminkanja tipSminkanja) {
        this.tipSminkanja = tipSminkanja;
    }

    public Predavac getPredavac() {
        return predavac;
    }

    public void setPredavac(Predavac predavac) {
        this.predavac = predavac;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kurs other = (Kurs) obj;
        if (this.idKursa != other.idKursa) {
            return false;
        }
        if (this.trajanjeUNedeljama != other.trajanjeUNedeljama) {
            return false;
        }
        if (!Objects.equals(this.nazivKursa, other.nazivKursa)) {
            return false;
        }
        if (!Objects.equals(this.tipSminkanja, other.tipSminkanja)) {
            return false;
        }
        return Objects.equals(this.predavac, other.predavac);
    }

    @Override
    public String toString() {
        return nazivKursa;
    }

    @Override
    public String getTableName() {
        return "kurs";
    }

    @Override
    public List<GenericEntity> getList(ResultSet resultSet) throws Exception {
        List<GenericEntity> list = new LinkedList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String naziv = resultSet.getString("nazivKursa");
            int trajanjeUNedeljama = resultSet.getInt("trajanjeUNedeljama");
            int idTipaSminkanja = resultSet.getInt("idTipaSminkanja");
            TipSminkanja ts = new TipSminkanja();
            ts.setIdTipaSminkanja(idTipaSminkanja);
            int idPredavaca = resultSet.getInt("idPredavaca");
            Predavac p = new Predavac();
            p.setIdPredavaca(idPredavaca);

            Kurs k = new Kurs(id, naziv, trajanjeUNedeljama, ts, p);
            list.add(k);
        }
        return list;
    }

    @Override
    public String getAttributeNames() {
        return "nazivKursa,trajanjeUNedeljama,idTipaSminkanja,idPredavaca";
    }

    @Override
    public String getUnknownValues() {
        return "?,?,?,?";
    }

    @Override
    public void prepareStatement(PreparedStatement ps, GenericEntity entity) throws Exception {
        Kurs k = (Kurs) entity;
        ps.setString(1, k.getNazivKursa());
        ps.setInt(2, k.getTrajanjeUNedeljama());
        ps.setInt(3, k.getTipSminkanja().getIdTipaSminkanja());
        ps.setInt(4, k.getPredavac().getIdPredavaca());
    }

    @Override
    public String getUpdateQuery() {
        //za izmenu kursa
        return "nazivKursa=?, trajanjeUNedeljama=?, idTipaSminkanja=?, idPredavaca=?";
    }

    @Override
    public String getID(GenericEntity entity) {
        Kurs kurs = (Kurs) entity;
        return String.valueOf(kurs.getIdKursa());
    }

    @Override
    public String getOrderCondition() {
        //za order by
        return "id";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String naziv = resultSet.getString("nazivKursa");
            int trajanjeUNedeljama = resultSet.getInt("trajanjeUNedeljama");
            int idTipaSminkanja = resultSet.getInt("idTipaSminkanja");
            TipSminkanja ts = new TipSminkanja();
            ts.setIdTipaSminkanja(idTipaSminkanja);
            int idPredavaca = resultSet.getInt("idPredavaca");
            Predavac p = new Predavac();
            p.setIdPredavaca(idPredavaca);

            entity = new Kurs(id, naziv, trajanjeUNedeljama, ts, p);
        }
        return entity;
    }

    @Override
    public String getCondition(GenericEntity entity) {
        //za filter, pretraga po nazivu
        Kurs k = (Kurs) entity;
        return "LOWER(nazivKursa) LIKE '%" + k.getNazivKursa() + "%'";
        //LOWER(nazivKursa) LIKE '$kurs%' -- sadrzi rec kurs negde u nazivu        
    }

    @Override
    public String getLogin(GenericEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
