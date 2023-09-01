package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = {
                          {' ', ' ',' '},
                          {' ', ' ',' '},
                          {' ', ' ',' '}
                         };

        while (true){
                playerTurn(board, scanner);
                if (isGameFinished(board)){
                   break;
                };
                printBoard(board);

                computerTurn(board);
                if (isGameFinished(board)){
                    break;
                };
                printBoard(board);
        }

        //printBoard(board);

        //scanner.close();

    }

    private static boolean isGameFinished (char[][] board) {

        if (hasContestantWon(board, 'X')){
            printBoard(board);
            System.out.println("Player wins !");
            return true;
        }

        if (hasContestantWon(board, 'O')){
            printBoard(board);
            System.out.println("Computer wins !");
            return true;
        }




        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
              if( board[i][j] == ' '){
                  return false;
              }
            }
        }
        printBoard(board);
        System.out.println("The game is a tie !");
        return true;
    }

    private static boolean hasContestantWon (char[][] board, char symbole){
        if ((board[0][0] ==symbole && board[0][1] == symbole && board[0][2] == symbole) ||
            (board[1][0] ==symbole && board[1][1] == symbole && board[1][2] == symbole) ||
            (board[2][0] ==symbole && board[2][1] == symbole && board[2][2] == symbole) ||

            (board[0][0] ==symbole && board[1][0] == symbole && board[2][0] == symbole) ||
            (board[0][1] ==symbole && board[1][1] == symbole && board[2][1] == symbole) ||
            (board[0][2] ==symbole && board[1][2] == symbole && board[2][2] == symbole) ||

            (board[0][0] ==symbole && board[1][1] == symbole && board[2][2] == symbole) ||
            (board[0][2] ==symbole && board[1][1] == symbole && board[2][0] == symbole) ){
            return true;
        }
        return false;
    }

    private static void computerTurn (char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true){
            computerMove = rand.nextInt(9) +1;
            if (isValidMove(board, computerMove)) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove (char [][] board, int position){

        switch (position){
            case 1:
               return ( board[0][0] == ' ');
            case 2:
                return ( board[0][1] == ' ');
            case 3:
                return ( board[0][2] == ' ');
            case 4:
                return ( board[1][0] == ' ');
            case 5:
                return ( board[1][1] == ' ');
            case 6:
                return ( board[1][2] == ' ');
            case 7:
                return ( board[2][0] == ' ');
            case 8:
                return ( board[2][1] == ' ');
            case 9:
                return ( board[2][2] == ' ');
            default:
                return false;
        }

    }

    private static void playerTurn (char[][] board, Scanner scanner) {


        String useInput;
        while (true){
            System.out.println("Where would you like to play ? (1-9) ");
            useInput = scanner.nextLine();
            if (isValidMove(board, Integer.parseInt(useInput))){
                break;
            }else {
                System.out.println(useInput.concat(" is not valid move."));
            }
        }
        placeMove(board, useInput, 'X');
    }

    private static void placeMove (char[][] board, String position, char symbole ) {
        switch (position){
            case "1":
                board[0][0] = symbole;
                break;
            case "2":
                board[0][1] = symbole;
                break;
            case "3":
                board[0][2] = symbole;
                break;
            case "4":
                board[1][0] = symbole;
                break;
            case "5":
                board[1][1] = symbole;
                break;
            case "6":
                board[1][2] = symbole;
                break;
            case "7":
                board[2][0] = symbole;
                break;
            case "8":
                board[2][1] = symbole;
                break;
            case "9":
                board[2][2] = symbole;
                break;
            default:
                System.out.println(":(");
        }
    }

    private static void printBoard (char[][] board) {
        System.out.println( board[0][0] +"|" + board[0][1] + "|" + board[0][2]);
        System.out.println( "-+-+-");
        System.out.println( board[1][0] +"|" + board[1][1] + "|" + board[1][2]);
        System.out.println( "-+-+-");
        System.out.println( board[2][0] +"|" + board[2][1] + "|" + board[2][2]);
    }

}