package pl.wojtyna.trainings.recipes.citybike.solution.reservation.infra;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.api.usecases.RentBikeUseCase;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.EventPublisher;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.station.BikeStationRepository;

@Configuration
public class ReservationContextSpringConfig {

    @Bean
    public EventPublisher springEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return new SpringEventPublisher(applicationEventPublisher);
    }

    @Bean
    public BikeStationRepository bikeStationRepository() {
        return new InMemoryBikeStationRepository();
    }

    @Bean
    public RentBikeUseCase rentBikeUseCase(BikeStationRepository bikeStationRepo) {
        return new RentBikeUseCase(bikeStationRepo);
    }
}
