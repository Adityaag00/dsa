package nabeel_nagarro;

import java.util.Scanner;

public class anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();

//        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(char i:b.toCharArray()) {
            arr2[i-'a']++;
        }
        int cnt=0;
        for(char i:a.toCharArray()) {
            arr2[i-'a']--;
        }
        int maxi=0;
        int k=0;
        for(int i:arr2) {
            if(i>=0)
                cnt+=i;
            else {
                for (int j = 0; j < a.length(); j++) {
                    if(a.charAt(j)==(k+'a')) {
                        maxi=Math.max(maxi,j);
                    }
                }
            }
            k++;
        }
        for(int i=0;i<=maxi;i++) {
            if(arr2[a.charAt(i)-'a']==0) {
                cnt++;
            }
        }
        cnt+=maxi+1;
        System.out.println(cnt);
    }
}
