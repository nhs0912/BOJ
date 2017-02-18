package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 7568
 * 문제 이름 : 덩치
 * 문제 주소 : https://www.acmicpc.net/problem/7568
 */
class P_7568 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] weights;
    int[] heights;
    int[] rank; //순위 배열
    int[] point;//점수 배열

    void inputData(int N) throws IOException {
        weights = new int[N];
        heights = new int[N];
        rank = new int[N];
        point = new int[N];
//        for (int i = 0; i < rank.length; i++) {
//            rank[i] = 1;
//        }

        int index = 0;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            weights[index] = Integer.parseInt(st.nextToken());
            heights[index] = Integer.parseInt(st.nextToken());
            index++;
        }
    }

    void display(int[] arr) {
        for (int num : arr) {
            System.out.printf("%d ", num+1);
        }
        System.out.println();
    }

    void compareRank() {
        for (int i = 0; i < weights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (weights[i] < weights[j] && heights[i] < heights[j]) {
                    point[i]++;
                } else if (weights[i] > weights[j] && heights[i] > heights[j]) {
                    point[j]++;
                }
            }
        }
    }

//    void resultRank(int[] point) {
//
//        for (int i = 0; i < point.length; i++) {
//            int rankNum = 1;
//            for (int j = 0; j < point.length; j++) {
//                if (point[i] > point[j]) {
//                    rankNum++;
//                }
//            }
//            rank[i] = rankNum;
//        }
//
//    }


    void Solve() throws IOException {
        int N = Integer.parseInt(br.readLine().trim());
        inputData(N);
        //display(weights);
        //display(heights);
        compareRank();
        //resultRank(point);
        display(point);
        //display(rank);

    }

    public static void main(String[] args) throws IOException {
        new P_7568().Solve();
    }
}

