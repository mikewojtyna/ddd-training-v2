package pl.wojtyna.trainings.ddd.devbridge.examplemapping;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.ddd.devbridge.Bike;
import pl.wojtyna.trainings.ddd.devbridge.BikeRentalRejected;
import pl.wojtyna.trainings.ddd.devbridge.DomainEvents;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Booking a bike examples according to https://miro.com/app/board/uXjVMjjdRY8=/?share_link_id=827040499274")
@Disabled
class BookingABikeTest {

    // @formatter:off
    @DisplayName(
        """
         bike is rented successfully
        """
    )
    // @formatter:on
    @Test
    void test() {
        // given
        BookingSystem bookingSystem = new BookingSystem(1);
        Renter renter = new Renter(Money.of(CurrencyUnit.EUR, 50));

        // when
        DomainEvents events = bookingSystem.book(renter);

        // then
        var bikeWasBooked = events.hasOccurredEventOfType(BikeBooked.class);
        assertThat(bikeWasBooked).isTrue();
    }

    // @formatter:off
    @DisplayName(
        """
         given renter has 50 euro,
         then bike is rented successfully
        """
    )
    // @formatter:on
    @Test
    void test2() {
        // given
        BookingSystem bookingSystem = new BookingSystem(1);
        Renter renter = new Renter(Money.of(CurrencyUnit.EUR, 50));

        // when
        DomainEvents events = bookingSystem.book(renter);

        // then
        var bikeWasBooked = events.hasOccurredEventOfType(BikeBooked.class);
        assertThat(bikeWasBooked).isTrue();
    }

    // @formatter:off
    @DisplayName(
        """
         given renter has zero euro,
         then bike is rented successfully
        """
    )
    // @formatter:on
    @Test
    void test3() {
        // given
        BookingSystem bookingSystem = new BookingSystem(1);
        Renter renter = new Renter(Money.of(CurrencyUnit.EUR, 0));

        // when
        DomainEvents events = bookingSystem.book(renter);

        // then
        var bikeWasBooked = events.hasOccurredEventOfType(BikeRentalRejected.class);
        assertThat(bikeWasBooked).isTrue();
    }

    // @formatter:off
    @DisplayName(
        """
         given booking system has no bikes avaialble,
         then bike is rented successfully
        """
    )
    // @formatter:on
    @Test
    void test4() {
        // given
        Renter renter = new Renter(Money.of(CurrencyUnit.EUR, 0));
        BookingSystem bookingSystem = new BookingSystem(0);
        Bike bike = new Bike();
        bookingSystem.placeNew(bike);
        bookingSystem.book(renter);

        // when
        DomainEvents eventsAfterBookingAgain = bookingSystem.book(renter);

        // then
        var bikeWasBooked = eventsAfterBookingAgain.hasOccurredEventOfType(BikeRentalRejected.class);
        assertThat(bikeWasBooked).isTrue();
    }

    // @formatter:off
    @DisplayName(
        """
         given bike station
         and maintenance places a new bike in station,
         when renter wants to book a bike,
         then bike is rented successfully
        """
    )
    // @formatter:on
    @Test
    void test5() {
        // given
        Renter renter = new Renter(Money.of(CurrencyUnit.EUR, 100));
        BookingSystem bookingSystem = new BookingSystem(0);
        Bike bike = new Bike();
        bookingSystem.placeNew(bike);
        bookingSystem.book(renter);

        // when
        DomainEvents eventsAfterBookingAgain = bookingSystem.book(renter);

        // then
        var bikeWasBooked = eventsAfterBookingAgain.hasOccurredEventOfType(BikeBooked.class);
        assertThat(bikeWasBooked).isTrue();
    }
}
