package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account;

import org.jmolecules.ddd.annotation.ValueObject;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;

@ValueObject
public record DepositMade() implements DomainEvent {
}
