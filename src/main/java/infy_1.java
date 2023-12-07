import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class infy_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String x = in.next();
        HashMap<String ,Integer> map = new HashMap<>();
        HashMap<String,String> xx = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        xx.put("L","R");
        xx.put("D","U");
        xx.put("R","L");
        xx.put("U","D");
        for(int i=0;i<n;i++) {
            if(map.containsKey(xx.get(""+x.charAt(i)))) {
                map.put(xx.get(""+x.charAt(i)),map.get(xx.get(""+x.charAt(i)))-1);
            }
            if (map.containsKey(""+x.charAt(i))) {
                map.put(""+x.charAt(i),map.get(""+x.charAt(i))+1);
            }
            else
                map.put(""+x.charAt(i),1);
        }

        for (String j:map.keySet()) {
            for(int k=0;k<map.get(j);k++) {
                list.add(j);
            }
        }
        System.out.println(list.size()/2);
    }
}
