package pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation;

public record BikeRent(BorrowerId by, RentalDuration forDuration) implements BikeRentalEvent {
}
