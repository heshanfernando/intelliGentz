/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.DBConnection;
import db.DBHandle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Owner;

/**
 *
 * @author Heshan
 */
public class OwnerController {
    
     public static Boolean addOwner(Owner owner) throws ClassNotFoundException, SQLException {
        String query="INSERT INTO owner VALUES(?,?,?,?,?,?)";
        Object[] data={owner.getOwnerId(),owner.getUserName(),owner.getPassword(),owner.getOwnerName(),owner.getOwnerContactNo(),owner.getOwnerNicNo()};
        boolean status = DBHandle.setData(DBConnection.getConnectionToDB(), query, data);
        return status;
    }

    public static List<Owner> getAllOwners() throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM owner";
        Object[] data={};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        List<Owner> ownerList=new ArrayList<Owner>();
        while(resultSet.next()){
            Owner owner=new Owner(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4), resultSet.getString(5),resultSet.getString(6));
            ownerList.add(owner);
        }
        return ownerList;
    }
    
}
