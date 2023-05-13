package pl.wojtyna.trainings.ddd.crowdsorcery.payment.api;

import org.jmolecules.ddd.annotation.ValueObject;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.integration.IntegrationEvent;

@ValueObject
public record PaymentEvent() implements IntegrationEvent, DomainEvent {
}
