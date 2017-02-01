package Problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2436
 * 문제 이름 : 공약수
 * 문제 주소 : https://www.acmicpc.net/problem/2436
 */
class P_2436 {
    public boolean CheckRelativePrimeNumber(int a, int b) {
        //서로소 검사
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int temp = 0;
        while (a != 0) {
            temp = a;
            a = b % a;
            if (a == 0) {
                b = temp;
                break;
            } else {
                b = temp;
            }
        }

        if (b != 1) {
            return false;
        } else {
            return true;
        }
    }


    void Solution(int gcd, int lcm) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (lcm % gcd == 0) {
            int num = lcm / gcd;
            int size = (int) Math.sqrt(num);
            int[] divisors = new int[100000]; //num의 약수 숫자집합
            int index = 0;
            boolean first = true;
            int minSum = 0; //최솟값
            int sum = 0;
            int minX = 0; //X 제일 작은 값
            int minY = 0; //Y 제일 작은 값
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    divisors[index++] = i;
                }
            }

            for (int i = 0; divisors[i] <= size && divisors[i] !=0; i++) {
                int X = gcd * divisors[i]; //첫번째 수
                int Y = ((lcm / X) * gcd); //두번째 수
                if (CheckRelativePrimeNumber(divisors[i], lcm / X)) {
                    //X' 와  Y' 가 서로소 이면
                    sum = X + Y;
                    if (first) {
                        minSum = sum;
                        minX = X;
                        minY = Y;
                        first = false;
                    } else {
                        if (minSum > sum) {
                            minSum = sum;
                            minX = X;
                            minY = Y;
                        }
                    }
                }
            }
            bw.write(minX + " " + minY);
            bw.close();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int gcd = Integer.parseInt(st.nextToken());//최대 공약수
        int lcm = Integer.parseInt(st.nextToken());//최소 공배수
        new P_2436().Solution(gcd, lcm);
        //  boolean check = new Main().CheckRelativePrimeNumber(gcd,lcm);
        //  System.out.println(check);
    }
}