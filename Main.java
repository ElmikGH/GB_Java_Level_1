package IG_Homework_Lesson_4;

import java.util.Arrays;

public class Main {

//  4. Вывести при помощи методов из пункта 3 ФИО и возраст.
//     При выполнении 8го задания добавил номер сотрудника.
    private static void printEmployeeInfo (Employee emp1) {
        System.out.printf("\nСотрудник номер: %d \nФИО: %s \nВозраст: %d", emp1.getID(), emp1.getName(), emp1.getAge());
    }

//  5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    private static void oldEmployee(Employee[] array,int n) {
        for (int i = 0; i < array.length; i++ ) {
            if (array[i].getAge() > n)
                printEmployeeInfo(array[i]);
        }
    }
//  7. * Подсчитать средние арифметические зарплаты и возраста
    private static int[] avg (Employee[] array) {
        int[] avgAll = new int[2];
        for (int i = 0; i < array.length; i++) {
            avgAll[0] += array[i].getSalary();
            avgAll[1] += array[i].getAge();
        }
        avgAll[0] /= array.length;
        avgAll[1] /= array.length;

        return avgAll;
    }

    public static void main (String[] args) {
       Employee emp1 = new Employee ("Васильев Василий Васильевич", 100000, 50);
       Employee emp2 = new Employee ("Афанасьев Афанасий Афанасьивеч", 20000, 96);
       Employee emp3 = new Employee ("Иванов Иван Иванович", 40000, 20);
       Employee emp4 = new Employee ("Дорофеев Дорофей Дорофеевич", 80000, 35);
       Employee emp5 = new Employee ("Александров Александ Александрович", 20000, 40);

        Employee[] baseEmployee = {emp1, emp2, emp3, emp4, emp5};

        System.out.printf("\nИнформация о сотрудниках: " );
        printEmployeeInfo(emp1);
        printEmployeeInfo(emp2);
        printEmployeeInfo(emp3);
        printEmployeeInfo(emp4);
        printEmployeeInfo(emp5);
        System.out.printf("\n\nСотрудники старше 40 лет: " );
        oldEmployee(baseEmployee, 40);
        System.out.printf("\n\nСредняя зарплата и средний возраст сотрудников: " + Arrays.toString(avg(baseEmployee)));
    }
}
