import java.util.Scanner;

public class LineSegmentIntersection {

    // Class to represent a point
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Function to find the orientation of three points (p, q, r)
    // 0 -> collinear, 1 -> clockwise, 2 -> counterclockwise
    static int orientation(Point p, Point q, Point r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (Math.abs(val) < 1e-9) return 0; // collinear
        return (val > 0) ? 1 : 2; // clockwise or counterclockwise
    }

    // Check if a point q lies on the line segment 'pr'
    static boolean onSegment(Point p, Point q, Point r) {
        return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
               q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
    }

    // Function to check if two line segments intersect
    static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4) return true;

        // Special cases
        // p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;
        // q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;
        // p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;
        // q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false; // No intersection
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first line segment
        System.out.println("Enter coordinates of the first line segment:");
        System.out.print("p1 (x1 y1): ");
        Point p1 = new Point(scanner.nextDouble(), scanner.nextDouble());
        System.out.print("q1 (x2 y2): ");
        Point q1 = new Point(scanner.nextDouble(), scanner.nextDouble());

        // Input for the second line segment
        System.out.println("Enter coordinates of the second line segment:");
        System.out.print("p2 (x3 y3): ");
        Point p2 = new Point(scanner.nextDouble(), scanner.nextDouble());
        System.out.print("q2 (x4 y4): ");
        Point q2 = new Point(scanner.nextDouble(), scanner.nextDouble());

        // Check intersection
        if (doIntersect(p1, q1, p2, q2)) {
            System.out.println("The line segments intersect.");
        } else {
            System.out.println("The line segments do not intersect.");
        }

        scanner.close();
    }
}
