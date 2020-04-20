package IG_Homework_Lesson_5;

public class Dog extends Animal{
    private final String type = "Собака";
    private int runRange = 500;
    private float jumpRange =  0.5f;
    private int swimRange = 0;

    public Dog (String name){
        super (name);
        runRange += Math.random()*300;
        jumpRange += Math.round(1+Math.random()*3);
        swimRange += Math.round(1+Math.random()*5);
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
            System.out.printf("\nСвирепый %s прыгает.",name);
        else
            System.out.printf("\nСвирепый %s лежит у миски.",name);


    }

    @Override
    public void swim(float a) {
        if (a <= swimRange)
            System.out.printf("\nСвирепый %s рассекает волны.",name);
        else
            System.out.printf("\nСвирепый %s лежит у миски.",name);
    }

    @Override
    public void run(float a) {
        if (a <= runRange)
            System.out.printf("\nСвирепый %s несется вперед.",name);
        else
            System.out.printf("\nСвирепый %s лежит у миски.",name);
    }
}
