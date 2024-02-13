package Calk;

import java.util.Scanner;
import static Calk.RomanNumerals.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        try {
            System.out.println(calc(value));
        } catch (GeneralExeption e) {
            System.out.println(e.getMessage());
        }



    }

    public static String calc(String input) throws GeneralExeption {

        input = input.replaceAll("\\s+","");

        String[] split = input.split("[+|*|\\-|/]");

//        return split;

        if (split.length > 2) {
            throw new GeneralExeption("Введено больше 2х цифр или отрицательное значение");
        } else if (split.length < 2) {
            throw new GeneralExeption("Введено меньше 2х цифр или введена не верная арифметическая операция. Можно использовать только '+','-','*','/'");
        } else if (split[0].equals("")) {
            throw new GeneralExeption("Введено меньше 2х цифр или введена не верная арифметическая операция. Можно использовать только '+','-','*','/'");
        }

        String[] ari = {"+", "-", "*", "/"};

        int index = 0;
        for (int i = 0; i < ari.length; i++) {
            if (input.contains(ari[i])) {
                index = i;
                break;
            }
        }


        if (!(check(split[0]) == check(split[1]))) {
            throw new GeneralExeption("Неправильный формат ввода чисел. Можно использовать только арабские или только римские числа.");
        }


        if (check(split[0])) {

            String one = split[0];
            String two = split[1];

            int intOne = toArabic(one);
            int intTwo = toArabic(two);

            if (!(intOne > 0 && intOne <= 10 && intTwo > 0 && intTwo <= 10)) {
                throw new GeneralExeption("Вводимые числа должны быть от 1 до 10");
            }

            int res;

            switch (ari[index]) {
                case "+":
                    res = intOne + intTwo;
                    break;
                case "-":
                    res = intOne - intTwo;
                    break;
                case "*":
                    res = intOne * intTwo;
                    break;
                case "/":
                    res = intOne / intTwo;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ari[index]);
            }
            if (res <= 0) {
                throw new GeneralExeption("Результат работы с римскими числами не может быть нулём или отрицательным значением.");
            }
            String result = toRoman(res);
            return result;

        }


        if (!check(split[0])) {

            if(!(split[0].matches("[0-9]+") && split[1].matches("[0-9]+"))){
                throw new GeneralExeption("Введена неверная римская цифра");
            }

                Integer one = Integer.parseInt(split[0]);
                Integer two = Integer.parseInt(split[1]);




            if (!(one > 0 && one <= 10 && two > 0 && two <= 10)) {
                throw new GeneralExeption("Вводимые числа должны быть от 1 до 10");
            }


            int res = 0;

            switch (ari[index]) {
                case "+":
                    res = one + two;
                    break;
                case "-":
                    res = one - two;
                    break;
                case "*":
                    res = one * two;
                    break;
                case "/":
                    res = one / two;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ari[index]);
            }
            String result = String.valueOf(res);
            return result;

        }
        String q = new String("a");
        return q;
    }
}