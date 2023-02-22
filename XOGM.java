import java.util.Scanner;

class XOGM extends Manger{
    Scanner sc = new Scanner(System.in);

    

    void runGame() {
        char[] sy = {'X', 'O'};
        this.board = new XOB();
        this.player = new Player[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Please enter your name: ");
            name = sc.nextLine();
            System.out.println("you'r sybmol is : " + sy[i]);
            player[i] = new Player(name, sy[i]);
        }
        while (true){
            for (int i=0 ;i<2; i++) {
                board.displayBoard();
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