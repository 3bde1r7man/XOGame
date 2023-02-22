public class XOB extends Board {


    XOB() {
        super(3);
    }

    boolean update(int x, int y, char s) {
        if (!(x < 0 || x > 2 || y < 0 || y > 2) && (board[x][y] == ' ')) {
            board[x][y] = s;
            n_moves++;
            return true;
        }
        else {
            return false;
        }
    }

    void displayBoard() {
        System.out.print("\n_______\n");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("\n|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(  board [i][j] + "|");
            }
            System.out.print("\n_______\n");
        }  
        
    }

    boolean isWinner(char s) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == s) {
                return true;
            }
            else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == s) {
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
        } else {
            return false;
        }
    }
    
} 