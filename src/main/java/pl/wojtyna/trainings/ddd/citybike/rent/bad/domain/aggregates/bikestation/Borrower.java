package pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation;

import lombok.EqualsAndHashCode;
import org.jmolecules.ddd.annotation.Entity;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

@Entity
@EqualsAndHashCode(of = "id")
class Borrower {

    private final BorrowerId id;
    private Money balance;

    Borrower(BorrowerId id, Money balance) {
        this.id = id;
        this.balance = balance;
    }

    public BorrowerId id() {
        return id;
    }

    void updateBalance(RentalDuration rentalDuration) {
        var cost = calculateCost(rentalDuration);
        if (balance.isGreaterThan(cost)) {
            balance = balance.minus(cost);
        }
    }

    boolean hasEnoughFunds(RentalDuration rentalDuration) {
        return balance.isGreaterThan(Money.of(CurrencyUnit.EUR, rentalDuration.duration().toHours() * 10));
    }

    private Money calculateCost(RentalDuration rentalDuration) {
        return Money.of(CurrencyUnit.EUR, rentalDuration.duration().toHours() * 10);
    }
}
