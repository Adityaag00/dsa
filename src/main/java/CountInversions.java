import java.util.Scanner;

public class CountInversions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int count =0;
        String[] ss = s.split(" ");

        for(String x:ss) {
            if(x.equals("./")) {
                count=count;
            }
            else if(x.equals("../")) {
                count=0;
            }
            else if(x.equals("x/")){
                count++;
            }
            else if(x.equals("../x")) {
                count=1;
            }
            else if(x.equals("./x")) {
                count++;
            }
        }

        System.out.println(count);
    }
}
