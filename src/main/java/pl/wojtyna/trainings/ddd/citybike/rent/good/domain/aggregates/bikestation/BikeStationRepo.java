package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import java.util.Optional;

@SecondaryPort
public interface BikeStationRepo {

    Optional<BikeStation> load(BikeStationId id);

    void save(BikeStation bikeStation);
}
