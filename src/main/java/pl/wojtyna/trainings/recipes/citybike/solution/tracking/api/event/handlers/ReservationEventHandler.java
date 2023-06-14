package pl.wojtyna.trainings.recipes.citybike.solution.tracking.api.event.handlers;

import pl.wojtyna.trainings.recipes.citybike.solution.reservation.api.events.BikeReservationPublicEvent;
import pl.wojtyna.trainings.recipes.citybike.solution.tracking.domain.BikeLocationTrackingService;

public class ReservationEventHandler {

    private final BikeLocationTrackingService trackingService;

    public ReservationEventHandler(BikeLocationTrackingService trackingDomainService) {this.trackingService = trackingDomainService;}

    public void handle(BikeReservationPublicEvent event) {
        switch (event) {
            case BikeReservationPublicEvent.BikeRented bikeRented -> startTrackingTime(bikeRented);
            case BikeReservationPublicEvent.BikeReturned bikeReturned -> stopTrackingTime(bikeReturned);
        }
    }

    private void stopTrackingTime(BikeReservationPublicEvent.BikeReturned bikeReturned) {
        trackingService.stopTrackingBike(bikeReturned.bikeId());
    }

    private void startTrackingTime(BikeReservationPublicEvent.BikeRented bikeRented) {
        trackingService.startTrackingBike(bikeRented.bikeId());
    }
}
