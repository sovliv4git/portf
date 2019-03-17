package ru.sovliv;

import java.sql.*;

/**
 * Класс реализации подключения к базе данных.
 * @author solovev (sovliv@yandex.ru)
 * @since 17.03.2019
 */
public class DatabaseConnection {

    /**
     * Константы для подключения к базе данных и два запроса для демострации работы
     */
    private static final String URL = "jdbc:mysql://localhost:3306/words"
            + "?verifyServerCertificate=false" + "&useSSL=false" + "&requireSSL=false"
            + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "toor";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    String querySelect = "select * from test";
    String loadDataInFile = "load data infile 'C:/Users/1/Desktop/sort_text.txt' into table test;";

    /**
     * Метод с реализацией подключения к бд и выполнением запросов mysql
     */
    public void connectToDB() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(querySelect);
            rs = stmt.executeQuery(loadDataInFile);
            rs = stmt.executeQuery(querySelect);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}