package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account;

import org.joda.money.Money;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;

public record WithdrawalMade(Money amount) implements DomainEvent {
}
