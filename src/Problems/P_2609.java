package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2609
 * 문제 이름 : 최대공약수 최소공배수
 * 문제 주소 : https://www.acmicpc.net/problem/2609
 */
class P_2609 {

    public int GCD(int num1, int num2) {
        if (num1 < num2) {
            return GCD(num2, num1);
        }
        if (num2 == 0) {
            return num1;
        } else {
            return GCD(num2, num1 % num2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int GCD = new P_2609().GCD(num1, num2);//최대공약수
        int LCM = (num1 / GCD) * (num2 / GCD) * GCD; //최소공배수
        System.out.println(GCD);
        System.out.println(LCM);
    }
}

