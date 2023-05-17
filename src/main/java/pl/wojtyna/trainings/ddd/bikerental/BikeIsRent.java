package pl.wojtyna.trainings.ddd.bikerental;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;

public record BikeIsRent(int hours) implements DomainEvent {

    public boolean isUnlimited() {
    }
}
