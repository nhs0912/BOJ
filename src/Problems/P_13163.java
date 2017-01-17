package Problems;
/**
 * 문제 번호 : 13163번
 * 문제 이름 : 닉네임에 갓 붙이기
 * 문제 설명 :
 * 방금 막 프로그래밍을 배우기 시작한 찬우는 acmicpc.net에 있는 회원들이 모두 신같이 보였다.
 * 그래서 찬우는 모든 회원의 닉네임 앞에 ‘갓’을 붙이려고 한다.
 * 찬우가 ‘koosaga’라는 닉네임을 가진 회원을 갓으로 바꿔 부른다면 ‘godsaga’가 된다.
 * 또, 찬우가 ‘acka’라는 닉네임을 가진 회원을 갓으로 바꿔 부른다면 ‘godka’가 될 것이다.
 * 찬우는 닉네임을 갓으로 바꾸는 알고리즘을 생각하다가, 아래와 같이 2단계 방법을 사용하면 될 것으로 생각했다.
 * 닉네임을 음절 단위로 쪼갠다.
 * 가장 첫 음절을 ‘god’으로 바꾼 후 쪼갠 음절을 합친다.
 * 찬우는 수작업으로 N명의 닉네임을 모두 음절 단위로 쪼갰다. 찬우를 도와 이 닉네임들에 갓을 붙이는 프로그램을 작성하자.
 */

import java.io.*;
import java.util.StringTokenizer;

class P_13163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        String god = "god";
        sb.append(god);
        while(N-- >0) {
            st = new StringTokenizer(br.readLine().trim());
            int cnt = st.countTokens();
            while (st.hasMoreTokens()) {

                if (cnt != st.countTokens()) {
                    sb.append(st.nextToken());
                } else {
                    st.nextToken();
                }
            }
            bw.write(sb.toString()+"\n");
            sb.delete(3,sb.length());
        }
        bw.close();
    }
}