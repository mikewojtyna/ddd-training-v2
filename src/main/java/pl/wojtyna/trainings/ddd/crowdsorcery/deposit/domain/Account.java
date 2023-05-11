package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain;

import org.joda.money.Money;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvents;

public class Account {

    public DomainEvents makeDeposit(Deposit deposit) {
        throw new UnsupportedOperationException("Implement this method");
    }

    public DomainEvents withdraw(Money amount) {
        throw new UnsupportedOperationException("Implement this method");
    }
}
