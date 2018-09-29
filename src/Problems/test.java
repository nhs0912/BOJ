import java.util.Stack;

/**
 * Created by Melissa Gu on 08/12/2017.
 */
public class test {

    public static boolean solution(String input){
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<Character>();
        for( int i = 0; i< input.length() ; i++){
            stack.push(input.charAt(i));
        }
        for(int j = 0; j < input.length() ; j++){
            sb.append(stack.pop());
        }
        if(input.equals(sb.toString())){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String str ="POOF";
        String str2 = "POOF";
        if(str == str2){
            System.out.println("작동");
        }

        System.out.print(solution("POOP"));
    }

}
