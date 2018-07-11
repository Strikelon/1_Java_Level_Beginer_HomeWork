package hm5;

public class Bird extends Animal{
    public Bird(){
        super();
        runLimit=randMethod(5);
        swimLimit=0;
        jumpLimit=randMethod(0.2f);
    }
    public Bird(String name, String color){
        super(name,color);
        runLimit=randMethod(5);
        swimLimit=0;
        jumpLimit=randMethod(0.2f);
    }
    public Bird(String name, int birthYear, String color){
        super(name,birthYear,color);
        runLimit=randMethod(5);
        swimLimit=0;
        jumpLimit=randMethod(0.2f);
    }

    @Override
    public void swim(float swimLength){
        System.out.println("Птицы не умеют плавать и не могут проплыть заданное расстояние!");
    }
}
