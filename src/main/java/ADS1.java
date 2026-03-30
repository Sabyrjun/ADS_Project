import java.util.Scanner;
public class ADS1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer n: ");
        int n = input.nextInt();
        int result = sumSquares(n);
        System.out.println("The sum of the first squares" + n + "integer: " + result);
        input.close();
    }

    public static int sumSquares(int n) {
        if (n <= 1){
            return 1;
        }
        return (n*n)+sumSquares(n-1);
    }
}
