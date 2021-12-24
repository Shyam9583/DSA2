package online.technotap.dsa2.dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MaximalSquareTest {

    private MaximalSquare maximalSquare;

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}},
                        4
                ),
                Arguments.of(
                        new char[][]{{'0', '1'}, {'1', '0'}},
                        1
                ),
                Arguments.of(
                        new char[][]{{'0'}},
                        0
                ),
                Arguments.of(
                        new char[][]{{'1'}},
                        1
                )
        );
    }

    @BeforeEach
    void setup() {
        maximalSquare = new MaximalSquare();
    }

    @ParameterizedTest
    @MethodSource("provideArgs")
    @DisplayName("With the valid matrix, it should return valid size of the square sub matrix while using optimal space")
    void maximalSquare(char[][] matrix, int expected) {
        int actual = maximalSquare.maximalSquare(matrix);
        assertThat(actual).isEqualTo(expected);
    }
}