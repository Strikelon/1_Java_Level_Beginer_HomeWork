package hm5;

//1 Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
//2 Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
//3 У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,; прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ; плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).
//4 При попытке животного выполнить одно из этих действий, оно должно сообщить результат. (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
//5 Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.

public class hm5 {

    public static void main(String[] args) {
        float runDistance=0, swimDistance=0, jumpHeight=0;
        String animalType="Животное";
        Dog dog1=new Dog("Патрик",2010,"Серый");
        Dog dog2=new Dog("Белый клык",2015,"Серый");
        Dog dog3=new Dog("Шарик", 2012, "Коричневый");

        Horse horse1=new Horse("Платва",2014,"Белый");
        Horse horse2=new Horse("Конец-горбунок",2011,"Красный");
        Horse horse3=new Horse("Единорог",2005,"Серебристый");

        Cat cat1=new Cat("Кот в сапогах",2005,"Рыжий");
        Cat cat2=new Cat("Мики Маус",2010,"Черно-белый");
        Cat cat3=new Cat("Сильвестр",2007,"Серый");

        Bird bird1=new Bird("Чик Чирик",2015,"Синий");
        Bird bird2=new Bird("Кеша",2016,"Радужный");
        Bird bird3=new Bird("Говорун",2014,"Синий");

        Animal[] animals=new Animal[12];
        animals[0]=dog1;
        animals[1]=dog2;
        animals[2]=dog3;
        animals[3]=horse1;
        animals[4]=horse2;
        animals[5]=horse3;
        animals[6]=cat1;
        animals[7]=cat2;
        animals[8]=cat3;
        animals[9]=bird1;
        animals[10]=bird2;
        animals[11]=bird3;
        for(int i=0;i<animals.length;i++){
            if(animals[i] instanceof Dog){
                runDistance=500;
                swimDistance=10;
                jumpHeight=0.5f;
                animalType="Собака: ";
            }else if(animals[i] instanceof Horse){
                runDistance=1500;
                swimDistance=100;
                jumpHeight=3;
                animalType="Лошадь: ";
            } else if(animals[i] instanceof Cat){
                runDistance=200;
                swimDistance=10;
                jumpHeight=2;
                animalType="Кот: ";
            } else if(animals[i] instanceof Bird){
                runDistance=5;
                swimDistance=80;
                jumpHeight=0.2f;
                animalType="Птица: ";
            }
            System.out.println(animalType + animals[i].getName()+". Цвет: "+animals[i].getColor()+". Лет: "+animals[i].getAge());
            System.out.println("Может пробежать: "+animals[i].getRunLimit()+" метров. Может проплыть: "+animals[i].getSwimLimit()+" метров. Может перепрыгнуть препятствие высотой: "+animals[i].getJumpLimit()+" метров.");
            animals[i].run(runDistance);
            animals[i].swim(swimDistance);
            animals[i].jump(jumpHeight);
        }


    }
}
