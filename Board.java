abstract class Board {
    
    int SIZE, n_moves;
    char[][] board;
    
    Board(){}

    Board(int n) {
        this.SIZE = n;
        this.n_moves = 0;
        this.board = new char[n][n];
        this.fillBoard(' ');
    }

    abstract boolean update(int x, int y, char s);
    abstract void displayBoard();
    abstract boolean isWinner(char s);
    abstract boolean isDraw();

    void fillBoard(char ch) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ch;
            }
        }
    }
}