package pl.wojtyna.trainings.ddd.bikerental;

import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowableOfType;

@DisplayName("Renting a bike")
class RentingABikeTest {

    // @formatter:off
    @DisplayName(
        """
         given bike is available and user is registered with 100 pln balance,
         when user rents a bike,
         then bike is rent without a time limit
        """
    )
    // @formatter:on
    @Test
    void test() {
        // given
        var system = BikeSystem.having(new Bike());
        var borrower = new Borrower(Money.parse("PLN 100"));
        SomeDomainRule rule = null;

        // when
        var events = system.rentBikeBy(borrower, rule);

        // then
        assertThat(events.hasOccurredEventOfType(BikeIsRent.class)).isTrue();
        boolean atLeastOneEventsMatches = events.hasAtLeastOneEventMatching(event -> {
            if (event instanceof BikeIsRent bikeIsRent) {
                return bikeIsRent.isUnlimited();
            }
            return false;
        });
        assertThat(atLeastOneEventsMatches).isTrue();
    }


    // @formatter:off
    @DisplayName(
        """
         given bike is available and user is registered with 0 pln balance,
         when user rents a bike,
         then ERROR: user has no money
        """
    )
    // @formatter:on
    @Test
    void test2() {
        // given
        var system = new BikeSystem();
        var bike = new Bike();
        system.addAvailable(bike);
        var borrower = new Borrower(Money.parse("PLN 0"));
        SomeDomainRule rule = null;

        // when
        var exception = catchThrowableOfType(() -> system.rentBikeBy(borrower, rule),
                                             InsufficientFundsException.class);

        // then
        assertThat(exception).isNotNull();
    }

}
