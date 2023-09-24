package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation.BikeRent;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

@DisplayName("Bike station examples")
class BikeStationTest {

    // @formatter:off
    @DisplayName(
        """
         given bike station with 1 bike,
         when George rents a bike,
         then bike is rent
        """
    )
    // @formatter:on
    @Test
    void test0() {
        // given
        var bikeStation = new BikeStation(new BikeStationId("Warsaw01"));
        var bike = new Bike(new BikeId("bike01"));
        bikeStation.placeNew(bike);
        var borrower = new Borrower(new BorrowerId("george"));

        // when
        var events = bikeStation.rent(bike).by(borrower).forDuration(new RentalDuration(Duration.ofHours(6)));

        // then
        events.hasAtLeastOneEventMatching(event -> event instanceof BikeRent);
    }

    // @formatter:off
    @DisplayName(
        """
         given bike station with 0 bikes,
         when George rents a bike,
         then bike is not rent
        """
    )
    // @formatter:on
    @Test
    void test1() {
        // given
        var bikeStation = new BikeStation(new BikeStationId("Warsaw01"));
        var bike = new Bike(new BikeId("bike01"));
        var borrower = new Borrower(new BorrowerId("george"));

        // when
        var exception = catchThrowable(() -> bikeStation.rent(bike).by(borrower)
                                                        .forDuration(new RentalDuration(Duration.ofHours(6))));

        // then
        assertThat(exception).isInstanceOf(BikeNotAvailableException.class);
    }

    // @formatter:off
    @DisplayName(
        """
         given bike station with 1 bike,
         when George rents a bike,
         then bike is rent,
         and when George rents a bike again,
         then bike is not rent
        """
    )
    // @formatter:on
    @Test
    void test2() {
        // given
        var bikeStation = new BikeStation(new BikeStationId("Warsaw01"));
        var bike = new Bike(new BikeId("bike01"));
        bikeStation.placeNew(bike);
        var borrower = new Borrower(new BorrowerId("george"));

        // when
        var events = bikeStation.rent(bike).by(borrower).forDuration(new RentalDuration(Duration.ofHours(6)));

        // then
        events.hasAtLeastOneEventMatching(event -> event instanceof BikeRent);

        // when
        var exception = catchThrowable(() -> bikeStation.rent(bike).by(borrower)
                                                        .forDuration(new RentalDuration(Duration.ofHours(6))));

        // then
        assertThat(exception).isInstanceOf(BikeNotAvailableException.class);
    }

    // @formatter:off
    @DisplayName(
        """
         given bike station with 1 bike,
         when George rents a bike for 12 hours,
         then bike is not rent
        """
    )
    // @formatter:on
    @Test
    void test3() {
        // given
        var bikeStation = new BikeStation(new BikeStationId("Warsaw01"));
        var bike = new Bike(new BikeId("bike01"));
        bikeStation.placeNew(bike);
        var borrower = new Borrower(new BorrowerId("george"));

        // when
        var exception = catchThrowable(() -> bikeStation.rent(bike).by(borrower)
                                                        .forDuration(new RentalDuration(Duration.ofHours(12))));

        // then
        assertThat(exception).isInstanceOf(MaximumRentalDurationExceededException.class);
    }
}