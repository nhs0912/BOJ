package Problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 1934
 * 문제 이름 : 최소공배수
 * 문제 주소 : https://www.acmicpc.net/problem/1934
 */
class P_1934 {

    int getGCD(int num1, int num2) {
        if (num1 < num2) {
            getGCD(num2, num1);
        }
        if (num2 == 0) {
            return num1;
        }
        return getGCD(num2, num1 % num2);
    }

    int gcd( int a, int b ){
        while( a*1L*b != 0 ){
            int k = a%b;
            a = b;
            b = k;
        }
        return a+b;
    }

    int Solution(int num1, int num2) throws IOException {

        int result = getGCD(num1, num2);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine().trim());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int gcd = new P_1934().Solution(num1, num2);
            int result =(num1/gcd) * (num2/gcd) * gcd;
            bw.write(Integer.toString(result) + "\n");
        }
        bw.close();

    }
}