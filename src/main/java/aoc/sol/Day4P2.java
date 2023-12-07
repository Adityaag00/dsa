package aoc.sol;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Day4P2 {


    static long mod = 1000000007;
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        AtomicLong total = new AtomicLong();
        long startTime = System.nanoTime();
        Map<Integer, Integer> m = new HashMap<>();
        AtomicInteger lastCard = new AtomicInteger();
        Files.readAllLines(Path.of("F:\\Programming Workspace\\JAVA\\ProjectDSA\\src\\main\\java\\aoc\\input\\day4.txt")).forEach(input -> {
            String[] cardAndNumbers = input.split(":");
            String[] numberWithSpaces = cardAndNumbers[0].split(" ");
            int cardNumber = Integer.parseInt(numberWithSpaces[numberWithSpaces.length - 1]);
            lastCard.set(cardNumber);
            if(!m.containsKey(cardNumber)){
                m.put(cardNumber, 1);
            }
            String[] leftAndRight = cardAndNumbers[1].split("\\|");
            String[] leftNumbers = leftAndRight[0].split(" ");
            String[] rightNumbers = leftAndRight[1].split(" ");
            leftNumbers = Arrays.stream(leftNumbers).filter(s -> (!s.equals("") && !s.equals(" "))).toArray(String[]::new);
            rightNumbers = Arrays.stream(rightNumbers).filter(s -> (!s.equals("") && !s.equals(" "))).toArray(String[]::new);
            int count = 0;
            Set<String> t = new HashSet<>(Arrays.asList(leftNumbers));
            for (String s : rightNumbers) {
                if (t.contains(s)) {
                    count++;
                }
            }
            int currentCount = m.getOrDefault(cardNumber, 1);
            for (int i = 1; i <= count; i++) {
                m.put(cardNumber + i, m.getOrDefault(cardNumber + i, 1) + currentCount);
            }
        });
        m.forEach((k, v) -> {
            if (k > lastCard.get()) {
                return;
            }
            total.addAndGet(v);
        });
        long endTime = System.nanoTime();
        out.println(total.get());
        out.println("Took " + (endTime - startTime) / 1000000 + " ms");
        out.close();
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
