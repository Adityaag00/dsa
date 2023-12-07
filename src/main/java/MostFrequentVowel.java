import java.util.*;

public class MostFrequentVowel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();

        HashMap<Character, Integer> map = new HashMap<>();

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        Character ans = ' ';
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() > max) {
                max = characterIntegerEntry.getValue();
                ans = characterIntegerEntry.getKey();
            }
        }
        System.out.println(ans);
    }
}
