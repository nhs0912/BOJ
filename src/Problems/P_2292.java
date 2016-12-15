package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nhs0912 on 2016-12-15.
 */
public class P_2292 {
    static int isNumber(int roomNo)
    {//몇번째로 갈 수 있는지 알아내는 메서드
        int cnt=0;//방번호
        int findNum=1;//각 테두리 방의 최대번호 방
        if(roomNo!=1) {
            for (int i = 1; i < roomNo; i++) {
                findNum += 6*i;
                if (roomNo <=findNum){
                    cnt=i+1;//최대번호 안에 숫자가 들어있다면 i+1번
                    break;
                }
            }
        }
        else{//방번호 1을 입력했을 경우
            return 1;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roomNo=Integer.parseInt(br.readLine());
        System.out.println(isNumber(roomNo));
    }
}
