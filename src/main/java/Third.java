import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Third {

    static long ans=0;
    static String x="";
    static int mod= 1000000007;
    public static void main(String[] args) {
        int mod= 1000000007;
        Scanner in = new Scanner(System.in);
        x = in.next();
        int n=in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        printAllSubSequences(arr);
        System.out.println(ans);
    }

    public static void printAllSubSequences(int [] arrInput){
        int [] temp = new int[arrInput.length];
        int index = 0;
        solve(arrInput, index, temp);
    }

    private static void solve(int [] arrInput, int index, int [] temp){
        if(index==arrInput.length){
            calc(arrInput,temp);
            return;
        }
        temp[index] = 1;
        solve(arrInput,index+1,temp);
        temp[index] = 0;
        solve(arrInput,index+1,temp);
    }

    private static void calc(int [] arrInput, int [] temp){
        String result = "";
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i]==1)
                result += arrInput[i];
        }
        if(result=="")
            return;
        calculateans(result);
    }

    static void calculateans(String s) {
        String ss="";
        int i=0;
        for (char c : s.toCharArray()) {
            if(c=='0') {
                i++;
                continue;
            }
            ss=s.substring(i);
            break;
        }
        if(ss.length()<x.length()) {
            return;
        }
        boolean flag=false;
        if(ss.length()>x.length()) {
            ans=((ans%mod)+1%mod)%mod;
        }
        else {
            for (int j = 0; j < ss.length(); j++) {
                if(((int)ss.charAt(j))>((int)x.charAt(j))) {
                    ans=((ans%mod)+1%mod)%mod;
                    break;
                }
                else if(((int)ss.charAt(j))==((int)x.charAt(j))) {
                    flag=true;
                    continue;
                }
                else {
                    flag=false;
                    break;
                }
            }
            if (flag) {
                ans=((ans%mod)+1%mod)%mod;
            }
        }
    }

}
