import java.util.Scanner;

public class TicTacToe {
  static Scanner type = new Scanner(System.in);
  public static void main(String[] args) {

    //Stats
    int wins = 0;
    int losses = 0;
    int ties = 0;
    int times = 0;

    //board
    char[][] board = new char[3][3];

    //Start up
    System.out.println("Let's play Tic Tac Toe!");
    while (true) {
      //Ask player
      System.out.println("Type play to start the game, quit to quit the game, or stats to view your stats.");
      String input = type.nextLine();

      //Player responds
      if (!input.equals("play") && !input.equals("quit") && !input.equals("stats") && !input.equals("play to start the game, quit to quit the game, or stats to view your stats")) {
        System.out.println("That's not a valid input.");
      }
      else if (input.equals("play to start the game, quit to quit the game, or stats to view your stats")) {
        System.out.println("Are you trying to be coy?");
      }
      else if (input.equals("stats")) {
          System.out.println("Wins: " + wins);
          System.out.println("Losses: " + losses);
          System.out.println("Ties: " + ties);
          System.out.println("Times: " + times);
      }
      else if (input.equals("quit")) {
        break;
      }
      else if (input.equals("play")) {
        for (int x = 0; x < 3; x++) {
          for (int y = 0; y < 3; y++ ) {
            board[x][y] = '■';
          }
        }
      while (true) {
          //Asking the player
          System.out.println("Player's move");
          while (true) {
            System.out.print("Enter a row! 0, 1 , or 2!  ");
            int row = type.nextInt();
            System.out.print("Enter a column! 0, 1 , or 2!  ");
            int column = type.nextInt();
            //Out of bounds
            if (row < 0 || row > 2 || column < 0 || column > 2) {
            System.out.println("Your move isn't valid.");
            }
            //Occupied
            else if (board[row][column] != '■') {
              System.out.println("Try a different location.");
            }
            //A-Okay!
            else {
              board[row][column] = 'X';
              break;
            }
          }
          printBoard(board);
          if (hasWon(board) == 'X') {
            System.out.println("Player has won!");
            wins = (wins) + 1;
            times = (times) + 1;
            break;
          }
          else if (hasTied(board)) {
            System.out.println("It's a tie!");
            ties = (ties) + 1;
            times = (times) + 1;
            break;
          }
          System.out.println("Computer's move.");
          while (true) {
            int row =(int)(Math.random() * 3);
            int column =(int)(Math.random() * 3);
            if (board[row][column] != '■') {
            }
            else {
              board[row][column] = 'O';
              break;
            }
          }
          printBoard(board);
          if (hasWon(board) == 'O'){
            System.out.println("The computer has won!");
            losses = (losses) + 1;
            times = (times) + 1;
            break;
          }
          else if (hasTied(board)) {
            System.out.println("It's a tie!");
            ties = (ties) + 1;
            times = (times) + 1;
            break;
          }
        }
      }
    }
    System.out.println("Thank you for playing!");
  }
    public static void printBoard(char[][] board) {
      for (int x = 0; x < 3; x++) {
        for (int y = 0; y < 3; y++) {
          System.out.print(board[x][y]);
        }
        System.out.println();
      }
    }
    public static char hasWon(char[][] board) {
      for (int x = 0; x < 3; x++) {
        if (board[x][0] == board[x][1] && board[x][1] == board[x][2] && board[x][1] != '■') {
          return board[x][0];
        }
      }
      for (int y = 0; y < 3; y++) {
        if (board[0][y] == board[1][y] && board[1][y] == board[2][y] && board[1][y] != '■') {
          return board[0][y];
        }
      }
      if (board[0][0] == board[1][1] && board[2][2] == board[1][1] && board[1][1] != '■') {
        return board[0][0];
      }
      if (board[2][0] == board[1][1] && board[0][2] == board[1][1] && board[1][1] != '■') {
        return board[0][0];
      }
      return '-';
    }
    public static boolean hasTied(char[][] board) {
      for (int x = 0; x < 3; x++) {
        for (int y = 0; y < 3; y++) {
          if (board[x][y] == '■') {
            return false;
          }
        }
      }
      return true;
    }
}
