package hm6;

import java.io.*;
import java.util.Scanner;

public class homework6_1 {
    public static void main(String[] args){
        try {

//1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
//2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.

            PrintStream ps = new PrintStream(new FileOutputStream("hw3file.txt"));

            Scanner sc1 = new Scanner(new FileInputStream("hw1file.txt"));
            while(sc1.hasNextLine()){
                ps.println(sc1.nextLine());
            }
            sc1.close();
            sc1 = new Scanner(new FileInputStream("hw2file.txt"));
            while(sc1.hasNextLine()){
                ps.println(sc1.nextLine());
            }
            sc1.close();
            ps.close();

//3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.

            String searchWord1="move";
            Boolean result=false;

            Scanner sc2 = new Scanner(new FileInputStream("file.txt"));
            while (sc2.hasNext()){
                if(searchWord1.equals(sc2.next())){
                    result=true;
                    break;
                }
            }
            sc2.close();
            System.out.println("file.txt : "+ result);

//4 ** Написать метод, проверяющий, есть ли указанное слово в папке

            System.out.println("--------------------------");

            File directory = new File("papka");
            String searchWord2="you";
            Boolean result2=false;

            if(directory.exists()){
                String[] files=directory.list();
                for(int i=0;i<files.length;i++){
                    Scanner sc3 = new Scanner(new FileInputStream(directory.getName()+"/"+files[i]));
                    while (sc3.hasNext()){
                        if(searchWord2.equals(sc3.next())){
                            result2=true;
                            break;
                        }
                    }
                    sc3.close();
                    System.out.println(files[i]+" : "+result2);
                    result2=false;
                }
            }else {
                System.out.println("Каталог не найден");
            }


        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Writing failed");
        }
    }
}
