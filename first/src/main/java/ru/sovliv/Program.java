package ru.sovliv;

/**
 * Main class
 * @author solovev (sovliv@yandex.ru)
 * @since 19.03.2019
 */

public class Program {

    public static void main(String[] args) {
        ConnectToDataBase conToDB = new ConnectToDataBase();
        SortAndWrite sortAndWrite = new SortAndWrite();

        conToDB.start();
        conToDB.yield();
        sortAndWrite.start();
    }
}
