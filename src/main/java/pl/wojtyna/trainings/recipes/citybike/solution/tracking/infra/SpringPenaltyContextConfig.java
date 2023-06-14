package pl.wojtyna.trainings.recipes.citybike.solution.tracking.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.recipes.citybike.solution.tracking.api.event.handlers.ReservationEventHandler;
import pl.wojtyna.trainings.recipes.citybike.solution.tracking.domain.BikeLocationTrackingService;

@Configuration
public class SpringPenaltyContextConfig {

    @Bean
    public BikeLocationTrackingService penaltyDomainService() {
        return new BikeLocationTrackingService();
    }

    @Bean
    public ReservationEventHandler penaltyReservationEventHandler(BikeLocationTrackingService penaltyTrackingDomainService) {
        return new ReservationEventHandler(penaltyTrackingDomainService);
    }
}
