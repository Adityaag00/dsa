import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        int n = in.nextInt();
        int q = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++) {
            list.add(in.nextInt());
        }
        String[] qq = new String[q];
        for(int i=0;i<q;i++) {
            qq[i]=in.next();
        }
        Collections.sort(list);
        int ans=0;
        for(String query:qq) {
            String[] queries = query.split(" ");
            if(queries[0].equals("1")) {
                if(queries[1].equals("-1")) {
                    int ind = getIndex(Integer.parseInt(queries[2]),list);
                    if(ind!=-1) {
                        list.remove(new Integer(Integer.parseInt(queries[2])));
                        n-=1;
                    }
                }
                else {
                    list.add(Integer.parseInt(queries[2]));
                    Collections.sort(list);
                }
            }
            else {
                int left = Integer.parseInt(queries[1]);
                int right = Integer.parseInt(queries[2]);
                int count = 0;
                count = upperIndex(list, n, right) -
                        lowerIndex(list, n, left) + 1;
                ans+=count;
            }
        }
        System.out.println(ans);
    }

    static int getIndex(int x, ArrayList<Integer> arr) {
        int left = 0, right = arr.size() - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) == x)
                return mid;
            if (arr.get(mid) < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    static int lowerIndex(ArrayList<Integer> arr, int n, int x)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr.get(mid) >= x)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
    static int upperIndex(ArrayList<Integer> arr, int n, int y)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr.get(mid) <= y)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h;
    }

}
