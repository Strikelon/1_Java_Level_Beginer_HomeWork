package hm5;

import java.util.Random;

public abstract class Animal extends Object {
    protected int currentYear = 2018;

    protected String name;
    protected final int birthYear;
    protected String color;

    protected float runLimit;
    protected float jumpLimit;
    protected float swimLimit;

    public Animal(){
        this.birthYear=currentYear;
    }

    public Animal(String name, String color){
        this();
        this.name=name;
        this.color=color;
    }

    public Animal(String name, int birthYear, String color){
        this.name=name;
        this.birthYear=birthYear;
        this.color=color;
    }

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    public final int getAge(){
        return this.currentYear-this.birthYear;
    }

    public float getRunLimit(){
        return this.runLimit;
    }

    public float getJumpLimit(){
        return this.jumpLimit;
    }

    public float getSwimLimit(){
        return this.swimLimit;
    }

    public void run(float runLength){
        if(runLength<=runLimit){
            System.out.println(this.name+" успешно пробежал расстояние: "+runLength+" метров!");
        }else System.out.println(this.name+" не может пробежать расстояние: "+runLength+" метров. Его лимит: "+this.runLimit+" метров!");
    }

    public void swim(float swimLength){
        if(swimLength<=swimLimit){
            System.out.println(this.name+" успешно проплыл расстояние: "+swimLength+" метров!");
        }else System.out.println(this.name+" не может проплыть расстояние: "+swimLength+" метров. Его лимит: "+this.swimLimit+" метров!");
    }

    public void jump(float jumpHeight){
        if(jumpHeight<=jumpLimit){
            System.out.println(this.name+" успешно перепрыгнул препятствие высотой: "+jumpHeight+" метров!");
        }else System.out.println(this.name+" не может перепрыгнуть высоту: "+jumpHeight+" метров. Его лимит: "+this.jumpLimit+" метров!");
    }

    protected static float randMethod(float a){
        Random rand = new Random();
        return a+(a*rand.nextInt(21)/100)-(a*rand.nextInt(21)/100);
    }
}
