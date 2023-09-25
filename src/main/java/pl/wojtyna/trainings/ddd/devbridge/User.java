package pl.wojtyna.trainings.ddd.devbridge;

import lombok.Value;
import org.joda.money.Money;

@Value
public class User {

    private Money balance;

    public static User withBalance(Money money) {

        return null;
    }

    public Money balance() {
        return null;
    }
}
