import java.util.Scanner;
public class TicTacToe{
    private static char[][] board= new char[3][3];
    private static char currentPlayer='X';
    public static void main(String[] args){
        initialiseBoard();
        while(true){
            printBoard();
            playerMove();
            if (hasWon()){
                System.out.println(currentPlayer+" is the winner!");
                break;
            }
            if (isFull()){
                System.out.println("It is a tie!");
                break;
            }
            switchPlayer();
        }

    }

    private static void switchPlayer(){
        if(currentPlayer=='X'){
            currentPlayer='O';
        }else{
            currentPlayer='X';
        }
    }

    private static void initialiseBoard(){
        for (int row=0; row<board.length;row++){
            for (int col=0; col<board[row].length;col++){
                board[row][col]=' ';
            }
        }
    }

    private static void printBoard() {
        System.out.print("    "); // Padding for row numbers
        for (int col = 0; col < board[0].length; col++) {
            System.out.print(col + "   ");
        }
        System.out.println();

        System.out.println("   -------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print(row + " | ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("   -------------");
        }
    }

    private static void playerMove(){
        while (true){
            Scanner scanner=new Scanner(System.in);
            System.out.println("Player "+currentPlayer+"'s turn");
            System.out.print("Enter the row number: ");
            int row= scanner.nextInt();
            System.out.print("Enter the column number: ");
            int col= scanner.nextInt();
            if (col>=0&&col<3&&row>=0&&row<3&&board[row][col]==' '){
                board[row][col]=currentPlayer;
                printBoard();
                if (hasWon()){
                    break;
                }
                break;
            }else{
                System.out.println("Invalid move!");
            }
        }
    }
    private static boolean hasWon(){
        for (int i=0; i< board.length;i++){
            if ((board[i][0]==currentPlayer&&board[i][1]==currentPlayer&&board[i][2]==currentPlayer)||board[0][i]==currentPlayer&&board[1][i]==currentPlayer&&board[2][i]==currentPlayer){
                return true;
            }
            if ((board[0][0]==currentPlayer&&board[1][1]==currentPlayer&&board[2][2]==currentPlayer)||(board[0][2]==currentPlayer&&board[1][1]==currentPlayer&&board[2][0]==currentPlayer)){
                return true;
            }
        }
        return false;
    }
    private static boolean isFull(){
        for (int row=0; row<board.length;row++){
            for (int col=0; col<board[row].length;col++){
                if (board[row][col]==' '){
                    return false;
                }
            }
        }
        return true;
    }
}
