//import java.io.*;
//import java.util.StringTokenizer;
//
///**
// * 문제 번호 : 11778
// * 문제 이름 : 피보나치 수와 최대공약수
// * 문제 주소 : https://www.acmicpc.net/problem/11778
// */
//class Main {
//
//
//    //int mod = 1000000;
//    //int p = (mod / 10) * 15; //주기
//
//
//    long fibonacci(long num) {
//        long[] memo = new long[(int) num + 1];
//        memo[0] = 0;
//        memo[1] = 1;
//        for (int i = 2; i <= num; i++) {
//            memo[i] = memo[i - 1] + memo[i - 2];
//        }
//        return memo[(int)num];
//    }
//
//    long GCD(long x, long y) {
//        if (x < y) {
//            long tmp = x;
//            x = y;
//            y = tmp;
//        }
//        if (y == 0) {
//            return x;
//        } else {
//            return GCD(y, x % y);
//        }
//    }
//
//    void Solve() throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine().trim());
//        long num1 = Long.parseLong(st.nextToken());
//        long num2 = Long.parseLong(st.nextToken());
//        long fibo1 = fibonacci(num1);
//        long fibo2 = fibonacci(num2);
//        System.out.println(fibonacci(num1));
//        System.out.println(fibonacci(num2));
//        long mod = 1000000007l;
//        System.out.println((GCD(fibo1, fibo2)) % mod);
//    }
//
//    public static void main(String[] args) throws IOException {
//        new Main().Solve();
//    }
//}
//
