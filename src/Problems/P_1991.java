package Problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 이름 : 트리 순회
 * 문제 번호 : 1991
 * 문제 사이트 : https://www.acmicpc.net/problem/1991
 */
class P_1991 {

    char[] Tree = new char[67108863];
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void inOrder(int root) throws IOException {
        if (Tree[root] != '.' && Tree[root] != '\u0000') {
            inOrder(root * 2);
            //System.out.print(Tree[root]);
            bw.write(Tree[root]);
            inOrder((root * 2) + 1);
        }
    }

    void preOrder(int root) throws IOException {
        if (Tree[root] != '.' && Tree[root] != '\u0000') {
            //System.out.print(Tree[root]);
            bw.write(Tree[root]);
            preOrder(root * 2);
            preOrder((root * 2) + 1);
        }

    }

    void postOrder(int root) throws IOException {
        if (Tree[root] != '.' && Tree[root] != '\u0000') {
            postOrder(root * 2);
            postOrder((root * 2) + 1);
            //System.out.print(Tree[root]);
            bw.write(Tree[root]);
        }
    }


    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine().trim());
        Tree[1] = 'A';
        int index = 0;
        if (N > 0) {
            while (N-- > 0) {//N만큼 입력 받기
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                char data = st.nextToken().charAt(0);
                for (int i = 1; i < Tree.length; i++) {
                    if (Tree[i] == data) {
                        index = i;//parent
                        break;
                    }
                }
                Tree[index * 2] = st.nextToken().charAt(0); //left
                Tree[(index * 2) + 1] = st.nextToken().charAt(0); //right
            }
            preOrder(1);
            //System.out.println();
            bw.write("\n");
            inOrder(1);
            bw.write("\n");
            //System.out.println();
            postOrder(1);
            bw.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new P_1991().Solve();
    }
}