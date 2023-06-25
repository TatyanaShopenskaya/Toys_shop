package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Выберите действие:
                   1 Введите наименование игрушки и частоту выпадения
                   2 Провести игру
                   3 Выйти из игры (Не забудьте выполнить выход после проведения розыгрыша!)
                    >\s""");
            var selection = s.next();
            switch (selection) {
                case "1" -> game.addToy();
                case "2" -> game.play();
                case "3" -> System.exit(0);
                }
            }
        }
    }
