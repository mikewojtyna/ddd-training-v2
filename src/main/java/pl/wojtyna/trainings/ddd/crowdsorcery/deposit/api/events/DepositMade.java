package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.api.events;

import org.jmolecules.ddd.annotation.ValueObject;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.integration.IntegrationEvent;

@ValueObject
public record DepositMade() implements IntegrationEvent {
}
