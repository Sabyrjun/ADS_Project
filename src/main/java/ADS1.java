/*
import java.util.Scanner;
public class ADS1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sample Input: n = ");
        int n = input.nextInt();
        System.out.print("Sample Output: ");
        int result = sumSquares(n);
        System.out.println(" = " + result);
        input.close();
    }
    public static int sumSquares(int n) {
        if (n <= 1) {
            System.out.print("1^2");
            return 1;
        }
        int sum = sumSquares(n - 1);
        System.out.print(" + " + n + "^2");
        return (n * n) + sum;
    }
}
*/

/*
import  java.util.Scanner;
public class ADS1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите общий размер масива: ");
        int size = sc.nextInt();
        int[] numbers = new int[size];

        System.out.println("Введите числа через пробел или Enter:");
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.print("Сколько первых цифр сложить?: ");
        int n = sc.nextInt();
        int result = sumArray(numbers, n);
        System.out.println("Сумма первых " + n + " элементов " + result);
        sc.close();
    }


    public static int sumArray(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }
        return arr[n - 1] + sumArray(arr, n - 1);
    }
}
*/

import  java.util.Scanner;
public class ADS1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int result = sumIntenger(n);
        System.out.println("Сумма первых n чисел: " + result);
        input.close();
    }

    public static int sumIntenger(int number){
        if (number <= 1) {
            return 1;
        }
        return number + sumIntenger(number - 1);
    }
}


