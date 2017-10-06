import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class P_1722 {


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
        int N = sc.nextInt();
        int[] numbers = new int[N];
        int[] copyNumbers = new int[N];
        int[] result = new int[N];
        int order = sc.nextInt();// 1 이면 몇번째 수열을 출력, 2이면 어떤 수열이 몇번째인지?
        long sum = 0;
        if (order == 1) {
            // 순열 구하기
            long orderCnt = sc.nextLong();// 몇번째 순열인지

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = i + 1;
               // result[i] = i + 1;
            }
            //if (orderCnt != 1) {
                long num = 0;
                for (int k = 0; k < result.length; k++) {
                    long factorialNum = Factorial(numbers.length - (k + 1));
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] == 0) {
                            continue;
                        }
                        num = orderCnt;
                        orderCnt = orderCnt - factorialNum;
                        if (orderCnt <= 0) {
                            //음수나 0이 나왔을 경우 그 자릿수의 숫자를 확정한다. 그리고 나서 0으로 수정
                            orderCnt = num;
                            result[k] = numbers[i];
                            numbers[i] = 0;
                            break;
                        }

                    }
                }
            //}

            //print(numbers);
            //System.out.println("---result----");
            print(result);
        } else if (order == 2) {
            // order ==2 순열의 순서 구하기
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextInt();
                copyNumbers[i] = numbers[i];
            }

            Arrays.sort(copyNumbers);

            for (int i = 0; i < numbers.length - 1; i++) {
                // int cnt = numbers[i] - 1;
                long factorialNum = numbers.length - (i + 1);
                long smallNumCnt = 0;
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] > numbers[j]) {
                        smallNumCnt++;
                    }
                }
                long factorialResult = 1;
                for (long j = factorialNum; j > 0; j--) {
                    factorialResult *= j;
                }
                // System.out.println(smallNumCnt + "," + factorialResult);
                sum += smallNumCnt * factorialResult;
            }
            // System.out.println("sum=" + (sum + 1));
            System.out.println(sum + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        new P_1722().Solve();
    }
}
