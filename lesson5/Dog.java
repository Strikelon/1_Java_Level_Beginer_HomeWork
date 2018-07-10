package hm5;

public class Dog extends Animal {

    public Dog(){
        super();
        runLimit=randMethod(500);
        swimLimit=randMethod(10);
        jumpLimit=randMethod(0.5f);
    }

    public Dog(String name, String color){
        super(name,color);
        runLimit=randMethod(500);
        swimLimit=randMethod(10);
        jumpLimit=randMethod(0.5f);
    }

    public Dog(String name, int birthYear, String color){
        super(name,birthYear,color);
        runLimit=randMethod(500);
        swimLimit=randMethod(10);
        jumpLimit=randMethod(0.5f);
    }
}
