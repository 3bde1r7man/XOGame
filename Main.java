 
import java.util.Scanner;



public class Main{
    public static void main(String[] args) {
        XOGM mygame = new XOGM();
        mygame.runGame();
    }
    
}

abstract class Board {

    int SIZE, n_moves;
    char[][] board;
    public Board(int n){
        this.SIZE = n;
        this.n_moves = 0;
        this.board = new char[n][n];
    }
    abstract boolean update(int x, int y, char s);
    abstract void displayBoard();
    abstract boolean isWinner(char s);
    abstract boolean isDraw();
}
class XOB extends Board{

    public XOB(int n) {
        super(n);
    }

    boolean update(int x, int y, char s) {
        if (!(x < 0 || x > 2 || y < 0 || y > 2) && (board[x][y] == 0)) {
            board[x][y] = s;
            n_moves++;
            return true;
        }
        else {
            return false;
        }
          
    }

    void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("\n| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(  board [i][j] + " |");
            }
            System.out.print("\n-----------------------------\n");
        }  
        
    }

    boolean isWinner(char s) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == s) {
                return true;
            }
            else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[i][0] == s) {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == s  ) {
            return true;
        }  
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == s ) {
            return true;
        }
        return false;
        
    }

    boolean isDraw() {
        if (n_moves == 9) {
            return true;
          }
          else {
            return false;
          }
    }

} 
abstract class Manger {
    int x, y;
    String name;
    Board board;
    Player[] player;
   /* 
   public Manger(Board b, Player[] p ){
        this.board = b;
        this.player = p;
    }
   */ 
    abstract void runGame();
    
}
class XOGM extends Manger{
    Scanner sc = new Scanner(System.in);
    /*
        public XOGM(Board b, Player[] p) {
            super(b, p);
        }
      
     */
    

    void runGame() {
        char[] sy = {'X', 'O'};
        board = new XOB(3);
        player = new Player[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Please enter your name: ");
            name = sc.next();
            System.out.println("you'r sybmol is : " + sy[i]);
            player[i] = new Player(name, sy[i]);
        }
        while (true){
            for (int i=0 ;i<2; i++) {
                player[i].getMove(x, y);
                while (!board.update (x, y, player[i].getSymbol())){
                    player[i].getMove(x, y);
                }
                board.displayBoard();
                if (board.isWinner(player[i].getSymbol())){
                    System.out.println(player[i].getName() + "  " + player[i].getSymbol() + " wins\n");
                    return;
                }
                if (board.isDraw()){
                    System.out.println("Draw!");
                    return;
                }
            }
        }
        
    }

    
}

class Player {
    Scanner sc = new Scanner(System.in);
    String name;
    char symbol;
    public Player(String nm, char s){
        this.name = nm;
        this.symbol = s;
    }
    void getMove(int x, int y){
        System.out.println("Please enter your move (x , y): ");
        x = sc.nextInt();
        y = sc.nextInt();
    }
    String getName(){
        return name;
    }
    char getSymbol(){
        return symbol;
    }
}
