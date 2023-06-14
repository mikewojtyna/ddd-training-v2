package pl.wojtyna.trainings.recipes.citybike.task.penalty.domain;

import java.util.UUID;

public interface PenaltyImposer {

    void imposePenalty(UUID bikeId);
}
