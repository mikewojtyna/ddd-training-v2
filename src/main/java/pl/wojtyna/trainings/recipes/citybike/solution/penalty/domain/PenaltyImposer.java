package pl.wojtyna.trainings.recipes.citybike.solution.penalty.domain;

import java.util.UUID;

public interface PenaltyImposer {

    void imposePenalty(UUID bikeId);
}
