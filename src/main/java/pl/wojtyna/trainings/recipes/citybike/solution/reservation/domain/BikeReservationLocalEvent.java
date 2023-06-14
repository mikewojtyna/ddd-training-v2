package pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain;

import java.util.UUID;

public sealed interface BikeReservationLocalEvent {

    record BikeRented(UUID bikeId, UUID stationId) implements BikeReservationLocalEvent {
    }

    record BikeReturned(UUID bikeId, UUID stationId) implements BikeReservationLocalEvent {
    }
}
