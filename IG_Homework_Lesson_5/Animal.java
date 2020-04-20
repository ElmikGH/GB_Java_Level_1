package IG_Homework_Lesson_5;

/*
1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
*/

public abstract class Animal {
/*  2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    В качестве параметра каждому методу передается величина, означающая или длину препятствия
    (для бега и плавания), или высоту (для прыжков).
    3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,;
    прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ; плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).

*/
    protected String name;
    protected int runRange;
    protected float jumpRange;
    protected float swimRange;
    protected String type;

    public Animal (String name) {
        this.name = name;
    }
    public int getRunRange() {
        return runRange;
    }
    public float getJumpRange() {
        return jumpRange;
    }
    public float getSwimRange() {
        return swimRange;
    }
    public String getType() {
        return type;
    }

    public abstract void jump (float a);
    public abstract void swim (float a);
    public abstract void run (float a);


}
