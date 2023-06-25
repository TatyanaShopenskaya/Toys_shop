package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Game {
    private static int num = 1;       //num - счетчик для id
    private static ArrayList<Toys> toys = new ArrayList<>();
    private static PriorityQueue<Toys> award = new PriorityQueue<>();


    public void addToy() {            // функция добавления игрушек для розыгрыша
        Scanner scan = new Scanner(System.in);
        int id1;
        String name1;
        int frequency;
        while (true) {

            System.out.print("Введите наименование игрушки: ");
            name1 = scan.nextLine();
            break;
        }
        System.out.print("Укажите частоту выпадения игрушки: ");
        String value = scan.nextLine();
        if (isDigit(value)) {
            frequency = Integer.parseInt(value);
            if (frequency > 0) {
                Toys toy = new Toys(num, name1, frequency);
                if (!toys.contains(toy) || toys.size() == 0) {
                    num++;
                    toys.add(toy);
                }
            }
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Toys getAward() {                 //функция определения игрушки с наибольшей частотой выпадения
        if (award.size() == 0) {
            //Random rnd = new Random();
            for (Toys toy : toys) {
                for (int i = 0; i < toy.getId(); i++) {
                    Toys temp = new Toys(toy.getId(), toy.getName(), toy.getFrequency());
                    award.add(temp);
                }
            }
        }
        return award.poll();
    }

    public void play() {                      //функция запуска розыгрыша
        if (toys.size() > 1) {
            Toys prize = getAward();
            System.out.println(prize.getName());
            saveResult(prize.getInfo());
        }
    }

    private void saveResult(String text) {    //функция сохранения рез-тов в текстовый файл
        File file = new File("text.txt");
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("text.txt", true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


