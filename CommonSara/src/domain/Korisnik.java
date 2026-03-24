/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Korisnik implements GenericEntity {

    private int idKorisnika;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String kontaktTelefon;
    private String mejl;
    private String korisnickoIme;
    private String lozinka;

    public Korisnik() {
    }

    public Korisnik(int idKorisnika, String ime, String prezime, Date datumRodjenja, String kontaktTelefon, String mejl, 
            String korisnickoIme, String lozinka) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.kontaktTelefon = kontaktTelefon;
        this.mejl = mejl;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getMejl() {
        return mejl;
    }

    public void setMejl(String mejl) {
        this.mejl = mejl;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.idKorisnika;
        hash = 13 * hash + Objects.hashCode(this.ime);
        hash = 13 * hash + Objects.hashCode(this.prezime);
        hash = 13 * hash + Objects.hashCode(this.datumRodjenja);
        hash = 13 * hash + Objects.hashCode(this.kontaktTelefon);
        hash = 13 * hash + Objects.hashCode(this.mejl);
        hash = 13 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 13 * hash + Objects.hashCode(this.lozinka);
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
        final Korisnik other = (Korisnik) obj;
        if (this.idKorisnika != other.idKorisnika) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.kontaktTelefon, other.kontaktTelefon)) {
            return false;
        }
        if (!Objects.equals(this.mejl, other.mejl)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        return Objects.equals(this.datumRodjenja, other.datumRodjenja);
    }
    
    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public List<GenericEntity> getList(ResultSet resultSet) throws Exception {
        List<GenericEntity> list = new LinkedList<>();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String imeK = resultSet.getString("ime");
            String prezimeK = resultSet.getString("prezime");
            Date datRodjenja = resultSet.getDate("datumRodjenja");
            String kontaktTel = resultSet.getString("kontaktTelefon");
            String mail = resultSet.getString("mejl");
            String korisnicko = resultSet.getString("korisnickoIme");
            String lozink = resultSet.getString("lozinka");
            
            Korisnik k = new Korisnik(id, imeK, prezimeK, datRodjenja, kontaktTel, mail, korisnicko, lozink);
            list.add(k);
        }
        return list;
    }

    @Override
    public String getAttributeNames() {
        return "ime,prezime,datumRodjenja,kontaktTelefon,mejl,korisnickoIme,lozinka";
    }

    @Override
    public String getUnknownValues() {
        return "?,?,?,?,?,?,?";
    }

    @Override
    public void prepareStatement(PreparedStatement ps, GenericEntity entity) throws Exception {
        Korisnik k = (Korisnik) entity;
        ps.setString(1, k.getIme());
        ps.setString(2, k.getPrezime());
        ps.setDate(3,k.getDatumRodjenja());
        ps.setString(4, k.getKontaktTelefon());
        ps.setString(5, k.getMejl());
        ps.setString(6, k.getKorisnickoIme());
        ps.setString(7, k.getLozinka());
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID(GenericEntity entity) {
        Korisnik k = (Korisnik) entity;
        return String.valueOf(k.getIdKorisnika());
    }

    @Override
    public String getOrderCondition() {
        //za order by
        return "ime";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if(resultSet.next()){
            int id = resultSet.getInt("id");
            String imeK = resultSet.getString("ime");
            String prezimeK = resultSet.getString("prezime");
            Date datRodjenja = resultSet.getDate("datumRodjenja");
            String kontaktTel = resultSet.getString("kontaktTelefon");
            String mail = resultSet.getString("mejl");
            String korisnicko = resultSet.getString("korisnickoIme");
            String lozink = resultSet.getString("lozinka");
            
            entity = new Korisnik(id, imeK, prezimeK, datRodjenja, kontaktTel, mail, korisnicko, lozink);
        }
        return entity;
    }

    @Override
    public String getCondition(GenericEntity entity) {
        Korisnik k = (Korisnik) entity;
        return "ime LIKE '%" + k.getIme() + "%' AND prezime LIKE '%" + k.getPrezime() + "%'";
    }
    
    //provera za registraciju
    public String uslovZaParametre(GenericEntity entity){
        Korisnik k = (Korisnik) entity;
        return "mejl LIKE '" + k.getIme() + "' OR korisnickoIme LIKE'" + k.getPrezime() + "'";
    }

    @Override
    public String getLogin(GenericEntity entity) {
        Korisnik k = (Korisnik) entity;
        return "korisnickoIme='" + k.getKorisnickoIme() + "' AND lozinka='" + k.getLozinka() + "'";
    }
}
