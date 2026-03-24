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
public class RasporedKursa implements GenericEntity {

    private Grupa grupa;
    private String danUNedelji;
    private int brojCasova;
    private String opisKursa;
    private int sala;
    private String vreme;

    public RasporedKursa() {
    }

    public RasporedKursa(Grupa grupa, String danUNedelji, int brojCasova, String opisKursa, int sala, String vreme) {
        this.grupa = grupa;
        this.danUNedelji = danUNedelji;
        this.brojCasova = brojCasova;
        this.opisKursa = opisKursa;
        this.sala = sala;
        this.vreme = vreme;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public String getDanUNedelji() {
        return danUNedelji;
    }

    public void setDanUNedelji(String danUNedelji) {
        this.danUNedelji = danUNedelji;
    }

    public int getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(int brojCasova) {
        this.brojCasova = brojCasova;
    }

    public String getOpisKursa() {
        return opisKursa;
    }

    public void setOpisKursa(String opisKursa) {
        this.opisKursa = opisKursa;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final RasporedKursa other = (RasporedKursa) obj;
        if (this.brojCasova != other.brojCasova) {
            return false;
        }
        if (this.sala != other.sala) {
            return false;
        }
        if (!Objects.equals(this.danUNedelji, other.danUNedelji)) {
            return false;
        }
        if (!Objects.equals(this.opisKursa, other.opisKursa)) {
            return false;
        }
        if (!Objects.equals(this.vreme, other.vreme)) {
            return false;
        }
        return Objects.equals(this.grupa, other.grupa);
    }
    
    @Override
    public String getTableName() {
        return "rasporedKursa";
    }

    @Override
    public List<GenericEntity> getList(ResultSet resultSet) throws Exception {
        List<GenericEntity> list = new LinkedList<>();
        while(resultSet.next()){
            int idGrupe = resultSet.getInt("idGrupe");
            Grupa g = new Grupa();
            g.setIdGrupe(idGrupe);
            
            String danUNedelji = resultSet.getString("danUNedelji");
            int brojCasova = resultSet.getInt("brojCasova");
            String opisKursa = resultSet.getString("opisKursa");
            int sala = resultSet.getInt("sala");
            String vreme = resultSet.getString("vreme");
            
            RasporedKursa rk = new RasporedKursa(g, danUNedelji, brojCasova, opisKursa, sala, vreme);
            list.add(rk);
        }
        return list;
    }

    @Override
    public String getAttributeNames() {
        return "idGrupe,danUNedelji,brojCasova,opisKursa,sala,vreme";
    }

    @Override
    public String getUnknownValues() {
        return "?,?,?,?,?,?";
    }

    @Override
    public void prepareStatement(PreparedStatement ps, GenericEntity entity) throws Exception {
        RasporedKursa rs = (RasporedKursa) entity;
        ps.setInt(1, rs.getGrupa().getIdGrupe());
        ps.setString(2, rs.getDanUNedelji());
        ps.setInt(3, rs.getBrojCasova());
        ps.setString(4, rs.getOpisKursa());
        ps.setInt(5, rs.getSala());
        ps.setString(6, rs.getVreme());
    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID(GenericEntity entity) {
        return String.valueOf(grupa.getIdGrupe());
    }

    @Override
    public String getOrderCondition() {
        //za order by
        return "idGrupe";
    }

    @Override
    public GenericEntity getResult(ResultSet resultSet) throws Exception {
        GenericEntity entity = null;
        if(resultSet.next()){
           int idGrupe = resultSet.getInt("idGrupe");
           Grupa g = new Grupa();
           g.setIdGrupe(idGrupe);
           
           String danUNedelji = resultSet.getString("danUNedelji");
           int brojCasova = resultSet.getInt("brojCasova");
           String opisKursa = resultSet.getString("opisKursa");
           int sala = resultSet.getInt("sala");
           String vreme = resultSet.getString("vreme");
           
           entity = new RasporedKursa(grupa, danUNedelji, brojCasova, opisKursa, sala, vreme);
        }
        return entity;    }

    @Override
    public String getCondition(GenericEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getLogin(GenericEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
