package IG_Homework_Lesson_5;


public abstract class Animal {

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
