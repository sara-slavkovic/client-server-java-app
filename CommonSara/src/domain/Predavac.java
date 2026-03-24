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
public class Predavac implements GenericEntity {

    private int idPredavaca;
    private String ime;
    private String prezime;
    private String email;

    public Predavac() {
    }

    public Predavac(int idPredavaca, String ime, String prezime, String email) {
        this.idPredavaca = idPredavaca;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public int getIdPredavaca() {
        return idPredavaca;
    }

    public void setIdPredavaca(int idPredavaca) {
        this.idPredavaca = idPredavaca;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        final Predavac other = (Predavac) obj;
        if (this.idPredavaca != other.idPredavaca) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getTableName() {
        return "predavac";
    }

    @Override
    public List<GenericEntity> getList(ResultSet resultSet) throws Exception {
        List<GenericEntity> list = new LinkedList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String ime = resultSet.getString("ime");
            String prezime = resultSet.getString("prezime");
            String email = resultSet.getString("email");

            Predavac p = new Predavac(id, ime, prezime, email);
            list.add(p);
        }
        return list;
    }

    @Override
    public String getAttributeNames() {
        return "ime,prezime,email";
    }

    @Override
    public String getUnknownValues() {
        return "?,?,?";
    }

    @Override
    public void prepareStatement(PreparedStatement ps, GenericEntity entity) throws Exception {
        Predavac p = (Predavac) entity;
        ps.setInt(1, p.getIdPredavaca());
        ps.setString(2, p.getIme());
        ps.setString(3, p.getPrezime());
        ps.setString(4, p.getEmail());
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID(GenericEntity entity) {
        Predavac p = (Predavac) entity;
        return String.valueOf(p.getIdPredavaca());
    }

    @Override
    public String getOrderCondition() {
        //za order by
        return "ime";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String ime = resultSet.getString("ime");
            String prezime = resultSet.getString("prezime");
            String email = resultSet.getString("email");

            entity = new Predavac(id, ime, prezime, email);
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
