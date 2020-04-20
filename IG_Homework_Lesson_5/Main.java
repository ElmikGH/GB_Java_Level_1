package IG_Homework_Lesson_5;


import java.util.Scanner;

public class Main {
/*
1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.

2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
   В качестве параметра каждому методу передается величина, означающая или длину препятствия
   (для бега и плавания), или высоту (для прыжков).

3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,; прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
   плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).

4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат. (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')

5. **** Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
*/
        private static void printTest (Animal[] p) {
                for (int i = 0; i < p.length; i++) {
                        if (p[i].getSwimRange() <= 0)
                                System.out.printf("\n%s по имени %s бегает на " + p[i].getRunRange() + " метров, прыгает на " + p[i].getJumpRange() + " м., не умеет плавать.", p[i].getType(), p[i].name);
                        else
                                System.out.printf("\n%s по имени %s бегает на " + p[i].getRunRange() + " метров, прыгает на " + p[i].getJumpRange() + " м., плавает на " + p[i].getSwimRange() + "м..", p[i].getType(), p[i].name);
                }
        }

        private static void allJump (Animal[] p, float a) {
                for (int i = 0; i < p.length; i++ ) {
                        p[i].jump(a);
                }
        }

        private static void allRun (Animal[] p, float a) {
                for (int i = 0; i < p.length; i++ ) {
                        p[i].run(a);
                }
        }

        private static void allSwim (Animal[] p, float a) {
                for (int i = 0; i < p.length; i++ ) {
                        p[i].swim(a);
                }
        }

        private static void animalsMove (Animal[] p) {
                while (true) {
                        float distance;
                        int userChoice;
                        System.out.println("\nЧто сделать нашим зверюшкам?\n1 - попрыгать \n2 - плыть \n3 - бежать \n4 - выйти");
                        Scanner newScanner = new Scanner(System.in);
                        userChoice = newScanner.nextInt();
                        if (userChoice == 4)
                                break;
                        System.out.println("На сколько метров?");
                        distance = newScanner.nextFloat();

                        if (userChoice == 1) {
                                allJump(p, distance);
                        } else if (userChoice == 2) {
                                allSwim(p, distance);
                        } else if (userChoice == 3) {
                                allRun(p, distance);
                        } else
                                System.out.println("Введите, пожалуйста верные значения.");
                }
        }

        public static void main (String[] args) {

                Cat c1 = new Cat ("Сигурд");
                Cat c2 = new Cat ("Зигфрид");
                Horse h1 = new Horse ("Слейпнир");
                Bird b1 = new Bird ("Ведрфельнир");
                Dog d1 = new Dog ("Гарм");

                Animal[] panteon = {c1, c2, h1, b1, d1};
                printTest (panteon);
                animalsMove(panteon);
        }
}
