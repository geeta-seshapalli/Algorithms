// Java implementation for subset sum
// problem using recursion
import java.util.*;

class Sum {

    // Function to check if there is a subset
    // with the given sum using recursion
    static boolean isSubsetSumRec(int[] arr, int n, int sum, List<Integer> subset) {

        // Base Cases
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        // If last element is greater than 
        // sum, ignore it
        if (arr[n - 1] > sum) {
            return isSubsetSumRec(arr, n - 1, sum, subset);
        }

        // Check if sum can be obtained by including 
        // or excluding the last element
        if (isSubsetSumRec(arr, n - 1, sum, subset)) {
            return true;
        }

        // Include the current element and recurse
        subset.add(arr[n - 1]);
        if (isSubsetSumRec(arr, n - 1, sum - arr[n - 1], subset)) {
            return true;
        }
        
        // Backtrack if including arr[n-1] doesn't lead to a solution
        subset.remove(subset.size() - 1);
        return false;
    }

    static boolean isSubsetSum(int[] arr, int sum, List<Integer> subset) {
        return isSubsetSumRec(arr, arr.length, sum, subset);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target sum
        System.out.print("Enter the target sum: ");
        int sum = sc.nextInt();

        // List to store the subset elements
        List<Integer> subset = new ArrayList<>();

        // Check if a subset with the given sum exists
        if (isSubsetSum(arr, sum, subset)) {
            System.out.println("True");
            System.out.println("Subset with the given sum: " + subset);
        } else {
            System.out.println("False");
        }

        sc.close();
    }
}
