package pl.wojtyna.trainings.recipes.citybike.solution.penalty.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.recipes.citybike.solution.penalty.api.event.handlers.ReservationEventHandler;
import pl.wojtyna.trainings.recipes.citybike.solution.penalty.domain.PenaltyDomainService;
import pl.wojtyna.trainings.recipes.citybike.solution.penalty.domain.PenaltyImposer;

@Configuration
public class SpringPenaltyContextConfig {

    @Bean
    public PenaltyImposer penaltyImposer() {
        return new BillingContextPenaltyImposer();
    }

    @Bean
    public PenaltyDomainService penaltyDomainService(PenaltyImposer penaltyImposer) {
        return new PenaltyDomainService(penaltyImposer);
    }

    @Bean
    public ReservationEventHandler penaltyReservationEventHandler(PenaltyDomainService penaltyTrackingDomainService) {
        return new ReservationEventHandler(penaltyTrackingDomainService);
    }
}
