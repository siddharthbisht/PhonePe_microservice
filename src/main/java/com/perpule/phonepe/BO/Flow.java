package com.perpule.phonepe.BO;

import com.perpule.phonepe.DAO.TransactionsDAO;

public abstract class Flow {


    private Boolean InitiateBool=false;
    private String DebitResponse=null;


    public Flow(){}

    //GENERAL APIs FLOW SPLITTER

    AllocateTransactionId allocateTransactionId;

    public String Inititate( String phoneNumber, Integer totalAmount ){
        String transactionId;
        AllocateTransactionId allocate=new AllocateTransactionId(phoneNumber,totalAmount,new TransactionsDAO());
        transactionId=allocate.getTransactionId();



        return transactionId;

    }


}

