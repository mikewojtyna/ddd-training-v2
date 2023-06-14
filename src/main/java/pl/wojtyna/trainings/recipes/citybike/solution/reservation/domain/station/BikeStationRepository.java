package pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.station;

import java.util.Optional;
import java.util.UUID;

public interface BikeStationRepository {

    Optional<BikeStation> findById(UUID bikeStationId);

    void save(BikeStation bikeStation);
}
