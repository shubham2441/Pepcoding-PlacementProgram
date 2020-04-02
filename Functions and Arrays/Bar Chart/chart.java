import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        while (max > 0) {
            for (int i = 0; i < n; i++) {
                if (arr[i] >= max) {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println(" ");
            max = max - 1;
        }
    }
}