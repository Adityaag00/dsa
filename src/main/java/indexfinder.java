public class indexfinder {
    public static void main(String[] args) {
        String x="> 01.01.1970 05:30 - god damn";
        int i=0;
        for(char c:x.toCharArray())  {
            System.out.println(c+" "+i++);
        }
    }
}
