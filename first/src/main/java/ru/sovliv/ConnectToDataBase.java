package ru.sovliv;

import java.sql.*;

/**
 * Класс реализации подключения к базе данных.
 * @author solovev (sovliv@yandex.ru)
 * @since 17.03.2019
 */
public class ConnectToDataBase extends Thread {

    /**
     *  Константы для подключения к базе данных и запрос для демострации работы
     */
    private static final String URL = "jdbc:mysql://localhost:3306/words"
            + "?verifyServerCertificate=false" + "&useSSL=false" + "&requireSSL=false"
            + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "toor";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    String loadDataInFile = "load data infile 'C:/Users/1/Desktop/sort_text.txt' into table test;";


    /**
     * Метод с реализацией подключения к бд и выполнением запроса mysql
     */
    @Override
    public void run() {
        try {
            System.out.println("1 - run thread connect to db...");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();
            System.out.println("4 - thread connect to db is working...");
            rs = stmt.executeQuery(loadDataInFile);
            System.out.println("5 - data is being added to the db...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("6 - data is added.");
    }
}
