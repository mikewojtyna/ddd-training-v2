package pl.wojtyna.trainings.ddd.crowdsorcery.common.domain;

public interface EventPublisher {

    void publish(DomainEvents events);
}
