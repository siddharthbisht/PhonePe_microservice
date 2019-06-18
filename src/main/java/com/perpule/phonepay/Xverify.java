package com.perpule.phonepay;

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

import static java.security.spec.MGF1ParameterSpec.SHA256;

public class Xverify {


    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public Xverify() { }

    String responseData;
    String merchantId = "M2306160483220675579140 ";
    String transactionId = "TX123456789";
    String merchantOrderId = "M123456789";
    Integer amount = 100;
    String instrumentType = "MOBILE";
    String instrumentReference = "9999999999";
    String message = "collect for XXX order";
    String email = "amitxxx75@gmail.com";
    Integer expiresIn = 180;
    String storeId = "store1";
    String terminalId = "terminal1";
    String salt_key="8289e078-be0b-484d-ae60-052f117f8deb";
    String salt_index="1";

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

        public void xverify_main(){

            TreeMap payload = new TreeMap();
            payload.put("merchantId", merchantId);
            payload.put("transactionId", transactionId);
            payload.put("merchantOrderId", merchantOrderId);
            payload.put("amount", amount);
            payload.put("instrumentType", instrumentType);
            payload.put("instrumentReference", instrumentReference);
            payload.put("message", message);
            payload.put("email", email);
            payload.put("expiresIn", expiresIn);
            payload.put("storeId", storeId);
            payload.put("terminalId", terminalId);
        try {
            URL transactionURL = new URL("http://mercury-uat.phonepe.com/v3/charge");
            JSONObject obj = new JSONObject(payload);
            String auth = obj.toString();
            String postData = Base64.getEncoder().encodeToString((auth).getBytes());
            String xverify = SHA256(postData+ "/v3/service/access" + salt_key) + "###" + salt_index;

            HttpURLConnection connection = (HttpURLConnection) transactionURL.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-verify",xverify);
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
            requestWriter.writeBytes(postData);
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

