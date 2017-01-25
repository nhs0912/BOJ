package Problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2017-01-17
 * 문제 번호 : 5544
 * 문제 이름 : 리그
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/5544
 */
class P_5544 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int teamCnt = Integer.parseInt(br.readLine().trim()); // 팀 수
        int[] teamScore = new int[teamCnt]; //팀 점수
        int matchCnt = teamCnt * (teamCnt - 1) / 2; //경기 수
        int[] rankArr = new int[teamCnt];//순위
        while (matchCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int teamA = Integer.parseInt(st.nextToken()) - 1;
            int teamB = Integer.parseInt(st.nextToken()) - 1;
            int teamA_Score = Integer.parseInt(st.nextToken());
            int teamB_Score = Integer.parseInt(st.nextToken());

            if (teamA_Score > teamB_Score) {//A가 이겼을 경우
                teamScore[teamA] += 3;
            } else if (teamA_Score < teamB_Score) {//B가 이겼을 경우
                teamScore[teamB] += 3;
            } else if (teamA_Score == teamB_Score) {//무승부 일 경우
                teamScore[teamA] += 1;
                teamScore[teamB] += 1;
            }
        }
        for (int i = 0; i < teamScore.length; i++) {
            for (int j = 0; j < teamScore.length; j++) {

                if (i == j) {
                    continue;
                }
                if (teamScore[i] < teamScore[j]) {
                    //팀점수가 같거나 높으면
                    rankArr[i]++;
                }
            }
        }

        for (int i = 0; i < rankArr.length; i++) {
            bw.write((rankArr[i] + 1) + "\n");
        }
        bw.close();
    }


}