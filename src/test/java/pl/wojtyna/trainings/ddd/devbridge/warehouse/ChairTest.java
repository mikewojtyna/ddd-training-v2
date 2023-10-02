package pl.wojtyna.trainings.ddd.devbridge.warehouse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.ddd.devbridge.chair.warehouse.Chair;
import pl.wojtyna.trainings.ddd.devbridge.chair.warehouse.Dimensions;
import pl.wojtyna.trainings.ddd.devbridge.chair.warehouse.Warehouse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("How we can use a chair in the warehouse context")
class ChairTest {

    // @formatter:off
    @DisplayName(
        """
         given chair with dimensions 10x10x10
         and warehouse with dimensions 100x100x100,
         when we store it in the warehouse,
         then we can have at most 1000 chairs in the warehouse
        """
    )
    // @formatter:on
    @Test
    void test() {
        // given
        Warehouse warehouse = Warehouse.of(new Dimensions(100, 100, 100));
        Chair chair = new Chair(new Dimensions(10, 10, 10));

        // when
        int howManyChairs = warehouse.howManyChairCanFit(chair);

        // then
        assertThat(howManyChairs).isEqualTo(1000);
    }
}
