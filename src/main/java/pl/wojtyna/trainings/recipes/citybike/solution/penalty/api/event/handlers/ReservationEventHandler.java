package pl.wojtyna.trainings.recipes.citybike.solution.penalty.api.event.handlers;

import pl.wojtyna.trainings.recipes.citybike.solution.penalty.domain.PenaltyDomainService;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.api.events.BikeReservationPublicEvent;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        Executors.newSingleThreadScheduledExecutor()
                 .scheduleAtFixedRate(() -> penaltyDomainService.imposePenalty(bikeRented.bikeId()),
                                      0,
                                      1,
                                      TimeUnit.HOURS);
    }
}
