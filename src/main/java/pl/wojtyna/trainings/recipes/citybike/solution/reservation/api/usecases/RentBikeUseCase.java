package pl.wojtyna.trainings.recipes.citybike.solution.reservation.api.usecases;

import pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.station.BikeStationRepository;

import java.util.UUID;

public class RentBikeUseCase {

    private final BikeStationRepository bikeStationRepository;

    public RentBikeUseCase(BikeStationRepository bikeStationRepository) {this.bikeStationRepository = bikeStationRepository;}

    public void rent(UUID bikeId) {
        bikeStationRepository.findById(bikeId).ifPresent(bikeStation -> {
            DomainEvents events = bikeStation.rentBike(bikeId);
            bikeStationRepository.save(bikeStation);
            publishEvents();
        });
    }
}
