package hm2;

import java.util.Arrays;

public class hm2 {

//1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
//2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
//3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
//4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
//5 * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);
//6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||, эти символы в массив не входят.
//7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
//8 **** Не пользоваться вспомогательным массивом при решении задачи 7.

//Метод для задания №1: Задать целочисленный массив, состоящий из элементов 0 и 1.
//Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    private static void zadanie1(int[] arr){

        for(int i=0;i<arr.length;i++) arr[i]=(arr[i]>0)?0:1;
    }
//Метод для задания №2: Задать пустой целочисленный массив размером 8.
//Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
    private static void zadanie2(int[] arr){

        for(int i=0,j=1;i<arr.length;i++,j+=3) arr[i]=j;
    }
//Метод для задания №3: Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
// написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
    private static void zadanie3(int[] arr){
        for(int i=0;i<arr.length;i++) arr[i]=(arr[i]<6)?(arr[i]*2):(arr[i]);
    }
//Метод для задания №4: Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    private static int arrayMax(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++) max=(arr[i]>max)?arr[i]:max;
        return max;
    }

    private static float arrayMax(float[] arr){
        float max=arr[0];
        for(int i=0;i<arr.length;i++) max=(arr[i]>max)?arr[i]:max;
        return max;
    }

    private static int arrayMin(int[] arr){
        int min=arr[0];
        for (int i=0;i<arr.length;i++) min=(arr[i]<min)?arr[i]:min;
        return min;

    }

    private static float arrayMin(float[] arr){
        float min=arr[0];
        for (int i=0;i<arr.length;i++) min=(arr[i]<min)?arr[i]:min;
        return min;

    }

    //Метод для задания №5:Создать квадратный двумерный целочисленный массив
    // (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);

    private static void diagonaliInt(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
               arr[i][j]=(i==j||i+j==arr.length-1)?1:0;
            }
        }
    }
