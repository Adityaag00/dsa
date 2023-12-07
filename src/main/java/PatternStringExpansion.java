import java.util.Scanner;

public class PatternStringExpansion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0) {
            int n= in.nextInt();
            String s = in.next();
            String temp="";
            String ans="";
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if(Character.isDigit(c)) {
                    String num=""+c;
                    if(i<n-1) {
                        while(i<n-1 && Character.isDigit(s.charAt(i+1))) {
                            i++;
                            num+=s.charAt(i);
                        }
                    }
                    for (int j = 0; j < Integer.parseInt(num); j++) {
                        ans+=temp;
                    }
                    temp="";
                }
                else {
                    temp+=c;
                }
            }
            System.out.println(ans);
        }
    }
}
