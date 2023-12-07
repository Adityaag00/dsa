import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LexographicallyLargest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while (t-->0) {
            int n= in.nextInt();
            String s= in.next();

            HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
            char max='a';
            int i=0;
            for(char c: s.toCharArray()) {
                if(c<max) {
                    i++;
                    continue;
                }
                else {
                    if(c==max) {
                        if(map.containsKey(c)) {
                            map.get(c).add(i);
                        }
                        else {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(i);
                            map.put(c,list);
                        }
                    }
                    else {
                        max=c;
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(i);
                        map.put(c,list);
                    }
                    i++;
                }
            }
            ArrayList<Integer> list = map.get(max);
            if(list.size()>1) {
                ArrayList<String> list1 = new ArrayList<>();
                for(int i1:list) {
                    StringBuilder sb = new StringBuilder(s.substring(0,i1+1));
                    sb.reverse();
                    String temp= sb +s.substring(i1+1);
                    list1.add(temp);
                }
                String maxAns="";
                for(String s1:list1) {
                    if(maxAns.compareTo(s1)<0) {
                        maxAns=s1;
                    }
                }
                System.out.println(maxAns);
            }
            else {
                StringBuilder sb = new StringBuilder(s.substring(0,list.get(0)+1));
                sb.reverse();
                String ans= sb +s.substring(list.get(0)+1);
                System.out.println(ans);
            }
        }
    }
}
