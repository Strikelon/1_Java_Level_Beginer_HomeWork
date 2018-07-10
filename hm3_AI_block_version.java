package hm3;

import java.util.Random;
import java.util.Scanner;

public class hm3_AI_block_version {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '_';
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int winСondition;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static void initMap() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        winСondition=3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("--");
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты X и Y (от 1 до 3) через пробел >>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX &&
                y >= 0 && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean aiAction(char c,int blockTest) {
        int checkHorizont = 0;
        int checkVertical = 0;
        int checkDiagonal1 = 0;
        int checkDiagonal2 = 0;
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == c) checkHorizont++;
                if (field[j][i] == c) checkVertical++;
            }
            if(checkHorizont==blockTest){
                for (int x = 0; x < fieldSizeX; x++){
                    if(isCellEmpty(x,i)){
                        field[i][x]=DOT_AI;
                        return true;
                    }
                }
            }
            checkHorizont=0;
            if(checkVertical==blockTest){
                for (int y = 0; y < fieldSizeX; y++){
                    if(isCellEmpty(i,y)){
                        field[y][i]=DOT_AI;
                        return true;
                    }
                }
            }
            checkVertical=0;
            if (field[i][i]==c) checkDiagonal1++;
            if (field[i][fieldSizeY-1-i]==c) checkDiagonal2++;
        }
        if(checkDiagonal1==blockTest){
            for (int i = 0; i < fieldSizeX; i++){
                if(isCellEmpty(i,i)){
                    field[i][i]=DOT_AI;
                    return true;
                }
            }
        }
        if(checkDiagonal2==blockTest){
            for (int i = 0; i < fieldSizeX; i++){
                if(isCellEmpty(fieldSizeY-1-i,i)){
                    field[i][fieldSizeY-1-i]=DOT_AI;
                    return true;
                }
            }
        }
        return false;
    }

    private static void aiTurn() {
        int x;
        int y;
        if(aiAction(DOT_AI, winСondition-1)){
            return;
        } else if(aiAction(DOT_HUMAN, winСondition-1))
        {
            return;
        } else {
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isCellEmpty(x, y));
            field[y][x] = DOT_AI;
        }

    }

    private static boolean checkWin(char c,int winTest) {
        int checkHorizont=0;
        int checkVertical=0;
        int checkDiagonal1=0;
        int checkDiagonal2=0;
        for(int i=0;i<fieldSizeY;i++){
            for(int j=0;j<fieldSizeX;j++){
                if(field[i][j]==c) checkHorizont++;
                if(field[j][i]==c) checkVertical++;
            }
            if(checkHorizont==winTest ){
                return true;
            } else checkHorizont=0;
            if (checkVertical==winTest){
                return true;
            }else checkVertical=0;
            if (field[i][i]==c) {
                checkDiagonal1++;
            }
            if (field[i][fieldSizeY-1-i]==c) {
                checkDiagonal2++;
            }
        }
        if(checkDiagonal1==winTest){
            return true;
        }
        else if(checkDiagonal2==winTest){
            return true;
        }else {
            return false;
        }
    }

    private static boolean isFieldFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args){

        initMap();
        printMap();
        while(true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_HUMAN, winСondition)) {
                System.out.println("Выиграл игрок!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_AI,winСondition)){
                System.out.println("Выиграл компьютер!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }

    }
}
