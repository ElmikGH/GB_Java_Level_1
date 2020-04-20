package IG_Homework_Lesson_5;

public class Horse extends Animal {
    private final String type = "Лошадь";
    private int runRange = 1000;
    private int jumpRange = 1;
    private int swimRange = 50;

    public Horse (String name){
        super (name);
        runRange += Math.random()*500;
        jumpRange += Math.round(1+Math.random()*2);
        swimRange += Math.round(1+Math.random()*50);
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
            System.out.printf("\nБыстрый %s прыгает.",name);
        else
            System.out.printf("\nБыстрый %s хочет сахарок.",name);

    }

    @Override
    public void swim(float a) {
        if (a <= swimRange)
        System.out.printf("\nБыстрый %s плещется в воде.",name);
        else
        System.out.printf("\nБыстрый %s хочет сахарок.",name);
    }

    @Override
    public void run(float a) {
        if (a <= runRange)
            System.out.printf("\nБыстрый %s мчится вперед.",name);
        else
            System.out.printf("\nБыстрый %s хочет сахарок.",name);
    }
}
