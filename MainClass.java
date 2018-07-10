package hm4;

public class MainClass {

//1    Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
//2    Конструктор класса должен заполнять эти поля при создании объекта;
//3    Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
//4    Вывести при помощи методов из пункта 3 ФИО и должность.
//5    Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
//6*   Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
//7**  Написать методы (принимающие на вход массив сотрудников), вычисляющие средний возраст и среднюю зарплату сотрудников, вывести результаты работы в консоль.
//8*** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер

    public static float averageAge(Person[] array){
        float sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i].getAge();
        }
        return sum/array.length;
    }

    public static float averagePaycheck(Person[] array){
        float sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i].getPaycheck();
        }
        return sum/array.length;
    }

    public static void main(String[] args){
      Person a=new Person("Алексей","менеджер", "3333334",20,25000);

      System.out.println("Индетификационный номер сотрудника: "+a.getId());
      System.out.println("Имя сотрудника: "+a.getName());
      System.out.println("Должность сотрудника: "+a.getPosition());
      System.out.println("Телефон сотрудника: "+a.getPhone());
      System.out.println("Возраст сотрудника: "+a.getAge());
      System.out.println("Зарплата сотрудника: "+a.getPaycheck());
      System.out.println();

      Person[] persArray = new Person[5];
      persArray[0]=new Person("Игорь", "Финансовый директор", "4562378",45,100000);
      persArray[1]=new Person("Роман","Курьер", "1700010",19,15000);
      persArray[2]=new Person("Георгий","Курьер","4504545",63,15000);
      persArray[3]=new Person("Николай","Менеджер","3332525",25,30000);
      persArray[4]=new Person("Анна","Офис менеджер","1501514",19,12000);

      System.out.println("Сотрудники старше 40 лет \n");

      for(int i=0;i<persArray.length;i++){
          if(persArray[i].getAge()>40){
              System.out.println("Индетификационный номер сотрудника: "+persArray[i].getId());
              System.out.println("Имя сотрудника: "+persArray[i].getName());
              System.out.println("Должность сотрудника: "+persArray[i].getPosition());
              System.out.println("Телефон сотрудника: "+persArray[i].getPhone());
              System.out.println("Возраст сотрудника: "+persArray[i].getAge());
              System.out.println("Зарплата сотрудника: "+persArray[i].getPaycheck());
              System.out.println();
          }
      }

      System.out.println("Повышаем зарплату сотрудникам старше 40 лет на 5000 рублей\n");

        for(int i=0;i<persArray.length;i++){
            if(persArray[i].getAge()>40){
                persArray[i].increasePaycheck(5000);
                System.out.println("Индетификационный номер сотрудника: "+persArray[i].getId());
                System.out.println("Имя сотрудника: "+persArray[i].getName());
                System.out.println("Должность сотрудника: "+persArray[i].getPosition());
                System.out.println("Телефон сотрудника: "+persArray[i].getPhone());
                System.out.println("Возраст сотрудника: "+persArray[i].getAge());
                System.out.println("Зарплата сотрудника: "+persArray[i].getPaycheck());
                System.out.println();
            }
        }

        System.out.println("Средний возраст сотрудников: "+averageAge(persArray));

        System.out.println("Средняя зарплата сотрудников: "+averagePaycheck(persArray));



    }
}
