package ajita_nagarro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BigPrimeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int k= in.nextInt();
        System.out.println(getBigPrimenUmber(n, arr, k));
    }

    static int getBigPrimenUmber(int n, int[] arr, int k){
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        int x =1;

        for(int i=1;i<=k;i++) {
            q1.add(x*arr[0]);
            q2.add(x*arr[1]);
            q3.add(x*arr[2]);

            x=Math.min(q1.peek(), Math.min(q2.peek(), q3.peek()));
            if(x==q1.peek()) {
                q1.remove();
            }
            if(x==q2.peek()) {
                q2.remove();
            }
            if(x==q3.peek()) {
                q3.remove();
            }
        }
        return x;
    }

    public int kthNumber(int input1,int[] input2,int input3){
       return getBigPrimenUmber(input1, input2, input3);
    }
}
