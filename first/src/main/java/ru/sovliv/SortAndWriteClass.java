package ru.sovliv;

import java.io.*;
import java.util.*;

/**
 * Класс с реализацией сортировки текстового файла и его записи в новый файл
 * @author solovev (sovliv@yandex.ru)
 * @since 17.03.2019
 */
public class SortAndWriteClass extends DatabaseConnection{

    /**
     * Метод с реализованной сортировкой и записью файла
     */
    public void sortAndWriteFile() {
        String unsortedFile = "C:/Users/1/Desktop/text.txt";
        String sortFile = "C:/Users/1/Desktop/sort_text.txt";
        List<String> list = new ArrayList<>();
        String str;

        try {
            Scanner scanner = new Scanner(new File(unsortedFile));
            while (scanner.hasNext()) {
                str = scanner.next();
                list.add(str);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.printf("cannot find file");
        }
        Collections.sort(list);
        try (FileWriter fw = new FileWriter(sortFile)) {
            for (String word : list) {
                fw.write(word + " \n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}