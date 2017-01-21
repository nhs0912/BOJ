import java.io.*;

/**
 * 문제 이름 : 괄호의 값
 * 문제 번호 : 2504
 * 문제 사이트 : https://www.acmicpc.net/problem/2504
 */


class A<T> {
    T t;

}

class Stack<T> {
    private int size = 0;
    //private char[] datas;
    private T[] datas;
    int top = -1;

    boolean overPopCheck = true;//stack이 비어있을 때 pop을 하였는지 검사

    Stack(int size) {

        this.size = size;

        datas = (T[]) new Object[size];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == datas.length - 1;
    }

    void push(T data) {
        if (!isFull()) {
            datas[++top] = data;
        } else {
            //System.out.println("가득찼습니다.");
        }
    }

    T pop() {
        if (!isEmpty()) {
            return datas[top--];
        } else {
            //System.out.println("스택에 데이터가 없습니다.");
            overPopCheck = false;
            return null;
        }
    }

    T peek() {
        if (!isEmpty()) {
            return datas[top];
        } else {
            System.out.println("스택에 데이터가 없습니다.");
            return null;
        }
    }

    int getSize() {
        return size;
    }

    int getTop() {
        return top;
    }

    boolean setoverPopCheck(boolean overPopCheck) {
        this.overPopCheck = overPopCheck;
        return overPopCheck;
    }

    boolean getoverPopCheck() {
        return overPopCheck;
    }
}


class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean isRight = true; //올바른 괄호 검사
        String str = br.readLine().trim();
        char[] parenthesis = str.toCharArray();
        Stack sumStack = new Stack(parenthesis.length);
        int sum = 1;
        int total = 0;


        Stack s = new Stack(parenthesis.length);
        for (int i = 0; i < parenthesis.length; i++) {
            char data = parenthesis[i];
            switch (data) {
                case '(':
                case '[':
                    s.push(data);
                    break;
                case ')':
                case ']':
                    char pop = (char) s.pop();
                    if ('(' == pop && data != ')' || '[' == pop && ']' != data) {
                        //올바르지 않은 괄호이면
                        total = 0;
                        isRight = false;
                        break;
                    } else {
                        //올바른 괄호라면

                        if (s.isEmpty()) {
                            //비어있는 상태면
                            if (pop == '(') {
                                sum *= 2;
                            } else {
                                sum *= 3;
                            }
                            sumStack.push(sum);
                            sum = 1;
                        } else {// 비어있지 않은 상태이면
                            if (pop == '(') {
                                sum *= 2;
                            } else {
                                sum *= 3;
                            }
                        }


                    }
            }
        }
        while (!sumStack.isEmpty()) {
            total += (int) sumStack.pop();
        }
        System.out.println(total);
        if (s.isEmpty() && s.getoverPopCheck() && isRight) {
            bw.write("YES" + "\n");
        } else {
            bw.write("NO" + "\n");
        }
        bw.close();
    }


}