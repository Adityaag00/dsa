package aoc.sol;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class day5P2 {
    static long mod = 1000000007;
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        AtomicLong total = new AtomicLong(Long.MAX_VALUE);
        long startTime = System.nanoTime();
        List<Long> seeds = new ArrayList<>();
        List<String> seedToSoilMap = new ArrayList<>();
        List<String> soilToFertilizerMap = new ArrayList<>();
        List<String> fertilizerToWaterMap = new ArrayList<>();
        List<String> waterToLightMap = new ArrayList<>();
        List<String> lightToTemperatureMap = new ArrayList<>();
        List<String> temperatureToHumidityMap = new ArrayList<>();
        List<String> humidityToLocationMap = new ArrayList<>();
        AtomicReference<String> current = new AtomicReference<>("");
        Files.readAllLines(Path.of("/Users/aditya/Programming Workspace/JAVA/ProjectDSA/src/main/java/aoc/input/day5.txt")).forEach(input -> {
            if (input.startsWith("seeds")) {
                String[] seedT = input.split(":")[1].split(" ");
                seedT = Arrays.stream(seedT).filter(s -> !s.equals("") && !s.equals(" ")).toArray(String[]::new);
                for (String s : seedT) {
                    seeds.add(Long.parseLong(s));
                }
            }
            if (input.equals("seed-to-soil map:")) {
                current.set("seed-to-soil map");
            } else if (input.equals("soil-to-fertilizer map:")) {
                current.set("soil-to-fertilizer map");
            } else if (input.equals("fertilizer-to-water map:")) {
                current.set("fertilizer-to-water map");
            } else if (input.equals("water-to-light map:")) {
                current.set("water-to-light map");
            } else if (input.equals("light-to-temperature map:")) {
                current.set("light-to-temperature map");
            } else if (input.equals("temperature-to-humidity map:")) {
                current.set("temperature-to-humidity map");
            } else if (input.equals("humidity-to-location map:")) {
                current.set("humidity-to-location map");
            } else if (!input.equals("") && !input.equals(" ")) {
                switch (current.get()) {
                    case "seed-to-soil map":
                        seedToSoilMap.add(input);
                        break;
                    case "soil-to-fertilizer map":
                        soilToFertilizerMap.add(input);
                        break;
                    case "fertilizer-to-water map":
                        fertilizerToWaterMap.add(input);
                        break;
                    case "water-to-light map":
                        waterToLightMap.add(input);
                        break;
                    case "light-to-temperature map":
                        lightToTemperatureMap.add(input);
                        break;
                    case "temperature-to-humidity map":
                        temperatureToHumidityMap.add(input);
                        break;
                    case "humidity-to-location map":
                        humidityToLocationMap.add(input);
                        break;
                }
            }
        });
        Collections.sort(seedToSoilMap);
        current.set("seed-to-soil map");
        List<Pair> seedPairs = new ArrayList<>();
        for (int i = 0; i < seeds.size(); i += 2) {
            seedPairs.add(new Pair(seeds.get(i), seeds.get(i + 1)));
        }
        Set<Pair> visitedSeedPairs = new HashSet<>();
        Set<Pair> visitedSoilPairs = new HashSet<>();
        Set<Pair> visitedFertilizerPairs = new HashSet<>();
        Set<Pair> visitedWaterPairs = new HashSet<>();
        Set<Pair> visitedLightPairs = new HashSet<>();
        Set<Pair> visitedTemperaturePairs = new HashSet<>();
        Set<Pair> visitedHumidityPairs = new HashSet<>();
        Set<Pair> visitedLocationPairs = new HashSet<>();
        for (Pair seedPair : seedPairs) {
            if (visitedSeedPairs.contains(seedPair))
                continue;
            visitedSeedPairs.add(seedPair);
            System.out.println("Seed Pair: " + seedPair.a + " " + seedPair.b);
            for (String s : seedToSoilMap) {
                List<Pair> soilPairs = new ArrayList<>();
                long[] range = Arrays.stream(s.split(" ")).filter(s1 -> !s1.isEmpty() && !s1.equals(" "))
                        .mapToLong(Long::parseLong).toArray();
                long a = seedPair.a;
                long b = seedPair.a + seedPair.b - 1;
                long rA = range[0];
                long rB = range[0] + range[2] - 1;
                addInListPair(a, b, rA, rB, soilPairs);
                System.out.println("Soil Pair: " + Arrays.toString(soilPairs.toArray()));
                for (Pair soilPair : soilPairs) {
                    if (visitedSoilPairs.contains(soilPair))
                        continue;
                    visitedSoilPairs.add(soilPair);
                    List<Pair> fertilizerPairs = new ArrayList<>();
                    for (String s1 : soilToFertilizerMap) {
                        long[] range1 = Arrays.stream(s1.split(" ")).filter(s2 -> !s2.isEmpty() && !s2.equals(" "))
                                .mapToLong(Long::parseLong).toArray();
                        long a1 = soilPair.a;
                        long b1 = soilPair.a + soilPair.b - 1;
                        long rA1 = range1[0];
                        long rB1 = range1[0] + range1[2] - 1;
                        addInListPair(a1, b1, rA1, rB1, fertilizerPairs);
                        System.out.println("Fertilizer Pair: " + Arrays.toString(fertilizerPairs.toArray()));
                        for (Pair fertilizerPair : fertilizerPairs) {
                            if (visitedFertilizerPairs.contains(fertilizerPair))
                                continue;
                            visitedFertilizerPairs.add(fertilizerPair);
                            List<Pair> waterPairs = new ArrayList<>();
                            for (String s2 : fertilizerToWaterMap) {
                                long[] range2 = Arrays.stream(s2.split(" ")).filter(s3 -> !s3.isEmpty() && !s3.equals(" "))
                                        .mapToLong(Long::parseLong).toArray();
                                long a2 = fertilizerPair.a;
                                long b2 = fertilizerPair.a + fertilizerPair.b - 1;
                                long rA2 = range2[0];
                                long rB2 = range2[0] + range2[2] - 1;
                                addInListPair(a2, b2, rA2, rB2, waterPairs);
                                System.out.println("Water Pair: " + Arrays.toString(waterPairs.toArray()));
                                for (Pair waterPair : waterPairs) {
                                    if (visitedWaterPairs.contains(waterPair))
                                        continue;
                                    visitedWaterPairs.add(waterPair);
                                    List<Pair> lightPairs = new ArrayList<>();
                                    for (String s3 : waterToLightMap) {
                                        long[] range3 = Arrays.stream(s3.split(" ")).filter(s4 -> !s4.isEmpty() && !s4.equals(" "))
                                                .mapToLong(Long::parseLong).toArray();
                                        long a3 = waterPair.a;
                                        long b3 = waterPair.a + waterPair.b - 1;
                                        long rA3 = range3[0];
                                        long rB3 = range3[0] + range3[2] - 1;
                                        addInListPair(a3, b3, rA3, rB3, lightPairs);
                                        System.out.println("Light Pair: " + Arrays.toString(lightPairs.toArray()));
                                        for (Pair lightPair : lightPairs) {
                                            if (visitedLightPairs.contains(lightPair))
                                                continue;
                                            visitedLightPairs.add(lightPair);
                                            List<Pair> temperaturePairs = new ArrayList<>();
                                            for (String s4 : lightToTemperatureMap) {
                                                long[] range4 = Arrays.stream(s4.split(" ")).filter(s5 -> !s5.isEmpty() && !s5.equals(" "))
                                                        .mapToLong(Long::parseLong).toArray();
                                                long a4 = lightPair.a;
                                                long b4 = lightPair.a + lightPair.b - 1;
                                                long rA4 = range4[0];
                                                long rB4 = range4[0] + range4[2] - 1;
                                                addInListPair(a4, b4, rA4, rB4, temperaturePairs);
                                                System.out.println("Temperature Pair: " + Arrays.toString(temperaturePairs.toArray()));
                                                for (Pair temperaturePair : temperaturePairs) {
                                                    if (visitedTemperaturePairs.contains(temperaturePair))
                                                        continue;
                                                    visitedTemperaturePairs.add(temperaturePair);
                                                    List<Pair> humidityPairs = new ArrayList<>();
                                                    for (String s5 : temperatureToHumidityMap) {
                                                        long[] range5 = Arrays.stream(s5.split(" ")).filter(s6 -> !s6.isEmpty() && !s6.equals(" "))
                                                                .mapToLong(Long::parseLong).toArray();
                                                        long a5 = temperaturePair.a;
                                                        long b5 = temperaturePair.a + temperaturePair.b - 1;
                                                        long rA5 = range5[0];
                                                        long rB5 = range5[0] + range5[2] - 1;
                                                        addInListPair(a5, b5, rA5, rB5, humidityPairs);
                                                        System.out.println("Humidity Pair: " + Arrays.toString(humidityPairs.toArray()));
                                                        for (Pair humidityPair : humidityPairs) {
                                                            if (visitedHumidityPairs.contains(humidityPair))
                                                                continue;
                                                            visitedHumidityPairs.add(humidityPair);
                                                            List<Pair> locationPairs = new ArrayList<>();
                                                            for (String s6 : humidityToLocationMap) {
                                                                long[] range6 = Arrays.stream(s6.split(" ")).filter(s7 -> !s7.isEmpty() && !s7.equals(" "))
                                                                        .mapToLong(Long::parseLong).toArray();
                                                                long a6 = humidityPair.a;
                                                                long b6 = humidityPair.a + humidityPair.b - 1;
                                                                long rA6 = range6[0];
                                                                long rB6 = range6[0] + range6[2] - 1;
                                                                addInListPair(a6, b6, rA6, rB6, locationPairs);
                                                                System.out.println("Location Pair: " + Arrays.toString(locationPairs.toArray()));
                                                                for (Pair locationPair : locationPairs) {
                                                                    if (visitedLocationPairs.contains(locationPair))
                                                                        continue;
                                                                    visitedLocationPairs.add(locationPair);
                                                                    long a7 = locationPair.a;
                                                                    total.set(Math.min(total.get(), a7));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        out.println(total.get());
        out.println("Took " + (endTime - startTime) / 1000000 + " ms");
        out.close();
    }

    public static void addInListPair(long a, long b, long rA, long rB,long rk,long rj, List<Pair> x) {
        System.out.println("-----------------"+" a: "+a+" b: "+b+" rA: "+rA+" rB: "+rB);
        if (a > rA) {
            if (b < rB) {
                Pair p2 = new Pair(a, b - a + 1);
                x.add(p2);
            } else if (b == rB) {
                Pair p2 = new Pair(a, b - a + 1);
                x.add(p2);
            } else {
                Pair p2 = new Pair(a, rB - a + 1);
                x.add(p2);
            }
        } else if (a == rA) {
            if (b < rB) {
                Pair p1 = new Pair(a, b - a + 1);
                x.add(p1);
            } else if (b == rB) {
                Pair p1 = new Pair(a, b - a + 1);
                x.add(p1);
            } else {
                Pair p1 = new Pair(a, rB - a + 1);
                x.add(p1);
            }
        } else {
            if (b < rB) {
                Pair p2 = new Pair(rA, b - a + 1);
                x.add(p2);
            } else if (b == rB) {
                Pair p2 = new Pair(rA, b - a + 1);
                x.add(p2);
            } else {
                Pair p2 = new Pair(rA, rB - a + 1);
                x.add(p2);
            }
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

    static class Pair {
        long a, b;

        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return "(" + a + ", " + b + ")";
        }

        public boolean equals(Object o) {
            if (o instanceof Day1.Pair) {
                Day1.Pair p = (Day1.Pair) o;
                return p.a == a && p.b == b;
            }
            return false;
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
