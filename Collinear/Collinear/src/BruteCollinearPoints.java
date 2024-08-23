import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private List<LineSegment> lineSegments;
    private int numOfLineSegments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        lineSegments = new ArrayList<>();
        this.numOfLineSegments = 0;

        for (int m = 0; m < points.length; m++) {
            if (points[m] == null) throw new IllegalArgumentException();
            for (int y = m + 1; y < points.length; y++) {
                // Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal
                if (points[m].slopeTo(points[y]) == Double.NEGATIVE_INFINITY) throw new IllegalArgumentException();
            }
        }
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int p = k + 1; p < points.length; p++) {
                        double ij = points[i].slopeTo(points[j]);
                        if (ij == points[i].slopeTo(points[k]) && ij == points[i].slopeTo(points[p])) {
                            if (points[i].compareTo(points[j]) < 1 && points[j].compareTo(points[k]) < 1 && points[k].compareTo(points[p]) < 1) {
                                lineSegments.add(new LineSegment(points[i], points[p]));
                                numOfLineSegments++;
                            }
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return this.numOfLineSegments;
    }

    public LineSegment[] segments() {
        // lineSegments.toArray(new LineSegment[lineSegments.size()]);
        return lineSegments.toArray(new LineSegment[0]);
    }
}
