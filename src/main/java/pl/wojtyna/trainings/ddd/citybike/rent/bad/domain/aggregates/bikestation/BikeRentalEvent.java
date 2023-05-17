package pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;

public sealed interface BikeRentalEvent extends DomainEvent permits BikeRent, NotEnoughFunds, BikeReturned {
}
