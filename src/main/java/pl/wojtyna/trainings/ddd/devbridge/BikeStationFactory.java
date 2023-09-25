package pl.wojtyna.trainings.ddd.devbridge;

import pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation.BikeStation;

public interface BikeStationFactory {

    DomainResult<BikeStation> create();
}
