import java.util.Scanner;

class Player {
    Scanner sc = new Scanner(System.in);
    String name;
    char symbol;
    public Player(String nm, char s){
        this.name = nm;
        this.symbol = s;
    }
    void getMove(int x, int y){
        System.out.println("Please enter your move (x , y) (index start from 0): ");
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
