package ajita_nagarro;

import java.util.*;

import java.util.HashMap;
import java.util.Map;

class LinkGenerator {
    static Map<Integer, Integer> parent;
    static StringBuilder link;

    public static String generateLink(int n, int[][] relations, int m, int[] clientFiles) {
        parent = new HashMap<>();
        for (int[] relation : relations) {
            int a = relation[0];
            int b = relation[1];
            parent.put(b, a);
        }
        link = new StringBuilder("com/");
        for (int clientFile : clientFiles) {
            int p = clientFile;
            while (p > 0) {
                link.append(p).append("/");
                p = parent.get(p);
            }
        }
        return link.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        int clientFiles = in.nextInt();

        int[] files = new int[clientFiles];
        for (int i = 0; i < clientFiles; i++) {
            files[i] = in.nextInt();
        }
        System.out.println(generateLink(n, arr, clientFiles, files));
    }

}


//
//import java.util.*;
//
//public class second {
//
//
//        for (int i = 0; i < clientFiles; i++) {
//            files[i] = in.nextInt();
//        }
//        Map<Integer,Node> map = new HashMap<>();
//        Node one = new Node(1);
//        for (int i=0;i<n;i++) {
//            int container = arr[i][0];
//            int data = arr[i][1];
//
//            if(data >0) {
//
//            }
//            map.get(container).children.add(data);
//        }
//
//        for (Node node : one.children) {
//            System.out.println(node.value);
//        }
//    }
//
//    static Node getNode(Node node, int container) {
//        if(node.children.contains(container)) {
//            return node;
//        } else {
//            for(int child : node.children) {
//                Node childNode = getNode(node, child);
//                if(childNode != null) {
//                    return childNode;
//                }
//            }
//        }
//        return null;
//    }
//
//    static class Node{
//        int value;
//        Set<Integer> children;
//        Node(int value){
//            this.value = value;
//            children = new HashSet<>();
//        }
//    }
//}
