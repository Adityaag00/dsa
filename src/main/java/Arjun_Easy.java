import java.util.Scanner;

public class Arjun_Easy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i = in.nextInt();

        while(i-->0) {
            int n = in.nextInt();
            String s="";
            if(n>=0 && n<=40) {
                s="U";
            }
            else if(n>=41 && n<=50) {
                s="D";
            }
            else if(n>=51 && n<=60) {
                s="C";
            }
            else if(n>=61 && n<=70) {
                s="B";
            }
            else if(n>=71 && n<=80) {
                s="B+";
            }
            else if(n>=81 && n<=90) {
                s="A";
            }
            else if(n>=91 && n<=100) {
                s="S";
            }
            else {
                s="Invalid input";
            }
            System.out.println(s);
        }
    }
}
