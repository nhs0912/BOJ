package Problems;

import java.io.*;
import java.util.StringTokenizer;


/**
 * 10월 5주차
 * 카드 구매하기1
 * 11052번
 */
class P_11052 {

    int[] valueArr;
    int N = 0;
    int[] maxValueArr;

    void display(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            if (i == 1) {
                System.out.print(arr[i]);
            } else {
                System.out.printf("%3d", arr[i]);
            }
        }
        System.out.println();
    }

    void inputData() throws IOException {
        //FileInputStream fis = new FileInputStream("input.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        valueArr = new int[N + 1];
        int index = 1;
        while (st.hasMoreTokens()) {
            valueArr[index++] = Integer.parseInt(st.nextToken());
        }

    }

    void logic() {

        maxValueArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (maxValueArr[i] < maxValueArr[i - j] + valueArr[j]) {
                    maxValueArr[i] = maxValueArr[i - j] + valueArr[j];
                }
            }
        }


    }



    void Solve() throws IOException {

        //입력값
        inputData();


        //로직 프로세스
        logic();

        System.out.println(maxValueArr[N]);

    }

    public static void main(String[] args) throws IOException {
        new P_11052().Solve();
    }
}