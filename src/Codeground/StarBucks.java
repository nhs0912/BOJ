package Codeground;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 코드그라운드
 * "스타벅스"
 */
/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class StarBucks {
    //static int Answer;

    public static void main(String args[]) throws Exception {

         //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            sc.nextLine();
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int N = Integer.parseInt(st.nextToken());//사람 수
            int M = Integer.parseInt(st.nextToken());//커피 종류
            int K = Integer.parseInt(st.nextToken());// 법인카드 한계 금액
            int[] coffeeKindCnt = new int[M + 1];//커피 종류 갯수
            int[] coffeePay = new int[M + 1]; //커피 가격
            int index = 1;
            int calculatorNum = M;// (커피 갯수 X 커피 종류) 갯수
            int totalPay = 0; //총 가격
            char answer = '0'; //최종 결과
            while (N-- > 0) {
                int order = sc.nextInt();
                coffeeKindCnt[order]++;//커피 종류 갯수 증가
            }
            while (M-- > 0) {
                coffeePay[index++] = sc.nextInt();//커피 가격 정보 입력
            }
            index = 1;
            while (calculatorNum-- > 0) {
                totalPay += coffeeKindCnt[index] * coffeePay[index++];
            }

            if (totalPay > K) {
                answer = 'N';
            } else {
                answer = 'Y';
            }

            System.out.println("Case #" + (test_case + 1));
            System.out.println(answer);
        }
    }
}