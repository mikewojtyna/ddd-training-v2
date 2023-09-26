package pl.wojtyna.trainings.ddd.devbridge;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;

import java.util.List;

public class DomainEvents {

    private List<DomainEvent> events;

    public DomainEvents(List<DomainEvent> events) {
        this.events = events;
    }

    public boolean hasOccurredEventOfType(Class<? extends DomainEvent> eventType) {
        return events.stream().map(DomainEvent::getClass).anyMatch(eventType::isAssignableFrom);
    }

    public static DomainEvents of(DomainEvent event) {
        return new DomainEvents(List.of(event));
    }
}
