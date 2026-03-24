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
public class TipSminkanja implements GenericEntity {

    private int idTipaSminkanja;
    private String nazivTipaSminkanja;

    public TipSminkanja() {
    }

    public TipSminkanja(int idTipaSminkanja, String nazivTipaSminkanja) {
        this.idTipaSminkanja = idTipaSminkanja;
        this.nazivTipaSminkanja = nazivTipaSminkanja;
    }

    public int getIdTipaSminkanja() {
        return idTipaSminkanja;
    }

    public void setIdTipaSminkanja(int idTipaSminkanja) {
        this.idTipaSminkanja = idTipaSminkanja;
    }

    public String getNazivTipaSminkanja() {
        return nazivTipaSminkanja;
    }

    public void setNazivTipaSminkanja(String nazivTipaSminkanja) {
        this.nazivTipaSminkanja = nazivTipaSminkanja;
    }

    @Override
    public String toString() {
        return nazivTipaSminkanja;
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
        final TipSminkanja other = (TipSminkanja) obj;
        if (this.idTipaSminkanja != other.idTipaSminkanja) {
            return false;
        }
        return Objects.equals(this.nazivTipaSminkanja, other.nazivTipaSminkanja);
    }

    @Override
    public String getTableName() {
        return "tipSminkanja";
    }

    @Override
    public List<GenericEntity> getList(ResultSet resultSet) throws Exception {
        List<GenericEntity> list = new LinkedList<>();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String naziv = resultSet.getString("nazivTipaSminkanja");
            
            TipSminkanja ts = new TipSminkanja(id, naziv);
            list.add(ts);
        }
        return list;
    }

    @Override
    public String getAttributeNames() {
        return "nazivTipaSminkanja";
    }

    @Override
    public String getUnknownValues() {
        return "?";
    }

    @Override
    public void prepareStatement(PreparedStatement ps, GenericEntity entity) throws Exception {
        TipSminkanja tipSminkanja = (TipSminkanja) entity;
        ps.setString(1, tipSminkanja.getNazivTipaSminkanja());
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID(GenericEntity entity) {
        TipSminkanja tipSminkanja = (TipSminkanja) entity;
        return String.valueOf(tipSminkanja.getIdTipaSminkanja());
    }

    @Override
    public String getOrderCondition() {
        //za order by
        return "nazivTipaSminkanja";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if(resultSet.next()){
            int id = resultSet.getInt("id");
            String naziv = resultSet.getString("nazivTipaSminkanja");
            
            entity = new TipSminkanja(id, naziv);
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
