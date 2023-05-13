package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.payment;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.Deposit;

public record PaymentVerified(Deposit deposit) implements DomainEvent {
}
