package com.perpule.phonepe.BO.Phonepe;
import com.perpule.phonepe.BO.Flow;
import com.perpule.phonepe.DAO.CustomerDAO;
import com.perpule.phonepe.DAO.DatabaseController;
import com.perpule.phonepe.DAO.TransactionsDAO;
import com.perpule.phonepe.model.RequestPaymentRequest;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.TreeMap;
import java.util.logging.Logger;

public class RequestPayment {

    public RequestPayment(){}

    private static final Logger LOGGER = Logger.getLogger(DatabaseController.class.getName());
    private String responseData;
    private RequestPaymentRequest request;
    private TransactionsDAO transac;


    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public RequestPayment(String instrumentReference, TransactionsDAO txn){
        this.request=new RequestPaymentRequest(instrumentReference);
        this.transac=new TransactionsDAO(txn);
    }


    public static String SHA256(String input) {
        try {
            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown"
                    + " for incorrect algorithm: " + e);
            return null;
        }
    }
    public void requestpayment_main(){
        try {
            accessURL();

        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

    private void accessURL(){
        Flow flow;
        flow = new PhonePePaymentRequest();
        transac.retrieveData(request.getInstrumentReference());
        String txnID = flow.Inititate(request.getInstrumentReference(),request.getAmount());

        TreeMap payload = new TreeMap();
        payload.put("merchantId", request.getMerchantId());
        //payload.put("transactionId", request.getTransactionId());
        payload.put("transactionId", txnID);
        payload.put("merchantOrderId", request.getMerchantOrderId());
        payload.put("amount", request.getAmount());
        payload.put("instrumentType", request.getInstrumentType());
        payload.put("instrumentReference", request.getInstrumentReference());
        payload.put("message", request.getMessage());
        payload.put("email", request.getEmail());
        payload.put("expiresIn", request.getExpiresIn());
        payload.put("storeId", request.getStoreId());
        payload.put("terminalId", request.getTerminalId());
        TreeMap body = new TreeMap();
        try {
            URL transactionURL = new URL("https://mercury-uat.phonepe.com/v3/charge");
            JSONObject obj = new JSONObject(payload);
            String auth = obj.toString();
            String postData = Base64.getEncoder().encodeToString((auth).getBytes());
            String xverify = SHA256(postData+ "/v3/charge" + request.getSalt_key()) + "###" + request.getSalt_index();
            body.put("request", postData);
            JSONObject obj1 = new JSONObject(body);
            String auth1 = obj1.toString();
            HttpURLConnection connection = (HttpURLConnection) transactionURL.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-verify",xverify);
            connection.setRequestProperty("x-callback-url","https://perpuleinternship.appspot.com/requestpayment");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
            requestWriter.writeBytes(auth1);
            requestWriter.close();
            InputStream is = connection.getInputStream();
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
            if ((responseData = responseReader.readLine()) != null) {
                System.out.append("Response Json = " + responseData);
            }
            System.out.append("Requested Json = " + xverify + " ");
            System.out.append("\nRequested Json = " + postData + " ");
            responseReader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}