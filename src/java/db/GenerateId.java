/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

/**
 *
 * @author Heshan
 */
public class GenerateId {
    
    public static String generateId(String prefix, String table, String column) throws ClassNotFoundException, SQLException{
        String sql="select "+column+" from "+table+" order by "+column+" desc limit 1 ";
        Object[] data=new Object[]{};
        ResultSet resultSet=DBHandle.getData(DBConnection.getConnectionToDB(),sql,data);
        String lastId=null;
        int index=0;
        if(resultSet.next()){
            lastId = resultSet.getString(1);
            for (int i = 0; i < lastId.length(); i++) {
                char c=lastId.charAt(i);
                if(Character.isDigit(c)){
                    index=i;
                    break;
                }
            }
            
            String number=lastId.substring(index);
            int intNumber=Integer.parseInt(number);
            intNumber++;

            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);

            String newId=prefix+numberFormat.format(intNumber);
            return newId;
        }else{
            return prefix+"001";
        }
    }
    
}
