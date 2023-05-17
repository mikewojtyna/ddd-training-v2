package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;

public sealed interface BikeRentalEvent extends DomainEvent permits BikeRent, BikeReturned {
}
