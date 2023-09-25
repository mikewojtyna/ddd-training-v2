package pl.wojtyna.trainings.ddd.devbridge;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;

import java.util.List;

public class DomainEvents {

    private List<DomainEvent> events;

    public boolean hasOccurredEventOfType(Class<? extends DomainEvent> eventType) {return false;}

    public static DomainEvents of(DomainEvent event) {
        return null;
    }
}
