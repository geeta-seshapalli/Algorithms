import java.util.*;

// User function Template for Java
class Pair {
    int node;
    int distance;

    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    // Function to find the sum of weights of the edges of the Minimum Spanning Tree.
    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V]; // Visited array
        pq.add(new Pair(0, 0)); // {weight, node}
        int sum = 0;

        while (!pq.isEmpty()) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1) continue; // Skip if node is already visited
            vis[node] = 1; // Mark the node as visited
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }
        return sum;
    }
}

public class Prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        // Input number of edges
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        // Initialize adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Input edges
        System.out.println("Enter the edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            ArrayList<Integer> tmp1 = new ArrayList<>();
            ArrayList<Integer> tmp2 = new ArrayList<>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        int sum = Solution.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);

        sc.close();
    }
}
