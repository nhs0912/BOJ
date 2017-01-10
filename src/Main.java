import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] InOffice;
        String[] people;
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        InOffice = new String[n];
        people = new String[n];
        int index = 0;
        while (n > 0) {
            n--;
            st = new StringTokenizer(br.readLine().trim());
            String name = st.nextToken();
            String order = st.nextToken();

            switch (order) {
                case "enter":
                    people[index++] = name;
                    break;
                case "leave":
                    for (int i = 0; i < people.length; i++) {
                        if (people[i].equals(name)) {
                            people[i] = null;
                            break;
                        }
                    }
                    break;
            }
        }
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) {
                System.out.println(people[i]);
            }
        }


    }
}