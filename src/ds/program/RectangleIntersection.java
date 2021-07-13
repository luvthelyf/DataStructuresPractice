package ds.program;

import java.util.ArrayList;
import java.util.List;

public class RectangleIntersection {

    private static class Rectangle {
        List<Coordinate> coordinateList;

        public Rectangle(Coordinate leftTop, Coordinate rightBottom) {
            this.coordinateList = new ArrayList<>();
            this.coordinateList.add(leftTop);
            this.coordinateList.add(rightBottom);
        }
    }

    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        Rectangle[] rectangleArr = new Rectangle[3];

        rectangleArr[0] = new Rectangle(
                new Coordinate(1, 2),
                new Coordinate(5, 1)
        );
        rectangleArr[1] = new Rectangle(
                new Coordinate(2, 4),
                new Coordinate(4, 1)
        );
        rectangleArr[2] = new Rectangle(
                new Coordinate(3, 3),
                new Coordinate(6, 0)
        );
        System.out.println(new RectangleIntersection().intersectionRect(rectangleArr));
    }

    private List<Coordinate> intersectionRect(Rectangle[] rectangleArr) {
        if (rectangleArr.length == 1) return rectangleArr[0].coordinateList;
        Rectangle firstRect = rectangleArr[0];
        for (int i = 1; i < rectangleArr.length; i++) {
            List<Coordinate> newRectCoordinates = findIntersectionOfRect(firstRect, rectangleArr[i]);
            if (newRectCoordinates != null)
                firstRect = new Rectangle(newRectCoordinates.get(0), newRectCoordinates.get(1));
        }

        return firstRect.coordinateList;
    }

    private List<Coordinate> findIntersectionOfRect(Rectangle r1, Rectangle r2) {
        List<Coordinate> r1List = r1.coordinateList;
        List<Coordinate> r2List = r2.coordinateList;
        int left1 = r1List.get(0).x;
        int top1 = r1List.get(0).y;
        int right1 = r1List.get(1).x;
        int bottom1 = r1List.get(1).y;
        int left2 = r2List.get(0).x;
        int top2 = r2List.get(0).y;
        int right2 = r2List.get(1).x;
        int bottom2 = r2List.get(1).y;

        int x1 = Math.max(left1, left2);
        int y1 = Math.min(top1, top2);
        int x2 = Math.min(right1, right2);
        int y2 = Math.max(bottom1, bottom2);
        if (x1 > x2 || y2 > y1) {
            return null;
        }
        Coordinate topLeft = new Coordinate(x1, y1);
        Coordinate bottomRight = new Coordinate(x2, y2);
        List<Coordinate> finalList = new ArrayList<>();
        finalList.add(topLeft);
        finalList.add(bottomRight);
        return finalList;
    }
}
