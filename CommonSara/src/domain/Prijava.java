/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Prijava implements GenericEntity {

    private Korisnik korisnik;
    private Kurs kurs;
    private Date datumPrijave;
    private String napomena;
    private Grupa grupa;

    public Prijava() {
    }

    public Prijava(Korisnik korisnik, Kurs kurs, Date datumPrijave, String napomena, Grupa grupa) {
        this.korisnik = korisnik;
        this.kurs = kurs;
        this.datumPrijave = datumPrijave;
        this.napomena = napomena;
        this.grupa = grupa;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
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
        final Prijava other = (Prijava) obj;
        if (!Objects.equals(this.napomena, other.napomena)) {
            return false;
        }
        if (!Objects.equals(this.korisnik, other.korisnik)) {
            return false;
        }
        if (!Objects.equals(this.kurs, other.kurs)) {
            return false;
        }
        if (!Objects.equals(this.datumPrijave, other.datumPrijave)) {
            return false;
        }
        return Objects.equals(this.grupa, other.grupa);
    }

    @Override
    public String getTableName() {
        return "prijava";
    }

    @Override
    public List<GenericEntity> getList(ResultSet resultSet) throws Exception {
        List<GenericEntity> list = new LinkedList<>();
        while (resultSet.next()) {
            int idKorisnika = resultSet.getInt("idKorisnika");
            Korisnik k = new Korisnik();
            k.setIdKorisnika(idKorisnika);

            int idKursa = resultSet.getInt("idKursa");
            Kurs kurss = new Kurs();
            kurss.setIdKursa(idKursa);

            Date datumPr = resultSet.getDate("datumPrijave");
            String napomen = resultSet.getString("napomena");

            int idGrupe = resultSet.getInt("idGrupe");
            Grupa g = new Grupa();
            g.setIdGrupe(idGrupe);

            Prijava p = new Prijava(k, kurss, datumPr, napomen, g);
            list.add(p);
        }
        return list;
    }

    @Override
    public String getAttributeNames() {
        return "idKorisnika,idKursa,datumPrijave,napomena,idGrupe";
    }

    @Override
    public String getUnknownValues() {
        return "?,?,?,?,?";
        //return "?";
    }

    @Override
    public void prepareStatement(PreparedStatement ps, GenericEntity entity) throws Exception {
//        Prijava p = (Prijava) entity;
//        if (p.getGrupa() == null) {
//            ps.setInt(1, 1);
//            return;
//        }
//        ps.setInt(1, p.getGrupa().getIdGrupe());
        Prijava p = (Prijava) entity;
        ps.setLong(1, p.getKorisnik().getIdKorisnika());
        ps.setLong(2, p.getKurs().getIdKursa());
        ps.setDate(3, p.getDatumPrijave());
        ps.setString(4, p.getNapomena());

        if (p.getGrupa() == null) {
            ps.setInt(5, 1);//dodeljivanje defaultne gr
            return;
        }
        ps.setInt(5, p.getGrupa().getIdGrupe());
    }

    @Override
    public String getUpdateQuery() {
        //return "idGrupe=?";
        return "idKorisnika=?, idKursa=?, datumPrijave=?, napomena=?, idGrupe=?";
    }

    @Override
    public String getID(GenericEntity entity) {
        Prijava p = (Prijava) entity;
        return "idKorisnika =" + p.getKorisnik().getIdKorisnika() + " AND idKursa = " + p.getKurs().getIdKursa();
    }

    @Override
    public String getOrderCondition() {
        //ZA ORDER BY
        return "idKursa";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if (resultSet.next()) {
            int idKorisnika = resultSet.getInt("idKorisnika");
            Korisnik k = new Korisnik();
            k.setIdKorisnika(idKorisnika);

            int idKursa = resultSet.getInt("idKursa");
            Kurs kurss = new Kurs();
            kurss.setIdKursa(idKursa);

            Date datumPr = resultSet.getDate("datumPrijave");
            String napomen = resultSet.getString("napomena");

            int idGrupe = resultSet.getInt("idGrupe");
            Grupa g = new Grupa();
            g.setIdGrupe(idGrupe);

            entity = new Prijava(k, kurss, datumPr, napomen, g);
        }
        return entity;
    }

    @Override
    public String getCondition(GenericEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getLogin(GenericEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
