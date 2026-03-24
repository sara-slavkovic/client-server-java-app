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
public class Grupa implements GenericEntity {

    private int idGrupe;
    private String nazivGrupe;
    private Date datumPocetkaKursa;
    private Kurs kurs;
    
    private List<RasporedKursa> rasporediKurseva;

    public Grupa() {
    }

    public Grupa(int idGrupe, String nazivGrupe, Date datumPocetkaKursa, Kurs kurs, List<RasporedKursa> rasporediKurseva) {
        this.idGrupe = idGrupe;
        this.nazivGrupe = nazivGrupe;
        this.datumPocetkaKursa = datumPocetkaKursa;
        this.kurs = kurs;
        this.rasporediKurseva = rasporediKurseva;
    }

    public int getIdGrupe() {
        return idGrupe;
    }

    public void setIdGrupe(int idGrupe) {
        this.idGrupe = idGrupe;
    }

    public String getNazivGrupe() {
        return nazivGrupe;
    }

    public void setNazivGrupe(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }

    public Date getDatumPocetkaKursa() {
        return datumPocetkaKursa;
    }

    public void setDatumPocetkaKursa(Date datumPocetkaKursa) {
        this.datumPocetkaKursa = datumPocetkaKursa;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public List<RasporedKursa> getRasporediKurseva() {
        return rasporediKurseva;
    }

    public void setRasporediKurseva(List<RasporedKursa> rasporediKurseva) {
        this.rasporediKurseva = rasporediKurseva;
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
        final Grupa other = (Grupa) obj;
        if (this.idGrupe != other.idGrupe) {
            return false;
        }
        if (!Objects.equals(this.nazivGrupe, other.nazivGrupe)) {
            return false;
        }
        if (!Objects.equals(this.datumPocetkaKursa, other.datumPocetkaKursa)) {
            return false;
        }
        if (!Objects.equals(this.kurs, other.kurs)) {
            return false;
        }
        return Objects.equals(this.rasporediKurseva, other.rasporediKurseva);
    }

    @Override
    public String toString() {
        return "Grupa{" + "idGrupe=" + idGrupe +", \nkurs="+ kurs +", \nnazivGrupe=" + nazivGrupe +  '}';
    }

    @Override
    public String getTableName() {
        return "grupa";
    }

    @Override
    public List<GenericEntity> getList(ResultSet resultSet) throws Exception {
        List<GenericEntity> list = new LinkedList<>();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String naziv = resultSet.getString("nazivGrupe");
            Date datumPocetka = resultSet.getDate("datumPocetkaKursa");
            int idKursa = resultSet.getInt("idKursa");
            
            Kurs k = new Kurs();
            k.setIdKursa(idKursa);
            
            Grupa g = new Grupa(id,naziv, datumPocetka, k, new LinkedList<>());
            list.add(g);
        }
        return list;
    }

    @Override
    public String getAttributeNames() {
        return "id,nazivGrupe,datumPocetkaKursa,idKursa";
    }

    @Override
    public String getUnknownValues() {
        return "?,?,?,?";
    }

    @Override
    public void prepareStatement(PreparedStatement ps, GenericEntity entity) throws Exception {
        Grupa g = (Grupa) entity;
        ps.setInt(1, g.getIdGrupe());
        ps.setString(2, g.getNazivGrupe());
        ps.setDate(3, g.getDatumPocetkaKursa());
        ps.setInt(4, g.getKurs().getIdKursa());
    }

    @Override
    public String getUpdateQuery() {
        return "nazivGrupe=?, datumPocetkaKursa=?, idKursa=?";
    }

    @Override
    public String getID(GenericEntity entity) {
        Grupa grupa = (Grupa) entity;
        return String.valueOf(grupa.getIdGrupe());
    }

    @Override
    public String getOrderCondition() {
        //za order by
        return "idKursa";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if(resultSet.next()){
            int id = resultSet.getInt("id");
            String naziv = resultSet.getString("nazivGrupe");
            Date datumPocetka = resultSet.getDate("datumPocetkaKursa");
            int idKursa = resultSet.getInt("idKursa");
            
            Kurs k = new Kurs();
            k.setIdKursa(idKursa);
            entity = new Grupa(id,naziv, datumPocetka, k, new LinkedList<>());            
        }
        return entity;
    }

    @Override
    public String getCondition(GenericEntity entity) {
        Grupa g = (Grupa) entity;
        return "nazivGrupe LIKE '%" + g.getNazivGrupe() + "%'";
    }

    @Override
    public String getLogin(GenericEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
