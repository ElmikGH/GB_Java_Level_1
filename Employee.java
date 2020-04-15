package IG_Homework_Lesson_4;

//    1. Создать класс "Сотрудник" с полями: ФИО, зарплата, возраст;
public class Employee {

    private static int ID = 0;
    private int uniqID;
    private String name;
    private int salary;
    private int age;

//    2. Конструктор класса должен заполнять эти поля при создании объекта;
    Employee (String name, int salary, int age) {
        this.name = name;
        this.age = age;
        this.salary = agesPrize(salary);

//    8. *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный
//       уникальный идентификационный порядковый номер
        uniqID = ID++;

    }
//    6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
//    Пришел к выводу, что уместнее всего делать надбавку через вызов метода в конструкторе, так как эта информация будет частью обьекта.
//    Можно делать это в геттере,но тогда надбавка будет начисляться при выведении значения зарплаты,
//    а в обьекте будет храниться зарплата заданная изначально.
    private int agesPrize(int n) {
        if (this.age > 45)
            n += 5000;
        return n;
    }

//    3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public int getAge() {
        return age;
    }
    public int getID() {
        return uniqID;
    }

}
