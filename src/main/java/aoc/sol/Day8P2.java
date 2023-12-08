package aoc.sol;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Day8P2 {


    static long mod = 1000000007;
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        AtomicLong total = new AtomicLong();
        long startTime = System.nanoTime();
        AtomicReference<String> instructions = new AtomicReference<>("");
        Map<String, Day8.Pair> m = new HashMap<>();
        List<String> toIterateFor = new ArrayList<>();
        Files.readAllLines(Path.of("/Users/aditya/Programming Workspace/JAVA/ProjectDSA/src/main/java/aoc/input/day8.txt")).forEach(input -> {
            if (!input.equals("") && !input.equals("\n") && !input.equals(" ")) {
                if (instructions.get().equals("")) {
                    instructions.set(input);
                    return;
                }
                String[] s = input.split("=");
                String second = s[1].trim().substring(1, s[1].trim().length() - 1);
                String[] pairs = second.split(",");
                m.put(s[0].trim(), new Day8.Pair(pairs[0].trim(), pairs[1].trim()));
                if (s[0].trim().endsWith("A")) {
                    toIterateFor.add(s[0].trim());
                }
            }
        });
        Map<String,String> currentMap = new HashMap<>();
        List<Long> ans = new ArrayList<>();
        for(String s : toIterateFor) {
            String current = s;
            int count = 0;
            while (true) {
                if(currentMap.containsKey(s)) {
                    current = currentMap.get(s);
                }
                if(current.endsWith("Z")) {
                    ans.add((long)count);
                    break;
                }
                char i = instructions.get().charAt(count % instructions.get().length());
                Day8.Pair pair = m.get(current);
                if (i == 'L') {
                    current = pair.a;
                } else {
                    current = pair.b;
                }
                currentMap.put(s,current);
                count++;
            }
        }
        System.out.println(Arrays.toString(ans.toArray()));
        long endTime = System.nanoTime();
        System.out.println(LcmOfArray(ans,0));
        out.println("Took " + (endTime - startTime) / 1000000 + " ms");
        out.close();
    }


    public static long gcd(long x, long y) {
        if (x % y == 0)
            return y;
        else
            return gcd(y, x % y);
    }

    public static long LcmOfArray(List<Long> arr, int idx)
    {

        // lcm(a,b) = (a*b/gcd(a,b))
        if (idx == arr.size() - 1){
            return arr.get(idx);
        }
        long a = arr.get(idx);
        long b = LcmOfArray(arr, idx+1);
        return (a*b/gcd(a,b)); //
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

    static class Pair {
        BigInteger a;
        String b;

        Pair(BigInteger a, String b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return a + "," + b;
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