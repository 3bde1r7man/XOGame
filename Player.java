import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    String name;
    char symbol;
    int x, y;
    public Player(String nm, char s){
        this.name = nm;
        this.symbol = s;
    }
    void getMove(){
        System.out.println("Please enter your move (x , y) (index start from 0): ");
        x = sc.nextInt();
        y = sc.nextInt();
    }
    String getName(){
        return name;
    }

    char getSymbol() {
        return symbol;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
