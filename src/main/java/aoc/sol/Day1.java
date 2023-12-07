package aoc.sol;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicLong;

public class Day1 {
    static long mod = 1000000007;
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        AtomicLong total = new AtomicLong();
        Set<String> nums = Set.of("z", "o", "t", "f", "s", "ze", "on", "tw", "th", "fo"
                , "fi", "si", "se", "ei", "ni", "zer", "one", "two", "thr", "fou", "fiv", "six", "sev", "eig", "nin"
                , "zero", "thre", "four", "five", "seve", "eigh", "nine", "three", "seven", "eight");
        List<String> perfect = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Files.readAllLines(Path.of("F:\\Programming Workspace\\JAVA\\ProjectDSA\\src\\main\\java\\aoc\\input\\day1.txt")).forEach(input -> {
            int firstNumber = -1;
            int secondNumber = -1;
            int left = 0;
            StringBuilder first = new StringBuilder();
            StringBuilder second = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char leftChar = input.charAt(left);
                if (Character.isDigit(leftChar)) {
                    firstNumber = Character.getNumericValue(leftChar);
                    first = new StringBuilder();
                } else if (Character.isLetter(leftChar)) {
                    first.append(leftChar);
                    if (nums.contains(first.toString())) {
                        if (perfect.contains(first.toString())) {
                            firstNumber = perfect.indexOf(first.toString()) + 1;
                        }
                    } else {
                        boolean found = false;
                        for (int j= i; j< first.length(); j++) {
                            for (int k= j ; j< first.length(); j++) {
                                if (nums.contains(first.substring(j, k))) {
                                    first = new StringBuilder(first.substring(j, k));
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            first = new StringBuilder();
                            first.append(leftChar);
                        }
                        if (perfect.contains(first.toString())) {
                            firstNumber = perfect.indexOf(first.toString()) + 1;
                            first = new StringBuilder();
                        }
                    }
                }
                if (firstNumber != -1) {
                    break;
                }
                left++;
            }
            for (int i = 0; i < input.length(); i++) {
                char rightChar = input.charAt(i);
                if (Character.isDigit(rightChar)) {
                    secondNumber = Character.getNumericValue(rightChar);
                    second = new StringBuilder();
                } else if (Character.isLetter(rightChar)) {
                    second.append(rightChar);
                    if (nums.contains(second.toString())) {
                        if (perfect.contains(second.toString())) {
                            secondNumber = perfect.indexOf(second.toString()) + 1;
                        }
                    } else {
                        System.out.println(second.toString());
                        boolean found = false;
                        for (int j= 0; j< second.length(); j++) {
                            for (int k= j ; k< second.length(); k++) {
                                System.out.println("j"+" "+j+" "+"k"+" "+k+" "+second.substring(j, k+1));
                                if (nums.contains(second.substring(j, k+1))) {
                                    second = new StringBuilder(second.substring(j, k+1));
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            second = new StringBuilder();
                            second.append(rightChar);
                        }
                        if (perfect.contains(second.toString())) {
                            secondNumber = perfect.indexOf(second.toString()) + 1;
                        }
                    }
                }
            }
            System.out.println(firstNumber + " " + secondNumber);
            int number = firstNumber * 10 + secondNumber;
            total.addAndGet(number);
        });
        out.println(total.get());
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

    static class Pair implements Comparable<Pair> {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair o) {
            if (this.a != o.a)
                return Integer.compare(this.a, o.a);
            else
                return Integer.compare(this.b, o.b);
            // return 0;
        }

        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair) o;
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
