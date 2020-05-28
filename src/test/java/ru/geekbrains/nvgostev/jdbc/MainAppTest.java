package ru.geekbrains.nvgostev.jdbc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MainAppTest {

    @ParameterizedTest
    @MethodSource("firstTestData")
    public void afterLastFourOkTest(int[] in, int[] result) {
        assertArrayEquals(result, MainApp.afterFour(in));
    }

    public static Stream<Arguments> firstTestData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 2, 5, 6}, new int[]{2, 5, 6}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 1, 2, 4, 5}, new int[]{5}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 3, 4, 1, 2}, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("secondTestData")
    public void afterLastFourCrushTest(int[] in) {
        assertThrows(RuntimeException.class, () -> MainApp.afterFour(in));
    }

    public static Stream<Arguments> secondTestData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 1, 2}),
                Arguments.arguments(new int[]{1, 2, 3, 2, 1}),
                Arguments.arguments(new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("thirdTestData")
    public void oneAndFoursCheckTest(int[] in, boolean result) {
        assertEquals(result, MainApp.oneAndFourCheck(in));
    }

    public static Stream<Arguments> thirdTestData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 1, 4}, false),
                Arguments.arguments(new int[]{1, 4, 1, 4}, true)
        );
    }
}

