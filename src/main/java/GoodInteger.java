import java.util.*;
import java.util.stream.Collectors;

public class GoodInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        String temp = ""+n;
        findsubsequences(temp,"");
        List<Integer> integerList = al.stream().filter(s -> !s.equals(""))
                .map(Integer::parseInt).collect(Collectors.toList());

        integerList.sort(Comparator.naturalOrder());

        System.out.println(integerList.get(next(integerList,k)));
    }

    static List<String> al = new ArrayList<>();

    private static void findsubsequences(String s,
                                         String ans)
    {
        if (s.length() == 0) {
            al.add(ans);
            return;
        }
        findsubsequences(s.substring(1), ans + s.charAt(0));
        findsubsequences(s.substring(1), ans);
    }

    private static int next(List<Integer> arr, int target)
    {
        int start = 0, end = arr.size() - 1;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) <= target) {
                start = mid + 1;
            }
            else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}
