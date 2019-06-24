package com.perpule.phonepe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

public class TransactionsDAO {

    String TransactionId;
    String PhoneNumber;
    String Amount;
    String Status;

    private static final Logger LOGGER = Logger.getLogger(DatabaseController.class.getName());
    public TransactionsDAO() {
    }

    public TransactionsDAO(String transactionId, String phoneNumber, String amount, String status) {
        TransactionId = transactionId;
        PhoneNumber = phoneNumber;
        Amount = amount;
        Status = status;
    }

    public TransactionsDAO(TransactionsDAO trans) {
        this.TransactionId = trans.getTransactionId();
        this.PhoneNumber = trans.getPhoneNumber();
        this.Amount = trans.getAmount();
        this.Status = trans.getStatus();
    }

    public void retrieveData(String orderId){
        try {

            Connection conn = DatabaseController.getConnection();
            PreparedStatement getstmt = conn.prepareStatement("SELECT * FROM Transactions WHERE TransactionId LIKE ?");
            getstmt.setString(1, "%" + orderId + "%");
            ResultSet rs = getstmt.executeQuery();
            // iterate through the java resultset
            while (rs.next()) {
                PhoneNumber = rs.getString(2);
                Amount = rs.getString(3);
                Status=rs.getString(4);
            }
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public void insertData(String transactionId, String phoneNumber, Integer amount, String status){
        try{
            Connection conn = DatabaseController.getConnection();
            PreparedStatement setstmt = conn.prepareStatement(
                    "INSERT INTO Transactions (TransactionId, PhoneNumber, Amount, Status) VALUES (?, ?,?,?);");
            setstmt.setString(1, transactionId);
            setstmt.setString(2, phoneNumber);
            setstmt.setString(3, String.valueOf(amount));
            setstmt.setString(4, status);
            setstmt.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateData(String transactionId, String phoneNumber, String amount, String status){
        try{
            Connection conn = DatabaseController.getConnection();

            PreparedStatement setstmt = conn.prepareStatement(
                    "UPDATE Transactions SET PhoneNumber=?, Amount=?, Status=? WHERE TransactionId LIKE ?;");
            setstmt.setString(1, phoneNumber);
            setstmt.setString(2, amount);
            setstmt.setString(3, status);
            setstmt.setString(4, "%"+transactionId+"%");
            setstmt.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getlastID(){
        try{
            Connection conn = DatabaseController.getConnection();
            PreparedStatement getstmt = conn.prepareStatement("SELECT * FROM Transactions ORDER BY TransactionId DESC LIMIT 1");
            ResultSet rs = getstmt.executeQuery();
            String lastId=null;
            while (rs.next()) {
                lastId = rs.getString(1);
            }
            return lastId;
        }catch (Exception e){return null;}
    }

    public void  updateStatus(String transactionId,String status){
        try{
            Connection conn = DatabaseController.getConnection();

            PreparedStatement setstmt = conn.prepareStatement(
                    "UPDATE Transactions SET Status=? WHERE TransactionId LIKE ?;");
            setstmt.setString(1, status);
            setstmt.setString(2, "%"+transactionId+"%");
            setstmt.execute();

        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public String getTransactionId() {
        return TransactionId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAmount() {
        return Amount;
    }

    public String getStatus() {
        return Status;
    }
}
