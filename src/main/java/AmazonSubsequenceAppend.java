import java.util.Scanner;
import java.util.Stack;

public class AmazonSubsequenceAppend {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String r = in.next();

        Stack<Character> st = new Stack<>();

        for(int i=r.length()-1;i>=0;i--) {
            st.add(r.charAt(i));
        }

        for(int i=0;i<s.length();i++) {
            if(st.peek()==s.charAt(i)) {
                st.pop();
            }
        }
        System.out.println(st.size());
    }
}
