package com.perpule.phonepe.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


public class DatabaseController {


    private static String DB_NAME = "data", DB_USER = "rohit", DB_PASS = "SqYr49B6jfjVYUG";
    private static final Logger LOGGER = Logger.getLogger(DatabaseController.class.getName());
    private static String url=null;

    private static Connection createConnectionPool() throws ClassNotFoundException,SQLException,IllegalAccessException,InstantiationException{

        String CLOUD_SQL_CONNECTION_NAME = System.getenv("CLOUD_SQL_INSTANCE_NAME");

        LOGGER.info("Database Name:" + DB_NAME + "Database User:" + DB_USER + "Cloud Instance:" + CLOUD_SQL_CONNECTION_NAME);

        url = "jdbc:google:mysql://perpuleinternship:us-central1:testdata?user=rohit&password=SqYr49B6jfjVYUG";
        Class.forName("com.mysql.jdbc.GoogleDriver").newInstance();
        Connection conn = DriverManager.getConnection(url);
        return conn;

    }


    public static Connection getConnection() throws SQLException {
        if(url == null){
            try{
                createConnectionPool();
            }
            catch (Exception e){}
        }
        return DriverManager.getConnection(url);
    }

}
