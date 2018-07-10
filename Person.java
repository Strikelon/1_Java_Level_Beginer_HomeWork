package hm4;

public class Person {
    private static int nextId=0;

    private int idNumber;
    private String name;
    private String position;
    private String phone;
    private int paycheck;
    private int age;


    public Person(){
        this.idNumber=nextId;
        nextId++;
    }

    public Person(String name, String position, String phone, int age, int paycheck){
        this.idNumber=nextId;
        nextId++;
        this.name=name;
        this.position=position;
        this.phone=phone;
        this.age=age;
        this.paycheck=paycheck;

    }

    public int getId(){
        return this.idNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getPosition(){
        return this.position;
    }

    public String getPhone(){
        return this.phone;
    }

    public int getPaycheck(){
        return this.paycheck;
    }

    public int getAge(){
        return this.age;
    }

    public void increasePaycheck(int amount){
        this.paycheck+=amount;
    }

}
