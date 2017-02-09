package Problems;
import java.io.*;
/**
 * Created by nhs09 on 2017-02-07.
 */
/**
 * 문제 번호 : 2562
 * 문제 이름 : 최대값
 * 문제 주소 : https://www.acmicpc.net/problem/2562
 */
class P_2562 {

    void Solve() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 9; //입력 갯수
        int[] arr = new int[10]; // 입력 숫자 저장 배열
        int index = 1; //입력 arr배열 주소값
        int bigNum = 0; //최댓값
        int bigNumIndex = 0; //최댓값 주소값
        while (N-- > 0) {
            arr[index] = Integer.parseInt(br.readLine().trim());
            if (arr[index] > bigNum) {
                bigNum = arr[index];
                bigNumIndex = index;
            }
            index++;
        }
        bw.write(bigNum+"\n");
        bw.write(bigNumIndex+"\n");
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        new P_2562().Solve();
    }
}


