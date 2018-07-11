package hm5;

public class Horse extends Animal {
    public Horse(){
        super();
        runLimit=randMethod(1500);
        swimLimit=randMethod(100);
        jumpLimit=randMethod(3);
    }
    public Horse(String name, String color){
        super(name,color);
        runLimit=randMethod(1500);
        swimLimit=randMethod(100);
        jumpLimit=randMethod(3);
    }

    public Horse(String name, int birthYear, String color){
        super(name,birthYear,color);
        runLimit=randMethod(1500);
        swimLimit=randMethod(100);
        jumpLimit=randMethod(3);
    }
}
