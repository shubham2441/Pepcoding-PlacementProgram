import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    public static int getValueIndecimal(int n, int b) {
        int sum = 0;
        int temp = 1;
        while (n != 0) {
            int temp_digit = n % 10;
            sum = sum + (temp_digit * temp);
            n = n / 10;
            temp = temp * b;
        }
        return sum;
    }
}