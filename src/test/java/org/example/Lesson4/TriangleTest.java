package org.example.Lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {
    @ParameterizedTest
    @CsvSource({"6, 3, 5", "8, 9, 4", "25, 50, 48"})
    void positiveAreaCountTest(int num, int num2, int num3) throws Exception {
        double area = TriangleArea.areaCount(num, num2, num3);
        System.out.println(area);
        assertThat(area).isNotNull();
        assertThat(area).isNotEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"6, 3, 3", "96, 9, 4", "0, 1, 3"})
    void impossibleTriangleAreaCountTest(int num, int num2, int num3) {
        Assertions.assertThrows(Exception.class, () -> TriangleArea.areaCount(num, num2, num3));
    }
}
