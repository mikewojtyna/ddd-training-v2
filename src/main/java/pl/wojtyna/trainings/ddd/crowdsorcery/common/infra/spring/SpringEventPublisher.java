package pl.wojtyna.trainings.ddd.crowdsorcery.common.infra.spring;

import org.springframework.context.ApplicationEventPublisher;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvents;

public class SpringEventPublisher implements DomainEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {this.applicationEventPublisher = applicationEventPublisher;}

    @Override
    public void publish(DomainEvents events) {
        events.stream().forEach(applicationEventPublisher::publishEvent);
    }
}
