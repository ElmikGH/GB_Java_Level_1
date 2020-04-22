package IG_Homework_Lesson_6;

import java.io.*;
import java.util.Scanner;

/*
1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
4. ** Написать метод, проверяющий, есть ли указанное слово в папке
 */
public class Main {
    //2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
    private static void fileCompoumd(String nameCompoundFile, String name) {
        try {
            FileInputStream readText = new FileInputStream(name);
            int i;
            FileOutputStream writeText = new FileOutputStream(nameCompoundFile, true);
            PrintStream newEnter = new PrintStream(writeText);
            while ((i = readText.read()) != -1) {
                newEnter.print((char) i);
            }
            writeText.close();
            readText.close();

        } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static String userFileName() {
        userEnter = new Scanner(System.in);
        String bufferText = userEnter.nextLine() + ".txt";
        return bufferText;

    }

    private static String userText() {
        userEnter = new Scanner(System.in);
        String bufferText = userEnter.nextLine();
        return bufferText;

    }

    private static void writeInFile(String name, boolean switcher, String userText) {
        try {
            FileOutputStream writeText = new FileOutputStream(name, switcher);
            PrintStream newEnter = new PrintStream(writeText);
            newEnter.println(userText);
            writeText.close();


        } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void readFile(String name) {
        try {

            FileInputStream readText = new FileInputStream(name);
            int i;
            while ((i = readText.read()) != -1) {
                System.out.print((char) i);
            }
            readText.close();

        } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    //3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
    private static boolean searching(String fileName, String request) {
        char[] userRequest = request.toCharArray();
        boolean checkSearch = false;
        try {
            FileInputStream readText = new FileInputStream(fileName);
            int i;
            int n = 0;
            while ((i = readText.read()) != -1) {
                if (userRequest[n] == ((char) i)) {
                    n++;
                    if (request.length() == n) {
                        checkSearch = true;
                        break;
                    }
                } else {
                    n = 0;
                }
            }
            readText.close();

        } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return checkSearch;
    }

    /*4. ** Написать метод, проверяющий, есть ли указанное слово в папке
     Сделал такую проверку на формат, чтобы не ловить ошибку доступа.
     Можно сделать чтобы формат файла передавал юзер, но я тут и так нагородил)
     Или можно добавить исключения, чтобы ошибка просто выводилась в консоль?*/
    private static void fileFolderExplorer(String folderName, String request) {
        char[] fileType = {'.', 't', 'x', 't'};
        File myFolder = new File(folderName);
        for (File files : myFolder.listFiles()) {
            char[] nameCheck = files.getName().toCharArray();
            int n = 0;
            for (int i = 0; i < nameCheck.length; i++) {
                if (fileType[n] == nameCheck[i])
                    n++;
                else
                    n = 0;
            }
            if (n == 4)
                System.out.println(files.getName() + " " + request + " " + searching(files.getName(), request));

        }

    }

    private static String end() {
        System.out.println("Продолжить? (Press N for exit to main menu)");
        String answer = userText();
        return answer;
    }

    private static int userMenuChoice;
    private static String[] fileArchive = new String[0];
    private static Scanner menuChoice;
    private static Scanner userEnter;
    private static String fileCompoundName;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nЗдравствуйте!\nВас приветствует файловый менеджер Boogle Drive.\nВыберете дальнейшее действие:\n1 - Создать и заполнить файл\n2 - Объединить файлы\n3 - Поиск в файле\n4 - Поиск в файлах директории\n5 - Выйти");
            menuChoice = new Scanner(System.in);
            userMenuChoice = menuChoice.nextInt();
            if (userMenuChoice == 1) {
                while (true) {
                    System.out.println("Сколько файлов создать?");
                    userMenuChoice = menuChoice.nextInt();
                    fileArchive = new String[userMenuChoice];
                    for (int i = 0; i < userMenuChoice; i++) {
                        System.out.println("Напишите название файла: ");
                        fileArchive[i] = userFileName();
                        System.out.println("Напишите что нужно добавить в файл: ");
                        writeInFile(fileArchive[i], false, userText());
                    }
                    for (int i = 0; i < userMenuChoice; i++) {
                        System.out.println("Имя файла: " + fileArchive[i] + "\nСодержимое файла:");
                        readFile(fileArchive[i]);
                    }
                    if (end().equals("N")) {
                        break;
                    }
                }

            } else if (userMenuChoice == 2) {
                while (true) {
                    if (fileArchive.length > 0) {
                        System.out.println("Сколько файлов вы создали за сессию и хотите объединить?");
                        userMenuChoice = menuChoice.nextInt();
                        System.out.println("Напишите название общего файла: ");
                        fileCompoundName = userFileName();
                        for (int i = 0; i < userMenuChoice; i++) {
                            fileCompoumd(fileCompoundName, fileArchive[i]);
                        }
                    } else {
                        System.out.println("Сколько файлов хотите объединить?");
                        userMenuChoice = menuChoice.nextInt();
                        fileArchive = new String[userMenuChoice];
                        System.out.println("Напишите название общего файла: ");
                        fileCompoundName = userFileName();
                        for (int i = 0; i < userMenuChoice; i++) {
                            System.out.println("Напишите " + (i + 1) + "е название файла для объединения: ");
                            fileArchive[i] = userFileName();
                            fileCompoumd(fileCompoundName, fileArchive[i]);
                        }
                    }
                    System.out.println("\nИмя общего файла: " + fileCompoundName + "\nСодержимое: ");
                    readFile(fileCompoundName);
                    if (end().equals("N")) {
                        break;
                    }
                }
            } else if (userMenuChoice == 3) {
                while (true) {
                    System.out.println("Напишите имя файла, затем укажите запрос: ");
                    System.out.println(searching(userFileName(), userText()));
                    if (end().equals("N")) {
                        break;
                    }
                }

            } else if (userMenuChoice == 4) {
                while (true) {
                    System.out.println("Напишите адрес папки для поиска в ней запроса, затем укажите запрос: ");
                    fileFolderExplorer(userText(), userText());
                    if (end().equals("N")) {
                        break;
                    }
                }
            } else if (userMenuChoice == 5) {
                break;
            } else {
                System.out.println("Введите корректное значение.");
            }
        }
        menuChoice.close();
        userEnter.close();
    }
//Адрес директории для проверки запроса: "C:\\Users\\User\\Desktop\\PBC\\Обучение\\Java\\Java_Level_1"
//Текст для проверки:
/*Beer is one of the oldest[1][2][3] and most widely consumed[4] alcoholic drinks in the world, and the third most popular drink overall after water and tea.[5] Beer is brewed from cereal grains—most commonly from malted barley, though wheat, maize (corn), and rice are also used. During the brewing process, fermentation of the starch sugars in the wort produces ethanol and carbonation in the resulting beer.[6] Most modern beer is brewed with hops, which add bitterness and other flavours and act as a natural preservative and stabilizing agent. Other flavouring agents such as gruit, herbs, or fruits may be included or used instead of hops. In commercial brewing, the natural carbonation effect is often removed during processing and replaced with forced carbonation.[7]

Some of humanity's earliest known writings refer to the production and distribution of beer: the Code of Hammurabi included laws regulating beer and beer parlours,[8] and "The Hymn to Ninkasi", a prayer to the Mesopotamian goddess of beer, served as both a prayer and as a method of remembering the recipe for beer in a culture with few literate people.[9][10]

Beer is distributed in bottles and cans and is also commonly available on draught, particularly in pubs and bars. The brewing industry is a global business, consisting of several dominant multinational companies and many thousands of smaller producers ranging from brewpubs to regional breweries. The strength of modern beer is usually around 4% to 6% alcohol by volume (ABV), although it may vary between 0.5% and 20%, with some breweries creating examples of 40% ABV and above.[11]
*/
}
