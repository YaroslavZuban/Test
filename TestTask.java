package ru.handh.shool.nsk.zuban;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер матрицы: ");
        int n = scanner.nextInt();//Вводим переменную n с клавиатуры

        while (n < 0) {//Можно было сделать, если n<0 то метод выкидывал ошибку и следовательно добавил бы try{...}   catch(){...}, но не стал. Подумал, что достаточно =)
            System.out.print("Введите n больше нуля: ");
            n = scanner.nextInt();
        }

        creatingArrays(n);
    }

    public static void creatingArrays(int size) {
        ArrayList<double[]> allArrays = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            allArrays.add(fillingArray());//Заполняем allArrays
        }

        for (double[] allArray : allArrays) {
            if (allArray.length % 2 == 0) {
                Arrays.sort(allArray);//Сортировка по возрастанию, данная функция из библиотеки Java
            } else {
                bubbleSort(allArray);//Специально написал самую простую сортировку, хотел добавить больше алгоритмов=)
            }

            System.out.println(Arrays.toString(allArray));//Вывод массива в строчку
        }
    }

    static double[] fillingArray() {// Задаем длину массива с помощью рандома от 1 до 21, в дальнейшем заполняем массив на промежутки от 1 до 200
        Random random = new Random();

        double[] mass = new double[random.nextInt(20 + 1)];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = Math.random() * 200;
        }

        return mass;
    }

    static void bubbleSort(double[] array) {// сортировка пузырьком
        boolean isSorted = true;
        double temp;

        while (isSorted) {
            isSorted = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = true;
                }
            }
        }
    }
}
