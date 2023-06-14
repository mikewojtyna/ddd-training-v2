package pl.wojtyna.trainings.recipes.citybike.solution.tracking.api.usecases;

import pl.wojtyna.trainings.recipes.citybike.solution.tracking.domain.BikeLocationTrackingService;
import pl.wojtyna.trainings.recipes.citybike.solution.tracking.domain.Location;

import java.util.UUID;

public class CurrentBikeLocationUseCase {

    private final BikeLocationTrackingService trackingService;

    public CurrentBikeLocationUseCase(BikeLocationTrackingService penaltyTrackingDomainService) {
        this.trackingService = penaltyTrackingDomainService;
    }

    Location locationOf(UUID bikeId) {
        return trackingService.currentLocationOf(bikeId);
    }
}
