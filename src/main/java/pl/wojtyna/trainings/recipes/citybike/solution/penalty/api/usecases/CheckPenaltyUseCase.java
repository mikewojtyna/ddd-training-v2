package pl.wojtyna.trainings.recipes.citybike.solution.penalty.api.usecases;

import pl.wojtyna.trainings.recipes.citybike.solution.penalty.domain.Penalty;
import pl.wojtyna.trainings.recipes.citybike.solution.penalty.domain.PenaltyDomainService;

import java.util.UUID;

public class CheckPenaltyUseCase {

    private final PenaltyDomainService penaltyTrackingDomainService;

    public CheckPenaltyUseCase(PenaltyDomainService penaltyTrackingDomainService) {
        this.penaltyTrackingDomainService = penaltyTrackingDomainService;
    }

    Penalty penaltyOf(UUID bikeId) {
        return penaltyTrackingDomainService.penaltyOf(bikeId);
    }
}
