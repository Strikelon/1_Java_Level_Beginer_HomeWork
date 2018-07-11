package hm5;

public class Cat extends Animal{
    public Cat(){
        super();
        runLimit=randMethod(200);
        swimLimit=0;
        jumpLimit=randMethod(2);
    }
    public Cat(String name, String color){
        super(name,color);
        runLimit=randMethod(200);
        swimLimit=0;
        jumpLimit=randMethod(2);
    }
    public Cat(String name, int birthYear, String color){
        super(name,birthYear,color);
        runLimit=randMethod(200);
        swimLimit=0;
        jumpLimit=randMethod(2);
    }

    @Override
    public void swim(float swimLength){
        System.out.println("Коты не умеют плавать и не могут проплыть заданное расстояние!");
    }
}
