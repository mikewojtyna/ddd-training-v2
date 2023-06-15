package pl.wojtyna.trainings.recipes.citybike.solution.reservation.infra;

import org.springframework.context.ApplicationEventPublisher;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.BikeReservationLocalEvent;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain.EventPublisher;

public class SpringEventPublisher implements EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {this.applicationEventPublisher = applicationEventPublisher;}

    @Override
    public void publish(BikeReservationLocalEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
