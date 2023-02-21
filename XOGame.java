import java.util.Arrays;
import java.util.Scanner;


public class XOGame {
   public static void main(String[] args) {
      System.out.println("Hello world fuck java & any one else");
      int age =10;
      int[] numbers = {1,5,3,6,8,7,10};
      for(int i =0;i<age;i++){
          System.out.println(i);
      }
      Arrays.sort(numbers);
      System.out.println(Arrays.toString(numbers));
      try (Scanner sc = new Scanner(System.in)) {
          System.out.println("Enter a number to print: ");
          int y = sc.nextInt();
          System.out.println(y);
      }
      
  }
}
