import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class P_1476 {


    public void swap(long[] arr, int x, int y) {
        long tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void print(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    long Factorial(int num) {
        if (num < 2) {
            return 1;
        }
        return num * Factorial(num - 1);
    }

    public void Solve() throws FileNotFoundException {
        //FileInputStream fis = new FileInputStream("test.txt");
        //Scanner sc = new Scanner(fis);
        Scanner sc = new Scanner(System.in);
        // System.out.println("long 최댓값 : "+ Long.MAX_VALUE);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int year = 0;
        int tmpE = 0, tmpS = 0, tmpM = 0;
        while (true) {
            year++;
            if (tmpE == 15) {
                tmpE = 1;
            } else {
                tmpE++;
            }

            if (tmpM == 19) {
                tmpM = 1;
            } else {
                tmpM++;
            }

            if (tmpS == 28) {
                tmpS = 1;
            } else {
                tmpS++;
            }

            if (tmpE == E && tmpS == S && tmpM == M) {
                System.out.println(year);
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new P_1476().Solve();
    }
}
