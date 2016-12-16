import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt( token.nextToken() );

        int x;
        x = n;
        int index = 1;
        while(true) {
            if(x - index <= 0) break;
            x -= index;
            index++;
        }

        int resultX = index-x+1;
        int resultY = x;

        if(index%2 == 0) {
            int temp = resultX;
            resultX = resultY;
            resultY = temp;
        }
        System.out.println( resultX + "/" + resultY );
    }
}
