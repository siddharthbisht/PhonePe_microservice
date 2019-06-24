package com.perpule.phonepe.BO;

import com.perpule.phonepe.DAO.DatabaseController;
import com.perpule.phonepe.DAO.TransactionsDAO;

import java.util.logging.Logger;

public class AllocateTransactionId {

    String PhoneNumber;
    String TransactionId;
    Integer TotalAmount;
    private TransactionsDAO transaction;
    private static final Logger LOGGER = Logger.getLogger(DatabaseController.class.getName());


    public AllocateTransactionId() {
    }

    public AllocateTransactionId(String phoneNumber, Integer totalAmount, TransactionsDAO trans) {
        this.PhoneNumber = phoneNumber;
        this.TotalAmount = totalAmount;
        this.transaction=new TransactionsDAO(trans);
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public String Get_transactionID(){
        try {

            //Auto-Increment TransactionId and insert into table
            TransactionId=Integer.toString(Integer.parseInt(transaction.getlastID())+1);
            transaction.insertData(TransactionId,PhoneNumber,TotalAmount,"INITIAL_TXN");
            return TransactionId;


        }catch (Exception e){
            LOGGER.info("failed");
            return null;
        }
    }
}
