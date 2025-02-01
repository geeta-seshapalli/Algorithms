import java.util.*;
public class convexHull {

    // To find the orientation of ordered triplet
    // 0 --> p, q, and r are collinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - 
                  (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0; // collinear
        return (val > 0) ? 1 : 2; // clock or counterclockwise
    }

    // Prints convex hull of a set of n points
    static void convexHull(Point points[], int n) {
        // There must be at least 3 points
        if (n < 3) {
            System.out.println("Convex hull is not possible with less than 3 points.");
            return;
        }

        // Initialize Result
        Vector<Point> hull = new Vector<Point>();

        // Find the leftmost point
        int l = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].x < points[l].x) {
                l = i;
            }
        }

        // Start from the leftmost point, keep moving counterclockwise
        int p = l, q;
        do {
            hull.add(points[p]);

            q = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                if (orientation(points[p], points[i], points[q]) == 2) {
                    q = i;
                }
            }
            p = q;

        } while (p != l); // While we don't come back to the first point

        // Print the result
        System.out.println("The points in the convex hull are:");
        for (Point point : hull) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }

    // Driver program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();

        // Create an array to store the points
        Point[] points = new Point[n];

        // Read the points from the user
        System.out.println("Enter the points (x y):");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }

        // Compute and print the convex hull
        convexHull(points, n);

        scanner.close();
    }
}

// Point class to store points
class Point {
    int x, y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
