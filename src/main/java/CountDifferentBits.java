import java.math.BigInteger;
import java.util.Scanner;

public class CountDifferentBits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long i = in.nextLong();
        long j = in.nextLong();

        if(i<0) {
            i=-i;
            i=getTwos(i);
            System.out.println(i);
        }
        if(j<0) {
            j=-j;
            j=getTwos(j);
        }

        long k = i^j;

        System.out.println(countBits(k));
    }

    static int countBits(long x) {
        int xx=0;
        while(x!=0) {
            x=x&(x-1);
            xx++;
        }
        return xx;
    }

    static long getTwos(long x) {
        String s = Long.toBinaryString(x);
        String two = findTwoscomplement(new StringBuffer(s));
        String app="";
        for (int i = 0; i < 32 - two.length(); i++) {
            app+="1";
        }
        return new BigInteger(app+two, 2).longValue();
    }

    static String findTwoscomplement(StringBuffer str)
    {
        int n = str.length();

        int i;
        for (i = n-1 ; i >= 0 ; i--)
            if (str.charAt(i) == '1')
                break;

        if (i == -1)
            return "1" + str;
        for (int k = i-1 ; k >= 0; k--)
        {
            if (str.charAt(k) == '1')
                str.replace(k, k+1, "0");
            else
                str.replace(k, k+1, "1");
        }
        return str.toString();
    }

}
