package Problems;
/**
 *  문제 번호 : 7785
 *  문제 이름 : 회사에 있는 사람
 *  문제 설명 :
 *  You are working in a ”Giigle” software company.
 *  The job in this company is very easy, so people don’t sit in the oﬃce from 9am till 6pm.
 *  They come to work at any time, and leave the oﬃce at any time.
 *  You have a magnetic keys system that keeps the log on all people
 *  – when they entered the oﬃce, and when they leaved. Your task is to ﬁnd all people that are in oﬃce now.
 *
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class P_7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] stArr = new String[2];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            stArr = br.readLine().split(" ");
            if (stArr[1].equals("enter")) {
                set.add(stArr[0]);
            } else {
                set.remove(stArr[0]);
            }
        }
        String[] arr = set.toArray(new String[set.size()]);
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; --i) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }
}