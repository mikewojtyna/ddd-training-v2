package pl.wojtyna.trainings.recipes.citybike.solution.penalty.domain;

import java.util.UUID;

public class PenaltyDomainService {

    private final PenaltyImposer penaltyImposer;

    public PenaltyDomainService(PenaltyImposer penaltyImposer) {this.penaltyImposer = penaltyImposer;}

    public void stopTrackingBike(UUID bikeId) {
        // noop
    }

    public void startTrackingBike(UUID bikeId) {
        // noop
    }

    public Penalty penaltyOf(UUID bikeId) {
        // noop
        return new Penalty();
    }

    public void imposePenalty(UUID bikeId) {
        penaltyImposer.imposePenalty(bikeId);
    }
}
