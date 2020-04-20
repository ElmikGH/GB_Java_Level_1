package IG_Homework_Lesson_5;

public class Cat extends Animal {
    private final String type = "Кот";
    private int runRange = 100;
    private float jumpRange = 0;
    private float swimRange = 0;

    public Cat (String name){
        super (name);
        runRange += Math.random()*100;
        jumpRange += Math.round(1+Math.random()*3);
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

    @Override
    public void jump(float a) {
        if (a <= jumpRange)
            System.out.printf("\nГрозный %s прыгает.",name);
        else
            System.out.printf("\nГрозный %s спит в коробке.",name);
    }

    @Override
    public void swim(float a) {
        if (a <= swimRange)
            System.out.printf("\nГрозный %s рассекает волны.",name);
        else
            System.out.printf("\nГрозный %s спит в коробке.",name);
    }


    @Override
    public void run(float a) {
        if (a <= runRange)
            System.out.printf("\nГрозный %s мчится вперед.",name);
        else
            System.out.printf("\nГрозный %s спит в коробке.",name);
    }
}
