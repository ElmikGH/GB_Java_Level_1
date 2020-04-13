package Ivan_Gordeev_Homework;

import java.util.Random;
import java.util.Scanner;

public class Lesson_3 {
    private static void userChoise() {
        int win;
        while (true) {
            System.out.print("Введите размер поля по оси X и Y (целый положительные значения)?\n");
            fieldSizeX = SCANNER.nextInt();
            fieldSizeY = SCANNER.nextInt();
            if (fieldSizeX > 0 && fieldSizeY > 0)
                break;
        }
        while (true) {
            System.out.printf("Сколько знаков нужно собрать подряд (положительное значение, не больше сторон поля)?\n");
            win = SCANNER.nextInt();
            if (fieldSizeX > 0 && fieldSizeY > 0 && win > 0 && (win <= fieldSizeX || win <= fieldSizeY))
                break;
            }
        winCheck = win;
    }
    private static int winCheck;
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    // init field
    private static void initMap() {
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    // print field
    private static void printMap() {
        System.out.println("-------");
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    // human turn
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.printf("Введите координаты вашего хода сначала по оси x, затем по оси y:", fieldSizeX);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!(isEmptyCell(y, x) && isValidCell(y, x)));
        field[y][x] = HUMAN_DOT;
    }

    // is cell empty
    private static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    // is cell valid
    private static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
/*  Почему-то не работает валидатор isValidCell, при этом не работает ни один похожий метод для проверки данных от пользователя.
    Попробую починить если успею разобраться с 3м заданием.
    Пока написал костыль в виде 2х циклов на ввод размера поля и условий победы.
    Не успел разобраться с 3м заданием.

    private static boolean isValidCellWin(int n) {
        return n > 0 && n <= fieldSizeX || n <= fieldSizeY;
    }
    private static boolean isValidCellField(int y, int x) {
        return x > 0 && y > 0;
    }
 */
    // ai turn
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(y, x));
        field[y][x] = AI_DOT;
    }

    // check win
    private static boolean checkWin(char c, int n) {
        int countD = 0;
        int count = 0;
        for (int i = 0; i < field.length; i++) {
            if (count < n && countD < n) {
                count = 0;
                countD =0;
                for (int b = 0; b < field.length; b++) {
                    if (field[i][b] == c) {
                        count++;
                    } else if (count >= n) {
                        break;
                    } else {
                        count = 0;
                    }
                }
                for (int b = 0; b < field.length; b++) {
                    if (field[b][i] == c) {
                        count++;
                    } else if (count >= n) {
                        break;
                    } else {
                        count = 0;
                    }
                }
                for (int b = 0; b < field.length; b++) {
                    if (field[b][b] == c) {
                        countD++;
                    } else if (countD >= n) {
                        break;
                    } else {
                        countD = 0;
                    }
                }
                for (int b = 0; b < field.length; b++) {
                    if (field[(field[i].length - 1) - b][b] == c) {
                        countD++;
                    } else if (countD >= n) {
                        break;
                    } else {
                        countD = 0;
                    }
                }
            }
        }
        return count >= n || countD >= n;
    }
 /*       // hor
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        //ver
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        //dia
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
  */

    // check draw
    private static boolean isMapFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(y, x)) return false;
            }
        }
        return true;
    }

    private static boolean gameChecks(char aiDot, String s) {
        if (checkWin(aiDot, winCheck)) {
            System.out.println(s);
            return true;
        }
        if (isMapFull()) {
            System.out.println("draw!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        while (true) {
            userChoise();
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (gameChecks(HUMAN_DOT, "Human win!")) break;
                aiTurn();
                printMap();
                if (gameChecks(AI_DOT, "AI win!")) break;
            }
            System.out.println("Play again (Press 'Y')?");
            if (!SCANNER.next().equals("Y"))
                break;
        }
        SCANNER.close();

    }
}
