package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;
import org.joda.money.Money;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvents;

@Entity
public class Account {

    private final AccountId id;

    public Account(AccountId id) {
        this.id = id;
    }

    public DomainEvents makeDeposit(Deposit deposit) {
        throw new UnsupportedOperationException("Implement this method");
    }

    public DomainEvents withdraw(Money amount) {
        throw new UnsupportedOperationException("Implement this method");
    }

    @Identity
    public AccountId id() {
        return id;
    }
}
