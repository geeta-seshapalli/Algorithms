import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TSP {

    static int tsp(int[][] cost) {
        // Number of nodes
        int numNodes = cost.length;
        List<Integer> nodes = new ArrayList<>();

      
        for (int i = 1; i < numNodes; i++) {
            nodes.add(i);
        }

        int minCost = Integer.MAX_VALUE;

        // Generate all permutations of the remaining nodes
        do {
            int currCost = 0;

            // Start from node 0
            int currNode = 0;

            // Calculate the cost of the current permutation
            for (int i = 0; i < nodes.size(); i++) {
                currCost += cost[currNode][nodes.get(i)];
                currNode = nodes.get(i);
            }

            // Add the cost to return to the starting node
            currCost += cost[currNode][0];

            // Update the minimum cost if the current cost is lower
            minCost = Math.min(minCost, currCost);

        } while (nextPermutation(nodes));

        return minCost;
    }

    static boolean nextPermutation(List<Integer> nodes) {
        int i = nodes.size() - 2;

        
        while (i >= 0 && nodes.get(i) >= nodes.get(i + 1)) {
            i--;
        }

       
        if (i < 0) {
            return false;
        }

      
        int j = nodes.size() - 1;
        while (nodes.get(j) <= nodes.get(i)) {
            j--;
        }

      
        Collections.swap(nodes, i, j);

     
        Collections.reverse(nodes.subList(i + 1, nodes.size()));

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the number of cities
        System.out.print("Enter the number of cities: ");
        int n = sc.nextInt();

        // Initialize the cost matrix
        int[][] cost = new int[n][n];
        System.out.println("Enter the cost matrix (row by row):");

        // Take input for the cost matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // Calculate and print the result
        int res = tsp(cost);
        System.out.println("The minimum cost of the tour is: " + res);
        sc.close();
    }
}
