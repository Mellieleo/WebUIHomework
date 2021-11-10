package org.example.Lesson4;

public class TriangleArea {

    static double areaCount (int a, int b, int c) throws Exception {
        if (checkIfPossible(a, b, c)) {
            double halfPerimeter = 0.5 * (a+b+c);
            return Math.round((Math.sqrt(halfPerimeter*(halfPerimeter-a)*(halfPerimeter-b)*(halfPerimeter-c))) * 100.0)/100.0;
        } else {
            throw new Exception("This triangle is impossible!");
        }
    }

    static boolean checkIfPossible (int a, int b, int c) {
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }
}
