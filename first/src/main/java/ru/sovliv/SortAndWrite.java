package ru.sovliv;

import java.io.*;
import java.util.*;

/**
 * Класс с реализацией сортировки текстового файла и его записи в новый файл
 * @author solovev (sovliv@yandex.ru)
 * @since 19.03.2019
 */
public class SortAndWrite extends Thread {

    /**
     * Метод с реализованной сортировкой и записью данных в отдельный файл
     */
    @Override
    public void run() {
        String unsortedFile = "C:/Users/1/Desktop/text.txt";
        String sortFile = "C:/Users/1/Desktop/sort_text.txt";
        List<String> list = new ArrayList<>();
        String str;
        int count = 0;
        System.out.println("2 - run thread sort and write in file...");

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
                count++;
                fw.write(count + " - " + word + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("3 - sort and write in file is done.");
    }
}