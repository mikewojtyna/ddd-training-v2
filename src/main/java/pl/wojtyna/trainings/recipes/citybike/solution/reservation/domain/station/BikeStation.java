package pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.station;

import pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.BikeReservationLocalEvent;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.EventPublisher;

import java.util.UUID;

public class BikeStation {

    private final EventPublisher eventPublisher;

    public BikeStation(EventPublisher localEvents) {
        this.eventPublisher = localEvents;
    }

    public void rentBike(UUID bikeId) {
        // some domain logic
        eventPublisher.publish(new BikeReservationLocalEvent.BikeRented(bikeId, UUID.randomUUID()));
    }

    public void returnBike(UUID bikeId) {
        // some domain logic
        eventPublisher.publish(new BikeReservationLocalEvent.BikeReturned(bikeId, UUID.randomUUID()));
    }
}
