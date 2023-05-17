package pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation;

public record NotEnoughFunds(BorrowerId id, RentalDuration forDuration) implements BikeRentalEvent {
}
