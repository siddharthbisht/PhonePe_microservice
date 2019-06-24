package com.perpule.phonepe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String PhoneNumber;
    private String Name;



    public CustomerDAO() {
    }

    public CustomerDAO(CustomerDAO cust) {
        this.PhoneNumber = cust.getPhoneNumber();
        this.Name = cust.getName();
    }

    public CustomerDAO(String phoneNumber, String name) {
        PhoneNumber = phoneNumber;
        Name = name;

    }


    public void retrieveData(String phoneNumber){
        try {

            Connection conn = DatabaseController.getConnection();
            PreparedStatement getstmt = conn.prepareStatement("SELECT * FROM test WHERE PhoneNumber LIKE ?");
            getstmt.setString(1, "%" + phoneNumber + "%");
            ResultSet rs = getstmt.executeQuery();
            // iterate through the java resultset
            while (rs.next()) {
                PhoneNumber = rs.getString(1);

            }
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public void insertData(String phoneNumber, String name){
        try{
            Connection conn = DatabaseController.getConnection();
            PreparedStatement setstmt = conn.prepareStatement(
                    "INSERT INTO test (PhoneNumber,Name) VALUES (?, ?);");
            setstmt.setString(1, phoneNumber);
            setstmt.setString(2, name);
            setstmt.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*public void updateData(String phoneNumber, String accessToken, String state, String expires, String customerId){
        try{
            Connection conn = DatabaseController.getConnection();
            PreparedStatement setstmt = conn.prepareStatement(
                    "UPDATE Customer SET AccessToken = ?, State = ?,Expires=?, CustomerId=? WHERE PhoneNumber LIKE ?;");
            setstmt.setString(1, accessToken);
            setstmt.setString(2, state);
            setstmt.setString(3, expires);
            setstmt.setString(4, customerId);
            setstmt.setString(5, "%"+phoneNumber+"%");
            setstmt.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    //We need to call retrieve function from getCustomerId method


}
