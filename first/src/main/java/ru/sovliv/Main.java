package ru.sovliv;

/**
 * Main class
 * @author solovev (sovliv@yandex.ru)
 * @since 17.03.2019
 */
public class Main extends SortAndWriteClass{

    public static void main(String[] args) {
        Main main = new Main();
        main.sortAndWriteFile();
        main.connectToDB();
    }
}