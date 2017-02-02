package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2948
 * 문제 이름 : 2009년
 * 문제 주소 : https://www.acmicpc.net/problem/2948
 */
class P_2948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] week = new String[]{"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int day = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());

        //int criterion = 2; //기준
        int sumDay = 0; //총 날짜
        if (month != 1) {
            for (int i = 1; i < month; i++) {
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        sumDay += 31;
                        break;
                    case 2:
                        sumDay += 28;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        sumDay += 30;
                        break;
                }
            }
            sumDay+=day;
        } else {
            sumDay = day;
        }


        System.out.println(week[sumDay % 7]);
    }
}

