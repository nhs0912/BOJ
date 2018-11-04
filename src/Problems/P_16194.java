package Problems;

import java.io.*;
import java.util.StringTokenizer;


/**
 * 10월 5주차
 * 카드 구매하기2
 * 16194번
 */
class P_16194 {

    int[] valueArr;
    int N = 0;
    int[] minValueArr;

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

        minValueArr = new int[N + 1];

        for (int i = 1; i < minValueArr.length; i++) {
            //-1로 setting
            minValueArr[i] = -1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (minValueArr[i] == -1) {
                    //초기 setting -1은 계산을 한 적이 없으므로 바로 최소값으로 setting
                    minValueArr[i] = minValueArr[i - j] + valueArr[j];
                } else if (minValueArr[i] > minValueArr[i - j] + valueArr[j]) {
                    minValueArr[i] = minValueArr[i - j] + valueArr[j];
                }
            }
        }


    }


    void Solve() throws IOException {

        //입력값
        inputData();


        //로직 프로세스
        logic();

        //result output
        System.out.println(minValueArr[N]);

    }

    public static void main(String[] args) throws IOException {
        new P_16194().Solve();
    }
}