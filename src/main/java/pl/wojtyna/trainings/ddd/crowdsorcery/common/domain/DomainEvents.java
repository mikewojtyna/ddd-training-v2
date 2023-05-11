package pl.wojtyna.trainings.ddd.crowdsorcery.common.domain;

public record DomainEvents() {

    public void publishUsing(EventPublisher eventPublisher) {
        throw new UnsupportedOperationException("Implement this method");
    }
}
