import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimumNumberOfOperationsPowerOf2And3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n=in.nextInt();

        if(n<0) {
            System.out.println(-1);
        }
        else if(n==0) {
            System.out.println(0);
        }
        else {
            ArrayList<Integer> nums = new ArrayList<>();
            int temp=1;
            for(int i=0;i<15;i++) {
                nums.add(temp);
                temp=temp*2;
            }
            temp=3;
            for(int i=0;i<11;i++) {
                nums.add(temp);
                temp=temp*3;
            }
            Collections.sort(nums);
            temp=n;
            int steps=0;
            while(temp>=0) {
                if(temp==0) {
                    break;
                }
                int next = -1;
                for (int x : nums) {
                    if(x>temp)
                        break;
                    next=x;
                }
                temp-=next;
                steps++;
            }
            System.out.println(steps);
        }
    }

    private static int next(ArrayList<Integer> arr, int target)
    {
        int start = 0, end = arr.size()-1;
        if(end == 0) return -1;
        if (target > arr.get(end)) return end;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) > target) {
                end = mid - 1;
            }
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
