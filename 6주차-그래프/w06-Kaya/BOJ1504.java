import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int vertex, weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o){
        return weight - o.weight;
    }
}
public class Main {
    static int v, e, v1, v2;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] check;
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v+1];
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[v+1];
        check = new boolean[v+1];

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[s].add(new Node(f, d));
            list[f].add(new Node(s, d));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, v);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, v);

        int ans = 0;
        if(result1 >= INF && result2 >= INF) {
            ans = -1;
        } else {
            ans = Math.min(result1, result2);
        }

        System.out.println(ans);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node curr = q.poll();
            int currNode = curr.vertex;
            int currWeight = curr.weight;

            if(check[currNode]) continue;
            check[currNode] = true;

            for(int i=0; i<list[currNode].size(); i++) {
                int nextNode = list[currNode].get(i).vertex;
                int nextWeight = list[currNode].get(i).weight;

                if(!check[nextNode] && dist[nextNode] > currWeight + nextWeight) {
                    dist[nextNode] = currWeight + nextWeight;
                    q.add(new Node(nextNode, dist[nextNode]));
                }
            }
        }
        return dist[end];
    }
}
