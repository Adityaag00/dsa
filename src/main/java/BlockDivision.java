import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BlockDivision {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of blocks of shares
        int p = sc.nextInt(); // number of people who applied for allocation
        int[] shares = new int[n]; // array to store number of shares in each block
        for (int i = 0; i < n; i++) {
            shares[i] = sc.nextInt();
        }
        if(p>n) {
            System.out.println(-1);
            return;
        }

        int low = 1; // minimum shares allotted to a shareholder
        int high = Arrays.stream(shares).sum(); // maximum shares allotted to a shareholder
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 1; // number of shareholders
            int sum = 0; // total shares allotted to shareholders
            for (int i = 0; i < n; i++) {
                if (sum + shares[i] <= mid) {
                    sum += shares[i];
                } else {
                    count++;
                    sum = shares[i];
                }
            }
            if (count <= p) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}
