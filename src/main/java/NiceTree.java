import java.util.*;

public class NiceTree {
    static class Node {
        ArrayList<Edge> edges= new ArrayList<>();
    }

    static class Edge{
        Node node;
        int data;

        Edge(Node node,int data) {
            this.node=node;
            this.data=data;
        }
        public String toString() {
            return node.toString() +" "+data;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        HashMap<Integer,Node> map = new HashMap<>();
        HashSet<Node> set = new HashSet<>();
        for(int i=1;i<=n;i++) {
            map.put(i,new Node());
        }
        for(int i=0;i<m;i++) {
            int x= in.nextInt();
            int y= in.nextInt();
            int z= in.nextInt();
            if(map.containsKey(x)) {
                Node nodeF = map.get(x);
                Node nodeT=map.get(y);
                nodeF.edges.add(new Edge(nodeT,z));
                if(z==0) {
                    set.add(nodeF);
                }
                map.put(x,nodeF);
            }
        }

        long ans=1;
        int mod= 1000000007;
        for (Node node:set) {
            ArrayList<Edge> edges = node.edges;
            HashSet<Integer> nums = new HashSet<>();
            for (Edge e:edges) {
                if(e.data==0) {
                    Node node1 = e.node;
                    ArrayList<Edge> list = node1.edges;
                    for(Edge edge:list) {
                        nums.add(edge.data);
                    }
                    continue;
                }
                nums.add(e.data);
            }
            long temp = 5- nums.size();
            ans=((ans%mod)*(temp%mod))%mod;
        }
        System.out.println(ans);
    }
}
