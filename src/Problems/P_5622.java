package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nhs0912 on 2016-12-15.
 */
public class P_5622 {

    static int changeNum(char ch) {
        int num = 0;
        switch (ch) {
            case 'A':
            case 'B':
            case 'C':
                num = 2;
                break;
            case 'D':
            case 'E':
            case 'F':
                num = 3;
                break;
            case 'G':
            case 'H':
            case 'I':
                num = 4;
                break;
            case 'J':
            case 'K':
            case 'L':
                num = 5;
                break;
            case 'M':
            case 'N':
            case 'O':
                num = 6;
                break;
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                num = 7;
                break;

            case 'T':
            case 'U':
            case 'V':
                num = 8;
                break;
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                num = 9;
                break;
        }

        return num+1;//시간은 숫자+1 이다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String engTxt = br.readLine();
        char[] chars = engTxt.toCharArray();//String to char
        int sum = 0;//총 시간
        for (int i = 0; i < chars.length; i++) {
            sum += changeNum(chars[i]);
        }
        System.out.println(sum);
    }
}
