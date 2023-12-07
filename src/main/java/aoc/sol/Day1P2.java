package aoc.sol;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Day1P2 {
    static long mod = 1000000007;
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        AtomicLong total = new AtomicLong();
        long start = System.currentTimeMillis();
        Set<String> nums = Set.of("z", "o", "t", "f", "s","e","n", "ze", "on", "tw", "th", "fo"
                , "fi", "si", "se", "ei", "ni", "zer", "one", "two", "thr", "fou", "fiv", "six", "sev", "eig", "nin"
                , "zero", "thre", "four", "five", "seve", "eigh", "nine", "three", "seven", "eight");
        Set<String> numsInverted = Set.of("e", "o", "r", "x", "n", "t", "en", "ow", "ee", "ru", "ev", "xi", "ne", "th"
                , "eno", "owt", "eer", "ruo", "evi", "xis", "nev", "thg", "eni", "eerh", "ruof", "evif", "neve", "thgi", "enin"
                , "eerht", "neves", "thgie");
        List<String> perfect = Arrays.asList("one", "two", "three   ", "four", "five", "six", "seven", "eight", "nine");
        List<String> perfectInverted = Arrays.asList("eno", "owt", "eerht", "ruof", "evif", "xis", "neves", "thgie", "enin");
        AtomicInteger leftVal = new AtomicInteger();
        AtomicInteger rightVal = new AtomicInteger();
        Files.readAllLines(Path.of("F:\\Programming Workspace\\JAVA\\ProjectDSA\\src\\main\\java\\aoc\\input\\day1.txt")).forEach(input -> {
            int left = 0;
            int right = 0;
            while (true) {
                String s = input.substring(left, right + 1);
                if (left == right) {
                    char c = input.charAt(left);
                    if (Character.isDigit(c)) {
                        leftVal.set(Character.getNumericValue(c));
                        break;
                    }
                }
                if (nums.contains(s)) {
                    if (perfect.contains(s)) {
                        leftVal.set(perfect.indexOf(s) + 1);
                        break;
                    } else {
                        right++;
                        if (right == input.length()) {
                            right = left;
                        }
                    }
                } else {
                    left++;
                    right = left;
                }
            }
            left = 0;
            right = 0;
            input = new StringBuilder(input).reverse().toString();
            while (true) {
                String s = input.substring(left, right + 1);
                if (left == right) {
                    char c = input.charAt(left);
                    if (Character.isDigit(c)) {
                        rightVal.set(Character.getNumericValue(c));
                        break;
                    }
                }
                if (numsInverted.contains(s)) {
                    if (perfectInverted.contains(s)) {
                        rightVal.set(perfectInverted.indexOf(s) + 1);
                        break;
                    } else {
                        right++;
                        if (right == input.length()) {
                            right = left;
                        }
                    }
                } else {
                    left++;
                    right = left;
                }
            }
            input = new StringBuilder(input).reverse().toString();
            total.addAndGet(leftVal.get()*10 + rightVal.get());
        });
        long end = System.currentTimeMillis();
        out.println(total.get());
        out.println(end - start);
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
