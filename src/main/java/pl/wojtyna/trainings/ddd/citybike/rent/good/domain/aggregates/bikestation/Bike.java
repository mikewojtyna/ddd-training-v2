package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Bike(BikeId id) {
}
