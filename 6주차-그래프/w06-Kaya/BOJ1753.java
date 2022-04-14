import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, weight;

    Node(int idx, int weight) {
        this.vertex = idx;
        this.weight = weight;
    }

    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
public class Main {
    static ArrayList<Node>[] list;
    static int v, e, start;
    static int[] distance;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();   // 정점
        e = sc.nextInt();   // 간선
        start = sc.nextInt();

        list = new ArrayList[v+1]; // 정점 인접리스트
        distance = new int[v+1];

        for(int i=1; i<=v; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INF);
        distance[start] = 0;

        for(int i=0; i<e; i++) {
            int s = sc.nextInt();   // 출발
            int f = sc.nextInt();   // 도착
            int d = sc.nextInt();   // 가중치

            list[s].add(new Node(f, d));
        }
        dijkstra();
        for(int i=1; i<=v; i++) {
            if(distance[i] == INF) {
                System.out.println("INF");
            } else System.out.println(distance[i]);
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        while(!q.isEmpty()) {
            Node node = q.poll();
            int vertex = node.vertex;
            int weight = node.weight;

            if(distance[vertex] < weight) continue;

            for(int i=0; i<list[vertex].size(); i++) {
                int connectedVertex = list[vertex].get(i).vertex;
                int newWeight = list[vertex].get(i).weight + weight;

                if(distance[connectedVertex] > newWeight) {
                    distance[connectedVertex] = newWeight;
                    q.add(new Node(connectedVertex, newWeight));
                }
            }
        }
    }
}

