package aoc.sol;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Day7 {


    static long mod = 1000000007;
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        AtomicLong total = new AtomicLong();
        long startTime = System.nanoTime();
        Map<Integer, List<String>> m = new HashMap<>();
        Map<String, List<Integer>> cardToBid = new HashMap<>();
        Files.readAllLines(Path.of("F:\\Programming Workspace\\JAVA\\ProjectDSA\\src\\main\\java\\aoc\\input\\day7.txt")).forEach(input -> {
            String[] cardAndBid = input.split(" ");
            cardAndBid = Arrays.stream(cardAndBid).filter(s -> (!s.equals("") && !s.equals(" "))).toArray(String[]::new);
            if (cardToBid.containsKey(cardAndBid[0])) {
                cardToBid.get(cardAndBid[0]).add(Integer.parseInt(cardAndBid[1]));
            } else {
                List<Integer> t = new ArrayList<>();
                t.add(Integer.parseInt(cardAndBid[1]));
                cardToBid.put(cardAndBid[0], t);
            }
            String card = cardAndBid[0];
            Map<Character, Integer> cardToCount = new HashMap<>();
            for (int i = 0; i < card.length(); i++) {
                cardToCount.put(card.charAt(i), cardToCount.getOrDefault(card.charAt(i), 0) + 1);
            }
            List<Integer> countList = new ArrayList<>(cardToCount.values());
            countList.sort(Collections.reverseOrder());
            if (countList.size() == 1) {
                if (m.containsKey(7)) {
                    m.get(7).add(card);
                } else {
                    List<String> t = new ArrayList<>();
                    t.add(card);
                    m.put(7, t);
                }
            } else if (countList.size() == 2) {
                if (countList.get(0) == 4) {
                    if (m.containsKey(6)) {
                        m.get(6).add(card);
                    } else {
                        List<String> t = new ArrayList<>();
                        t.add(card);
                        m.put(6, t);
                    }
                } else {
                    if (m.containsKey(5)) {
                        m.get(5).add(card);
                    } else {
                        List<String> t = new ArrayList<>();
                        t.add(card);
                        m.put(5, t);
                    }
                }
            } else if (countList.size() == 3) {
                if (countList.get(0) == 3) {
                    if (m.containsKey(4)) {
                        m.get(4).add(card);
                    } else {
                        List<String> t = new ArrayList<>();
                        t.add(card);
                        m.put(4, t);
                    }
                } else {
                    if (m.containsKey(3)) {
                        m.get(3).add(card);
                    } else {
                        List<String> t = new ArrayList<>();
                        t.add(card);
                        m.put(3, t);
                    }
                }
            } else if (countList.size() == 4) {
                if (m.containsKey(2)) {
                    m.get(2).add(card);
                } else {
                    List<String> t = new ArrayList<>();
                    t.add(card);
                    m.put(2, t);
                }
            } else {
                if (m.containsKey(1)) {
                    m.get(1).add(card);
                } else {
                    List<String> t = new ArrayList<>();
                    t.add(card);
                    m.put(1, t);
                }
            }
        });
        List<String> rankedCards = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            if (m.containsKey(i)) {
                m.get(i).sort((a, b) -> {
                    if (a.equals(b)) {
                        return 0;
                    }
                    for (int j = 0; j < a.length(); j++) {
                        if (a.charAt(j) != b.charAt(j)) {
                            return isAGreaterThanB(a.charAt(j), b.charAt(j));
                        }
                    }
                    return 0;
                });
                rankedCards.addAll(m.get(i));
            }
        }
        for (int i = 0; i < rankedCards.size(); i++) {
            String card = rankedCards.get(i);
            int bid = 1;
            List<Integer> bids = cardToBid.get(card);
            if(bids.size()>0) {
                bid = bids.get(0);
                bids.remove(0);
            }
            total.addAndGet((long) bid * (i + 1));
        }
        long endTime = System.nanoTime();
        out.println(total.get());
        out.println("Took " + (endTime - startTime) / 1000000 + " ms");
        out.close();
    }

    public static int isAGreaterThanB(char a, char b) {
        if (a == 'A' && b == 'A') {
            return 0;
        }
        if (a == 'A') {
            return 1;
        }
        if (b == 'A') {
            return -1;
        }
        if (a == 'K' && b == 'K') {
            return 0;
        }
        if (a == 'K') {
            return 1;
        }
        if (b == 'K') {
            return -1;
        }
        if (a == 'Q' && b == 'Q') {
            return 0;
        }
        if (a == 'Q') {
            return 1;
        }
        if (b == 'Q') {
            return -1;
        }
        if (a == 'J' && b == 'J') {
            return 0;
        }
        if (a == 'J') {
            return 1;
        }
        if (b == 'J') {
            return -1;
        }
        if (a == 'T' && b == 'T') {
            return 0;
        }
        if (a == 'T') {
            return 1;
        }
        if (b == 'T') {
            return -1;
        }
        int a1 = a - '0';
        int b1 = b - '0';

        if (a1 > b1) {
            return 1;
        } else if (a1 < b1) {
            return -1;
        } else {
            return 0;
        }
    }


    public static long gcd(long x, long y) {
        if (x % y == 0)
            return y;
        else
            return gcd(y, x % y);
    }

    public static long pow(long n, long p, long m) {
        long result = 1;
        if (p == 0)
            return 1;
        if (p == 1)
            return n;
        while (p != 0) {
            if (p % 2 == 1)
                result *= n;
            if (result >= m)
                result %= m;
            p >>= 1;
            n *= n;
            if (n >= m)
                n %= m;
        }
        return result;
    }

    static class Pair implements Comparable<Day1.Pair> {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Day1.Pair o) {
            if (this.a != o.a)
                return Integer.compare(this.a, o.a);
            else
                return Integer.compare(this.b, o.b);
            // return 0;
        }

        public boolean equals(Object o) {
            if (o instanceof Day1.Pair) {
                Day1.Pair p = (Day1.Pair) o;
                return p.a == a && p.b == b;
            }
            return false;
        }

        public int hashCode() {
            return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
        }
    }

    public static class Debug {
        //change to System.getProperty("ONLINE_JUDGE")==null; for CodeForces
//		public static final boolean LOCAL = System.getProperty("LOCAL")!=null;
        private static <T> String ts(T t) {
            if (t == null) {
                return "null";
            }
            try {
                return ts((Iterable) t);
            } catch (ClassCastException e) {
                if (t instanceof int[]) {
                    String s = Arrays.toString((int[]) t);
                    return "{" + s.substring(1, s.length() - 1) + "}";
                } else if (t instanceof long[]) {
                    String s = Arrays.toString((long[]) t);
                    return "{" + s.substring(1, s.length() - 1) + "}";
                } else if (t instanceof char[]) {
                    String s = Arrays.toString((char[]) t);
                    return "{" + s.substring(1, s.length() - 1) + "}";
                } else if (t instanceof double[]) {
                    String s = Arrays.toString((double[]) t);
                    return "{" + s.substring(1, s.length() - 1) + "}";
                } else if (t instanceof boolean[]) {
                    String s = Arrays.toString((boolean[]) t);
                    return "{" + s.substring(1, s.length() - 1) + "}";
                }
                try {
                    return ts((Object[]) t);
                } catch (ClassCastException e1) {
                    return t.toString();
                }
            }
        }

        private static <T> String ts(T[] arr) {
            StringBuilder ret = new StringBuilder();
            ret.append("{");
            boolean first = true;
            for (T t : arr) {
                if (!first) {
                    ret.append(", ");
                }
                first = false;
                ret.append(ts(t));
            }
            ret.append("}");
            return ret.toString();
        }

        private static <T> String ts(Iterable<T> iter) {
            StringBuilder ret = new StringBuilder();
            ret.append("{");
            boolean first = true;
            for (T t : iter) {
                if (!first) {
                    ret.append(", ");
                }
                first = false;
                ret.append(ts(t));
            }
            ret.append("}");
            return ret.toString();
        }

        public static void dbg(Object... o) {
//			if(LOCAL) {
            System.err.print("Line #" + Thread.currentThread().getStackTrace()[2].getLineNumber() + ": [");
            for (int i = 0; i < o.length; i++) {
                if (i != 0) {
                    System.err.print(", ");
                }
                System.err.print(ts(o[i]));
            }
            System.err.println("]");
//			}
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("..//input//day1.txt"));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() throws IOException {
            String st = br.readLine();
            return st;
        }
    }
}
