package pl.wojtyna.trainings.ddd.citybike.rent.good.usecases;

import pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation.BikeId;
import pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation.BikeStationId;
import pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation.BorrowerId;
import pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation.RentalDuration;

public class RentBikeUseCase {

    public void rent(BikeStationId id, BikeId bike, BorrowerId borrowerId, RentalDuration duration) {
        // load aggregate
        // execute command
        // save aggregate
        // publish events
    }
}