//Написал метод для наглядности вывода двумерного массива
    private static void showMnogomer(int[][] arr){
        for(int i=0;i<arr.length;i++){
                System.out.println(Arrays.toString(arr[i]));
        }
    }

    //Метод для задания №6
    private static boolean checkBalance(int[] arr){
        boolean result=false;
        for(int i=0;i<arr.length-1;i++){
            int left_sum=0;
            int right_sum=0;
            for(int j=0;j<=i;j++) {
                left_sum += arr[j];
            }
            for(int g=(arr.length-1);g>i;g--){
                right_sum +=arr[g];
            }
            if(left_sum==right_sum){
                result=true;
                break;
            }
        }
        return result;
    }

    //Метод для задания №7
    private static int[] driveArray(int[] arr, int drive){
        int[] helpArray = new int[arr.length];
        if (drive>=0){
            drive=(drive<=arr.length)?drive:drive-(arr.length*(drive/arr.length));
            for(int i=0;i<arr.length;i++){
                if(i+drive<arr.length){
                    helpArray[i+drive]=arr[i];
                }else{
                    helpArray[(i+drive)-arr.length]=arr[i];
                }
            }
        } else {
            drive=((drive*(-1))<=arr.length)?drive:drive-(arr.length*(drive/arr.length));
            for(int j=(arr.length-1);j>=0;j--){
                if(j+drive>=0){
                    helpArray[j+drive]=arr[j];
                }else{
                    helpArray[arr.length+(j+drive)]=arr[j];
                }
            }
        }

        for(int g=0;g<arr.length;g++) arr[g]=helpArray[g];

        return arr;
    }

    //Метод для задания №8
    private static void shift(int[] a, int val){
        boolean dir;
        if (val>0){
            dir=true;
        }else if (val<0){
            dir=false;
            val=-val;
        } else
            return;

        val %=a.length;
        int lastIndex = a.length-1;
        for (int i=0; i<val;i++){
            if (dir) {
                int temp=a[lastIndex];
//                System.arraycopy(a,0,a,1,lastIndex);
                for(int j=lastIndex;j>0;j--){
                    a[j]=a[j-1];
                }
                a[0]=temp;
            }else{
                int temp=a[0];
//                System.arraycopy(a,1,a,0,lastIndex);
                for(int j=0;j<lastIndex;j++){
                    a[j]=a[j+1];
                }
                a[lastIndex]=temp;
            }
        }
    }

    public static void main(String[] args) {

        // Проверка работы задания №1
        int[] arrayInt1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задание №1");
        System.out.println("Исходное состояние массива: "+ Arrays.toString(arrayInt1));
        zadanie1(arrayInt1);
        System.out.println("Измененное состояние массива: "+ Arrays.toString(arrayInt1));

        // Проверка работы задания №2
        int[] arrayInt2 = new int[8];
        System.out.println("Задание №2");
        System.out.println("Исходное состояние массива: "+ Arrays.toString(arrayInt2));
        zadanie2(arrayInt2);
        System.out.println("Измененное состояние массива: " + Arrays.toString(arrayInt2));

        // Проверка работы задания №3
        int[] arrayInt3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Задание №3");
        System.out.println("Исходное состояние массива: " + Arrays.toString(arrayInt3));
        zadanie3(arrayInt3);
        System.out.println("Измененное состояние массива: "+ Arrays.toString(arrayInt3));

        // Проверка работы задания №4
        int[] arrayInt4 = {1, 5, 3, -2, 11, 4, 5, 14, 4, 8, 9, 1 };
        float[] arrayFloat4={1.0f, 5.0f, 3.0f, -2.0f, 11.0f, 4.0f, 5.0f, 14.0f, 4.0f, 8.0f, 9.0f, 1.0f };
        System.out.println("Задание №4");
        System.out.println("Исходное состояние массива: " + Arrays.toString(arrayInt4));
        System.out.println("Максимальный элемент в массиве: "+arrayMax(arrayInt4));
        System.out.println("Минимальный элемент в массиве: "+ arrayMin(arrayInt4));
        System.out.println("Исходное состояние дробного массива: "+ Arrays.toString(arrayFloat4));
        System.out.println("Максимальный элемент в дробном массиве: "+arrayMax(arrayFloat4));
        System.out.println("Минимальный элемент в дробном массиве: "+arrayMin(arrayFloat4));

        // Проверка работы задания №5
        int[][] arrayInt5= new int[9][9];
        System.out.println("Задание№5");
        System.out.println("Исходное состояние массива: ");
        showMnogomer(arrayInt5);
        diagonaliInt(arrayInt5);
        System.out.println("Измененное состояние массива: ");
        showMnogomer(arrayInt5);

        // Проверка работы задания №6
        int[] arrayInt6_1={1, 1, 1, 2, 1};
        int[] arrayInt6_2={2, 1, 1, 2, 1};
        int[] arrayInt6_3={10, 1, 2, 3, 4};
        System.out.println("Задание№6");
        System.out.println("Исходное состояние массива#1: " + Arrays.toString(arrayInt6_1));
        System.out.println("Есть ли место в массиве, где сумма левой и правой части равны: "+ checkBalance(arrayInt6_1));
        System.out.println("Исходное состояние массива#2: " + Arrays.toString(arrayInt6_2));
        System.out.println("Есть ли место в массиве, где сумма левой и правой части равны: "+ checkBalance(arrayInt6_2));
        System.out.println("Исходное состояние массива#3: " + Arrays.toString(arrayInt6_3));
        System.out.println("Есть ли место в массиве, где сумма левой и правой части равны: "+ checkBalance(arrayInt6_3));

        // Проверка работы задания №7
        int[] arrayInt7_1={11, 2, 3, 4, 5};
        int[] arrayInt7_2={9,8,7,6,5,4,3,2,1};
        System.out.println("Задание №7");
        System.out.println("Исходное состояние массива: " + Arrays.toString(arrayInt7_1));
        System.out.println("Пример смещения массива влево: " + Arrays.toString(driveArray(arrayInt7_1,-33)));
        System.out.println("Исходное состояние массива: " + Arrays.toString(arrayInt7_2));
        System.out.println("Пример смещения массива вправо: " + Arrays.toString(driveArray(arrayInt7_2,7)));

        // Проверка работы задания №8
        int[] arrayInt8_1={2, 3, 4, 5, 6, 7};
        System.out.println("Задание №8");
        System.out.println("Исходное состояние массива: " + Arrays.toString(arrayInt8_1));
        shift(arrayInt8_1,17);
        System.out.println("Измененное состояние массива: " + Arrays.toString(arrayInt8_1));

    }

}
