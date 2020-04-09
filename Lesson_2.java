package Ivan_Gordeev_Homework;

import java.util.Arrays;
import java.util.Random;

public class Lesson_2 {
/*
    1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
*/
    public static void firstTask (byte [] a) {
        for ( byte i = 0; i < a.length; i++) {
            if (a [i] == 0) {
                a [i] = 1;
            } else {
                a [i] = 0;
            }
       }
    }
/*  2 Задать пустой целочисленный массив размером 8.
    Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
*/
    public static void secondTask (int [] a2) {
        for ( int i = 0; i < a2.length; i++) {
            a2[i] = 1 + (i*3);
        }
    }
/*  3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
*/
    public static void thirdTask (int [] a3) {
        for (int i = 0; i < a3.length; i++) {
            if (a3[i] < 6) {
                a3[i] = a3[i]*2;
            }
        }
    }

    //  4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    public static int fourthTaskMax(int[] a4) {
        int maxA4 = a4[0];
        for (int i = 0; i < a4.length; i++) {
            if (maxA4 < a4[i]) {
                maxA4 = a4[i];
            }
        }
        return maxA4;
    }
    public static int fourthTaskMin(int[] a4) {
        int minA4 = a4[0];
        for (int i = 0; i < a4.length; i++) {
            if (minA4 > a4[i]) {
                minA4 = a4[i];
            }
        }
        return minA4;
    }
/*  5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами,
    используя цикл(ы);
*/
    //В задаче не указано обьявление метода для решения, поэтому решение в main

/*  6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3, 4]) → true.
    Абстрактная граница показана символами ||, эти символы в массив не входят.
*/
    public static boolean sixthTask(int [] a6) {
        int left = 0;
        int right = 0;
        for ( int i = 0; i < a6.length; i++) {
            right = 0;
            left += a6[i];
            for (int b = (i+1); b < a6.length; b++) {
                right += a6[b];

               }
            if (left == right) {
                break;}
            }
        return left == right;
            }
/*  7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен циклически сместить все элементы массива на n позиций.
*/
    // Седьмое не осилил к сдаче
/*  8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
*/


    public static void main (String[] args) {

        //Первое задание
        byte[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        firstTask(array1);
        System.out.println("Первое задание - " + Arrays.toString(array1));

        //Второе задание
        int[] array2 = new int[8];
        secondTask(array2);
        System.out.println("\nВторое задание - " + Arrays.toString(array2));

        //Третье задание
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        thirdTask(array3);
        System.out.println("\nТретье задание - " + Arrays.toString(array3));

        //Четвертое задание
        int[] array4 = new int [10];
        for ( int i = 0; i < array4.length; i++) {
            array4[i] = (int) (Math.random()*100);
        }
        System.out.println("\nЧетвертое задание.\nРандомный массив: "+ Arrays.toString(array4) + "\nМаксимальное значение из массива - "
                    + fourthTaskMax(array4) + ".\n" +"Минимальное значение из массива - " + fourthTaskMin(array4) + ".");

        //Пятое задание
        int[][] array5 = new int [5][5];
        System.out.println("\nПятое задание.");
        for ( int i = 0; i < array5.length; i++) {
            array5[i][i] = 1;

            for ( int b = 0; b < array5[i].length; b++) {
                array5[(array5[i].length-1) - b][b] = 1;
                System.out.print(array5[i][b] +"\t");
            }
        System.out.print("\n");
        }

        //Шестое задание
        int[] array6 = new int [10];
        for ( int i = 0; i < array6.length; i++) {
            array6[i] = (int) (Math.random()*10);
        }
        System.out.println("\nШестое задание.\nРандомный массив: "+ Arrays.toString(array6) + "\nЕсть ли баланс в массиве? - "+ sixthTask(array6));

        //Седьмое задание


    }
}

