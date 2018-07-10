package hm1;

public class hm1 {

    // 1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    public static float method1(float a, float b, float c, float d ){
        return a * (b + (c / d));
    }

    // 2. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public static boolean predelSumma(int a, int b){
        return ((a+b>=10)&&(a+b<=20));
    }

    //3. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное
    public static boolean otricatelnoe(int a){
        return (a<0);
    }
    //4. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static String hellomethod(String name){
        return "Привет, "+name+" !";
    }

    //5. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean checkYear(int year){
        int test1, test2, test3;
        test1=year%4;
        test2=year%100;
        test3=year%400;
        boolean result;
        if(test1==0&&test2>0){
            result=true;
        }else if(test1==0&&test2==0&&test3==0){
            result=true;
        } else result=false;
        return result;
    }


    public static void main(String[] args) {

        System.out.println(method1(2,3,20,5)); // проверяем задание №1
        System.out.println(predelSumma(10,6)); // проверяем задание №2
        System.out.println(otricatelnoe(5)); // проверяем задание №3
        System.out.println(hellomethod("Иван")); // проверяем задание №4
        // проверяем задание №5
        if(checkYear(1960)){
            System.out.println("Год високосный");
        } else System.out.println("Год не високосный");
        }
    }

