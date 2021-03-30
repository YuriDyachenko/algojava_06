package kurs;

import java.util.Arrays;
import java.util.Random;

public class ArraysMethods {
    private final int size = 400;
    private final String[] baseArray;
    private final Random random;

    public ArraysMethods() {
        random = new Random();
        baseArray = new String[size];
        fillBaseArray();
    }

    public String[] getCopyOfBaseArray() {
        return Arrays.copyOf(baseArray, size);
    }

    private void fillBaseArray() {
        String consonants = "qwrtpsdfghklzxcvbnmjy";
        String vowels = "euioa";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < baseArray.length; i++) {
            int length = random.nextInt(6) + 5;
            for (int j = 0; j < length; j++) {
                stringBuilder.append(getRandomChar(j % 2 == 0 ? consonants : vowels));
            }
            baseArray[i] = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    private char getRandomChar(String s) {
        return s.charAt(random.nextInt(s.length()));
    }

    public void sort(String[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(String[] arr, int low, int high) {
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        String onMiddle = arr[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i].compareTo(onMiddle) < 0) i++;
            while (arr[j].compareTo(onMiddle) > 0) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);
    }

    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubbleSort(String[] arr) {
        for (int i = arr.length - 1; i >= 1; i--)
            for (int j = 0; j < i; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0) swap(arr, j, j + 1);
    }

    public void selectionSort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0)
                    min = j;
            }
            swap(arr, i, min);
        }
    }

    public void byInsertionSort(String[] arr) {
        int in;
        for (int i = 1; i < arr.length; i++) {
            String buff = arr[i];
            in = i;
            while (in > 0 && arr[in - 1].compareTo(buff) >= 0) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = buff;
        }
    }
}
