package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nhs0912 on 2016-12-15.
 */
public class P_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] CroatiaAphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String str = br.readLine();
        int twoWordCnt = 0;//나머지 크로아티아 알파벳 철자 갯수
        int threeWordCnt = 0; //"dz=" 철자 갯수
        int alphabetCnt=0; //총 알파벳 갯수
        char[] chars = str.toCharArray();//String to char[]
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < CroatiaAphabets.length; j++) {
                if (CroatiaAphabets[j].charAt(0) == chars[i]) {//croatia 알파벳 첫 글자와 내가 입력한 첫 글자를 비교해서 같으면
                    if (CroatiaAphabets[j].charAt(1) == chars[i + 1]) {//두번째 철자를 비교한다.
                        if (CroatiaAphabets[j].charAt(0) == 'd' && CroatiaAphabets[j].charAt(1) == 'z') {//dz= 인 경우 cnt 3 증가
                            if (chars.length - i > 2) {
                                if (CroatiaAphabets[j].charAt(2) == chars[i + 2]) { //'='까지 검사
                                    threeWordCnt += 3;
                                    i += 2;
                                    break;
                                }
                            }
                        } else {//나머지 단어들은 철자 갯수가 2라서 cnt 2증가
                            twoWordCnt += 2;
                            i += 1;
                            break;
                        }
                    }
                }
            }
        }
        alphabetCnt=chars.length-threeWordCnt-twoWordCnt;
        alphabetCnt+=threeWordCnt/3+twoWordCnt/2;
        System.out.println(alphabetCnt);

    }
}
