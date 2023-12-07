package aoc.sol;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Day3P2 {

    static long mod = 1000000007;
    static int inf = Integer.MAX_VALUE;

    static HashSet<String> visited = new HashSet<>();

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        AtomicLong total = new AtomicLong();
        long startTime = System.nanoTime();
        List<String> inputs = Files.readAllLines(Path
                .of("F:\\Programming Workspace\\JAVA\\ProjectDSA\\src\\main\\java\\aoc\\input\\day3.txt"));
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < inputs.get(i).length(); j++) {
                if (inputs.get(i).charAt(j) == '*') {
                    total.addAndGet(visitAllSides(j, i, inputs));
                }
            }
        }
        long endTime = System.nanoTime();
        out.println(total.get());
        out.println("Took " + (endTime - startTime) / 1000000 + " ms");
        out.close();
    }

    public static int getValueAdjacent(List<String> strings, Direction direction, int x, int y) {
        boolean found = false;
        int x1 = 0, y1 = 0;
        switch (direction) {
            case UP:
                if (y <= 0) {
                    break;
                }
                x1 = x;
                y1 = y - 1;
                if (Character.isDigit(strings.get(y - 1).charAt(x))) {
                    found = true;
                    break;
                }
                break;
            case DOWN:
                if (y >= strings.size() - 1) {
                    break;
                }
                x1 = x;
                y1 = y + 1;
                if (Character.isDigit(strings.get(y + 1).charAt(x))) {
                    found = true;
                    break;
                }
                break;
            case LEFT:
                if (x <= 0) {
                    break;
                }
                x1 = x - 1;
                y1 = y;
                if (Character.isDigit(strings.get(y).charAt(x - 1))) {
                    found = true;
                    break;
                }
                break;
            case RIGHT:
                if (x >= strings.get(y).length() - 1) {
                    break;
                }
                x1 = x + 1;
                y1 = y;
                if (Character.isDigit(strings.get(y).charAt(x + 1))) {
                    found = true;
                    break;
                }
                break;
            case UP_LEFT:
                if (y <= 0 || x <= 0) {
                    break;
                }
                x1 = x - 1;
                y1 = y - 1;
                if (Character.isDigit(strings.get(y - 1).charAt(x - 1))) {
                    found = true;
                    break;
                }
                break;
            case UP_RIGHT:
                if (y <= 0 || x >= strings.get(y).length() - 1) {
                    break;
                }
                x1 = x + 1;
                y1 = y - 1;
                if (Character.isDigit(strings.get(y - 1).charAt(x + 1))) {
                    found = true;
                    break;
                }
                break;
            case DOWN_LEFT:
                if (y >= strings.size() - 1 || x <= 0) {
                    break;
                }
                x1 = x - 1;
                y1 = y + 1;
                if (Character.isDigit(strings.get(y + 1).charAt(x - 1))) {
                    found = true;
                    break;
                }
                break;
            case DOWN_RIGHT:
                if (y >= strings.size() - 1 || x >= strings.get(y).length() - 1) {
                    break;
                }
                x1 = x + 1;
                y1 = y + 1;
                if (Character.isDigit(strings.get(y + 1).charAt(x + 1))) {
                    found = true;
                    break;
                }
                break;
        }
        if (found) {
            String toCheck = strings.get(y1);
            int tempX = x1;
            StringBuilder sb = new StringBuilder();
            while (tempX >= 0) {
                if (!Character.isDigit(toCheck.charAt(tempX))) {
                    break;
                }
                sb.append(toCheck.charAt(tempX));
                tempX--;
            }
            tempX++;
            if (visited.contains(tempX + "," + y1)) {
                return 0;
            }
            visited.add(tempX + "," + y1);
            sb.reverse();
            tempX = x1 + 1;
            while (tempX < toCheck.length()) {
                if (!Character.isDigit(toCheck.charAt(tempX))) {
                    break;
                }
                sb.append(toCheck.charAt(tempX));
                tempX++;
            }
            return Integer.parseInt(sb.toString());
        }
        return 0;
    }

    public static int visitAllSides(int x, int y, List<String> strings) {
        List<Integer> temp = new ArrayList<>();
        int count = 0;
        int up = getValueAdjacent(strings, Direction.UP, x, y);
        if(up != 0) {
            temp.add(up);
        }
        int down = getValueAdjacent(strings, Direction.DOWN, x, y);
        if(down != 0) {
            temp.add(down);
        }
        int left = getValueAdjacent(strings, Direction.LEFT, x, y);
        if(left != 0) {
            temp.add(left);
        }
        int right = getValueAdjacent(strings, Direction.RIGHT, x, y);
        if(right != 0) {
            temp.add(right);
        }
        int upLeft = getValueAdjacent(strings, Direction.UP_LEFT, x, y);
        if(upLeft != 0) {
            temp.add(upLeft);
        }
        int upRight = getValueAdjacent(strings, Direction.UP_RIGHT, x, y);
        if(upRight != 0) {
            temp.add(upRight);
        }
        int downLeft = getValueAdjacent(strings, Direction.DOWN_LEFT, x, y);
        if(downLeft != 0) {
            temp.add(downLeft);
        }
        int downRight = getValueAdjacent(strings, Direction.DOWN_RIGHT, x, y);
        if(downRight != 0) {
            temp.add(downRight);
        }
        if(temp.size() == 2) {
            return temp.get(0) * temp.get(1);
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

