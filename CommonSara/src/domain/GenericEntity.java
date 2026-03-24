/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Korisnik
 */
public interface GenericEntity extends Serializable {

    public String getTableName();
    public List<GenericEntity> getList(ResultSet resultSet) throws Exception;
    public String getAttributeNames();
    public String getUnknownValues();
    public void prepareStatement(PreparedStatement ps, GenericEntity entity) throws Exception;
    public String getUpdateQuery();
    public String getID(GenericEntity entity);
    public String getOrderCondition();
    public GenericEntity getResult(ResultSet resultSet) throws Exception;
    public String getCondition(GenericEntity entity);
    public String getLogin(GenericEntity entity);

}
