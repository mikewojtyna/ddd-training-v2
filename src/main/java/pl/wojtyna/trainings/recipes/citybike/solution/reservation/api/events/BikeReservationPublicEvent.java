package pl.wojtyna.trainings.recipes.citybike.solution.reservation.api.events;

import java.util.UUID;

public sealed interface BikeReservationPublicEvent {

    record BikeRented(UUID bikeId, UUID stationId) implements BikeReservationPublicEvent {
    }

    record BikeReturned(UUID bikeId, UUID stationId) implements BikeReservationPublicEvent {
    }
}
