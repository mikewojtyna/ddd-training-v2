package pl.wojtyna.trainings.ddd.claudehello;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class ClaudeTest {

    // @formatter:off
    @DisplayName(
        """
         given 2 and 3,
         when add using calculator,
         then result is 5
        """
    )
    // @formatter:on
    @Test
    void test() {
        // given
        var firstNumber = 2;
        var secondNumber = 3;

        // when
        var result = Calculator.add(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(5);
    }

    // @formatter:off
    @DisplayName(
        """
         given 2 and 3,
         when multiply using calculator,
         then result is 6
        """
    )
    // @formatter:on
    @Test
    void test2() {
        // given

        // when
        var result = Calculator.multiply(2, 3);

        // then
        assertThat(result).isEqualTo(6);
    }

    // @formatter:off
    @DisplayName(
        """
         given 6 and 3,
         when divide 6 and 3,
         then result is 2
        """
    )
    // @formatter:on
    @Test
    void test3() {
        // given
        var firstNumber = 6;
        var secondNumber = 3;

        // when
        var result = Calculator.divide(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(2);
    }
}
