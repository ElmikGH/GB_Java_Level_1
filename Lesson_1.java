package Ivan_Gordeev_Homework;

import java.util.Scanner;

public class Lesson_1 {

/*  1. Написать метод вычисляющий выражение a * (b + (c / d))
    и возвращающий результат с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода;*/
    public static float firstTask(float x, float y, float z, float w) {
        float results = x * (y + (z / w));
        return results;
    }

/*  2. Написать метод, принимающий на вход два целых числа,
    и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;*/
    public static String secondTask(int x2, int y2) {
        int amount = x2 + y2;
        if (amount >= 10 && amount <= 20) {
            return "true";
        } else {
            return "false";
        }
    }

/*  3. Написать метод, которому в качестве параметра передается целое число,
    метод должен проверить положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом.
    Результат работы метода вывести в консоль */
    public static String thirdTask(int x3) {
        if (x3 < 0) {
            return "Ваше число " + x3 + " - это меньше 0, следовательно оно отрицательное.";
        } else {
            return "Ваше число " + x3 + " - это больше или равно 0, следовательно оно положительное.";
        }
    }
/*  4. Написать метод, которому в качестве параметра передается строка,
    обозначающая имя, метод должен вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.*/
    public static String fourthTask(String x4){
        return "Привет, " + x4 + "!";
    }

/*  5. Написать метод, который определяет является ли год високосным.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    Для проверки работы вывести результаты работы метода в консоль */
    public static String fifthTask(float x5) {
        float request = x5/4;
        if (x5 > 99 && x5 < 200) {
            return "Год не високосный.";
        } else if ( x5 > 399 && x5 < 500){
            return "Год високосный.";
        } else if ( request % 1 == 0) {
            return "Год високосный.";
        } else {
            return "Год не високосный.";
        }
    }
    public static void main(String[] args) {
//Первая задача
        int a = 3;
        int b = 1;
        int c = 30;
        int d = 11;
        System.out.println("Первое задание.\nКалибровка вычислительной машины.\nРезультат вычислений первого задания = " + firstTask(a, b, c, d) + "\nНачинаю калибровку консоли.");
//Вторая задача
        Scanner a2 = new Scanner (System.in);
        System.out.println("\nВторое задание.\nВведите 2 целых числа, сумма которых находится в пределах диапазона от 10 до 20 включительно.\nВведите первое целое число: ");
        int userNumber = a2.nextInt();

        Scanner b2 = new Scanner (System.in);
        System.out.println("Введите второе целое число: ");
        int userNumber2 = b2.nextInt();

        System.out.println(secondTask(userNumber, userNumber2));
//Третья задача
        Scanner a3 = new Scanner (System.in);
        System.out.println("\nТретье задание.\nНачинаю калибровку положительных и отрицательных значений.\nВведите число: ");
        int userNumber3 = a3.nextInt();
        System.out.println(thirdTask(userNumber3));
//Четвертая задача
        Scanner a4 = new Scanner (System.in);
        System.out.println("\nЧетвертое задание.\nКалибровка завершена.\nНазовите Ваше имя: ");
        String userNumber4 = a4.next();
        System.out.println(fourthTask(userNumber4));
//Пятая задача
        Scanner a5 = new Scanner (System.in);
        System.out.println("\nПятое задание.\nСекретная программа определения високосности года запущена.\nНапишите год: ");
        int userNumber5 = a5.nextInt();
        System.out.println(fifthTask(userNumber5));

        System.out.println("\nСпасибо за использование нашего терминала.");
        a2.close();
        b2.close();
        a3.close();
        a4.close();
        a5.close();
    }
}


