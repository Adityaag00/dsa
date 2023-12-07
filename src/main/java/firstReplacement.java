import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class firstReplacement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        HashMap<Character,Integer> map = new HashMap<>();

        int counter=0;
        HashSet<pair> set = new HashSet<>();

        for (char c:s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            }
            else {
                map.put(c,1);
            }
        }
        int n=s.length();
        for(int i=0;i<n/2;i++) {
            if(s.charAt(i)!=s.charAt(n-i-1)) {
                pair p = new pair(s.charAt(i),s.charAt(n-i-1));
                set.add(p);
            }
        }
        HashMap<Character,Character> map1 = new HashMap<>();
        for(pair pp:set) {
            char first=pp.first,second=pp.second;
            if(map1.containsKey(pp.first)) {
                first=map1.get(first);
            }
            if(map1.containsKey(pp.second)) {
                second=map1.get(second);
            }
            int x=map.get(pp.first);
            int y=map.get(pp.second);
            if(x<y) {
                counter+=x;
                map1.put(first,second);
                System.out.println(first+" "+second);
                map.put(second,map.get(second)+map.get(first));
            }
            else {
                counter+=y;
                System.out.println(second+" "+first);
                map1.put(second,first);
                map.put(first,map.get(first)+map.get(second));
            }
            System.out.println(counter);
        }
        System.out.println(counter);
    }

    static class pair
    {
        char first, second;
        public pair(char first,
                    char second)
        {
            this.first = first;
            this.second = second;
        }
    }
}
