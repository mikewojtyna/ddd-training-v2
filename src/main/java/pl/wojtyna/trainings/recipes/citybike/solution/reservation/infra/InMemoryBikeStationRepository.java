package pl.wojtyna.trainings.recipes.citybike.solution.reservation.infra;

import pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.station.BikeStation;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.station.BikeStationRepository;

import java.util.Optional;
import java.util.UUID;

public class InMemoryBikeStationRepository implements BikeStationRepository {

    @Override
    public Optional<BikeStation> findById(UUID bikeStationId) {
        return Optional.empty();
    }

    @Override
    public void save(BikeStation bikeStation) {

    }
}
