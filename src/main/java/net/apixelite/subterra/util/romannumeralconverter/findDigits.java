package net.apixelite.subterra.util.romannumeralconverter;

public class findDigits {
    public static int tempDigit = 0;

    public static int getLastDigit(int number) {
        return Math.abs(number % 10);
    }

    public static int getFirstDigit(int number) {
        while (number != 0) {
            tempDigit = Math.abs(number % 10);
            number /= 10;
        }
        return tempDigit;
    }
}
