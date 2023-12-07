import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumScoreXOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        long arr[] = new long[n];
        long pre[] = new long[n];
        long suf[] = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if(i>0) {
                pre[i]=pre[i-1]^arr[i];
            }
            else {
                pre[i]=arr[i];
            }
        }
        PriorityQueue<Long> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> queue2 = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=arr.length-1;i>=0;i--) {
            if(i<arr.length-1) {
                suf[i]=suf[i+1]^arr[i];
            }
            else {
                suf[i]=arr[i];
            }
            queue2.add(suf[i]);
        }
        long max=Long.MIN_VALUE;

        for(int i=0;i<n-1;i++) {
            queue1.add(pre[i]);
            max=Math.max(max,queue1.peek()+ queue2.peek());
            if(i<n-1)
                queue2.remove(suf[i+1]);
        }
        System.out.println(max);
    }
}
