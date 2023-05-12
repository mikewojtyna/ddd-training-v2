package pl.wojtyna.trainings.ddd.crowdsorcery.common.domain;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

@SecondaryPort
public interface EventPublisher {

    void publish(DomainEvents events);
}
