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

import java.util.Scanner;

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
 /*
import  java.util.Scanner;
public class ADS1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число:");
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
*/
/*
import java.util.Scanner;
public class ADS1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите основание:");
        int b = input.nextInt();
        System.out.println("Введите n показатель:");
        int n = input.nextInt();
        int result = sumPowers(b, n);
        System.out.println(" = " + result);
        input.close();
    }
    public static int power(int a, int x) {
        if (x == 0) return 1;
        return a * power(a, x - 1);
    }
    public static int sumPowers(int a, int x) {
        if (x == 0) {
            System.out.print(a + "^0");
            return 1;
        }
        int sum = sumPowers(a, x - 1);
        System.out.print(" + " + a + "^" + x);
        return power(a, x) + sum;
    }
}
*/
/*
import java.util.Scanner;
public class ADS1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество элементов N: ");
        int n = input.nextInt();
        System.out.println("Введите последовательность:");
        reversePrint(n, input);
        input.close();
    }
    public static void reversePrint(int n, Scanner input) {
        if (n <= 0) {
            return;
        }
        int current = input.nextInt();
        reversePrint(n - 1, input);
        System.out.print(current + " ");
    }
}
*/
/*
import java.util.Scanner;
public class ADS1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            int n = input.nextInt();
            // Чистим буфер после nextInt(), чтобы он не мешал читать строки
            input.nextLine();
            reverseStrings(n, input);
        }
        input.close();
    }
    public static void reverseStrings(int n, Scanner sc) {
        if (n <= 0) {
            return;
        }
        String current = sc.nextLine();
        reverseStrings(n - 1, sc);
        System.out.println(current);
    }
}
*/
/*
import java.util.Scanner;

public class ADS1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        fillSpiral(matrix, 0, 0, n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void fillSpiral(int[][] matrix, int row, int col, int size, int num) {
        if (size <= 0) return;
        if (size == 1) {
            matrix[row][col] = num;
            return;
        }

        //ВС (слева направо)
        for (int i = 0; i < size - 1; i++) {
            matrix[row][col + i] = num++;
        }

        //ПС (сверху вниз)
        for (int i = 0; i < size - 1; i++) {
            matrix[row + i][col + size - 1] = num++;
        }

        //НС (справа налево)
        for (int i = 0; i < size - 1; i++) {
            matrix[row + size - 1][col + size - 1 - i] = num++;
        }

        //ЛC (снизу вверх)
        for (int i = 0; i < size - 1; i++) {
            matrix[row + size - 1 - i][col] = num++;
        }
        fillSpiral(matrix, row + 1, col + 1, size - 2, num);
    }
}
*/
/*
public class ADS1 {
    // Переменная, которая будет помнить, в какую строку матрицы мы сейчас пишем
    static int currentRow = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int totalRows = (int) Math.pow(k, n);
        int[][] matrix = new int[totalRows][n];
        int[] currentCombo = new int[n];
        generate(0, n, k, currentCombo, matrix);
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void generate(int index, int n, int k, int[] currentCombo, int[][] matrix) {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                matrix[currentRow][i] = currentCombo[i];
            }
            currentRow++;
            return;
        }
        for (int i = 1; i <= k; i++) {
            currentCombo[index] = i;
            generate(index + 1, n, k, currentCombo, matrix);
        }
    }
}
*/
















