package Problems;

import java.io.*;

class P_10799 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalCnt = 0;//총 쇠막대기 갯수
        String str = br.readLine().trim();
        char[] parenthesis = str.toCharArray();//String to char[]
        boolean isOpen=false;
        int stickCnt=0;
        for(int i=0; i<parenthesis.length;i++)
        {
            if(!isOpen && parenthesis[i] =='('){
                //닫혀있고 '(' 이라면 열어준다.
                isOpen=true;
            }
            else if(isOpen && parenthesis[i]=='(')
            {//열려있으면서 '(' 만났다면 쇠막대기 갯수 증가
                stickCnt++;
            }
            else if(isOpen && parenthesis[i]==')')
            {//열려있는데 ')' 만난다면 레이저 갯수 증가
                totalCnt+=stickCnt;
                isOpen=false;

            }
            else if(!isOpen && parenthesis[i]==')')
            {
                stickCnt--;
                totalCnt++;
            }
        }
        System.out.println(totalCnt);
        // s.display();
    }
}