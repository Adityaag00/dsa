import java.util.Scanner;

public class ReduceTheSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0) {
            String main= in.next();
            char ch = in.next().charAt(0);

            StringBuilder sb = new StringBuilder();
            char found=main.charAt(0);
            sb.append(found);
            for(int i=1;i<main.length();i++) {
                if(main.charAt(i)==ch && main.charAt(i)==found) {
                    continue;
                }
                found=main.charAt(i);
                sb.append(found);
            }
            System.out.println(sb.toString());
        }
    }
}

