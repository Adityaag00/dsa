package nabeel_nagarro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(brd.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(brd.readLine());
        int[] too = Arrays.stream(brd.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nop = Arrays.stream(brd.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arx = Arrays.stream(brd.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int q = Integer.parseInt(brd.readLine());

        for(int i=0;i<q;i++) {
            if(too[i]==1) {
                for(int j=0;j<nop[i];j++) {
                    arr[j]=arr[j]^arx[i];
                }
            }
            else {
                for(int j=n-1;j>=n-nop[i];j--) {
                    arr[j] = arr[j] ^ arx[i];
                }
            }
        }

        for (int x : arr) {
            System.out.print(x+" ");
        }
    }
}
