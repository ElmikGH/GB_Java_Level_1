package IG_Homework_Lesson_5;

public class Bird extends Animal {
    private final String type = "Птица";
    private int runRange = 5;
    private float jumpRange = 0.2f;
    private final int swimRange = 0;

    public Bird (String name){
        super (name);
        runRange += Math.random()*3;
        jumpRange += Math.random()*1;
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
            System.out.printf("\nМудрый %s прыгает.",name);
        else
            System.out.printf("\nМудрый %s сидит на ветке.",name);

    }

    @Override
    public void swim(float a) {
        if (a <= swimRange)
            System.out.printf("\nМудрый %s плещется в луже.",name);
        else
            System.out.printf("\nМудрый %s сидит на ветке.",name);
    }

    @Override
    public void run(float a) {
        if (a <= runRange)
            System.out.printf("\nМудрый %s переваливается.",name);
        else
            System.out.printf("\nМудрый %s сидит на ветке.",name);
    }
}
