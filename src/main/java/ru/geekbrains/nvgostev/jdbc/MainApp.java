package ru.geekbrains.nvgostev.jdbc;

import java.util.Arrays;


public class MainApp {

    public static int[] afterFour(int[] arr) {
        boolean hasFour = false;
        int indexOfFour = 0;

        if (arr == null || arr.length == 0) {
            throw new RuntimeException();
        }

        for (int number : arr) {
            if (number == 4)
                hasFour = true;
        }

        if (hasFour) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) indexOfFour = i + 1;
            }
        } else throw new RuntimeException();

        return Arrays.copyOfRange(arr, indexOfFour, arr.length);
    }

    public static boolean oneAndFourCheck(int[] arr) {

        for (int num : arr) {
            if (!(num == 1 || num == 4)) {
                return false;
            }
        }
        float sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (sum / arr.length == 4 || sum / arr.length == 1) {
            return false;
        }
        return true;
    }

}
