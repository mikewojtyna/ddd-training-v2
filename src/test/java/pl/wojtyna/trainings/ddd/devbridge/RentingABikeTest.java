package pl.wojtyna.trainings.ddd.devbridge;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Disabled("acts as a template, not implemented yet")
@DisplayName("Renting a bike examples")
class RentingABikeTest {

    // @formatter:off
    @DisplayName(
        """
         given a rental policy that always accepts the rental,
         when any user rents a bike,
         then bike is rented
        """
    )
    // @formatter:on
    @Test
    void test0() {
        // given
        User user = User.withBalance(Money.of(CurrencyUnit.EUR, 0));
        var system = new RentalSystem(1);

        // when
        // TODO: clarify do we want to rent only specific bikes, or maybe any bikes? For now, lest's assume the latter.
        DomainEvents events = system.rentAnyBikeBy(user, new AlwaysAllowPolicy());

        // then
        boolean bikeWasRented = events.hasOccurredEventOfType(BikeRented.class);
        assertThat(bikeWasRented).isTrue();
    }

    // @formatter:off
    @DisplayName(
        """
         given user and bike system,
         when rent a bike for 6 hours,
         and bike is returned after 7 hours,
         then financial penalty is issued
        """
    )
    // @formatter:on
    @Test
    void test2() {
        // given
        var system = new RentalSystem(1);
        var user = anyUser();

        // when
        DomainEvents rentalEvents = system.rentAnyBikeBy(user, new AlwaysAllowPolicy());
        Bike rentedBike = extractBikeFrom(rentalEvents);
        LocalDateTime now = LocalDateTime.of(2023, 11, 10, 10, 10);
        DomainEvents returnEvents = system.returnBike(rentedBike, now);

        // then
        var penaltyWasIssued = returnEvents.hasOccurredEventOfType(FinancialPenaltyIssued.class);
        assertThat(penaltyWasIssued).isTrue();
    }

    // @formatter:off
    @DisplayName(
        """
         given system with 1 bike,
         and bike was rent for the first time,
         when rent a bike for a second time,
         then bike rental is rejected
        """
    )
    // @formatter:on
    @Test
    void test3() {
        // given
        var system = new RentalSystem(1);
        var user = anyUser();
        system.rentAnyBikeBy(user, somePolicy());

        // when
        var domainEvents = system.rentAnyBikeBy(user, somePolicy());

        // then
        var rentalWasRejected = domainEvents.hasOccurredEventOfType(BikeRentalRejected.class);
        assertThat(rentalWasRejected).isTrue();
    }

    private RentalAllowancePolicy somePolicy() {
        return null;
    }

    private Bike extractBikeFrom(DomainEvents rentalEvents) {
        return null;
    }

    private User anyUser() {
        return null;
    }
}
