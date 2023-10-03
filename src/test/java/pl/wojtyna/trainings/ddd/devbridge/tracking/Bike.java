package pl.wojtyna.trainings.ddd.devbridge.tracking;

import pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation.BikeId;

public record Bike(BikeId bikeId, Location location) {
}
