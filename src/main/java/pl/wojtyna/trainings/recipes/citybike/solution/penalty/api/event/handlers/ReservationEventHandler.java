package pl.wojtyna.trainings.recipes.citybike.solution.penalty.api.event.handlers;

import pl.wojtyna.trainings.recipes.citybike.solution.penalty.domain.PenaltyDomainService;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.api.events.BikeReservationPublicEvent;

public class ReservationEventHandler {

    private final PenaltyDomainService penaltyDomainService;

    public ReservationEventHandler(PenaltyDomainService penaltyTrackingDomainService) {this.penaltyDomainService = penaltyTrackingDomainService;}

    public void handle(BikeReservationPublicEvent event) {
        switch (event) {
            case BikeReservationPublicEvent.BikeRented bikeRented -> startTrackingTime(bikeRented);
            case BikeReservationPublicEvent.BikeReturned bikeReturned -> stopTrackingTime(bikeReturned);
        }
    }

    private void stopTrackingTime(BikeReservationPublicEvent.BikeReturned bikeReturned) {
        penaltyDomainService.stopTrackingBike(bikeReturned.bikeId());
    }

    private void startTrackingTime(BikeReservationPublicEvent.BikeRented bikeRented) {
        penaltyDomainService.startTrackingBike(bikeRented.bikeId());
    }
}
