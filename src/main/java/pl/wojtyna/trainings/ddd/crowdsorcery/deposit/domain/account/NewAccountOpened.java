package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;

public record NewAccountOpened(DepositAccount account) implements DomainEvent {
}
