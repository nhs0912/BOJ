package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nhs0912 on 2016-12-16.
 */
public class P_1193 {
    P_1193() throws IOException {
        int num = scan();
        whatFraction(num);
    }

    int scan() throws IOException {
        //Scanner sc = new Scanner(System.in);
        //return sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        return num;
    }

    static void whatFraction(int num) {
        int up = 0; //분자
        int down = 0; //분모
        int n = 0; //몇번째 숫자인지 확인
        Boolean findFraction = false;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                if (i % 2 != 0) {//홀수 일 때
                    down = j + 1;
                    up = i - j;
                } else {
                    //짝수 일 때
                    up = j + 1;
                    down = i - j;
                }
                String txt = up + "/" + down;
                n++;
                if (n == num) {//입력된 순서와 n이 같으면 출력
                    System.out.print(txt);
                    findFraction = true;
                    break;
                }
            }

            if (findFraction) {//분수를 찾았으면 바깥쪽 for문도 break 해준다.
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new P_1193();
    }
}
