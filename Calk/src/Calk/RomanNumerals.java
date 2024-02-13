package Calk;

import java.util.*;

class RomanNumerals {

    public static String toRoman(int value) {

        TreeMap<Integer, String> romeNumbers = new TreeMap<>();
        romeNumbers.put(1, "I");
        romeNumbers.put(4, "IV");
        romeNumbers.put(5, "V");
        romeNumbers.put(9, "IX");
        romeNumbers.put(10, "X");
        romeNumbers.put(40, "XL");
        romeNumbers.put(50, "L");
        romeNumbers.put(90, "XC");
        romeNumbers.put(100, "C");



        int a = romeNumbers.floorKey(value);
        if (value == a) {
            return romeNumbers.get(value);
        }
        return romeNumbers.get(a) + toRoman(value - a);
    }




    static HashMap<Character, Integer> arabicNumbers = new HashMap<>();
    static {
        arabicNumbers.put('I', 1);
        arabicNumbers.put('V', 5);
        arabicNumbers.put('X', 10);
    }


    public static int toArabic(String value) {


        char[] array = value.toCharArray();

        if (array.length == 1 && arabicNumbers.containsKey(array[0])) {
            return arabicNumbers.get(array[0]);
        }

        int result = arabicNumbers.get(array[array.length - 1]);

        for (int i = array.length - 1; i > 0; i--) {

            if (array[i] > array[i - 1]) {
                result -= arabicNumbers.get(array[i - 1]);
            } else if (array[i] <= array[i - 1]) {
                result += arabicNumbers.get(array[i - 1]);
            }
        }
        return result;


    }

    public static boolean check(String a) {
        return arabicNumbers.containsKey(a.charAt(0));
    }


}