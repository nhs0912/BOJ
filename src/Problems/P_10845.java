import java.io.*;

import java.util.StringTokenizer;

/**
 * Created by nhs09 on 2017-01-06.
 */


class Queue {
    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node rear;
    private Node front;

    boolean isEmpty() {
        return rear == null;
    }

    void empty() {
        if (isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }


    void push(int data) {
        if (!isEmpty()) {
            Node newNode = new Node(data);
            rear.next = newNode;
            rear = newNode;
        } else {
            Node newNode = new Node(data);
            rear = newNode;
            front = newNode;
        }
    }

    void pop() {
        if (front!=null) {
            System.out.println(front.data);
            front = front.next;
            if(size()==0)
            {
                rear=null;
            }
        } else {
            rear=null;
            System.out.println(-1);
        }
    }

    void front() {
        if (front!=null) {
            System.out.println(front.data);
            //front = front.next;
        } else {
            System.out.println(-1);
        }
    }

    void back() {
        if (rear!=null) {
            System.out.println(rear.data);
        } else {
            System.out.println(-1);
        }
    }

    int size() {
        Node tmp = front;
        int cnt = 0;
        while (tmp != null) {
            cnt++;
            tmp = tmp.next;
        }
        return cnt;
    }

    void display() {
        while (front != null) {
            System.out.println(front.data);
            front = front.next;
        }
    }


}


public class P_10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        Queue q = new Queue();
        while (n > 0) {
            n--;
            st = new StringTokenizer(br.readLine().trim());
            String order = st.nextToken();
            int data = 0;
            if (st.hasMoreTokens()) {
                data = Integer.parseInt(st.nextToken());
            }
            switch (order) {
                case "push":
                    q.push(data);
                    break;
                case "pop":
                    q.pop();
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    q.empty();
                    break;
                case "front":
                    q.front();
                    break;
                case "back":
                    q.back();
                    break;
            }
        }
    }

}
