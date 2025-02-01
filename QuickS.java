import java.util.*;

class Solution {
    // Partition function for QuickSort
    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);  // Choosing the first element as pivot
        int i = low;
        int j = high;

        // Partitioning process
        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }

            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                // Swap arr[i] and arr[j]
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        // Swap pivot with arr[j]
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }

    // QuickSort recursive function
    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);  // Partition index
            qs(arr, low, pIndex - 1);  // Recursively sort left half
            qs(arr, pIndex + 1, high);  // Recursively sort right half
        }
    }

    // QuickSort driver function
    public static List<Integer> quickSort(List<Integer> arr) {
        qs(arr, 0, arr.size() - 1);
        return arr;
    }
}

public class QuickS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Take array size input
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        // Create an array list
        List<Integer> arr = new ArrayList<>();

        // Take array elements input
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // Printing the original array
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        // Sorting the array using QuickSort
        arr = Solution.quickSort(arr);

        // Printing the sorted array
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        sc.close();
    }
}
